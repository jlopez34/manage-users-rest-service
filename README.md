# manage-users-rest-service
API Restful to handler users 


## Implementation

### Technology:

Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run".

We take an opinionated view of the Spring platform and third-party libraries so you can get started with minimum fuss. Most Spring Boot applications need minimal Spring configuration.


### EndPoints:
| Http Method  | Endpoint | Description |
| ------------- | ------------- |-----------|
| POST  | http://localhost:8090/user/createt  | Create user with phone list associated|
| POST  | http://localhost:8090/authenticate  | Return JWT Token generated|

  ### Structure Package
```
com.nisum.manage.users
  - config  ---> package used to access to properties resource. 
  - controller --> package used to expose endpoints
  - entity --> package used to group file like dto/model
  - model --> package to create customer exception and handler exceptions
  - repository --> package used to implement access to H2 memory database
  - service --> package content to logic implementation (core)
  - security --> package used to implement generation to JWT for access to API REST
 ExchangeApplication
```
### Requirements

All test classes (any class that ends with `Test`) should not be modified.

Solution must use 
   * `Java 8`
   * `Gradle`
   * `Mockito`
   * `Spring Boot 2.5.6`


### Build and Tests
#### Build

1. You should to make clone project [https://github.com/jlopez34/manage-users-rest-service/][https://github.com/jlopez34/manage-users-rest-service/]
2. Run `./gradlew clean install`
3. Download Postman Collection:[https://github.com/jlopez34/manage-users-rest-service/blob/master/env/Nisum-challenge.postman_collection.json][https://github.com/jlopez34/manage-users-rest-service/blob/master/env/Nisum-challenge.postman_collection.json]
