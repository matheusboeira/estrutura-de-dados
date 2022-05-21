package app;

import java.util.Locale;

import entities.Student;
import entities.Vector;
import entities.utils.AppUtils;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        
        var studentA = new Student("Matheus", 22, 7.5);
        var studentB = new Student("Rogério", 22, 7.5);
        var studentC = new Student("Ana", 22, 7.5);
        var vector = new Vector(5);

        try {
            vector.add(studentA);
            vector.add(studentB);
            vector.add(studentB);
            vector.add(studentC);
            vector.add(studentA);
            vector.add(studentB);
            vector.add(studentA);
            vector.add("Olá, mundo!");
            vector.add(18.5);
            vector.remove(studentC);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        AppUtils.clearScreen();
        System.out.printf("Tamanho do vetor: %d\n\n", vector.size());
        System.out.println(vector);
        vector.shrinkToSize();
        System.out.printf("Tamanho do vetor: %d\n\n", vector.size());
    }
}
