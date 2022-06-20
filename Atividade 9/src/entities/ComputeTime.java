package entities;

import java.time.Duration;
import java.time.Instant;

import utils.App;
import utils.enums.Color;

public class ComputeTime {
    public static void selectionSort(VectorInteger vector) {
        Instant start = Instant.now();
        vector.selectionSort();
        Instant end = Instant.now();

        App.printf(Color.BLUE_BG, "%20s", "Selection Sort:");
        App.println(Color.BLUE, " " + Duration.between(start, end).getSeconds() + " segundos.");
    }

    public static void bubbleSort(VectorInteger vector) {
        Instant start = Instant.now();
        vector.bubbleSort();
        Instant end = Instant.now();

        App.printf(Color.RED_BG, "%20s", "Bubble Sort:");
        App.println(Color.RED, " " + Duration.between(start, end).getSeconds() + " segundos.");
    }
    
    public static void insertionSort(VectorInteger vector) {
        Instant start = Instant.now();
        vector.insertionSort();
        Instant end = Instant.now();
        
        App.printf(Color.GREEN_BG, "%20s", "Insertion Sort:");
        App.println(Color.GREEN, " " + Duration.between(start, end).getSeconds() + " segundos.");
    }
}
