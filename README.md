# Spring Boot Demo


This is a detailed tutorial how to develop a full fledged Java API with database connectivity developed in Visual Code.

## Initializing Project

1. First start Visual Code
2. Press Ctrl+Shift+P to open the command line
3. Type: Spring Initializr: Create a Maven project
4. Specify Spring Boot version (version number will change in the future) Here select the default
5. Specify project language: Java
6. Input group name: Should be reverse URL (e.g. **cloud.maayanlab**)
7. Input Artifact ID: This will be the project name (e.g. here we call it **demo**)
8. Specify packaging type (I chose WAR here for later dockerization)
9. Select one of the installed JAVA versions (I selected 1.8)

### Select Dependencies

The Dependencies that are selected can vary on the needs of the project. There are many to choose from such as database connectivity, OAuth, RestfulAPI support and many more. You should always choose:

-- **Spring Boot DevTools** (it will help with running a local version of the tool and do automatic restarts when code is modified)

For this project we also choose (use Ctrl+click to select multiple)

1. Spring Web
2. Spring Data JPA
3. MariaDB Driver

Then hit enter and the project will be built into the current folder. All JAVA code will be in the folder under **demo/src/main/java/cloud/maayanlab/demo**.

## Configure application properties

Browse to **demo/src/main/resources**, here you can modify properties such as server ports. In this example we change the server port for the local deployment to **8088** from the default **8080**

## Initially disable the JPA dependency until a database is set up

Open the pom.xml file and comment out the lines below (Ctrl + /)

``` 
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

Save changes. 

## Start server

Go to **demo/src/main/java/cloud/maayanlab/demo** and open DemoApplication.java. If you look closely you will see a **Run | Debug** link on top of public static void main(String[] args). 

-- Select **Run**

This will launch a Tomcat server which will now host the application at **localhost:8088**. Because we added Spring Boot DevTools as a dependency everytime we change code the server will be restarted automatically, which is very convenient.

This should conclude the initialization and setup.

# Developing an API

