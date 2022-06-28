package app;

import java.util.Scanner;

import entities.ListQueue;
import utils.App;
import utils.enums.Color;

public class Program {
    public static void main(String[] args) {
        App.clearScreen();

        ListQueue<String> queue = new ListQueue<>();
        queue.add("Matheus", "José Eduardo", "Raul", "Josefina");
        int order = 0;

        try (Scanner input = new Scanner(System.in)) {
            App.println(Color.PURPLE, "[SALA DE ESPERA]");

            Thread.sleep(1000);

            App.printfAndWait(Color.NONE, "\n>>> Chamando os nomes em 3...\n", 1000);
            App.printfAndWait(Color.NONE, ">>> Chamando os nomes em 2...\n", 1000);
            App.printfAndWait(Color.NONE, ">>> Chamando os nomes em 1...\n\n", 1000);

            for (String student : queue) {
                App.printf(Color.YELLOW, "Chamando [%d]: ", ++order);
                App.printfAndWait(Color.BLUE, " " + student, 2500);

                if (student.length() > 8)
                    App.printf(Color.GREEN, "\t>>> Atendido!", 250);
                else
                    App.printf(Color.GREEN, "\t\t>>> Atendido!", 250);

                App.printf(Color.CYAN, "\t" + queue + "\n");
                queue.remove();
            }
            App.println(Color.GREEN, "\nFila de atendimento finalizada, nos vemos semana que vem!\n");

        } catch (Exception e) {
            App.println(Color.RED, e.getMessage());
        }
    }
}
