## Atividade 5

Este exercício propõe a implementação da `Lista Simplesmente Encadeada (LSE, onde chamei de LinkedList)`. O objetivo era transformar o proposto em sala de aula de forma mais genérica, utilizando o tipo `Object`. Porém, resolvi transformar ela realmente genérica, utilizando os _Generics_ do Java. 

Desta forma, este exercício suporta o uso do tipo `Object` ou apenas aceitando apenas um tipo.

### Exemplo:

```java
    LinkedList<Object> list = new LinkeedList<>();
```

aceitando todos os tipos de dados, ou

```java
    LinkedList<String> list = new LinkeedList<>();
```

assim, aceitando apenas `Strings`.
