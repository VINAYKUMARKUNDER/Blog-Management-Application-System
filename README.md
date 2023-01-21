# Blog-Management-Application-System
<hr>
<li>A Sole Project developed by me depicting the implementation of the MyBlog online read-write post platform
<li>A developement of RESTful API for an Online Blog Management application. This API performs all the fundamental CRUD operations of blog platform with user validation at every step.
<br>
 
 # My Roles And Responsibilities
  
<hr>
<br>
<br>

1) Responsible for creating the User module.

3) Responsible for creating the Comments Module.

4) Responsible for creating the Post Module.

5) Responsible for creating the Category Module.

6) Responsible for Exception Handling.

7) Responsible for Security Authentication.

<br>
<br>


# Modules
<hr>
<li>User
<li>Post
<li>Comments
<li>Category

<br>
<br>

# Features
<hr>
<br>

- User Login authentication
- validation for the Username  and Password.
- validation for the current user and user identification
- RESTFUL API with CRUD operations

<br>
<br>


# ER Diagram
<hr>
The following Diagram depicts the flow of our Entity Relation Diagram to simplify the work flow.
<br>
<br>
 


  
  
<img src="https://www.linkpicture.com/q/er-Digramm.png"  width="100%" height="400">
<br>
<br>
<hr>
  


# Teach Stacks Implemented
<hr>
<br>
<br>
<li>Core_Java
<li>Spring framework
<li>Spring Boot Data JPA
<li>Spring Security
<li>Hibernate
<li>Maven
<li>MySQL
<li>Swagger
<li>Lombok

  

<br>
<br>

# Installation & Run
<hr>
<br>
<br>

```
#changing the server port
server.port=8998

#db specific properties
spring.datasource.url=jdbc:mysql://localhost:3306/my_blog
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=Vinay@1313

#ORM s/w specific properties
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.mvc.pathmatch.matching-strategy=ANT_PATH_MATCHER

logging.level.org.springframework.security=DEBUG

#spring.security.user.name=vinay
#spring.security.user.password==vinay
#spring.security.user.roles==ADMIN



```

<br>
<br>

# API Root Endpoint
<hr>
<br>
<br>

```
http://localhost:8998/
```

```
http://localhost:8888/swagger-ui/#
```
<br>
<br>


<!-- # Screenshots



<img src="https://i.ibb.co/PMq2JQK/Screenshot-452.png" alt="Screenshot-452" border="0">
<img src="https://i.ibb.co/PQmb4cS/Screenshot-453.png" alt="Screenshot-453" border="0">
<img src="https://i.ibb.co/PM03DWq/Screenshot-454.png" alt="Screenshot-454" border="0">
 -->
