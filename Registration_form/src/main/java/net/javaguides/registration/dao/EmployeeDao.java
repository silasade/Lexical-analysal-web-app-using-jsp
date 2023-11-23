package net.javaguides.registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import net.javaguides.registration.model.Employee;

public class EmployeeDao {

    public boolean registerEmployee(Employee employee) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO employee" +
            "(first_name, last_name, OtherName, password, address, comment, email_address) VALUES " +
            " (?, ?, ?, ?, ?, ?, ?);";

        boolean registrationSuccessful = false;

        Class.forName("com.mysql.cj.jdbc.Driver");

        
        try (Connection connection = DriverManager.getConnection(
        			    "jdbc:mysql://localhost:3306/backnaur?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true", "root", "Silas123.");

             // Step 2: Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {

            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getOtherName());
            preparedStatement.setString(4, employee.getPassword());
            preparedStatement.setString(5, employee.getAddress());
            preparedStatement.setString(6, employee.getComment());
            preparedStatement.setString(7, employee.getEmail_address());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            int result = preparedStatement.executeUpdate();

            registrationSuccessful = result > 0;

        } catch (SQLException e) {
            // Process SQL exception
            printSQLException(e);
        }
        return registrationSuccessful;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
