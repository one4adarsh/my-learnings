# 7. Heap

- A Heap is always complete
- MaxHeap: when the maximum value is on top

```
       99
   72      61
 58  55  27  18
```

- MinHeap: when the minimum value is on top

```
       18
   27      61
 58  55  72  99
```

- We implement a Heap with ArrayList
  - [99, 72, 61, 58, 55, 27, 18]
  - leftChildIndex = 2 * parentIndex + 1
  - rightChildIndex = 2 * parentIndex + 2
  - parentIndex = (int) (childIndex - 1) / 2

```
  99
     72 61
           58 55 27 18
```