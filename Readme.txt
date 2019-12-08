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


---------------------------------------------------------------------------------------------------
2019-12-08:

Overview of some relevant source sites:

https://docs.oracle.com/javase/8/docs/api/index.html
https://docs.spring.io/spring-framework/docs/current/javadoc-api/index.html?org/springframework/stereotype/Component.html
https://docs.spring.io/spring-boot/docs/current/api/
https://docs.spring.io/spring-boot/docs/current/reference/html/
https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-developing-auto-configuration.html#boot-features-bean-conditions
https://docs.spring.io/spring/docs/current/spring-framework-reference/index.html
https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#beans-autowired-annotation
https://mvnrepository.com/artifact/org.springframework/spring-context-indexer/5.1.9.RELEASE
https://repo.spring.io/release/org/springframework/spring/5.1.9.RELEASE/

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
