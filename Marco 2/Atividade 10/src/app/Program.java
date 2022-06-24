package app;

import java.util.Scanner;

import entities.QueueVector;
import utils.App;
import utils.enums.Color;

public class Program {
    public static void main(String[] args) {
        App.clearScreen();

        QueueVector<String> queue = new QueueVector<>(5);
        String[] students = { "Matheus", "José Eduardo", "Raul", "Josefina", "Epaminondas" };
        int order = 0;

        try (Scanner input = new Scanner(System.in)) {
            App.println(Color.PURPLE, "[SALA DE ESPERA]");

            for (String student : students) 
                queue.add(student);
            
            Thread.sleep(1000);
            
            App.printfAndWait(Color.NONE, "\n>>> Chamando os nomes em 3...\n", 1000);
            App.printfAndWait(Color.NONE, ">>> Chamando os nomes em 2...\n", 1000);
            App.printfAndWait(Color.NONE, ">>> Chamando os nomes em 1...\n\n", 1000);

            for (String student : students) {
                App.printf(Color.YELLOW, "Chamando [%d]: ", ++order);
                App.printfAndWait(Color.BLUE, " " + student, 2500);

                if (student.length() > 8) 
                    App.printf(Color.GREEN, "\t>>> Atendido!\n", 350);
                else 
                    App.printf(Color.GREEN, "\t\t>>> Atendido!\n", 350);

            }
            App.println(Color.CYAN, "\nFila de atendimento finalizada, nos vemos semana que vem!\n");
            App.println(Color.PURPLE, "A ordem foi a seguinte: " + queue);

        } catch (Exception e) {
            App.println(Color.RED, e.getMessage());
        }
    }
}
