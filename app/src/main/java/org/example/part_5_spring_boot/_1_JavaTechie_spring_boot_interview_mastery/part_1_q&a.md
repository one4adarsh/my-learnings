<!-- TOC -->
* [part_1_q&a](#part_1_qa)
  * [1. Why choose spring boot over spring Framework?](#1-why-choose-spring-boot-over-spring-framework)
  * [2. What all spring boot starters you have used?](#2-what-all-spring-boot-starters-you-have-used)
  * [3. How do you run spring boot application?](#3-how-do-you-run-spring-boot-application)
  * [4. Purpose of `@SpringBootApplication`?](#4-purpose-of-springbootapplication)
  * [5. Can you use the above three annotations instead of `@SpringBootApplication`?](#5-can-you-use-the-above-three-annotations-instead-of-springbootapplication)
  * [6. What is auto configuration?](#6-what-is-auto-configuration)
  * [7. How to disable specific auto-configuration class in spring boot?](#7-how-to-disable-specific-auto-configuration-class-in-spring-boot)
  * [8. How to customize default configuration in Spring Boot?](#8-how-to-customize-default-configuration-in-spring-boot)
  * [9. How does Spring Boot `run()` method work internally?](#9-how-does-spring-boot-run-method-work-internally)
  * [10. What is the command line runner in Spring Boot?](#10-what-is-the-command-line-runner-in-spring-boot)
<!-- TOC -->

# part_1_q&a

## 1. Why choose spring boot over spring Framework?

- Dependency Resolution/Avoid version conflict
- Avoid additional configuration
- Embed Tomcat, Jetty (no need to deploy WAR files)
- Provide production-ready features such as metrics, health checks.

## 2. What all spring boot starters you have used?

- spring-boot-starter-web
- spring-boot-starter-data-jpa
- spring-boot-starter-hateoas
- spring-boot-starter-validation
- spring-boot-starter-security
- spring-boot-starter-actuator

## 3. How do you run spring boot application?

- `mvn spring-boot-run`
  - If java + maven - then jar file will be in target folder

## 4. Purpose of `@SpringBootApplication`?

Equivalent to

- `@EnableAutoConfiguration` - Automatically configure dependencies
- `@ComponentScan` - Enable component scanning in main class and sub packages
- `@Configuration` - Allow to register extra bean in the context or input additional configuration classes.

## 5. Can you use the above three annotations instead of `@SpringBootApplication`?

- Yes

## 6. What is auto configuration?

- in application.properties file, add the following line -
  `debug=true`
- Then, run your application
- It lists positive matches and negative matches
  - positive matches will have a chance to be enabled by spring boot for us
- In auto configuration class, if all the conditions are satisfied, then only spring boot will autoconfigure for
  application

## 7. How to disable specific auto-configuration class in spring boot?

- from main app - `@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})`
  OR
- from application.properties -
  `spring.autoconfigure.exclude = org.springframework.boot.autoconfigure.aop.AopAutoconfiguration`

## 8. How to customize default configuration in Spring Boot?

- we can do through `application.properties` file

## 9. How does Spring Boot `run()` method work internally?

- Check application type from environment properties
- Create ApplicationContext
- Register bean into context
- Kick up embedded Tomcat container to run your jar/war

## 10. What is the command line runner in Spring Boot?

- Any preprocessing logic can be placed here
