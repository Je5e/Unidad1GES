package GES;

import GES.DAL.Repository;
import GES.Entities.Student;

import java.io.IOException;
import java.util.Scanner;

public class RegistrarNotasOption extends Option {

    public RegistrarNotasOption(int code) {
        this.setCode(code);
        this.setDescription("Registrar notas de alumnos.");
    }

    @Override
    public void executeAction() throws IOException {

        Scanner scanner = new Scanner(System.in);
        //Repository rep = new Repository();
        Repository context = new Repository();

        for (int i = 0; i < 3; i++) {
            System.out.println("Ingrese el nombre del alumno: ");
            String studentName = scanner.nextLine();
            System.out.println("Ingrese la nota: ");
            byte grade = Byte.parseByte(scanner.nextLine());

            Student newStudent = new Student(studentName, grade);
            try {
                boolean result;
                result = context.registerGrade(newStudent);
            } catch (IOException ex) {
                System.out.println(context.getErrorMessage());
            }
        }
        context.Dispose();

    }
}
