# Atividade 9

Este exercício propõe a implementação de três algoritmos de ordenação: `bubble sort`, `selection sort` e `insertion sort`. Além disso, computar o tempo de ordenação para cada um dos métodos, formando uma espécie de comparação. 

## Método 

Após a criação dos três algoritmos, foi criado três vetores e um método para "gerar" os números e inserir nestes vetores. De todo modo, estes números não foram criados de maneira aleatória, e sim, de maneira invertida. Para este caso, como o tamanho dos vetores é de 250 mil espaços, a ordem invertida (a partir do índice 0) é de 249.999 até 0 (último índice). O método criado foi o seguinte:

```
Nesta sequência: [249.999, 249.998, ..., 1, 0]
```

```java
public static void reversed(VectorInteger vector) {
    for (int i = vector.size() - 1; i >= 0; i--) {
        vector.add(i);
    }
}
```

Após inserir todos estes números, é chamada as funções de computagem de tempo e ordenação. 

```java
ComputeTime.insertionSort(vectorInsertionSort);
ComputeTime.bubbleSort(vectorBubbleSort);
ComputeTime.selectionSort(vectorSelectionSort);
```

Estas mostram o tempo, em segundos, dos métodos de ordenação. Vale ressaltar que os três vetores possuem os mesmos números. Então, os tempos tendem a ser próximos de uma comparação ideal.

Após isso, novamente foi chamado os métodos acima para verificar o tempo decorrido para caso os vetores já estivessem ordenados. Com isso, temos o seguinte resultado :clock4::

