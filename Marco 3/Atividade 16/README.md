## Exercício 15

Neste exercício foi proposto a criação dos métodos de buscar e imprimir os elementos de uma árvore binária de busca. Normalmente, só é solicitado uma criação do tipo genérico utilizando `Object`, porém, eu não consigo me manter nisso e sempre vou para o `Generic` do Java. De tal forma, foi necessário atrelar um tipo específico que contenha o método `compareTo` para que a árvore funcione, uma vez que os elementos serão comparados para serem impressos de forma ordenada. Com isso, inseriu-se o seguinte trecho de código no cabeçalho da ABB:

```java
    public class ABB<Type extends Comparable<Type>>
```

Desta forma, qualquer classe que não implementar o `Comparable`, não poderá ser inserida nesta estrutura. Os testes foram os seguintes:

```java
    var abb = new ABB<Integer>();
    abb.add(4, 5, 6, 1, 2);

    System.out.println("Raiz: " + abb.getRoot().getValue());                            // 6
    System.out.println("Impressão (em-ordem): " + abb);                                 // [1, 2, 4, 5, 6]
    System.out.println("Impressão (pré-ordem): " + abb.preOrder());                     // [4, 1, 2, 5, 6]
    System.out.println("Impressão (pós-ordem): " + abb.postOrder());                    // [2, 1, 6, 5, 4]
    System.out.println("Resultado da busca: " + abb.search(6));                         // NodeTree [value=6]
    System.out.println("Resultado da busca (elemento): " + abb.search(6).getValue());   // 6
    System.out.println("Remoção: " + abb.remove(6));                                    // true
    System.out.println("Impressão pós-remoção: " + abb.search(6));                      // null
```
