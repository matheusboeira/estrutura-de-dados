## Atividade 8

Este exercício propõe a implementação de dois métodos, um de maneira `recursiva` e outro de maneira `iterativa`, para buscar um elemento de um vetor de inteiros. Deve-se realizar a busca no pior caso (último elemento) e computar o tempo de execução.

O enunciado dizia, também, que deveria ser computado a busca do maior valor em um TAD vetor de 1000 posições. Porém, na minha máquina, só pude perceber a diferença de tempo a partir de `100.000.000` de elementos.

```java
var vector = new Vector<Integer>(100_000_000);
```

O método proposto é a implementação de uma busca binária que retorne o índice do elemento procurado, caso encontrado. De todo modo, o algoritmo só irá funcionar caso possua um vetor ordenado. De tal forma, criou-se um método para "gerar" elementos, de 1 a 100_000_000.

```java
for (int i = 0; i < vector.size(); i++) {
    vector.add(i + 1);
}
``` 

## Resultado dos testes

Para fins de comparação, foi necessário criar outro método para fins de comparação, uma vez que em ambos os casos, não houve diferenças significativas. Além disso, os resultados estão em milissegundos e nanossegundos.

### :clock4: Recursivo vs. Iterativo vs. Linear

