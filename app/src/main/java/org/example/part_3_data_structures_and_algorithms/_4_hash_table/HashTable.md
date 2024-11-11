# _4_hashtable

> class NodeHT

- attributes
  - String key
  - int value
  - NodeHT next
- constructor - (String key,int value)
  - this.key = key
  - this.value = value
  - this.next = null

> class HTConstructor

- attributes
  - int size = 7
  - NodeHT[] dataMap
- constructor - empty
  - this.dataMap = new NodeHT[size]
- methods
  - `void printTable()`
    - for loop: (0 to size)
      - temp = current value
      - while loop: (temp != null)
        - sout(key + ": " + value)
        - temp = temp.next

> class HTOperations

- methods
  - `int hash(String key)`
    - initialise: int hash = 0;
    - convert key to char[] keyChars
    - for loop: (int asciiValue: keyChars)
      - assign: hash = (hash + asciiValue * 23) % size
    - return: hash
  - `void set(String key, int value)`
    - initialise: NodeHT newNode = new NodeHT(key,value)
    - calculate: int index = this.hash(key)
    - check: if dataMap[index] == null
      - dataMap[index] = newNode
    - check: else
      - initialise: Node temp = dataMap[index]
      - while loop: (temp.next != null)
        - temp = temp.next
      - temp.next = newNode
  - `void get(String key)`
    - calculate: int index = this.hash(key)
    - initialise: Node temp = dataMap[index]
    - while loop: (temp != null)
      - check: if temp.key == key
        - sout(key + ": " + value)
        - break
      - temp = temp.next
    - sout("Not found")
  - `void getAllKeys()`
    - initialise: ArrayList<String> keys
    - for loop: (0 to size)
      - initialise: Node temp = dataMap[index]
      - while loop: temp != null
        - keys.add(temp.key)
        - temp = temp.next
    - sout(keys)