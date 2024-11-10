# SQL-Basics

<!-- TOC -->
* [SQL-Basics](#sql-basics)
  * [SQL Commands](#sql-commands)
  * [Data Types, Primary & Foreign Keys, Constraints](#data-types-primary--foreign-keys-constraints)
    * [Data Types](#data-types)
    * [Primary Key & Foreign Keys](#primary-key--foreign-keys)
    * [Constraints](#constraints)
  * [Create, Insert, Update](#create-insert-update)
    * [Create table](#create-table)
    * [Insert values in a table](#insert-values-in-a-table)
    * [Update existing rows in a table](#update-existing-rows-in-a-table)
  * [Alter](#alter)
    * [Add column](#add-column)
    * [Drop column](#drop-column)
    * [Alter/Modify column](#altermodify-column)
  * [Delete](#delete)
    * [Delete values in a table](#delete-values-in-a-table)
    * [Delete table](#delete-table)
    * [Truncate table](#truncate-table)
  * [Select statement](#select-statement)
  * [Where clause](#where-clause)
  * [Operators in SQL](#operators-in-sql)
  * [Limit clause](#limit-clause)
  * [Order By clause](#order-by-clause)
  * [Functions in SQL](#functions-in-sql)
  * [String Functions](#string-functions)
  * [Aggregate Functions](#aggregate-functions)
  * [Group By Statement](#group-by-statement)
  * [Having clause](#having-clause)
  * [Order of execution](#order-of-execution)
  * [Timestamp](#timestamp)
    * [Timestamp Function](#timestamp-function)
    * [Extract Function](#extract-function)
  * [Join](#join)
    * [Types of Join](#types-of-join)
    * [Inner Join](#inner-join)
    * [Left Join](#left-join)
    * [Right Join](#right-join)
    * [Full Join](#full-join)
    * [Self Join](#self-join)
  * [Union](#union)
  * [Union All](#union-all)
  * [Subquery / Inner Query / Nested Query](#subquery--inner-query--nested-query)
<!-- TOC -->

## SQL Commands

- DDL - Data Definition Language - create, alter, drop
- DML - Data Manipulation Language - select, insert, update, delete
- DCL - Data Control Language - grant and revoke permissions to users

## Data Types, Primary & Foreign Keys, Constraints

```
RDBMS

  Database
    |
    Tables
      |
      Data
        |
        Rows & Columns
```

### Data Types

- What value a column can store

- `int` - integer value
- `float` - decimal point number
- `bool` - boolean value
- `char` - fixed length string
- `varchar` - variable length string
- `data` - format: YYYY-MM-DD
- `datetime` - format: YYYY_MM_DD hh:mm:ss

### Primary Key & Foreign Keys

- A primary key is a unique column set in a table to easily identify & locate data in queries
  - unique, not null

- A foreign key is a column used to link two or more tables together
  - not unique, can be null

### Constraints

- Constraints are used to specify rules for data in a table
  - can be specified during the table creation
  - can be specified later on also

- `NOT NULL` - columns can not have null values
- `UNIQUE` - ensures all values in a column are different
- `PRIMARY KEY` - NOT NULL + UNIQUE
- `FOREIGN KEY` - use to link multiple tables
- `CHECK` - ensures that the value in a column satisfies a specific condition
- `DEFAULT` - sets a default value for a column if no value is specified
- `CREATE INDEX` - used to create and retrieve data from the database very quickly

## Create, Insert, Update

### Create table

- syntax:

```
CREATE TABLE table_name 
(
  column_name1 datatype constraint,
  column_name2 datatype constraint
);
```

- example:

```
CREATE TABLE customer
(
  cust_id int8 PRIMARY KEY,
  cust_name varchar(50) NOT NUll,
  age int NOT NULL,
  city char(50),
  salary numeric
);
```

### Insert values in a table

- syntax:

```
INSERT INTO table_name
(column_name1, column_name2, ...)
VALUES
(value1, value2, ...);
```

- example:

```
INSERT INTO customer
(cust_id, cust_name, age, city, salary)
VALUES
(1, 'Sam', 26, 'Delhi', 9000),
(2, 'Ram', 21, 'Mumbai', 11000);
```

### Update existing rows in a table

- syntax:

```
UPDATE table_name
SET column_name1 = 'value1', column_name2 = 'value2'
WHERE "ID"='value';
```

- example:

```
UPDATE customer
SET cust_name='Xam', age=32
WHERE cust_id = 2;
```

## Alter

### Add column

- syntax:

```
ALTER TABLE table_name
ADD column_name datatype;
```

### Drop column

- syntax:

```
ALTER TABLE table_name
DROP COLUMN column_name;
```

### Alter/Modify column

- syntax:

```
ALTER TABLE table_name
ALTER COLUMN column_name datatype;
```

## Delete

### Delete values in a table

- syntax:

```
DELETE FROM table_name
WHERE condition;
```

### Delete table

- DROP TABLE deletes a table in the database
- syntax:

```
DROP TABLE table_name
```

### Truncate table

- TRUNCATE TABLE deletes the data inside a table, but not table
- syntax:

```
TRUNCATE TABLE table_name;
```

## Select statement

- syntax:

```
SELECT column_name FROM table_name;
```

- example:

```
SELECT * FROM customers;
```

## Where clause

- Where clause is used to filter records
- syntax:

```
SELECT column_name FROM table_name
WHERE conditions;
```

- example:

```
SELECT * FROM customers
WHERE cust_id = 1;
```

## Operators in SQL

- Arithmetic Operators: +, -, *, /, %
- Comparison Operators: -, !=, <, <=, >, >=
- Logical Operators: ALL, IN, BETWEEN, LIKE, AND, OR, NOT, ANY
- Bitwise Operators: &, |

## Limit clause

- Where clause is used to set an upper limit on the number of tuples returned by SQL
- syntax:

```
SELECT column_name FROM table_name
LIMIT numeric;
```

- example:

```
SELECT * FROM customers
LIMIT 5;
```

## Order By clause

- Where clause is used to sort the result-set in an ascending(ASC) or descending(DESC) order
- syntax:

```
SELECT column_name FROM table_name
ORDER BY column_name ASC;
```

- example:

```
SELECT * FROM customers
ORDER BY cust_id ASC;
```

## Functions in SQL

1. System Defined Functions - rand(), round(), upper(), lower()
2. Uses Defined Functions - count(), sum(), avg(), max()

## String Functions

- UPPER() - converts the value of a field to uppercase
- LOWER() - converts the value of a field to lowercase
- LENGTH() - return the length of the value in a text field
- SUBSTRING() - extracts a substring from a string
- NOW() - returns the current system date & time
- FORMAT() - used to set format of a field
- CONCAT() - adds two or more stings together
- REPLACE() - replaces all occurrences of a substring within a string with a new substring
- TRIM() - removes leading and trailing spaces(or other specified characters) from a string

## Aggregate Functions

- COUNT() - returns numbers of values
- SUM() - returns sum of all values
- AVG() - returns average value
- MAX() - returns maximum value
- MIN() - returns minimum value
- ROUND() - rounds a number to a specified number of decimal places

## Group By Statement

- Groups rows that have the same values into summary rows
- Used by aggregate functions to group the result-set by one or more columns
- syntax:

```
SELECT column_name(s)
FROM table_name
GROUP BY column_name(s);
```

- example:

```
SELECT mode , SUM(amount) AS total
FROM payment
GROUP BY mode;
```

## Having clause

- Used to apply filter on the result of GROUP BY based on specific conditions
- `WHERE` clause places conditions on SELECT statement
- `HAVING` clause places conditions on groups created by GROUP BY Clause

- syntax:

```
SELECT column_name(s)
FROM table_name
WHERE conditons(s)
GROUP BY column_name(s)
HAVING condition(s);
```

- example:

```
SELECT mode , SUM(amount) AS total
FROM payment
GROUP BY mode
HAVING COUNT(amount) >= 3
ORDER BY total DESC;
```

## Order of execution

1. SELECT
2. FROM
3. WHERE
4. GROUP BY
5. HAVING
6. ORDER BY
7. LIMIT

## Timestamp

- Used for values that contains both date and time parts

- TIME - HH:MM:SS
- DATE - YYYY-MM-DD
- YEAR - YYYY or YY
- TIMESTAMP - YYYY-MM-DD HH:MM:SS
- TIMESTAMPZ - contains date, time and timezone

### Timestamp Function

- SHOW TIMEZONE
- SELECT NOW()
- SELECT TIMEOFDAY()
- SELECT CURRENT_TIME
- SELECT CURRENT_DATE
-

### Extract Function

- extracts a part from a given date value

- YEAR
- QUARTER
- MONTH
- WEEK
- DAY
- HOUR
- MINUTE
- DOW - Day of Week
- DOY - Day of Year

## Join

- Used to combine data from 2 or more tables, based on related columns between them.

### Types of Join

1. Inner Join - returns records that have matching values in both sides
2. Left Join - returns all records from the left table, and the matched records from the right table
3. Right Join - returns all records from the right table, and the matched records from the left table
4. Full Join - returns all records when there is a match in either left or right table

### Inner Join

- syntax:

```
SELECT column_name(s)
FROM table_name1
INNER JOIN table_name2
ON table_name1.column_name = table_name2.column_name;
```

- example:

```
SELECT *
FROM customer AS c
INNER JOIN payment AS p
ON c.customer_id = p.customer_id;
```

### Left Join

- syntax:

```
SELECT column_name(s)
FROM table_name1
LEFT JOIN table_name2
ON table_name1.column_name = table_name2.column_name;
```

- example:

```
SELECT *
FROM customer AS c
LEFT JOIN payment AS p
ON c.customer_id = p.customer_id;
```

### Right Join

- syntax:

```
SELECT column_name(s)
FROM table_name1
RIGHT JOIN table_name2
ON table_name1.column_name = table_name2.column_name;
```

- example:

```
SELECT *
FROM customer AS c
RIGHT JOIN payment AS p
ON c.customer_id = p.customer_id;
```

### Full Join

- syntax:

```
SELECT column_name(s)
FROM table_name1
FULL OUTER JOIN table_name2
ON table_name1.column_name = table_name2.column_name;
```

- example:

```
SELECT *
FROM customer AS c
FULL OUTER JOIN payment AS p
ON c.customer_id = p.customer_id;
```

### Self Join

- regular join in which a table is joined to itself
- Powerful for comparing values in a column of rows with same table
- example:

```
SELECT column_name(s)
FROM table_name1 As t1
JOIN table_name1 as t2
ON t1.column_name = t2.column_name;
```

## Union

- used to combine/concatenate the results of two or more SELECT statements without returning any duplicate rows and
  keeps unique records
- The select statements must have
  - same number of columns selected
  - same data type
  - same order
- syntax:

```
SELECT column_name(s) FROM table_name1
UNION
SELECT column_name(s) FROM table_name2;
```

## Union All

- same as union but includes duplicates as well
- syntax:

```
SELECT column_name(s) FROM table_name1
UNION ALL
SELECT column_name(s) FROM table_name2;
```

## Subquery / Inner Query / Nested Query

- Allows us to create complex query on the output of another query
- syntax:

```
SELECT column_name(s) 
FROM table_name
WHERE column_name OPERATOR
  (SELECT column_name FROM table_name WHERE ...);
```
