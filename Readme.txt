Date	: 2019-12-08.

Purpose:
Notes regarding an introductory course regarding Spring Boot 
and related topics

--------------------------------------------------------------------------------------------------
Todo:

--------------------------------------------------------------------------------------------------
Git:
The application will be available on: 
https://github.com/robkremers/Spring_Boot_Course_2019_09_23

git:

Initial:
git init
git pull https://github.com/robkremers/Spring_Boot_Course_2019_09_23.git
git status
git add .
git commit -m "Initial commit."
git pull https://github.com/robkremers/Spring_Boot_Course_2019_09_23.git
git remote add origin https://github.com/robkremers/Spring_Boot_Course_2019_09_23.git
git push -u origin master
git status

history

Normal:
If during the local work changes have been implemented it is advantageous to use:
git status
git add .
git commit --amend 
# or
git commit --amend --no-edit
git push -u origin master
git status

Using git commit --amend --no-edit prevents problematic execution of squashing.
(because there is only one commit locally until the commit is pushed to the repository).

Otherwise:
git status
git add .
git commit -m "A commit text"
git pull https://github.com/robkremers/Spring_Boot_Course_2019_09_23.git
git push -u origin master


---------------------------------------------------------------------------------------------------
2019-12-08:

Overview of some relevant source sites:

https://docs.oracle.com/javase/8/docs/api/index.html
https://javaee.github.io/javaee-spec/javadocs/index.html

https://docs.spring.io/spring-framework/docs/current/javadoc-api/index.html?org/springframework/stereotype/Component.html

https://docs.spring.io/spring-data/data-jpa/docs/current/api/

https://docs.spring.io/spring-boot/docs/current/api/
https://docs.spring.io/spring-boot/docs/current/reference/html/
https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-developing-auto-configuration.html#boot-features-bean-conditions

https://docs.spring.io/spring/docs/current/spring-framework-reference/index.html
https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#beans-autowired-annotation

https://mvnrepository.com/artifact/org.springframework/spring-context-indexer/5.1.9.RELEASE

https://repo.spring.io/release/org/springframework/spring/5.1.9.RELEASE/

https://www.baeldung.com/aspectj
- Gives an overview of AOP functionality.
https://www.eclipse.org/aspectj/
https://www.eclipse.org/aspectj/doc/released/weaver-api/index.html
https://www.eclipse.org/aspectj/doc/released/runtime-api/index.html
https://www.springboottutorial.com/spring-boot-and-aop-with-spring-boot-starter-aop

---------------------------------------------------------------------------------------------------
2019-12-08:

For the course pdf's have been received:
- Content
- Exercises
- Solutions

Since this is a commercial course I will not add them to the repository, but I will occasionally add comments
in order to keep the overview.

Domain-Driven Design (DDD)
1. All business logic is captured in the domain model that reflects the real world domain.
2. The business logic objects are independent of the enterprise service objects.

Advantages of DDD
- Business logic is independend of technology changes
  - Switching between technology is easy
- Business logic is easy to understand (Hahaha!)
  - Easy to write, test, modify

Core of Spring:
- DI: Dependency Injection
- AOP: Aspect-Oriented Programming
- Enterprise Service Templates

Spring ecosystem
- Spring (core) framework
- Spring webflow
- Spring integration
- Spring batch
- Spring security
- Spring data
- Spring cloud
- Spring boot

---------------------------------------------------------------------------------------------------
2019-12-09:

When do we use DI?
- When an object references another object whose implementation might change
  - You want to plug-in another implementation
- When an object references a plumbing object
  - An object that sends an email
  - A DAO object
- When an object references a resource
  - For example a database connection

---------------------------------------------------------------------------------------------------
2019-12-28:

Good programming practice principles:
  DRY: Don’t Repeat Yourself
    • Write functionality at one place, and only at one place
    • Avoid code scattering
  SoC: Separation of Concern
    • Separate business logic from (technical) plumbing code
    • Avoid code tangling

Aspect Oriented Programming (AOP) concepts
- Crosscutting concern:
  - Implementation of functionality required for specific parts of the code.
    - e.g.:
      - security checks
      - logging
- Joinpoint:
  - A specific point in the code
    - e.g. a method.
- Pointcut
  - A collection of 1 or more joinpoints
    - e.g. all methods of a class or all methods that have a parameter of type long.
- Advice
  - The implementation of the crosscutting concern.
    - e.g.:
      - A custom logging class.
      - A class providing mailing functionality.
- Aspect
  - What crosscutting concern do I execute (= advice) at which locations in the code ( = pointcut).
    - e.g.:
      - Call logging functionality before each method.
      - Call security functionality before each method.
- Weaving
  - Weave the advice code together with the target code at the corresponding pointcuts such that we get the correct execution.

Advice types:
- Before
  - First call the advice method and then the business logic method
- After returning
  - First call the business logic method and when this business logic method returns normally without an exception, then call the advice method
- After throwing an exception
  - First call the business logic method and when this business logic method throws an exception, then call the advice method
- After
  - First call the business logic method and then call the advice method (independent of how the business logic method returned: normally or with exception)
- Around
  - First call the advice method. The advice method calls the business logic method, and when the business logic method returns, we get back to the advice method

Implementing AOP
- Annotations
- XML

https://www.baeldung.com/aspectj

Necessary:
- See also: https://mvnrepository.com/search?q=aspectj

<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjrt</artifactId>
    <version>1.9.5</version>
</dependency>

<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjweaver</artifactId>
    <version>1.9.5</version>
</dependency>

When using a spring configuration xml file the tag 

  <aop:aspectj-autoproxy/> 

will tell Spring that we use annotations based AOP.

When using AOP with Spring Boot the following class level tags are being used for this purpose:

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

  @Aspect
  @Configuration

---------------------------------------------------------------------------------------------------
2019-12-30:

org.springframework.transaction.annotation

Transaction Propagation

Type          

MANDATORY
  Support a current transaction, throw an exception if none exists.
NESTED
  Execute within a nested transaction if a current transaction exists, behave like REQUIRED otherwise.
NEVER
  Execute non-transactionally, throw an exception if a transaction exists.
NOT_SUPPORTED
  Execute non-transactionally, suspend the current transaction if one exists.
REQUIRED (Default)
  Support a current transaction, create a new one if none exists.
REQUIRES_NEW
  Create a new transaction, and suspend the current transaction if one exists.
SUPPORTS
  Support a current transaction, execute non-transactionally if none exists.

Isolation

DEFAULT
  Use the default isolation level of the underlying datastore.
READ_COMMITTED (Default)
  A constant indicating that dirty reads are prevented; non-repeatable reads and phantom reads can occur.
READ_UNCOMMITTED
  A constant indicating that dirty reads, non-repeatable reads and phantom reads can occur.
REPEATABLE_READ
  A constant indicating that dirty reads and non-repeatable reads are prevented; phantom reads can occur.
SERIALIZABLE
  A constant indicating that dirty reads, non-repeatable reads and phantom reads are prevented.

