# StockApp - configuration

## Requirements
- Java Jdk 11 and above
- Maven Compiler
- H2 Database
- Git

## Clone the Project
Run below command on your commandline;
 
``git clone https://github.com/Kajol232/active-edge.git``

or download the project zip file on https://github.com/Kajol232/active-edge/


## Run Application

### Locally

You can either run the application locally on any IDE preferable Intellij Idea or with below command via command line;

- mvn clean install
- mvn spring-boot:run


### Containerize with Docker
- Change directory to the path of your application with below command
``cd ./stock-app/``
- Run below command to build the Docker image
``docker build -t stockapi .``
- Run below command to containerize the image
``docker run -e DATABASE_SERVER=jdbc:h2:mem:stock_db -dp 8080:8081 stockapi``

## Log In Details
- Username : admin
- Password : admin_pass


## API Documentation

### Locally

Access the api documentation on http://localhost:8081/swagger-ui.html# 

### Containerize with Docker
Access the api documentation on http://localhost:8080/swagger-ui.html# 

