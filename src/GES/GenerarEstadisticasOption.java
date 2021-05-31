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
        double promedio = notas.stream().mapToDouble(d -> d)
                .average()
                .orElse(0.0);
        int min = Collections.min(notas);
        int max = Collections.max(notas);

        Set<Integer> unique = new HashSet<>(notas);
        int mostRepeated = 0;
        int lessReapeted = 0;
        HashMap<Integer, Integer> allFrecuencies = new HashMap<>();
        for (Integer key : unique) {
            int frecuency = Collections.frequency(notas, key);
            allFrecuencies.put(frecuency, key);
        }
        List<Integer> keys = allFrecuencies.keySet().stream().toList();
        int lr = Collections.min(keys);
        int mr = Collections.max(keys);
        mostRepeated = allFrecuencies.get(mr);
        lessReapeted = allFrecuencies.get(lr);

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
