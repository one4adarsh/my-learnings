# _6_graph

- Vertex or Node
- Edge or Connection
  - The edges can be weighted or non-weighted
  - The connection can be directional or bidirectional
- Tree is a form of graph with limitation that each node can point to only 2 nodes

```
        A
     /     \
   E         B
    \       /
     D  -  C
``` 

## Adjacency Matrix

|   | A | B | C | D | E |
|---|---|---|---|---|---|
| A | 0 | 1 | 0 | 0 | 1 |
| B | 1 | 0 | 1 | 0 | 0 |
| C | 0 | 1 | 0 | 1 | 0 |
| D | 0 | 0 | 1 | 0 | 1 |
| E | 1 | 0 | 0 | 1 | 0 |

- We are storing connections and non-connections both in matrix, which is incredibly inefficient
- 45 degree line of zeroes
- If bidirectional - mirror image on each side of this 45 degree line
- If the edges are weighted, we'll store these weights instead of 1's

## Adjacency List

```
{
  "A" = ["B", "E"],
  "B" = ["A", "C"],
  "C" = ["B", "D"],
  "D" = ["C", "E"],
  "E" = ["D", "A"]
}
```

- Hashmap based representation
  - key = vertex
  - value = ArrayList of vertex

## Big O

### Space Complexity

| Matrix |   List   |
|:------:|:--------:|
| O(V^2) | O(V + E) |

### Time Complexity

|               | Matrix |   List   |
|:-------------:|:------:|:--------:|
|  Add vertex   | O(V^2) |   O(1)   |
|   Add edge    |  O(1)  |   O(1)   |
|  Remove edge  |  O(1)  |   O(E)   |
| Remove vertex | O(V^2) | O(V + E) |



