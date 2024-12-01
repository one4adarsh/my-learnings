# SOLID

## Why SOLID?

- it helps us to create more maintainable, understandable, and flexible software
- as our applications grow in size, we can reduce their complexity

## What is SOLID?

> S - Single Responsibility Principle

- A class should have one and only one reason to change, meaning that a class should have only one job
- less functionality means lower dependency → easier testing and well-organized classes
- my understanding in real-world application
  - one DTO class should be used for just one use case
    - e.g.
      - we may have similar kind of DTOs for POST and PUT endpoints
      - however, we should not use 1 single DTO for both purposes
      - we may have some fields in POST request body that are compulsory and can't be updated {e.g - emailId}
      - and these attributes are not required in PUT request body
      - That's why it's a good idea to keep one class for one purpose

> O - Open/Closed Principle

- software entities should be open for extension, but closed for modification
- my understanding in real-world application
  - if some new feature is being added in a class
  - it's easier to extend it and build a new class
  - e.g.
    - In our project, we make sure all entities have similar fixed attributes
      - like id(define how its generated), created_at, updated_at, deleted_at
    - and extended other entity classes with other specific attributes

> L - Liskov’s Substitution Principle

- if class A is a subtype of class B, we should be able to replace B with A without disrupting the behavior of our
  program

> I - Interface Segregation Principle

- larger interfaces should be split into smaller ones

> D – Dependency Inversion Principle

- Dependency Inversion is a general design guideline which recommends that classes should only have direct relationships
  with high-level abstractions
- Tt suggests that classes should rely on abstractions (e.g., interfaces or abstract classes) rather than concrete
  implementations
- Note: Difference between Dependency Inversion and Dependency Injection
  - Dependency Injection applies the Inversion of Control(IoC) principle by ensuring classes are never responsible for
    creating or supplying their own dependencies
    - (and therefore aren't responsible for the lifetime of those dependencies either)
  - Dependency Injection is a design pattern based around the principle of IoC
