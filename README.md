# Spring Boot REST API

### Setup

* Import the database in `src/main/java/com/example/restapitest/db/restapi_test.sql`
* Change the database credentials in `src/main/resources/application.properties`
```
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/restapi_test
spring.datasource.username=root
spring.datasource.password=
```

## API Details


### Get all users - GET 
```
http://localhost:8080/api/v1/user/all
```

### Get user by id - GET 
```
http://localhost:8080/api/v1/user/<enter-id>
```

### Create user - POST
```
http://localhost:8080/api/v1/user/create
```

```json
{
    "name": "Madushan",
    "email": "madushan@gmail.com",
    "dob": "1998-01-17"
}
```

### Update user - PUT
```
http://localhost:8080/api/v1/user/update/1
````

```json
{
    "name": "Madushan",
    "email": "madushan@gmail.com",
    "dob": "1998-01-17"
}
```

### Delete user - DELETE
```
http://localhost:8080/api/v1/user/delete/1
```
