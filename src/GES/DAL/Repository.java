package GES.DAL;

import GES.Entities.Student;
import org.jetbrains.annotations.NotNull;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Repository {
    private StringBuilder stringBuilderData;

    private FileWriter writer;
    private File dataBase;
    private String errorMessage;
    private boolean isAppend = false;

    public Repository() {
        createFile();
        //writer = getFileWriter();
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Boolean registerGrade(Student student) throws IOException {
        writer = getFileWriter();
        boolean result = false;
        stringBuilderData = new StringBuilder();
        stringBuilderData.append(student.getFirstName());
        stringBuilderData.append(",");
        stringBuilderData.append(student.getGrade());
        stringBuilderData.append("\n");
        try {
            writer.write(stringBuilderData.toString());
            result = true;
        } catch (IOException ex) {
            errorMessage = "No se pudo escribir a la bd.";
        }
        return result;
    }

    public boolean registrarEstadisticas(String data) {
        boolean result = false;
        writer = getFileWriter(true);
        try {
            writer.write(data);
            result = true;
        } catch (IOException ex) {
            errorMessage = "No se pudo escribir a la bd.";
        }
        return result;
    }

    private FileWriter getFileWriter(boolean append) {
        isAppend = append;
        return getFileWriter();
    }

    private FileWriter getFileWriter() {
        if (writer == null) {
            try {

                writer = new FileWriter("bd.txt", isAppend);
                isAppend = false;
            } catch (IOException ex) {
                errorMessage = "El archivo ya existe";
            }
        }

        return writer;
    }

    private void createFile() {
        try {
            dataBase = new File("bd.txt");
            if (dataBase.createNewFile()) {
                errorMessage = "File created.";
            } else {
                errorMessage = "File already exists.";
            }
        } catch (IOException ex) {
            errorMessage = "An error ocurred.";
        }

    }

    public List<Integer> getGrades() {
        List<Integer> result = new ArrayList<>();
        try {
            Scanner reader = new Scanner(dataBase);
            if (dataBase.exists()) {

                while (reader.hasNext()) {
                    String line = reader.nextLine();
                    String[] values = line.split(",");
                    result.add(Integer.parseInt(values[1]));
                }
            }
        } catch (FileNotFoundException ex) {
            errorMessage = "An error ocurred";
        }

        return result;
    }

    public void Dispose() throws IOException {
        writer.close();
    }
}
