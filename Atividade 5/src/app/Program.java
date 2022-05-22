package app;

import java.util.Locale;

import entities.LinkedList;
import entities.Student;
import entities.utils.AppUtils;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        
        Student studentA = new Student("Matheus", 22, 8.25);
        Student studentB = new Student("Rogério", 27, 10);
        LinkedList<Object> list = new LinkedList<>();

        list.addLast(studentA);
        list.addLast(10);
        list.addLast(studentB);

        AppUtils.clearScreen();
        System.out.printf("Tamanho da lista: %d.\n", list.size());
        System.out.printf("Está vazia: %s.\n\n", (list.isEmpty() ? "SIM" : "NÃO"));
        System.out.println(list);
    }
}
