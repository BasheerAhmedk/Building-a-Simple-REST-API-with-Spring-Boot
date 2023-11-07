# Building a Simple REST API with Spring Boot

In this project, we'll build a REST API using Spring Boot. You can also create a REST API without using Spring Boot, but for this tutorial, we'll use it.

## Getting Started

1. Head to [start.spring.io](http://start.spring.io) and create a new project with the following options:

    - **Project:** Maven
    - **Language:** Java
    - **Spring Boot:** Choose the latest stable version (avoid "SNAPSHOT" versions).
    
    **Project Metadata:**
    
    - **Group:** com.basheer.rest.webservices (you can customize this)
    - **Artifact:** restful-web-services (change it as needed)
    - **Name:** default
    - **Description:** default
    - **Package Name:** default
    - **Packaging:** Jar
    - **Java:** 17 (Spring Boot supports at least Java 17)

    **Dependencies:**
    - Spring Web
    - Spring Data JPA
    - H2 Database
    - Spring Boot DevTools

2. Click the "GENERATE" button to download a zip file and extract it to your system.

3. Open your Eclipse IDE or your preferred IDE.

4. Click on `File` -> `Import` -> `Existing Maven Projects` and choose the extracted project folder.

## Project Structure

![Project Structure](/restful-web-services/images/eclipse file structure.png)

Inside `src/main/java/com.basheer.rest.webservices.restfulwebservices`, you will see the project's main Java file (`RestfulWebServicesApplication.java`). Run this Java file.

## Creating Your First API

1. Create a new Java class inside the package `src/main/java/com.basheer.rest.webservices.restfulwebservices.helloworld` called `HelloWorldController.java`.

2. Add the following code to `HelloWorldController.java`:

```java
package com.basheer.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping(path = "/hello-world")
    public String HelloWorld() {
        return "Hello World";
    }
}
```

3. Save the file. If you haven't run the application, run it.

4. Open your web browser and type [http://localhost:8080/hello-world](http://localhost:8080/hello-world). You will see "Hello World" displayed in the web browser.

## Returning a JSON Response

To return a JSON response, create a class `HelloWorldBean.java` in the same package (`src/main/java/com.basheer.rest.webservices.restfulwebservices.helloworld`) with the following code:

```java
package com.basheer.rest.webservices.restfulwebservices.helloworld;

public class HelloWorldBean {

    private String message;

    public HelloWorldBean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HelloWorldBean [message=" + message + "]";
    }
}
```

Afterward, modify `HelloWorldController.java` to include the following method:

```java
@GetMapping(path = "/hello-world-bean")
public HelloWorldBean helloWorldBean() {
    return new HelloWorldBean("Hello World!");
}
```

Now, if you run the application again and open your browser to [http://localhost:8080/hello-world-bean](http://localhost:8080/hello-world-bean), you will receive a JSON response.

## Adding Your Name

To include your name in the message, create a new method in the controller:

```java
@GetMapping(path = "/hello-world/path-variable/{name}")
public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
    return new HelloWorldBean(String.format("Hello World, %s", name));
}
```

Access the API by typing [http://localhost:8080/hello-world/path-variable/Basheer](http://localhost:8080/hello-world/path-variable/Basheer) in your browser to get a JSON response.

This is a basic introduction to how APIs work.
```
