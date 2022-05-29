## Atividade 6

Este exercício propõ a implementação da `Lista Duplamente Encadeada (LDE, onde chamei de DoublyLinkedList)`. O objetivo era transformar a Lista desenvolvida em sala de aula numa lista mais genérica, utilizando a classe `Object`. Porém, da mesma forma do exercício passado, resolvi utilizar do recurso de _Generics_ da linguagem.

De tal forma, os exercícios do slide podem ser solucionados da seguinte forma:

### Exemplo

```java
    var list = new DoublyLinkedList<Integer>();

    list.add(1);
    list.add(2);
    list.add(3);

    System.out.println(list);
    System.out.println(list.endToStart());
```

Neste exemplo, no primeiro `println()` será impresso `[1, 2, 3]`, uma vez que defini como padrão (utilizando o `toString()`) a leitura da esquerda para a direita. 

Já no segundo `println()`, será impresso de trás para frente: `[3, 2, 1]`.

> :warning: Nota-se, também, que neste exemplo, a lista só aceitará números inteiros. Qualquer tentativa de adição para com outros elementos, não será possível compilar.

### Exemplo com Object

Visto que a lista está utilizando o _Generics_, ela facilmente poderia ser instanciada com um tipo específico ou mais 'genérico'. 

```java
    // Aqui, será aceito qualquer tipo de objeto.
    var list = new DoublyLinkedList<Object>();

    list.add(1);
    list.add("Sou uma String!");
    list.add(new Student("Matheus", 22));

    System.out.println(list);
```

Neste, o `println()` irá imprimir `[1, Sou uma String!, [Matheus,22,8.3]]`.