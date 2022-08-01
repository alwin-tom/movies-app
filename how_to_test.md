
### Testing of the application can be carried out in 2 different ways
Since Movies App is a rest application, testing should be focused on the APIs provided.

1. **Swagger UI**
Swagger can be used for identifying the API endpoint, HTTP method, headers and payload. Request can be also be triggered using the swagger UI itself which will yield the response. Swagger UI URL will be /swagger-ui.html
2. **Postman Application**
Postman can also be used for testing these APIs if we need to do in-depth testing with test scripts multiple headers etc.
  
There are various other tools like **SOAP UI**, **Jmeter**, etc which are readily available for API testing. These can be chosen as per the requirements.

### Unit test cases
Unit test cases are designed using Junit framework and the same can be invoked using the following command
~~~
mvn test
~~~
The test case execution will also happen during the installation with help of command **mvn clean install**.