# Grafos

# **Matriz de Adjacência:**

## **tipoDoGrafo:**

**Dirigido ou não-Dirigido:**
Todo grafo não dirigido é simétrico. Ou seja, se não for simétrica é dirigido

**Grafo Simples ou Multigrafo:**
Na matriz de adjacência de um **grafo simples**, todas as entradas devem ser 0 (sem aresta) ou 1 (uma única aresta). Ou seja, não pode ter aresta dupla, nem loop.

Na matriz de adjacência de um **multigrafo**, as entradas podem ter valores maiores que 1 para indicar a presença de múltiplas arestas.

**Grafo Regular ou Completo:**

Um **grafo é regular** se todos os vértices tiverem o mesmo *grau*, ou seja, o mesmo número de arestas conectadas a eles.

Para verificar se um grafo é regular usando a matriz de adjacência, você deve examinar todas as linhas (ou colunas) da matriz e garantir que todas tenham a mesma soma, que corresponde ao grau dos vértices.

Um **grafo é completo** se todos os pares de vértices estiverem conectados por uma única aresta.
Para verificar se um grafo é completo usando a matriz de adjacência, você deve verificar se todas as entradas da matriz são iguais a 1 (indicando uma aresta) ou 0 (indicando a ausência de uma aresta), exceto a diagonal principal, que deve ser preenchida com zeros (já que não há laços em grafos simples).

**Grafo Nulo ou Bipartido:**

- Um grafo é considerado **nulo** quando não possui nenhuma aresta, ou seja, todas as entradas da matriz de adjacência são iguais a zero.

- Para verificar se um grafo é nulo usando a matriz de adjacência, examine todas as entradas da matriz e verifique se todas são iguais a zero.

- Um **grafo bipartido** é um grafo cujos vértices podem ser divididos em dois conjuntos disjuntos, de forma que todas as arestas conectem um vértice de um conjunto ao de outro conjunto.

- Para verificar se um grafo é bipartido usando a matriz de adjacência, verifique se é possível dividir os vértices em dois conjuntos de tal forma que não exista nenhuma aresta conectando vértices do mesmo conjunto.

- Isso significa que, na matriz de adjacência, todas as entradas dentro de cada conjunto devem ser iguais a zero, e todas as entradas entre conjuntos diferentes devem ser iguais a zero.

ex:

```jsx
  A B C D
A 0 1 0 1
B 0 0 1 0
C 1 0 0 1
D 0 1 0 0
```

## arestasDoGrafo**:**

**Contagem de Arestas**:

- O número de arestas em um grafo é igual à metade do número de colunas na matriz de incidência.

- Cada coluna representa uma aresta, e contamos apenas uma vez cada aresta, mesmo que ela seja conectada a dois vértices.

- Se o grafo for dirigido, você não deve dividir o número de colunas na matriz de incidência por 2 para obter o número de arestas. A divisão por 2 é usada apenas para grafos não dirigidos.

**Conjunto de Arestas**:

- Cada coluna na matriz de incidência representa uma aresta.

- Para listar o conjunto de arestas, você pode criar uma lista onde cada elemento corresponde a uma aresta representada na matriz.

## grausDoVertice:

**Grafo Não Dirigido**:

- Se o grafo for não dirigido, você pode encontrar o grau de um vértice somando os valores correspondentes à linha do vértice na matriz de incidência. O grau de um vértice não dirigido é igual ao número de arestas incidentes nesse vértice.
- Por exemplo, na matriz de incidência, o grau do vértice A é a soma dos valores na linha A.

**Grafo Dirigido**:

- Se o grafo for dirigido, você deve considerar a orientação das arestas. O grau de um vértice dirigido é igual ao número de arestas que saem dele (grau de saída) menos o número de arestas que entram nele (grau de entrada).
- Para encontrar o grau de um vértice dirigido, subtraia a soma dos valores na linha correspondente à saída do vértice pela soma dos valores na linha correspondente à entrada do vértice na matriz de incidência.
