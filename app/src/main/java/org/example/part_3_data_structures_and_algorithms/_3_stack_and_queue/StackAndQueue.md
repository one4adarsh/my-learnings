# _3_stack_and_queue

## Stack

```
  top
   |
   5 -> 6 -> 7 ->
```

> class NodeStack

- attributes
  - int value
  - NodeStack next
- constructor - (int value)
  - this.value = value

> class StackConstructor

- attributes
  - NodeStack top
  - int height
- constructor - (int value)
  - NodeStack newNode = new NodeStack(value)
  - top = newNode
  - height = 1
- methods
  - `void getTop()`
    - sout(top.value)
  - `void getHeight()`
    - aout(height)
  - `void printStack()`
    - NodeStack temp = top;
    - while loop: (temp != null)
      - sout(temp.value)
      - temp = temp.next

> class StackOperations

- methods
  - `void push(int value)`
    - NodeStack newNode = new NodeStack(value)
    - check if (height == 0)
      - top = newNode
    - check else
      - newNode.next = top
      - top = newNode
    - height++
  - `void pop()`
    - check if (height == 0)
      - sout(empty)
    - else
      - NodeStack temp = top
      - top = top.next
      - temp.next = null
      - height--

## Queue

```
to Add: O(1)
to Remove: O(1)

  first(remove here)       last(add here)
   |                        |
   5 -> 6 -> 7 -> 8 -> 9 -> 10 ->
```

> class NodeQueue

- attributes
  - int value
  - NodeQueue next
- constructor - (int value)
  - this.value = value

> class QueueConstructor

- attributes
  - NodeQueue first
  - NodeQueue last
  - int length
- constructor - (int value)
  - NodeStack newNode = new NodeStack(value)
  - first = newNode
  - last = newNode
  - length = 1
- methods
  - `void getFirst()`
    - sout(first.value)
  - `void getLast()`
    - sout(last.value)
  - `void getLength()`
    - sout(length)
  - `void printQueue()`
    - NodeQueue temp = first
    - while loop: (temp != null)
      - sout(temp.value)
      - temp = temp.next

> class QueueOperations

- methods
  - `void enquque(int value)`
    - NodeQueue newNode = new NodeQueue(value)
    - check if (height == 0)
      - first = newNode
      - last = newNode
    - check else
      - last.next = newNode
      - last = newNode
    - length++
  - `void dequeue()`
    - check if(length == 0)
      - sout(empty)
    - check else if(length == 1)
      - first = null
      - last = null
      - length = 0
    - check else
      - NodeQueue temp = first
      - first = first.next
      - temp.next = null
      - length--

