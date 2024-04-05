package main.java.org.example;

import java.sql.*;

public class Main {
    static final String JDBC_URL = "jdbc:mysql://localhost:3306/student_management_system";
    static final String USERNAME = "root";
    static final String PASSWORD = "root";

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        System.out.println("Connected to database");
        readData(connection);
        createData(connection);
        System.out.println(" ");
        readData(connection);
        System.out.println(" ");
        updateData(connection);
        readData(connection);
        System.out.println(" ");
        deleteData(connection);
        readData(connection);

        connection.close();
    }

    public static void createData(Connection connection) throws SQLException { //inserting values into table
        String query = "INSERT INTO students (name, age, grade) VALUES (?, ?, ?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, "John");
            preparedStatement.setInt(2, 15);
            preparedStatement.setString(3, "C");
            preparedStatement.executeUpdate();
            System.out.println("Data created");
        }

    }

    public static void readData(Connection connection) throws SQLException{
        String query =  "SELECT * FROM students";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String grade = rs.getString("grade");
                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Grade: " + grade);
            }
        }
    }

    public static void updateData(Connection connection) throws SQLException{
        String query = "UPDATE students SET name = ? WHERE id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, "James");
            preparedStatement.setInt(2, 3);
            preparedStatement.executeUpdate();
            System.out.println("Data Updated");
        }
    }

    public static void deleteData(Connection connection) throws SQLException{
        String query = "DELETE FROM students WHERE id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, 6);
            preparedStatement.executeUpdate();
            System.out.println("Data Deleted");
        }
    }
}