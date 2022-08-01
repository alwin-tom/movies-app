### Follow the below-mentioned steps for running the application
1. Install JAVA (Version 8 or higher)
2. Configure Apache Maven
[Apache Maven installation tutorial](https://maven.apache.org/install.html)
3. Install required dependencies
	i. Open command prompt
	ii. Navigate to the project directory
	iii. Install required dependencies using below command
	~~~
	$ mvn clean install
	~~~
	iv. Once the dependencies are installed, we can run the application using below mentioned command
	~~~
	$ mvn spring-boot:run
	~~~
	Now the application can be accessed under the URL http://localhost:8080