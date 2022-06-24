package app;

import java.util.Locale;

import entities.Student;
import entities.Vector;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        
        var studentA = new Student("Matheus", 22, 7.5);
        var studentB = new Student("Rogério", 22, 7.5);
        var vector = new Vector(5);

        try {
            vector.add(studentA);
            vector.add(studentA);
            vector.add(studentA);
            vector.remove(studentB);
            System.out.println(vector.get(17));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        System.out.printf("Tamanho do vetor: %d\n\n", vector.size());
        System.out.println(vector);
    }
}
