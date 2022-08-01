
## About
The application is used to indicate whether a movie won a “Best Picture” Oscar based on OMDB API. It also caters to the features of rating a movie on a scale of 1-5 and also to retrieve top-rated 10 movies.

### Technologies
 1. JAVA
 2. Spring Boot
 3. MySQL

### Package Stucture
1. com.projects.moviesapp 
Base Package with spring Boot starter class and main method
2. com.projects.moviesapp.apimodels
Models for handling OMDB API request and responses
3. com.projects.moviesapp.components
Component class files like files for holding business logic and Request-Response interceptor
4. com.projects.moviesapp.configuration
Package for class files with custom application configurations
5. com.projects.moviesapp.controllers
Contains classes with controller files for Request-Response handling
6. com.projects.moviesapp.dao
Package for repository classes
7. com.projects.moviesapp.errorhandlers
Package for custome error handling and exception declarations
8. com.projects.moviesapp.models
Package to store database pojos
9. com.projects.moviesapp.reqresmodels
Models for handling API request and responses
10. com.projects.moviesapp.services
This package will hold service interfaces
11. com.projects.moviesapp.services.impl
Package for service implementation
