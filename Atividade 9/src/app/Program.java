package app;

import static java.lang.System.out;

import entities.ComputeTime;
import entities.VectorInteger;
import utils.App;
import utils.enums.Color;

public class Program {
    public static void main(String[] args) {
        final int MAX_LENGTH = 250_000;
        
        var vectorSelectionSort = new VectorInteger(MAX_LENGTH);
        var vectorBubbleSort = new VectorInteger(MAX_LENGTH);
        var vectorInsertionSort = new VectorInteger(MAX_LENGTH);

        reversed(vectorSelectionSort);
        reversed(vectorBubbleSort);
        reversed(vectorInsertionSort);
        
        try {
            App.println(Color.PURPLE, "\n[TEMPO DECORRIDO]\n");

            App.println(Color.WHITE, "<<< Ordem: 250_000 a 1 (NÃO ORDENADO)\n");
            ComputeTime.insertionSort(vectorInsertionSort);
            ComputeTime.bubbleSort(vectorBubbleSort);
            ComputeTime.selectionSort(vectorSelectionSort);

            App.println(Color.WHITE, "\n>>> Ordem: 1 a 250_000 (JÁ ORDENADO)\n");
            ComputeTime.insertionSort(vectorInsertionSort);
            ComputeTime.bubbleSort(vectorBubbleSort);
            ComputeTime.selectionSort(vectorSelectionSort);

            App.println("");
        } catch (Exception e) {
            out.println(e.getMessage());
        }
    }

    /**
     * Inserting numbers.
     * 
     * @param vector the vector to generate numbers
     */
    public static void reversed(VectorInteger vector) {
        for (int i = vector.size() - 1; i >= 0; i--) {
            vector.add(i);
        }
    }
}
