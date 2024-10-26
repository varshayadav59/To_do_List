package com.model;
public class Demo2 {
	import java.sql.*;

	public class UserDAO {

	    // Create Operation
	    public void addUser(String name, String email) {
	        String sql = "INSERT INTO users (name, email) VALUES (?, ?)";
	        try (Connection connection = DatabaseConnection.getConnection();
	             PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setString(1, name);
	            statement.setString(2, email);
	            statement.executeUpdate();
	            System.out.println("User added successfully!");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    // Read Operation
	    public void getUsers() {
	        String sql = "SELECT * FROM users";
	        try (Connection connection = DatabaseConnection.getConnection();
	             Statement statement = connection.createStatement();
	             ResultSet resultSet = statement.executeQuery(sql)) {
	            while (resultSet.next()) {
	                int id = resultSet.getInt("id");
	                String name = resultSet.getString("name");
	                String email = resultSet.getString("email");
	                System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    // Update Operation
	    public void updateUser(int id, String newName, String newEmail) {
	        String sql = "UPDATE users SET name = ?, email = ? WHERE id = ?";
	        try (Connection connection = DatabaseConnection.getConnection();
	             PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setString(1, newName);
	            statement.setString(2, newEmail);
	            statement.setInt(3, id);
	            int rowsUpdated = statement.executeUpdate();
	            if (rowsUpdated > 0) {
	                System.out.println("User updated successfully!");
	            } else {
	                System.out.println("User not found!");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    // Delete Operation
	    public void deleteUser(int id) {
	        String sql = "DELETE FROM users WHERE id = ?";
	        try (Connection connection = DatabaseConnection.getConnection();
	             PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setInt(1, id);
	            int rowsDeleted = statement.executeUpdate();
	            if (rowsDeleted > 0) {
	                System.out.println("User deleted successfully!");
	            } else {
	                System.out.println("User not found!");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
	Step 4: Testing the CRUD Operations
	Create a main class to test these operations:

	java
	Copy code
	public class Main {
	    public static void main(String[] args) {
	        UserDAO userDAO = new UserDAO();

	        // Create
	        userDAO.addUser("Alice", "alice@example.com");

	        // Read
	        System.out.println("Users List:");
	        userDAO.getUsers();

	        // Update
	        userDAO.updateUser(1, "Alice Updated", "alice_updated@example.com");

	        // Delete
	        userDAO.deleteUser(1);
	    }
	}


}
