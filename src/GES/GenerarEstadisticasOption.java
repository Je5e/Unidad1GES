package GES;

import GES.DAL.Repository;

import java.io.IOException;
import java.util.*;

public class GenerarEstadisticasOption extends Option {


    public GenerarEstadisticasOption(int code) {
        this.setCode(code);
        this.setDescription("Generar estadisticas.");
    }

    @Override
    public void executeAction() throws IOException {

        Repository repository = new Repository();
        List<Integer> notas = repository.getGrades();

        // Refactorizar este codigo.
        double promedio = StatisticManager.getAverageGrades(notas);

        int min = StatisticManager.getMinGrade(notas);
        int max = StatisticManager.getMaxGrade(notas);

        int mostRepeated = StatisticManager.getMostRepeatedGrade(notas);
        int lessReapeted = StatisticManager.getLessRepeatedGrade(notas);

        repository.registrarEstadisticas("promedio," + promedio + "\n");
        repository.registrarEstadisticas("max," + max + "\n");
        repository.registrarEstadisticas("min," + min + "\n");
        repository.registrarEstadisticas("mostreapeted," + mostRepeated + "\n");
        repository.registrarEstadisticas("lessreapeted," + lessReapeted + "\n");
        repository.Dispose();

        System.out.println("Promedio," + promedio);
        System.out.println("Max," + max);
        System.out.println("Min," + min);
        System.out.println("Most reapeted," + mostRepeated);
        System.out.println("Less reapeted," + lessReapeted);
    }
}
