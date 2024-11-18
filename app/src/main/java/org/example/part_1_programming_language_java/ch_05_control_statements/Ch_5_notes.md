# ch_05_control_statements
<!-- TOC -->
* [ch_05_control_statements](#ch_05_control_statements)
  * [Selection](#selection)
    * [if](#if)
    * [switch](#switch)
  * [Iteration](#iteration)
    * [while](#while)
    * [for](#for)
    * [for-each](#for-each)
    * [do-while](#do-while)
  * [Jump statements](#jump-statements)
<!-- TOC -->

## Selection

### if
```
if(expression){
    // ...
}
```

```
if(expression) {
    // ...
} else {
    // ...
}
```

```
if(expression) {
    // ...
} else if (expression) {
    // ...
} else {
    // ...
}
```

### switch
```
switch(expression) {
    case value1: 
        // ...
        break;
    case value2:
        // ...
        break;
    default:
        // ...
}
```

_A **switch** statement is usually more efficient than a set of nested **if**s._

## Iteration

### while
```
int n = 10;
while(n > 0) {
    // ...
    n--;
}
```

### for
```
for(int n = 10; n>0; n--) {
    // ...
}
```

### for-each

```
int[] nums = {1, 2, 3};
int sum = 0;
for (int x: nums) {
    sum += num;
}
```

it is possible to terminate loop using break statement

### do-while

```
int n = 10;
do {
    n--;
} while(n>0);
```

## Jump statements
- break
- continue
- return