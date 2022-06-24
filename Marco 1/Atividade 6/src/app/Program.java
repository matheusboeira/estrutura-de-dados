package app;

import static java.lang.System.out;

import java.util.Locale;

import entities.DoublyLinkedList;
import entities.Student;
import entities.utils.AppUtils;

public class Program {
    public static void main(String[] args) {
        AppUtils.clearScreen();
        Locale.setDefault(Locale.US);
        
        var list = new DoublyLinkedList<Object>();

        list.add(1);
        list.add("Sou uma String!");
        list.add(new Student("Matheus", 22, 8.25));

        out.printf("Tamanho da lista: %d.\n", list.size());
        out.printf("Está vazia: %s.\n\n", (list.isEmpty() ? "SIM" : "NÃO"));
        out.println(list);
        out.println(list.endToStart());
    }
}
