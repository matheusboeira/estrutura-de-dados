package app;

import utils.ABB;

public class Program {
    public static void main(String[] args) {
        var abb = new ABB<Integer>();
        abb.add(4, 5, 6, 1, 2);
    
        System.out.println("Raiz: " + abb.getRoot().getValue());
        System.out.println("Impressão (em ordem): " + abb);                                 // [1, 2, 4, 5, 6]
        System.out.println("Resultado da busca: " + abb.search(6));                         // NodeTree [value=6]
        System.out.println("Resultado da busca (elemento): " + abb.search(6).getValue());   // 6
        System.out.println("Remoção: " + abb.remove(6));                                    // 6
        System.out.println("Impressão pós-remoção: " + abb.search(6));                      // null
    }
}
