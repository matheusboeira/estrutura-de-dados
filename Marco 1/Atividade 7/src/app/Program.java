package app;

import static java.lang.System.out;

import java.time.Duration;
import java.time.Instant;
import java.util.Locale;
import java.util.Random;

import entities.Find;
import entities.Vector;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        
        var vector = new Vector<Integer>(100_000_000);
        generateNumbers(vector);

        Instant startRecursive = Instant.now();
        out.println("Maior elemento (recursivo): " 
            + Find.maxRecursive(0, vector.size() - 1, vector) + ".");
        Instant endRecursive = Instant.now();
        
        Instant startIterative = Instant.now();
        out.println("Maior elemento (recursivo): " 
            + Find.maxIterative(0, vector.size() - 1, vector) + ".");
        Instant endIterative = Instant.now();

        double recursive = Duration.between(startRecursive, endRecursive).getNano() / 10e6;
        double iterative = Duration.between(startIterative, endIterative).getNano() / 10e6;

        out.println("Tempo demorado no método recursivo: " + recursive + " ms.");
        out.println("Tempo demorado no método iterativo: " + iterative + " ms.");
    }

    public static void generateNumbers(Vector<Integer> vector) {
        Random random = new Random();

        for (int i = 0; i < vector.size(); i++) {
            vector.add(random.nextInt(1_000_000));
        }
    }
}
