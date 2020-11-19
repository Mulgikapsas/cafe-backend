# Setup

- Java 11
- Maven 3.6.3
- Run below
```shell script
mvn clean quarkus:dev
```

# Build container
```shell script
mvn clean package
docker build -t cafe-backend:latest .
```

# Examples

Open http://localhost:8080/api/items in browser
Or use Swagger http://localhost:8080/swagger-ui in browser
