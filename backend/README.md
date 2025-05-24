# EasySplit Application

EasySplit is a simple expense management application that facilitates equal splitting of expenses among all the members of a group. It provides an intuitive user interface for managing expenses and ensures fair distribution among group members.

## Technologies Used

- **Java Spring Boot**: Backend API development framework.
- **Postman**: API testing and handling tool.
- **MariaDB**: Relational database for persistent data storage.
- **React.js**: Frontend JavaScript library for building user-friendly UI.

## Features

- **Equal Splitting**: Automatically calculates and distributes expenses equally among all group members.
- **Expense Management**: Allows users to add, edit, and delete expenses.
- **User Authentication**: Secure authentication system for user accounts.
- **Group Management**: Create and manage groups for expense sharing.
- **Comprehensive Documentation**: Includes a detailed README file and documentation for setup and usage.

## Project Structure

The project follows a typical MVC (Model-View-Controller) structure:

- **Backend (Java Spring Boot)**:
  - `src/main/java`: Contains Java source code for the backend API.
  - `src/main/resources`: Configuration files, application properties, and static resources.
  - `pom.xml`: Maven project configuration file specifying dependencies.

- **Frontend (React.js)**:
  - `src/components`: React components for the UI.
  - `src/App.js`: Main application component.
  - `public/index.html`: HTML template.
  - `package.json`: NPM project configuration file.

## Dependencies

### Backend Dependencies (Maven)

- Spring Boot Starter Web
- Spring Boot Starter Data JPA
- Spring Boot Starter Security
- MariaDB Driver

### Frontend Dependencies (npm)

- React
- React Router
- Axios (for making HTTP requests)
- Bootstrap (for styling)

## Configuration

### Backend Configuration

1. **Database Configuration**: Set up MariaDB and configure the database connection properties in `application.properties`.
2. **Security Configuration**: Customize security settings, including authentication and authorization rules in the security configuration file.

### Frontend Configuration

1. **API Base URL**: Set the base URL of the backend API in the React application, usually located in a configuration file like `config.js`.

## Setup and Run

### Backend Setup

1. Clone the repository: `git clone https://github.com/m0hdali18/EasySplit`
2. Navigate to the backend directory: `cd backend`
3. Build the project: `mvn clean install`
4. Run the application: `java -jar target/easysplit.jar`

### Frontend Setup

1. Navigate to the frontend directory: `cd frontend`
2. Install dependencies: `npm install`
3. Start the development server: `npm start`

## Usage

1. Open the browser and navigate to the provided URL for the frontend application.
2. Sign in or create a new account.
3. Create a group or join an existing group.
4. Add expenses and select group members.
5. EasySplit will automatically calculate and distribute the expenses equally among all group members.

## Contributors

- [Mohammed Ali](https://github.com/m0hdali18) - Developer

## License

This project is licensed under the [MIT License](LICENSE).

## Additional Notes

Feel free to reach out for any questions or feedback. Contributions are welcome!
