# 1. Fibonacci Sequence

## fibNormal

- define edge case
  - if n == 0 or n==1
  - then return n
- return fibNormal(n-1) + fibNormal(n-2)

## fibMemoization
- create a memo of some size
- define edge case
  - if n == 0 or n==1
  - then return n
- check if memo has value for it
  - if yes, return the value
- save the value in memo and calculate fibNormal(n-1) + fibNormal(n-2)
- return the saved value

## fibBottomUp
- identify which values are required for calculation
- allocate space - create a variable for simplest case
- fill up the base case
- create a for loop till n
- return the value for n