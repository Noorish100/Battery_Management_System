# Battery_Management_System

# Battery Management System
A backend system for a web application that supports the management and monitoring of batteries deployed on electric vehicles. The system allows batteries to send data to the backend via a web API and provides users with various ways to access and analyze battery information.

### Table of Contents
- Overview
- Use Cases
- Technical Stacks
- Flow Daigram
- Database Design
- API Endpoints
- How to Use
- Contact

### Overview
The Battery Management System is designed to handle data from multiple batteries deployed on electric vehicles. Each battery periodically sends data to the backend, which is then stored in a database. Users can access this data through plain HTTP or REST APIs, enabling various queries and data retrieval operations.

### Use Cases
- Battery Data Collection
Multiple batteries deployed on electric vehicles send the following information to the backend once every minute:

    - Battery ID
    - Current
    - Voltage
    - Temperature
    - Time
- Data Storage
All data sent by batteries is stored in a dedicated database table.

- User Access
Users of the system can access battery data using plain HTTP or REST APIs. The following retrieval options are available:



### Technical Stacks

- Spring Boot 
- Spring Framework
- Spring Data JPA 
- MySQL 
- Hibernate
- Core Java
- Postman
### Flow Diagram
<img width="400" alt="flowed 2477" src="https://github.com/Noorish100/Battery_Management_System/assets/97448658/40927898-36d2-4cb3-96b2-759547a77312">

### URL Diagram
<img width="200" alt="flowed 2000" src="![uml](https://github.com/Noorish100/Battery_Management_System/assets/97448658/466113c8-2dc0-4c77-8c5e-f0d1e927c75b)>

### Installation & Run
- Before running the API server, you have to update the database configuration inside the application.properties file
- Update the port number, username, and password as per your local database configuration
````
server.port=8889
#db specific properties
spring.datasource.url=jdbc:mysql://localhost:3306/Battery
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=noorishes@123
#ORM s/w specific properties
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
````
### API Endpoints
- `User/getInfo/{id}:` Get all information of a specific battery.
- `User/specificInfo ? id= batteryId & list=field1 & list = field2 and so on:` Get the  specific details of battery.
- `User/specificInfoBetweenTimeRange ? id= batteryId & list=field1 & list = field2.... & stTime = startTime & endTime = endTime:` Get the  specific details of battery  between a given start and end time.

### How to Use
Clone the repository:
sh
Copy code
git clone https://github.com/noorish100/Battery_Management_System.git
Build and run the backend application.
Batteries can call the provided URLs every minute to send data.
Users can access battery data using the defined REST APIs.
