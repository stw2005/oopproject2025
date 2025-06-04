# Hospital Management System - Admin Portal

## Java 21 & H2 Database Configuration

This Spring Boot application has been successfully migrated to:
- **Java 21** compatibility
- **H2 In-Memory Database** (replacing MySQL)
- **Spring Boot 3.2.0** with Jakarta EE

## How to Run the Application

### Option 1: Using the startup script
```bash
./start-app.sh
```

### Option 2: Using Maven
```bash
mvn spring-boot:run
```

### Option 3: Using the JAR file
```bash
java -jar target/adminportal-0.0.1-SNAPSHOT.jar
```

## Accessing the Application

### Admin Portal
- **URL**: http://localhost:8200/adminportal
- **Port**: 8200
- **Context Path**: /adminportal

### H2 Database Console
- **URL**: http://localhost:8200/adminportal/h2-console
- **JDBC URL**: `jdbc:h2:mem:hmsdatabase`
- **Username**: `sa`
- **Password**: `password`
- **Driver Class**: `org.h2.Driver`

## Database Configuration

The application uses H2 in-memory database with the following configuration:

```properties
# H2 Database Configuration
spring.datasource.url=jdbc:h2:mem:hmsdatabase
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password

# H2 Console
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.H2Dialect
spring.jpa.show-sql=true
```

## Key Changes Made for Java 21 Compatibility

1. **Updated Dependencies**:
   - Spring Boot 3.2.0
   - Java 21 target version
   - H2 database dependency

2. **Namespace Migration**:
   - `javax.persistence.*` → `jakarta.persistence.*`
   - `javax.servlet.*` → `jakarta.servlet.*`

3. **Repository Method Updates**:
   - `findOne(id)` → `findById(id).orElse(null)`
   - `delete(id)` → `deleteById(id)`

4. **Database Tables**:
   - `patient` - Patient information
   - `doctors` - Doctor information  
   - `diseasetype` - Disease types
   - `assigneddoctors` - Doctor assignments

## Features

- Patient Management (Add, View, Update, Delete)
- Doctor Management
- Disease Type Management
- Doctor Assignment to Patients
- File Upload for Patient Images
- H2 Console for Database Management

## Development Notes

- The application uses Thymeleaf for templating
- Spring Security is configured
- Static resources are served from `/static/`
- All database operations are logged (show-sql=true)
