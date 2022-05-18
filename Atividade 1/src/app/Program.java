package app;

import entities.CartesianCoordinates;

public class Program {
    public static void main(String[] args) {
        var coordinateA = new CartesianCoordinates(1, 1);
        var coordinateB = new CartesianCoordinates(1, 4);

        double result = coordinateA.getDistanceBetween(coordinateB);
        System.out.printf("A distância é de %.2f metros.\n", result);
    }
}
