<!-- TOC -->
* [resources](#resources)
  * [_1_JavaTechie_spring_boot_interview_mastery](#_1_javatechie_spring_boot_interview_mastery)
    * [part_1_q&a](#part_1_qa)
    * [part_2_q&a](#part_2_qa)
    * [part_3_q&a](#part_3_qa)
    * [part_4_q&a](#part_4_qa)
    * [part_5_q&a](#part_5_qa)
    * [part_6_q&a](#part_6_qa)
<!-- TOC -->

# resources

## _1_JavaTechie_spring_boot_interview_mastery

### part_1_q&a

- https://youtu.be/-_tPeb3VE6w?si=v4Lwxuc1NfKiy12m
- https://drive.google.com/file/d/1BFPKjUhe-lueVdvFKm0mmh9A0jwlOsSU/view?usp=sharing

1. Why choose spring boot over spring Framework?
2. What all spring boot starters you have used?
3. How do you run spring boot application?
4. Purpose of `@SpringBootApplication`?
5. Can you use the above three annotations instead of `@SpringBootApplication`?
6. What is auto configuration?
7. How to disable specific auto-configuration class in spring boot?
8. How to customize default configuration in Spring Boot?
9. How does Spring Boot `run()` method work internally?
10. What is the command line runner in Spring Boot?

### part_2_q&a

- https://youtu.be/IdTdgTBXlFw?si=g3Ht159fCUQmZtE2
- https://drive.google.com/file/d/1dSSsjvwYN4kh-Q8yq9lXJDFKw8OY20ut/view?usp=sharing

11. Can you explain the purpose of stereotype annotations in the Spring Framework?
12. How can you define bean in Spring Framework?
13. What is dependency injection?
14. How many ways we can perform DI in Spring?
15. Difference between Constructor Injection and Setter Injection?
16. Provide a real-world use case where `@PostConstruct` is particularly useful?
17. How to load values dynamically in Spring Boot Application?
18. Difference between `.properties` and `.yaml` file? When to choose which?
19. Difference between `.yml` and `.yaml`?
20. Which will load first `.yaml` or `.properties`?
21. How to load external properties?
22. How to map/bind config properties to a java object?

### part_3_q&a

- https://youtu.be/XfScG87YSHQ?si=d5BY0yeFEK4yw9O6
- https://drive.google.com/file/d/1cmjMTbT8kGfU5IzFjow1OEF7lSr8tuIP/view?usp=sharing

23. How will you resolve bean dependency ambiguity?
24. Can we avoid dependency ambiguity without using `@Qualifier`?
25. What is bean scope? Different types of bean scopes?
26. How to define custom bean scope?
27. Realtime use case for Singleton scope and Prototype scope?
28. Can we inject prototype bean in singleton bean? If yes, what will happen if we inject prototype bean in singleton bean?
29. What is the difference between spring singleton and plain singleton?
30. What is the purpose of the BeanPostProcessor Interface in Spring, and how can you use it to customize bean initialization and destruction?

### part_4_q&a

- https://youtu.be/8lXV2S31pHU?si=V-C-2_Du_srs3SB4
- https://drive.google.com/file/d/1pZXXKtIw0ldPXX3ozgVbfoDXAQX4H_UM/view?usp=sharing

31. Have you worked on Restful Webservices? If yes, what all HTTP methods have you used in your project?
32. How can you specify the HTTP method type for your REST endpoint?
33. Design REST endpoint - GET /user/{id}
34. Design REST endpoint - GET /users?query=car&limit=10
35. Difference between `@PathVariable` & `@RequestParam`
36. Why `@RestController` not `@Controller`
37. How can we deserialize a JSON request payload into an object within a Spring MVC controller?
38. Can we perform update operation in POST method? If yes, why do we need PUT method?
39. Can we pass RequestBody in GET method?
40. How can we perform content negotiation (XML/JSON) in Rest endpoint? (endpoint returning different MediaType)
41. What all status codes you've observed?
42. Customize status code for your endpoint?
43. How can you enable cross-origin?
44. How can you upload a file in Spring?
45. How do you maintain versioning of your REST API?
46. How will you document your REST API?
47. How can you hide certain REST endpoints to prevent them from being exposed externally?
48. How will you consume restful API?

### part_5_q&a

- https://youtu.be/FDowW7NAjmw?si=Ed25B6gdJ-Ct1HMA
- https://drive.google.com/file/d/1PGtwcSy-L13CMgcVyDR_vng-GJwcJ3Dm/view?usp=sharing

49. How will you handle exceptions in your project?
50. How can you avoid defining handlers for multiple exceptions, or what is the best practice for handling exceptions?
51. How will you validate or sanitize your input payload?
52. How can you populate a validation error message to the end users?
53. How can you define custom bean validation?
54. Spring Profile – how to enable specific environment?
    - Use case: let's say you find a bug in the production environment, and now you want to debug that scenario, how can you do that from local?
55. How can you enable a specific environment without using profiles?
56. What is the difference between @Profile and @Conditional?
57. What is AOP?
58. What is Pointcut, Join point and Advice in AOP?
59. What are different types of advice?
60. When to use `@Around` Advice?
    - Use case: to evaluate the performance of a method, or to design a logging framework to capture request and response body of a method

### part_6_q&a

- https://youtu.be/RKLjZ0jfQIQ?si=0rXj69EwqqZcczs5
- https://drive.google.com/file/d/1SucPTvsInluN1I-YBrSP7kHjKpH0knIW/view?usp=sharing

61. How does your application interact with the database and which frameworks are you using?
62. Why is it important to configure a physical naming strategy?
63. What are the key benefits of using Spring Data JPA?
64. What are the differences between Hibernate, JPA and Spring Data JPA?
65. How can you connect multiple databases or data sources in a single application?
66. What are the different ways to define custom queries in Spring Data JPA?
67. Can you provide example to find results based on some range?
68. How will you define entity relationships or association mapping in Spring Data JPA?
69. Is this possible to execute Join query in Spring Data JPA? If yes, how?
70. How will you implement pagination and sorting in Spring Data JPA?
