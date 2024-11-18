# ch_03_data_types_variables
<!-- TOC -->
* [ch_03_data_types_variables](#ch_03_data_types_variables)
  * [Primitive types](#primitive-types)
  * [Primitive type wrappers](#primitive-type-wrappers)
  * [Reference types](#reference-types)
  * [Type conversion](#type-conversion)
  * [Type inference with local variables](#type-inference-with-local-variables)
<!-- TOC -->

## Primitive types
- Integers - byte, short, int, long
- Floating-point numbers - float, double
- Characters - char
  - ASCII: A-Z: 65 to 70
  - ASCII: a-z: 97 to 122
- Boolean - boolean

## Primitive type wrappers
- Byte, Short, Integer, Long
- Float, Double
- Character
- Boolean

## Reference types
- Class type
  - Special classes - String, StringBuffer, StringBuilder, Object
- Interface type
- Array type
  - _KIM: arrays of type char are not strings_

## Type conversion
- Explicit case - `(target-type) value` `e.g (int) 0.25` // int 0
- Type promotion - `e.g (1+2+3+4)/4.0` // double 2.5
- `Integer.parseInt("1234")` // int 1234

## Type inference with local variables
- `var`