# Brif5: SmartBank Credit Simulation Application

## Overview
This is a Java EE application developed for **SmartBank**, allowing clients to simulate credit payments based on a formula and submit their credit requests for processing. The app provides a list of credit requests, filtering options, and a detailed view with a history of state modifications.

## Features
- **Credit Simulation**: Clients can simulate their monthly payments based on the loan amount, interest rate, and loan duration.
- **Submit Credit Requests**: After simulation, clients can validate and submit their credit requests.
- **Request Management**: View and filter submitted credit requests by date and status.
- **Request Status**: The status of a request can be updated, and all modifications are logged with timestamps.
- **View History**: The history of status changes for each request is available in the detailed view.

## Technologies Used
- **JEE Technologies**:
    - **Servlets**: Used for handling HTTP requests.
    - **JSP/JSTL**: For rendering the user interface.
    - **JPA**: For ORM (Object-Relational Mapping).
    - **Hibernate**: Implementation of JPA to interact with the database.

- **Testing Frameworks**:
    - **JUnit**: Unit testing of the business logic.
    - **Mockito**: For mocking dependencies in the unit tests.

- **Build & Deployment**:
    - **Maven**: Dependency management and project build.
    - **Tomcat**: Servlet container for deploying the application.

- **Backend**:
    - **EntityManagerFactory Singleton**: Ensures a single instance of the `EntityManagerFactory` is used throughout the application.
    - **Dependency Injection**: Manually handled via constructors without any framework.

## Installation

### Prerequisites
- **JDK 11+**
- **Apache Maven**
- **Apache Tomcatg**



