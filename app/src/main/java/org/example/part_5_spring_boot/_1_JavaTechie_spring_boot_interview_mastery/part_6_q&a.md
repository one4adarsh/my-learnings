<!-- TOC -->
  * [part_6_q&a](#part_6_qa)
  * [61. How does your application interact with the database and which frameworks are you using?](#61-how-does-your-application-interact-with-the-database-and-which-frameworks-are-you-using)
  * [62. Why is it important to configure a physical naming strategy?](#62-why-is-it-important-to-configure-a-physical-naming-strategy)
  * [63. What are the key benefits of using Spring Data JPA?](#63-what-are-the-key-benefits-of-using-spring-data-jpa)
  * [64. What are the differences between Hibernate, JPA and Spring Data JPA?](#64-what-are-the-differences-between-hibernate-jpa-and-spring-data-jpa)
  * [65. How can you connect multiple databases or data sources in a single application?](#65-how-can-you-connect-multiple-databases-or-data-sources-in-a-single-application)
  * [66. What are the different ways to define custom queries in Spring Data JPA?](#66-what-are-the-different-ways-to-define-custom-queries-in-spring-data-jpa)
  * [67. Can you provide example to find results based on some range?](#67-can-you-provide-example-to-find-results-based-on-some-range)
  * [68. How will you define entity relationships or association mapping in Spring Data JPA?](#68-how-will-you-define-entity-relationships-or-association-mapping-in-spring-data-jpa)
  * [69. Is this possible to execute Join query in Spring Data JPA? If yes, how?](#69-is-this-possible-to-execute-join-query-in-spring-data-jpa-if-yes-how)
  * [70. How will you implement pagination and sorting in Spring Data JPA?](#70-how-will-you-implement-pagination-and-sorting-in-spring-data-jpa)
<!-- TOC -->

## part_6_q&a

## 61. How does your application interact with the database and which frameworks are you using?

- Possible ways - JDBC, Hibernate, JPA, Spring Data JPA
- Using Spring Data JPA to make connection from our app to a database
- What all steps are required to communicate with the DB
  - Create Entity class, define attributes along with id
    - annotations used are
      - `@Entity`
      - `@Table(name="employee")`
      - lombok related - `@Data`, `@NoArgsConstructor`, `@AllArgsConstructor`, `@Getter`, `@Setter`
    - for auto generating id
      - `@Id`
      - `@GeneratedValue(strategy = GenerationType.IDENTITY)`
    - for customizing column names
      - `@ColumnName(name=EMAIL_ID)`
  - Create a Repository interface
    - `public interface EmployeeRepository extend JpaRepository<Employee, Integer>{}`
  - Finally, connect through `application.properties`
    - datasource properties
      ```
      spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver 
      spring.datasource.url=jdbc:mysql://localhost:3306/db_name
      spring.datasource.username=root
      spring.datasource.passowrd=password
      ```
    - jpa specific properties
      ```
      spring.jpa.show-sql=true
      spring.jpa.hibernate.ddl-auto=update
      spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
      ```

## 62. Why is it important to configure a physical naming strategy?

- We use this when we don't want Spring Data JPA to customize the column names as a default type i.e., camel_case
- We can change it by adding following in `application.properties`
  ```
  spring.jpa.hibernate.naming.physical-strategy=org.hibernateboot.model.naming.PhysicalNamingStrategyStandardImpl
  ```

## 63. What are the key benefits of using Spring Data JPA?

- It simplifies the access of data access layer by providing the repository as a high level abstraction over Jpa entity
- It reduces the boilerplate code by providing built-in CRUD operation functions
- functions provided
  - `save()`
  - `saveAll()`
  - `findById()`
  - `findAll()`
  - `findByX()` like `List<Employee> findByAge(int age);`
  - `findByXandY()` like `List<Employee> findByAgeAndSalary(int age, double salary);`
  - `deleteById()`
  - `deleteAll()`
- It also supports query method generation from method name, which reduces the need to write custom queries

## 64. What are the differences between Hibernate, JPA and Spring Data JPA?

- Hibernate
  - It is an ORM tool for Java
  - It helps to map Table to Java class directly
  - It offers caching and transaction
  - In java terms, consider it as Impl

- JPA
  - It is specifications only that provide standard API and methods which do not contain any implementations
  - In java terms, consider it as Interface
  - ORM tools like Hibernate implements JPA specification

- Spring Data JPA
  - Another layer of abstraction on top of JPA specification
  - It provides some utility functions for CRUD operations

## 65. How can you connect multiple databases or data sources in a single application?

- It is possible to connect to multiple databases using spring data JPA
- Step 1: Create Entity class, define attributes along with id - stays same
- Step 2: Create a Repository interface – stays same
- Step 3: connect through `application.properties` - changes a little bit
  - datasource properties
    ```
    spring.datasource.employee.driver-class-name=com.mysql.cj.jdbc.Driver 
    spring.datasource.employee.url=jdbc:mysql://localhost:3306/db_name_employee
    spring.datasource.employee.username=root
    spring.datasource.employee.passowrd=password
  
    spring.datasource.department.driver-class-name=com.mysql.cj.jdbc.Driver 
    spring.datasource.department.url=jdbc:mysql://localhost:3307/db_name_department
    spring.datasource.department.username=root
    spring.datasource.department.passowrd=password
    ```
  - jpa specific properties
    ```
    spring.jpa.show-sql=true
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
    ```
  - Step 4: We need to define configuration so that specific entities connect to specific databases
    - In one of the configurations, we need to define `@Primary` and spring boot will use this as default data source
      - `EmployeeDataSourceConfig.java`
        - load from application.properties file
        - building the data source
        - provide this data source to entity manager
        - creating the transaction manager
          ```
          @Configuration
          @EnableTransactionManagement
          @EnableJpaRepositories(
                entityManagerFactoryRef = "employeeEntityManagerFactory",
                transactionManagerRef = "employeeTransactionManager",
                basePackages = { "com.javatechie.repository.employee" }
          )
          public class EmployeeDataSourceConfig {

            // load from application.properties file 
            @Primary
            @Bean(name = "employeeProperties")
            @ConfigurationProperties("spring.datasource.employee")
            public DataSourceProperties dataSourceProperties() {
              return new DataSourceProperties();
            }
      
            // building the data source
            @Primary
            @Bean(name = "employeeDatasource")
            @ConfigurationProperties(prefix = "spring.datasource.employee")
            public DataSource datasource(@Qualifier("employeeProperties") DataSourceProperties properties) {
              return properties.initializeDataSourceBuilder()
                               .build();
            }
       
            // provide this data source to entity manager
            @Primary
            @Bean(name = "employeeEntityManagerFactory")
            public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean
                    (EntityManagerFactoryBuilder builder, @Qualifier("employeeDatasource") DataSource dataSource) {
              Map<String, Object> jpaProps = new HashMap<>();
              jpaProps.put("hibernate.hbm2ddl.auto", "update");
              jpaProps.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
              return builder.dataSource(dataSource)
                            .properties(jpaProps)
                            .packages("com.javatechie.entity.employee")
                            .persistenceUnit("employee").build();
            }
 
            // creating the transaction manager
            @Primary
            @Bean(name = "employeeTransactionManager")
            @ConfigurationProperties("spring.jpa")
            public PlatformTransactionManager transactionManager(
                  @Qualifier("employeeEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
              return new JpaTransactionManager(entityManagerFactory);
            }
          }
          ```

## 66. What are the different ways to define custom queries in Spring Data JPA?

- method name syntax
  ```
  Optional<Employee> findByEmail(String email);
  ```
- JPQL
  ```
  // custom query using JPQL with index params
  @Query("select e from Employee e where e.firstName = ?1 and e.lastName = ?2")
  Employee findByFullNameJPQLIndexed(String firstName, String lastName);
  
  // custom query using JPQL with named params
  @Query("select e from Employee e where e.firstName =:firstName and e.lastName =:lastName")
  Employee findByFullNameJPQLNamed(@Param("firstName") String firstName, @Param("lastName") String lastName);
  ```
- Native SQL
  ```
  // custom native query using SQL with index params
  @Query(value = "select * from employees e where e.first_name = ?1 and e.last_name = ?2", nativeQuery = true)
  Employee findByFullNameSQLIndexed(String firstName, String lastName);
  
  // custom native query using SQL with named params
  @Query(value = "select * from employees e where e.first_name =:firstName and e.last_name =:lastName", nativeQuery = true)
  Employee findByFullNameSQLNamed(@Param("firstName") String firstName, @Param("lastName") String lastName);
  ```

## 67. Can you provide example to find results based on some range?

- Yes. Aggregate functions are not directly supported by JPA.
  - greater than
    ```
    List<Employee> findBySalaryGreaterThan(double salary);
    ```
  - range
    ```
    List<Employee> findByAgeBetween(int minAge, int MaxAge)
    ```
  - average
    ```
    @Query(value = "select avg(e.salary) from employees e)
    double averageSalary();
    ```

## 68. How will you define entity relationships or association mapping in Spring Data JPA?

- Note: This will not be applicable in microservices architecture.
- Customer
  ```
  @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
  private List<Order> orders;
  ```
- Order
  ```
  @ManyToOne
  @JoinColumn(name = "customer_id")
  private Customer customer;
  ```

## 69. Is this possible to execute Join query in Spring Data JPA? If yes, how?

- Note: This will not be applicable in microservices architecture.
- Yes, it is possible.
- With return type as Object[]
  ```
  @Query(value = "SELECT c.name, COUNT(o) FROM customer c JOIN c.orders o GROUP BY c.id")
  List<Object[]> findCustomerOrderCount();
  ```
- With proper response type, create a response DTO and map class name in the query itself
  ```
  @Query(value = "SELECT NEW com.javatechie.common.CustomerOrderDTO(c.name, COUNT(o), SUM(o.price)) FROM customer c JOIN c.orders o GROUP BY c.id")
  List<CustomerOrderDto> findCustomerOrderCount();
  ```

## 70. How will you implement pagination and sorting in Spring Data JPA?

- Sorting
  ```
  public List<Employee> findEmployeesWithSorting(String field) {
    repository.findAll(Sort.by(Sort.Direction.ASC, field));
  } 
  ```
- Pagination
  ```
  pubic List<Employee> findEmployeesWithPagination(int pageNumber, int pageSize) {
    // pageSize - 100
    // pageNumber -   0,      1     ...
    //              1-100, 101-200, ...
    repository.findAll(PageRequest.of(pageNumber,pageSize));
  }
  ```
- Pagination then Sorting
  ```
  pubic List<Employee> findEmployeesWithPaginationAndSorting(int pageNumber, int pageSize, String field) {
    repository.findAll(PageRequest.of(pageNumber,pageSize).withSort(Sort.by(Sort.Direction.ASC, field)));
  }
  ```