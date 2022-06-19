## Atividade 7

Este exercício propõe a implementação de dois métodos, um de maneira `recursiva` e outro de maneira `iterativa`, para encontrar o maior número entre eles. Com isso, deve-se computar o tempo de execução de cada método.

### Diferença de tempo

O enunciado dizia, também, que deveria ser computado a busca do maior valor em um TAD vetor de 1000 posições. Porém, na minha máquina, só pude perceber a diferença de tempo a partir de `100.000.000` de elementos.

```java
var vector = new Vector<Integer>(100_000_000);
```

:information_source: Vale ressaltar que os elemento estão sendo gerados de maneira aleatória.

```java
Random random = new Random();

for (int i = 0; i < vector.size(); i++) {
    vector.add(random.nextInt(1_000_000));
}
```

#### :clock4: Últimos testes computados

Três últimos testes computados. 

### Recursivo vs. Iterativo

+ 47.19970 ms `vs.` 19.89684 ms
+ 59.30025 ms `vs.` 23.49983 ms
+ 55.91505 ms `vs.` 25.50307 ms
