
## How to run

The solution contains 2 different application

  

1. Java Backend Application

This application is built on JAVA with maven. For running the application, follow the steps below.

**Please make sure that JAVA and maven are installed in the machine**

~~~

$ mvn clean install

~~~

~~~

$ mvn compile

~~~

~~~

$ mvn spring-boot:run

~~~

2. Angular UI App

This application is used for theclient-sidee view and use of features. It is made on Angular. For running the application, follow the steps below.

**Please make sure that node and angular CLI are installed in the machine**

~~~

$ npm install

~~~

~~~

$ ng serve

~~~
### Database configuration

As a part of database configuration, necessary SQL for managing database is provided in the file **Movies App - DB Queries.sql**. The same is also avaliable in https://github.com/alwin-tom/movies-app-db. It contains 3 different parts
1. Create DB
2. Create table movie-details
3. Insert data provided in CSV

The current designed solution is based on MySQL database and the properties for the same are a part of the **application.properties** file. While running we have cross check and make sure that the database connection properties are updated towards the database which we are connecting to. The properties include 
 1. Host name (IP address)
 2. User name
 3. Password
 
