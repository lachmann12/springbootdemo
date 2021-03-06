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
8. Specify packaging type (I chose **JAR** here for later dockerization)
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

# Packaging jar file

To package a **war** or **jar** file use the terminal and go into the **demo** folder. Then run:

Linux/MAC
```
mvnw clean install
```

Windows
```
mvnw.cmd clean install
```

This will create a file called **demo-0.0.1-SNAPSHOT.war/jar** in the **target** folder.

# Dockerization

To deploy the applicaton we want to encapsulate it in a Docker container. The folder **demo/docker** contains all that is needed to generate a Docker image.

1) go into **demo/docker** folder
2) chmod 777 buildDocker.sh (UNIX)
3) ./buildDocker.sh

This will start the packaging procedure and create a jar file. It will package the resulting jar file into a docker image. Edit the **buildDocker.sh** file to name the image. The **DockerFile** contains a line that modifies the environment variables. Here more memory can be reserved. Once the docker image is build it can be run locally with:

```
docker run --name demo -p 8099:8088 -it lachmann12/springbootdemo
```

The deployment can be tested at http://localhost:8099



# Developing an API

