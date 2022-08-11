package app;

import utils.ABB;

public class Program {
    public static void main(String[] args) {
        var abb = new ABB<Integer>();
        abb.add(4, 5, 6, 1, 2);

        System.out.println("Raiz: " + abb.getRoot().getValue());
        System.out.println("Impressão (em-ordem): " + abb);
        System.out.println("Impressão (pré-ordem): " + abb.preOrder());
        System.out.println("Impressão (pós-ordem): " + abb.postOrder());
        System.out.println("Resultado da busca: " + abb.search(6));
        System.out.println("Resultado da busca (elemento): " + abb.search(6).getValue());
    }
}
