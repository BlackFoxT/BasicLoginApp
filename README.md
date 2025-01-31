# Basic Spring Boot Login App

`git clone https://github.com/BlackFoxT/BasicLoginApp`

This is a basic login application built with **Spring Boot**, **Thymeleaf**, and **Spring Security**. It allows users to sign up, log in using an email instead of a username, and restricts access to authentication pages for logged-in users.

## Features
- User authentication with **Spring Security**
- Uses **email** instead of username for login
- Sign-up functionality to create new accounts
- Restricts access to `/auth/login` and `/auth/signup` for authenticated users
- Displays user information on the main page after login
- Simple **Thymeleaf** templates for frontend rendering
- **MySQL database integration** for persistent user storage
- Encrypted password storage to ensure secure handling of user credentials

## Technologies Used
- **Spring Boot**
- **Spring Security**
- **Thymeleaf**
- **Java 23+**
- **Maven**
- **MySQL**

## Setup & Run
### Prerequisites
Ensure you have the following installed:
- **Java 23+**
- **Maven**
- **MySQL** (Make sure it's running)

### Clone the Repository
```sh
git clone https://github.com/your-repo-url.git
cd your-repo-folder
```

### Configure Database
First, create the database schema in MySQL:
`CREATE SCHEMA your_database;`

Edit `src/main/resources/application.properties` and set up your MySQL database details:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### Build and Run
```sh
mvn spring-boot:run
```

The application will start at `http://localhost:8080`

## Endpoints
| Endpoint        | Description |
|----------------|-------------|
| `/`            | Main page displaying user info after login |
| `/auth/login`  | Login page (only accessible to non-authenticated users) |
| `/auth/signup` | Signup page (only accessible to non-authenticated users) |
| `/auth/logout` | Logout endpoint |

## Security Configuration
- **Email-based login**: The application uses `email` instead of the default `username` parameter.
- **Restricted pages**: Logged-in users **cannot access** `/auth/login` and `/auth/signup`.
- **Session-based authentication** with Spring Security.

![Security Config](src/main/resources/images/security_config.png)

In this securityFilterChain configuration, access permissions to pages are defined.
The /auth/login and /auth/signup pages are accessible only to unauthenticated (anonymous) users.
To enable login using an email instead of a username, the usernameParameter("email") has been set, so users can log in with their email address. 
The logout process is handled via the /auth/logout URL. 
After the user logs out, the system invalidates the session, deletes the JSESSIONID cookie, and redirects the user to the / page. 
This ensures users can safely log out.

![Database](src/main/resources/images/database.png)

This is example structure for our database.

### Screenshots for the project
![Main Page Before Login](src/main/resources/images/main_page_without_login.png)

![Signup Page](src/main/resources/images/signup_page.png)

![Login Page](src/main/resources/images/login_page.png)

![Main Page Before Login](src/main/resources/images/main_page_with_login.png)
