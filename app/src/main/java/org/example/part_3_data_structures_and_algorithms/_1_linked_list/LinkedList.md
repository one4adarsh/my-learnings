# _1_linked_list

> class NodeLL

- attributes
  - int value
  - NodeLL next
- constructor - (int value)
  - this.value = value

> class LLConstructor

- attributes
  - NodeLL head
  - NodeLL tail
  - int length
- constructor - (int value)
  - NodeDLL newNode = new NodeDLL(value)
  - head = newNode
  - tail = newNode
  - length = 1
- methods
  - `void getHead()`
    - sout(head.value)
  - `void getTail()`
    - sout(tail.value)
  - `void getLength()`
    - sout(length)
  - `void printList()`
    - NodeLL temp = head
    - while loop: (temp != null)
      - sout(temp.value)
      - temp = temp.next

> class LLOperations
- methods
  - `void append(int value)`
  - `void removeLast()`
  - `void prepend(int value)`
  - `void removeFirst()`
  - `NodeDLL get(int index)`
    - check if (index < 0 || index >= length)
      - return null
    - NodeLL temp = head
    - for loop (0, index)
      - temp = temp.next
    - return temp
  - `boolean set(int index, int value)`
    - check if (index < 0 || index >= length)
      - return false
    - NodeLL temp = get(index)
    - check if (temp != null)
      - temp.value = value
      - return true
    - return false
  - `boolean insert(int index, int value)`
    - check if (index < 0 || index > length)
      - return false
    - check if (index == 0)
      - prepend(value)
      - return true
    - check if (index == length)
      - append(value)
      - return true
    - NodeLL newNode = new NodeLL(value)
    - NodeLL before = get(index - 1)
    - newNode.next = before.next
    - before.next = newNode
    - length+=
    - return true
  - `void remove(int index)`
    - check if (index < 0 || index >= length)
      - return null
    - check if (index == 0)
      - removeFirst()
    - check if (index == length-1)
      - removeLast()
    - NodeLL before = get(index-1)
    - NodeLL temp = before.next
    - prev.next = temp.next
    - temp.next = null
    - length--
  - `void reverse()`
    - // swap head and tail
    - NodeLL temp = head
    - head = tail
    - tail = temp
    - // define after and before
    - NodeLL after = temp.next
    - NodeLL before = null
    - // reverse
    - for loop (0, length)
      - after = temp.next
      - temp.next = before
      - before = temp
      - temp = after

