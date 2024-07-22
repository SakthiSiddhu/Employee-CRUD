# Employee-CRUD
Basic Crud Operations Performed using Employee dataset and JPA Streamers

# Dataset Overview
Employee Dataset
* id - integer - identifies every employee uniquely
* education - string
* city - string
* paymentTier - int
* age - int
* gender - string (male|female)
* everBenched - string (YES|NO)
* experience - integer
* leave - integer

# Technologies Used
* Spring Boot - CRUD operations
* JPA Streamer - DAO Layer
* MYSQL - Database
* Swagger UI - GUI Tool for Api Testing & Documentation.

# JPA Streamer Overview
JPA Streamer is a Java library that allows you to query databases using Java streams, providing a more functional and declarative approach to data access. It integrates with the Java Persistence API (JPA) to enable the streaming of database entities in a type-safe manner.


# Dependencies 

* Spring-Boot Actuator
* Spring-Boot Web
* Spring-Boot DevTools
* MYSQL Connector
* JPA
* JPA streamer
* Lombok
* Swagger dependency

# Endpoints Created

Root: http://localhost:8220/employees

POST
/employees/addall: Adds multiple employees to the database.

GET

/employees/genderbyyear/{year}: Retrieves the number of employees categorized by gender for a specified year.

/employees/filter: Filters employees based on specified criteria.

/employees/byyear/{year}: Retrieves all employees who joined in a specified year.

/employees/bygender/{gender}: Retrieves count of all employees filtered by a specified gender.

/employees/byeducation: Retrieves all employees categorized based on their education.
