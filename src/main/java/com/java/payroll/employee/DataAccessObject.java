/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.payroll.employee;
    
import com.java.payroll.connection.DatabaseConn;
import com.java.payroll.user.UserManagement; // Interface
import com.java.payroll.user.User; // User class
import java.sql.*;
import javax.swing.JOptionPane;

public class DataAccessObject implements UserManagement {
    
    // Database Access Information
    private static final String TABLE_NAME = "Staff"; // Table in the Database that all employee information is stored
    private static final String EMP_ID_COLUMN = "id"; // Example: The column name for employee number (userId)

    /**
     * Retrieves a User record from the database using the employee number (id).
     * Follows the logic: retrieve -> check if the record exists.
     * @param user An input User object with only the userId set.
     * @return A fully populated User object if found, or a default User object (where userId is "") if not found.
     */
    @Override
    public User retrieve(User user) {
        
        String employeeNumber = user.getUserId();
        // This default constructor sets userId to "" (this is the "not found" sentinel)
        User retrievedUser = new User(); 

        // SQL: Selects all fields needed to fully construct the User object
        String sql = "SELECT " + EMP_ID_COLUMN + ", email, trn, country, street, city, parish, gender, day, month, year " +
             "FROM " + TABLE_NAME + " WHERE " + EMP_ID_COLUMN + " = ?";

        // Uses try with resources to automatically close Connection, PreparedStatement, and ResultSet
        try (Connection conn = DatabaseConn.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            // Database Connection check
            if (conn == null) {
                // Displays an error message to the user
                JOptionPane.showMessageDialog(null, 
                        "CRITICAL ERROR: Database connection is unavailable. Cannot proceed with sign-in check.", 
                        "Connection Failure", 
                        JOptionPane.ERROR_MESSAGE);

                // Fallback logging
                System.err.println("Database connection unavailable."); 

                return retrievedUser; // Returns the default User object (userId = "")
    }
            
            // 1. Set the employee number parameter (This prevents SQL Injection)
            ps.setString(1, employeeNumber);

            // 2. Execute the query
            try (ResultSet rs = ps.executeQuery()) {
                
                // 3. Check for record existence
                if (rs.next()) {
                    // Record found! Populate the User object using the full constructor
                    String userId = rs.getString(EMP_ID_COLUMN);
                   //String password = rs.getString("password"); // **VERIFY 'password'
                    String email = rs.getString("email");
                    String trn = rs.getString("trn");
                    String country = rs.getString("country");
                    String street = rs.getString("street");
                    String city = rs.getString("city");
                    String parish = rs.getString("parish");
                    String gender = rs.getString("gender");
                    int day = rs.getInt("day");
                    int month = rs.getInt("month");
                    int year = rs.getInt("year");
                    
                    retrievedUser = new User(userId, "", email, trn, country, street, city, parish, gender, day, month, year);
                    
      
                   //retrievedUser.setPassword(password); 
                 
                }
            }
        } catch (SQLException e) {
            System.err.println("Database error during user retrieval: " + e.getMessage());
            e.printStackTrace();
        }
        
        return retrievedUser; 
    }
    
    // Stubs for the other UserManagement interface methods
@Override
public boolean createFull(User user) {
    // Secure SQL using PreparedStatement to prevent SQL Injection
    // The query must list all columns being inserted.
    String sql = "INSERT INTO Staff (id, fullName, password, email, trn, country, street, city, parish, gender, day, month, year) " +
                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; // 13 values
    
    try (Connection conn = DatabaseConn.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        if (conn == null) { 
            return false; // Connection error handled in DatabaseConn
        } 

        // 1. Set parameters for all 13 fields
        ps.setString(1, user.getUserId());
        ps.setString(2, user.getFullName());
        ps.setString(3, user.getPassword()); // ⚠️ Must be HASHED before calling this method
        ps.setString(4, user.getEmail());
        ps.setString(5, user.getTrn());
        ps.setString(6, user.getCountry());
        ps.setString(7, user.getStreet());
        ps.setString(8, user.getCity());
        ps.setString(9, user.getParish());
        ps.setString(10, user.getGender());
        ps.setInt(11, user.getDay());
        ps.setInt(12, user.getMonth());
        ps.setInt(13, user.getYear());

        int affectedRows = ps.executeUpdate();
        return affectedRows == 1;

    } catch (SQLException ex) {
        System.err.println("SQL Error during full user creation: " + ex.getMessage());
        // Optionally show the user a message box for unique constraint violation, etc.
        // JOptionPane.showMessageDialog(null, "Registration Failed: User ID/TRN might already exist.", "Database Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
}

@Override
public boolean create(User user) {
    // Since createFull handles the full registration, this basic create method 
    // can optionally call createFull, or remain a simple stub if unused.
    // For now, we'll keep the stub to avoid runtime errors if FullSignUp isn't fixed yet.
    return false; 
}
    
    @Override 
    public User delete(User user) { 
        // Logic for deleting a basic user record
        return null; 
    }
    
    @Override 
    public void update(User user) {
        // Logic for updating a basic user record
    }
    
    @Override 
    public User deleteFull(User user) { 
        // Logic for deleting a full user record
        return null; 
    }
    
    @Override 
    public User retrieveFull(User user) { 
        // Logic for retrieving a full user record (potentially same as retrieve, or more complex)
        return null; 
    }
    
    @Override 
    public void updateFull(User user) {
        // Logic for updating a full user record
    }
}
