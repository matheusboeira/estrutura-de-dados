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

### Resultado para X elementos

<details>
  <summary>250.000</summary>
  <img src="https://user-images.githubusercontent.com/76896958/174528313-3651cb37-e04a-46e5-8f11-b5b8c8867b02.png">
</details>

<details>
  <summary>100.000</summary>
  <img src="https://user-images.githubusercontent.com/76896958/174527965-54c06a94-275e-4378-850c-523397219727.png">
</details>

<details>
  <summary>10.000</summary>
  <img src="https://user-images.githubusercontent.com/76896958/174527862-78292e50-b430-4474-a63e-588af554c635.png">
</details>

# Nota

Nota-se, que dependendo de como está ordenado o vetor, alguns algoritmos desempenham melhor do que outros. Insertion sort se destaca em ordenar vetores quase que já ordenados, assim como é ótimo para verificar se o vetor está ordenado, visto que possui uma eficiência excelente para isso. Bubble Sort já é um pouco mais lento, mas só foi perceptível quando coloquei em 250_000 elementos. Já o Selection Sort possui um desempenho similar em qualquer caso.
