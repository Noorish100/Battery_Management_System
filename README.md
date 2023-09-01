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
### Flow Daigram
<img width="429" alt="flowdm" src="https://github.com/Sab01123/testTibcoRepo1/assets/104069112/0492fbef-9542-41cc-82ee-1d5f1f2b62d6">

### Installation & Run
- Before running the API server, you have to update the database configuration inside the application.properties file
- Update the port number, username and password as per your local database configuration
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
- `Battery/getInfo/{id}:` Get all information of a specific battery.
- `Battery/specificInfo ? id= batteryId & list=field1 & list = field2 and so on:` Get the  specific details of battery.
- `Battery/specificInfoBetweenTimeRange ? id= batteryId & list=field1 & list = field2.... & stTime = startTime & endTime = endTime:` Get the  specific details of battery  between a given start and end time.

### How to Use
Clone the repository:
sh
Copy code
git clone https://github.com/noorish100/Battery_Management_System.git
Build and run the backend application.
Batteries can call the provided URLs every minute to send data.
Users can access battery data using the defined REST APIs.
