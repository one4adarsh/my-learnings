<!-- TOC -->
* [part_2_q&a](#part_2_qa)
  * [11. Can you explain the purpose of stereotype annotations in the Spring Framework?](#11-can-you-explain-the-purpose-of-stereotype-annotations-in-the-spring-framework)
  * [12. How can you define bean in Spring Framework?](#12-how-can-you-define-bean-in-spring-framework)
  * [13. What is dependency injection?](#13-what-is-dependency-injection)
  * [14. How many ways we can perform DI in Spring?](#14-how-many-ways-we-can-perform-di-in-spring)
  * [15. Difference between Constructor Injection and Setter Injection?](#15-difference-between-constructor-injection-and-setter-injection)
  * [16. Provide a real-world use case where `@PostConstruct` is particularly useful?](#16-provide-a-real-world-use-case-where-postconstruct-is-particularly-useful)
* [17. How to load values dynamically in Spring Boot Application?](#17-how-to-load-values-dynamically-in-spring-boot-application)
  * [18. Difference between `.properties` and `.yaml` file? When to choose which?](#18-difference-between-properties-and-yaml-file-when-to-choose-which)
  * [19. Difference between `.yml` and `.yaml`?](#19-difference-between-yml-and-yaml)
  * [20. Which will load first `.yaml` or `.properties`?](#20-which-will-load-first-yaml-or-properties)
  * [21. How to load external properties?](#21-how-to-load-external-properties)
  * [22. How to map/bind config properties to a java object?](#22-how-to-mapbind-config-properties-to-a-java-object)
<!-- TOC -->

# part_2_q&a

## 11. Can you explain the purpose of stereotype annotations in the Spring Framework?

- Stereotype annotations are used to indicate the role or purpose of class, e.g.
  - @Component (parent)
  - @Service
  - @Controller
  - @Repository

## 12. How can you define bean in Spring Framework?

- Define stereotype annotation and spring will take care of the entire lifecycle of that class

OR

- Define custom configuration

  ```
  @Configuration
  public class AppConfig {
    @Bean
    public Demoservice demoservice () {
      return new Demoservice ();
    }
  }
  ```

## 13. What is dependency injection?

- It is a design pattern.
- To achieve loose coupling between class by removing direct dependency.
- In simple words, we outsource class instance creation to spring.

  ```
  @Autowired
  private ClassName className;
  ```

## 14. How many ways we can perform DI in Spring?

- Field level DI
  ```
  @Autowired
  private OrderRepository orderRepository;
  ```

- Setter DI
  ```
  @Autowired
  public void setOrderRepository (OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }
  ```

- Constructor DI
  ```
  @Autowired
  public OrderService (OrderRepository orderRepository){
    this.ortherRepository = orderRepository;
  }
  ```

## 15. Difference between Constructor Injection and Setter Injection?

- When to use
  - constructor based dependency injection for mandatory dependencies
  - setter based dependency injection for optional dependencies

- Overriding
  - Setter injection overrides the constructor injection
  - If we use both, the IOC will use setter

- Mutability
  - Constructor: immutable (i.e., can't modify after object creation)
  - Setter: mutable

- Circular Dependency
  - Constructor: can't revolve circular dependency
  - Setter: circular dependency mitigated - use `@Lazy`

## 16. Provide a real-world use case where `@PostConstruct` is particularly useful?

- Used for pre-processing logic
- Note:
  - Firstly spring application `run()` method runs
  - Immediately after this `@PostConstruct` runs
  - After that, `CommandLineRunner` executes

  ```
  @PostConstruct
  public void initLogic() {
    System.out.println("Post construct logic executed");
  }
  ```

- Example use cases
  - connection pool logic
  - kafka producer/consumer instantiate
  - data seeding

# 17. How to load values dynamically in Spring Boot Application?

- in application properties
  ```
  discount.offer.price=25
  ```
- `@Value` annotation in code
  ```
  @Value("${discount.offer.price}")
  private int discountPrice;
  ```

OR

- ```
  environment.getProperty("discount.offer.price");
  ```

OR

- can also do this through spring configurations – environment variable

## 18. Difference between `.properties` and `.yaml` file? When to choose which?

1. syntax and structure -> `.=` vs `:`
2. hierarchy -> no order vs proper order
3. list & arrays -> not possible vs possible
4. complex data type possible in .yaml
5. readability in .yaml

## 19. Difference between `.yml` and `.yaml`?

- Both are the same.
- In the older version of windows, there was restriction to three letter extensions.

## 20. Which will load first `.yaml` or `.properties`?

- First `.properties` then `.yaml`
- `PropertySourceLoaderInterface` has two implementations for loading both files

## 21. How to load external properties?

- ```
  spring.configuration.import=file://users/javatechie/desktop
  ```

## 22. How to map/bind config properties to a java object?

```
@Configuration
@ConfigurationProperties(prefix="spring.datasource")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class DataSourceConfig {
  private String username;
  private String password;
}
```




