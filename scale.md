### Application scaling
The movies app is a microservice application with 3 APIs exposed to it. Scalability of the application can be accomplished using docker and Kubernetes on an infra level. On an application level, the point which needs to be considered is the connection pooling. We have to identify the average database session count and maintain the connection pool size accordingly.

The said property can be found in the **application.properties** file under the key name **datasource.moviesapp.maxPoolSize**