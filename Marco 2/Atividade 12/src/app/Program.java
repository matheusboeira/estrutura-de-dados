package app;

import java.util.Scanner;

import entities.ListQueue;
import entities.VectorStack;
import utils.App;
import utils.enums.Color;

public class Program {
    public static void main(String[] args) {
        App.clearScreen();

        var queue = new ListQueue<Object>();

        try (Scanner input = new Scanner(System.in)) {
            App.printf(Color.PURPLE, "[MENU DE OPÇÕES]\n\n");
            App.printf("\t1 - Verificar palíndromo\n");
            App.printf("\t2 - Inverter uma fila\n\n");
            App.printf(Color.YELLOW, "Digite uma das opções acima: ");
            var option = input.nextInt();
            input.nextLine();

            switch (option) {
                case 1 -> {
                    App.printf(Color.PURPLE, "[VERIFICAR PALÍNDROMO]\n\n");
                    App.printf("Digite uma frase: ");
                    var phrase = input.nextLine();
                    App.printf("\nA frase digitada foi: " + phrase);
                    var stack = new VectorStack<Object>(phrase.length());
                    App.printf("\nO resultado da verificação é: " 
                        + (stack.isPalindrome(phrase) ? "É palíndromo" : "Não é palíndromo"));
                }
                case 2 -> {
                    App.clearScreen();
                    App.printf(Color.PURPLE, "\n[INVERTENDO FILA]\n");
                    App.printf("\nDigite a sequência (em espaços): ");
                    var sequence = input.nextLine();

                    for (var element : sequence.split(" "))
                        queue.add(element);
                    
                    queue.reverse();
                    App.printf(Color.GREEN, "Ordem invertida: " + queue + "\n\n");
                }
                default -> {
                    App.printf(Color.RED, "Opção inválida!");
                }
            }
        } catch (Exception e) {
            App.println(Color.RED, e.getMessage());
        }
    }
}
