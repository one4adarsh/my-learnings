# 11. Sorting

## Bubble Sort

- Space: O(1)
- Time: O(n ^ 2)
- Code

```
for loop: i = [length - 1; 0; i--)
  for loop: j = [0; i; j++)
    if(array[j] > array[j+1])
      then swap
```

## Selection Sort

- Space: O(1)
- Time: O(n ^ 2)
- Code

```
for loop: i = [0; length; i++)
  minIndex = i
  for loop: j = [i+1; length; j++)
    if array[j] < array[minIndex]
      then minIndex = j
  if(i != minIndex)
    then swap
```

## Insertion Sort

- Space: O(1)
- Time: O(n ^ 2)
  - best use case: almost sorted array -> O(n)
- Code

```
for loop: i = [1; length; i++)
  temp = array[i]
  j = i - 1;
  while loop: (j > -1 && temp < array[j])
    array[j+1] = array[j]
    array[j] = temp;
    j--
```

## Merge Sort

- Space: O(n)
- Time: O(n log n)

## Quick Sort

- Space: O(1)
- Time: O(n log n)
  - worst use case: almost sorted array -> O(n ^ 2)

# For almost sorted array,

- best to use - Insertion sort
- worst to use - Quick sort