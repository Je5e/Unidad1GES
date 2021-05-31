package GES;

import java.util.*;

public class StatisticManager {

    public static double getAverageGrades(List<Integer> datos){
        return datos.stream().mapToDouble(d -> d)
                .average()
                .orElse(0.0);
    }
    public  static int getMinGrade(List<Integer> grades){
        return Collections.min(grades);
    }

    public static int getMaxGrade(List<Integer> notas) {
        return Collections.max(notas);
    }
    public static int getMostRepeatedGrade(List<Integer> grades){
        Set<Integer> unique = new HashSet<>(grades);
        int mostRepeated = 0;
        HashMap<Integer, Integer> allFrecuencies = new HashMap<>();
        for (Integer key : unique) {
            int frecuency = Collections.frequency(grades, key);
            allFrecuencies.put(frecuency, key);
        }
        List<Integer> keys = allFrecuencies.keySet().stream().toList();
        // Obtener el key del diccionario, que mas se repite.
        int mr = Collections.max(keys);
        mostRepeated = allFrecuencies.get(mr);
       return mostRepeated;
    }

    public static int getLessRepeatedGrade(List<Integer> notas) {
        Set<Integer> unique = new HashSet<>(notas);
        int lessRepeated = 0;
        HashMap<Integer, Integer> allFrecuencies = new HashMap<>();
        for (Integer key : unique) {
            int frecuency = Collections.frequency(notas, key);
            allFrecuencies.put(frecuency, key);
        }
        List<Integer> keys = allFrecuencies.keySet().stream().toList();
        // Obtener el key del diccionario, que menos se repite.
        int lr = Collections.min(keys);
        lessRepeated = allFrecuencies.get(lr);
        return lessRepeated;
    }
}
