<!-- TOC -->
  * [part_4_q&a](#part_4_qa)
  * [31. Have you worked on Restful Webservices? If yes, what all HTTP methods have you used in your project?](#31-have-you-worked-on-restful-webservices-if-yes-what-all-http-methods-have-you-used-in-your-project)
  * [32. How can you specify the HTTP method type for your REST endpoint?](#32-how-can-you-specify-the-http-method-type-for-your-rest-endpoint)
  * [33. Design REST endpoint - GET /user/{id}](#33-design-rest-endpoint---get-userid)
  * [34. Design REST endpoint - GET /users?query=car&limit=10](#34-design-rest-endpoint---get-usersquerycarlimit10)
  * [35. Difference between `@PathVariable` & `@RequestParam`](#35-difference-between-pathvariable--requestparam)
  * [36. Why `@RestController` not `@Controller`](#36-why-restcontroller-not-controller)
  * [37. How can we deserialize a JSON request payload into an object within a Spring MVC controller?](#37-how-can-we-deserialize-a-json-request-payload-into-an-object-within-a-spring-mvc-controller)
  * [38. Can we perform update operation in POST method? If yes, why do we need PUT method?](#38-can-we-perform-update-operation-in-post-method-if-yes-why-do-we-need-put-method)
  * [39. Can we pass RequestBody in GET method?](#39-can-we-pass-requestbody-in-get-method)
  * [40. How can we perform content negotiation (XML/JSON) in Rest endpoint? (endpoint returning different MediaType)](#40-how-can-we-perform-content-negotiation-xmljson-in-rest-endpoint-endpoint-returning-different-mediatype)
  * [41. What all status codes you've observed?](#41-what-all-status-codes-youve-observed)
  * [42. Customize status code for your endpoint?](#42-customize-status-code-for-your-endpoint)
  * [43. How can you enable cross-origin?](#43-how-can-you-enable-cross-origin)
  * [44. How can you upload a file in Spring?](#44-how-can-you-upload-a-file-in-spring)
  * [45. How do you maintain versioning of your REST API?](#45-how-do-you-maintain-versioning-of-your-rest-api)
  * [46. How will you document your REST API?](#46-how-will-you-document-your-rest-api)
  * [47. How can you hide certain REST endpoints to prevent them from being exposed externally?](#47-how-can-you-hide-certain-rest-endpoints-to-prevent-them-from-being-exposed-externally)
  * [48. How will you consume restful API?](#48-how-will-you-consume-restful-api)
<!-- TOC -->

## part_4_q&a

## 31. Have you worked on Restful Webservices? If yes, what all HTTP methods have you used in your project?

- `POST` - create
- `PUT` - update
- `GET` - retrieve
- `PATCH` – update partially
- `DELETE` - remove

## 32. How can you specify the HTTP method type for your REST endpoint?

- `@GetMapping()`
- `@PostMapping()`
- `@PutMapping()`
- `@PatchMapping()`
- `@DeleteMapping()`

Note – parent is `@RequestMapping()`

## 33. Design REST endpoint - GET /user/{id}

- Use `@PathVariable`
  ```
  @GetMapping("/user/{id}")
  public String getUserById(@PathVariable(name = "id") String userId) {
    //...
  }
  ```

## 34. Design REST endpoint - GET /users?query=car&limit=10

- Use `@RequestParam`
  ```
  @GetMapping("/users")
  public String getUsers(@RequestParam(name = "query") String query, 
                         @RequestParam(name = "limit", required = false, default = 100) int limit) {
    //...
  }
  ```

## 35. Difference between `@PathVariable` & `@RequestParam`

- Use Path Variables when
  - The parameter is required and should always be present in the URL
  - The parameter is part of the resource identification, such as an ID
  - The parameter has a fixed structure and is not expected to change frequently
  - The parameter is part of a hierarchical path
- Use Request parameters when
  - The parameter is optional and may not be present in every request
  - The parameter has a default value that can be used if not specified
  - The parameter can have multiple values, such as checkboxes in a form
  - The parameter is part of a complex object that can be automatically deserialized from the query string, such as JSON or XML

## 36. Why `@RestController` not `@Controller`

- In RestController, it will return whatever we are returning
- In Controller, spring boot expects return type to be model and view
  - In simple words, the webpage needs to be returned
  - To return Whatever we want in controller
  ```
  @GetMapping(value="/message", producer=MediaType.TYPE_PLAIN_VALUE)
  @ResponseBody
  public String message() {
    return "Hello from controller";
  }
  ```
- `@RestController` = `@Controller` + `@ResponseBody`

## 37. How can we deserialize a JSON request payload into an object within a Spring MVC controller?

- `@RequestBody` annotation - DTO classes
  ```
  @PostMapping("/users")
  @ResponseStatus(HttpStatus.CREATED)
  public User registerUserCredential(@RequestBody User user) {
    System.out.println("User ID: "+user.getUserName());
    System.out.println("User ID: "+user.getPassword());
    return user;
  }
  ```

## 38. Can we perform update operation in POST method? If yes, why do we need PUT method?

- Technically – yes! We don't do it because it violates the principle of REST
- POST - non idempotent
- PUT - idempotent

Idempotent - sending the same request multiple times will produce the same result, without changing the state of the server

## 39. Can we pass RequestBody in GET method?

- Technically – yes! It's not a recommended practice

## 40. How can we perform content negotiation (XML/JSON) in Rest endpoint? (endpoint returning different MediaType)

- endpoint - `@GetMapping(produces={ ... , ... })`
- dependency ...
- application.yml ...

## 41. What all status codes you've observed?

- 200 - ok
- 201 – created
- 204 - no content
- 400 - bad request
- 401 – authentication error
- 403 – authentication successful, but unauthorized
- 404 – resource not found
- 405 - method not allowed (mismatch of http method)
- 415 – unsupported media type
- 500 - internal server error (unexpected error)
- 502 - bad gateway

## 42. Customize status code for your endpoint?

- `@ResponseStatus(HttpStatus.CREATED)`

## 43. How can you enable cross-origin?

- CORS - cross-origin resource searching
- CORS is a security feature implemented by web browser to control web page request made from one domain to another
- Using CORS, you earn restrict what all hosts can access your application.
- How to do
  - `@CrossOrigin(origins="http://localhost:4000")` - on controller class

  OR

  - Java-Based configurations
  ```
  @Override
  public void addCorsMapping (CorsRegistry registry) {
    registry.addMapping("/api/**")
            .allowedOrigins(http://localhost:3000")
            .allowedMethods("GET","POST","PUT","DELETE")
            .allowedHeaders("origin","content-type","accept")
            .allowCredentials(true)
            .maxAge(3600);
  }
  ```

## 44. How can you upload a file in Spring?

- File is nat a raw content. It's of binary type.
- `@RequestParam("file") MultipartFile file`

## 45. How do you maintain versioning of your REST API?

Try to ensure backward compatibility

- Define a version in path uri
  - `@PostMapping("/v1/bookNow")`
  - `@PostMapping("/v2/bookNow")`
- Define request parameter
  - `@RequestParam(name="version") int version`
- Define header parameter
  - `@RequestHeader(name="Api-version") int version`

## 46. How will you document your REST API?

- Swagger <-> OpenAPI

- Add dependency
  - `springdoc-openapi-starter-webmvc-ui`
- access at
  - `localhost:8000/swagger-ui/index.html`
  - `localhost:8000/api-docs`

## 47. How can you hide certain REST endpoints to prevent them from being exposed externally?

- `@Hidden`

## 48. How will you consume restful API?

- RestTemplate
- FeignClient
- WebClient
- AdvanceRestClient