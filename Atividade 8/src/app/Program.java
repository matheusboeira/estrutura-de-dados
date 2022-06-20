package app;

import static java.lang.System.out;

import java.time.Duration;
import java.time.Instant;

import entities.Search;
import entities.Vector;
import utils.App;
import utils.enums.Color;

public class Program {
    public static void main(String[] args) {
        final int MAX_LENGTH = 100_000_000;
        
        var vector = new Vector<Integer>(MAX_LENGTH);
        generateNumbers(vector);

        try {
            Instant startRecursive = Instant.now();
            int recursiveResult = Search.recursiveBinarySearch(vector, MAX_LENGTH);
            Instant endRecursive = Instant.now();
            
            Instant startIterative = Instant.now();
            int iterativeResult = Search.iterativeBinarySearch(vector, MAX_LENGTH);
            Instant endIterative = Instant.now();

            Instant startLinear = Instant.now();
            int linear = Search.iterativeSearch(vector, MAX_LENGTH);
            Instant endLinear = Instant.now();

            out.println("\nResultado da busca binária recursiva: " + vector.get(recursiveResult));
            out.println("Resultado da busca binária iterativa: " + vector.get(iterativeResult));
            out.println("Resultado da busca linear iterativa: " + vector.get(linear) + "\n");
            
            Duration recursive = Duration.between(startRecursive, endRecursive);
            Duration iterative = Duration.between(startIterative, endIterative);
            Duration linearSearch = Duration.between(startLinear, endLinear);

            App.println(Color.PURPLE, "[TEMPO LEVADO]");
            App.println(Color.BLUE, "   Método recursivo (busca binária): ");
            App.printf(Color.YELLOW, "      Milissegundos: ");
            App.printf(Color.GREEN, (recursive.getNano() / 10e6) + " ms.\n");
            App.printf(Color.YELLOW, "      Nanossegundos: ");
            App.printf(Color.GREEN, (recursive.getNano()) + " ms.\n");

            App.println(Color.BLUE, "   Método iterativo (busca binária): ");
            App.printf(Color.YELLOW, "      Milissegundos: ");
            App.printf(Color.GREEN, (iterative.getNano() / 10e6) + " ms.\n");
            App.printf(Color.YELLOW, "      Nanossegundos: ");
            App.printf(Color.GREEN, (iterative.getNano()) + " ms.\n");

            App.println(Color.BLUE, "   Método iterativo (busca linear): ");
            App.printf(Color.YELLOW, "      Milissegundos: ");
            App.printf(Color.GREEN, (linearSearch.getNano() / 10e6) + " ms.\n");
            App.printf(Color.YELLOW, "      Nanossegundos: ");
            App.printf(Color.GREEN, (linearSearch.getNano()) + " ms.\n");
        } catch (Exception e) {
            out.println(e.getMessage());
        }
    }

    public static void generateNumbers(Vector<Integer> vector) {
        for (int i = 0; i < vector.size(); i++) {
            vector.add(i + 1);
        }
    }
}
