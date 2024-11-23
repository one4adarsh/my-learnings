<!-- TOC -->
  * [part_5_q&a](#part_5_qa)
  * [49. How will you handle exceptions in your project?](#49-how-will-you-handle-exceptions-in-your-project)
  * [50. How can you avoid defining handlers for multiple exceptions, or what is the best practice for handling exceptions?](#50-how-can-you-avoid-defining-handlers-for-multiple-exceptions-or-what-is-the-best-practice-for-handling-exceptions)
  * [51. How will you validate or sanitize your input payload?](#51-how-will-you-validate-or-sanitize-your-input-payload)
  * [52. How can you populate a validation error message to the end users?](#52-how-can-you-populate-a-validation-error-message-to-the-end-users)
  * [53. How can you define custom bean validation?](#53-how-can-you-define-custom-bean-validation)
  * [54. Spring Profile – how to enable specific environment?](#54-spring-profile--how-to-enable-specific-environment)
  * [55. How can you enable a specific environment without using profiles?](#55-how-can-you-enable-a-specific-environment-without-using-profiles)
  * [56. What is the difference between @Profile and @Conditional?](#56-what-is-the-difference-between-profile-and-conditional)
  * [57. What is AOP?](#57-what-is-aop)
  * [58. What is Pointcut, Join point and Advice in AOP?](#58-what-is-pointcut-join-point-and-advice-in-aop)
  * [59. What are different types of advice?](#59-what-are-different-types-of-advice)
  * [60. When to use `@Around` Advice?](#60-when-to-use-around-advice)
<!-- TOC -->

## part_5_q&a

## 49. How will you handle exceptions in your project?

- We need to populate the correct error message to the end user
- Extend exception class from either
  - RunTimeException - (unchecked)
  - Exception – (checked)
- `@RestControllerAdvice`
- `@ExceptionHandler`

- in Spring Boot 3.0+
  - no need to define custom error data class i.e define your own class to map error message
  - `ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMassage());`

## 50. How can you avoid defining handlers for multiple exceptions, or what is the best practice for handling exceptions?

- Wrap around in a try-catch statement and throw your own custom exception
- Handle this exception only

## 51. How will you validate or sanitize your input payload?

- dependency - `spring-boot-starter-validation`
- use annotations - `@NotNull`, `@NotEmpty`, `@NotBlank`, `@Max`, `@Min`

## 52. How can you populate a validation error message to the end users?

- handler for error

## 53. How can you define custom bean validation?

- Define annotation
  ```
  @Target({ElementType.FIELD,ElementType.PARAMETER})
  @Retention(RetentionPolicy.RUNTIME)
  @Constraint(validatedBy = ProductTypeValidator.class)
  public @interface ValidateProductType {
    public String message() default "Invalid productType: It should be either Electronics OR Education OR Baby&Kids";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
  }
  ```
- Define validator
  ```
  public class ProductTypeValidator implements ConstraintValidator<ValidateProductType, String> {
    @Override
    public boolean isValid(String productType, ConstraintValidatorContext constraintValidatorContext) {
        List<String> productTypes = Arrays.asList("Electronics", "Education","Baby&Kids");
        return productTypes.contains(productType);
    }
  }
  ```
- Use validator
  ```
  @ValidateProductType
  private String productType;
  ```

## 54. Spring Profile – how to enable specific environment?

> Use case: let's say you find a bug in the production environment, and now you want to debug that scenario, how can you do that from local?

- In local machine, we need to switch the environment
- To define multiple environments, we follow this pattern
  - `application.properties`
  - `application-prod.properties`
- To use profiles, use `@Profile("prod")` and specific code runs only for that profile selection
  ```
  @Configuration
  public class KafkaConfig {
    @Bean
    @Profile("prod")
    public KafkaProps devKafkaProps() {
        KafkaProps props = new KafkaProps("2.237.64.90:8181", 8181, "dev-user-topic");
        System.out.println("kafka prod bean initialized !");
        return props;
    }
  }
  ```
- In application.properties, we need to declare which profile to use
  ```
  spring.profiles.active=prod
  ```

## 55. How can you enable a specific environment without using profiles?

- `@ConditionalOnExpression("\${app.enableKafka}")`
OR
- `@ConditionalOnProperty(prefix = "app.active",name = "env",havingValue = "prod")`
- In application.properties, we need to declare 
  ```
  app.enableKafka=true
  OR
  app.active.env=prod
  ```

## 56. What is the difference between @Profile and @Conditional?

- `@Profile` is specifically designed for activating components based on the active profile in the application
- `@Conditional` is a more general purpose annotation which allows us to define condition for bean creation or config based on various criteria

## 57. What is AOP?

- AOP - Aspect Oriented Programming
- It provides a way to separate cross-cutting concerns or secondary logic from the main business logic
  - Secondary logic means it could be a transaction, logging, validation, auditing or notification related code

## 58. What is Pointcut, Join point and Advice in AOP?

- `Join point` is any point in your program such as method execution, exception handling, field access, etc. Spring supports only method execution join point.
- `Pointcut` is an expression language of AOP that matches join points.
- `Advice` represents an action taken by an aspect at a particular join point. There are different types of advices:

## 59. What are different types of advice?

- `@Before` - it executes before a join point
- `@AfterReturning` - it executes after a join point completes normally
- `@AfterThrowing` - it executes if method exits by throwing an exception
- `@After` - it executes after a join point regardless of join point exit whether normally or exceptional return
- `@Around` - it executes before and after a join point

## 60. When to use `@Around` Advice?

> Use case: to evaluate the performance of a method, or to design a logging framework to capture request and response body of a method