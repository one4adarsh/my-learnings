<!-- TOC -->
  * [part_3_q&a](#part_3_qa)
  * [23. How will you resolve bean dependency ambiguity?](#23-how-will-you-resolve-bean-dependency-ambiguity)
  * [24. Can we avoid dependency ambiguity without using `@Qualifier`?](#24-can-we-avoid-dependency-ambiguity-without-using-qualifier)
  * [25. What is bean scope? Different types of bean scopes?](#25-what-is-bean-scope-different-types-of-bean-scopes)
  * [26. How to define custom bean scope?](#26-how-to-define-custom-bean-scope)
  * [27. Realtime use case for Singleton scope and Prototype scope?](#27-realtime-use-case-for-singleton-scope-and-prototype-scope)
  * [28. Can we inject prototype bean in singleton bean? If yes, what will happen if we inject prototype bean in singleton bean?](#28-can-we-inject-prototype-bean-in-singleton-bean-if-yes-what-will-happen-if-we-inject-prototype-bean-in-singleton-bean)
  * [29. What is the difference between spring singleton and plain singleton?](#29-what-is-the-difference-between-spring-singleton-and-plain-singleton)
  * [30. What is the purpose of the BeanPostProcessor Interface in Spring, and how can you use it to customize bean initialization and destruction?](#30-what-is-the-purpose-of-the-beanpostprocessor-interface-in-spring-and-how-can-you-use-it-to-customize-bean-initialization-and-destruction)
<!-- TOC -->

## part_3_q&a

## 23. How will you resolve bean dependency ambiguity?

- Bean Dependency Ambiguity -
  - we have one interface
  - we have two implementations of that interface
  - we inject dependency by using interface
    - the problem here is how spring will know which interface to use?
      - this is a dependency ambiguity.

- use annotation- `@Qualifier`
- ex-
  ```
  @Autowired
  @Qualifier("OrderRepositoryImpl2")
  private OrderRepository orderRepository;
  ```

## 24. Can we avoid dependency ambiguity without using `@Qualifier`?

- Use another annotation - `@Resource`
- ex-
  ```
  @Autowired
  @Resource(name="OrderRepositoryImpl1")
  private OrderRepository orderRepository;
  ```

- Difference between `@Qualifier` and `@Resource`
- Qualifier
  1. specific to the spring framework
  2. injection by type
- Resource
  1. It's from java library itself
  2. injection by name

## 25. What is bean scope? Different types of bean scopes?

- Bean scope determines how long a bean instance will live, i.e., when it is created or destroyed
- It's all about bean lifecycle
- Types:
  - Singleton
  - Prototype
  - Request
  - Session
  - Application
  - WebSocket

Note: Request, Session, Application is only for web-based applications

> Singleton

- Spring Boot creates a single instance of the bean for the entire application context
- Default scope
- The Same instance will be shared across all the clients
- In simple words, spring will create one instance of that class

> Prototype

- Spring Bott creates a new instance every time it is requested for Spring container

  ```
  @Component
  @Scope("prototype")
  public class BeanScopeTestService {
    pubic BeanScopeTestService() {
      System.out.println("new instance created...");
    }
  }
  ```

> Request

- It creates a new instance of the bean for each HTTP request
- After processing the request, the bean instance is typically discarded

> Session

- It creates a single instance of the bean per user session
- The instance persists throughout the user's session and is typically discarded when the session ends

> Application

- It is used to create a single instance of the bean for the web application context
- One instance of bean across all users and sessions
- Used during - caching, shared resource

> WebSocket

- Create a single instance of the bean per WebSocket session

## 26. How to define custom bean scope?

- TODO

## 27. Realtime use case for Singleton scope and Prototype scope?

- Singleton
  - database configuration
  - service layer
  - application configuration
  - caching

- Prototype
  - user session
  - thread safety
  - heavy initialization

## 28. Can we inject prototype bean in singleton bean? If yes, what will happen if we inject prototype bean in singleton bean?

- Yes, Prototype bean will lose its behavior and behave as a singleton
- To avoid this situation, we can use the following three ways
  1. inject through application context
    ```
    @Autowired
    ApplicationContext context;
  
    // use like
    context.getBean(PrototypeBean.class);
    ```
  - this approach is not recommended because we're maintaining the bean life cycle ourselves

  2. inject through ObjectFactory
    ```
    @Autowired
    private ObjectFactory<ProtoTypeBean> protoTypeBeanObjectFactory;
  
    // use like
    protoTypeBeanObjectFactory.getObject();
    ```

  3. use `@Lookup` - spring will override and use method’s return type and parameters when we invoke it

## 29. What is the difference between spring singleton and plain singleton?

- Spring Singleton scope within the application context
- Plain singleton scope within the JVM

## 30. What is the purpose of the BeanPostProcessor Interface in Spring, and how can you use it to customize bean initialization and destruction?

- In spring framework, BeanPostProcessor is an interface that provides hooks or callbacks to perform preprocessing
  logic.
- It allows you to perform custom action before or after bean initialization.



