/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.payroll.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;



public class DatabaseConn {
    
    private static Connection myConn = null;
    
    public static Connection getConnection(){
        
        String url = "jdbc:mysql://localhost:3306/payflowdb";
        
        try {
            myConn = DriverManager.getConnection(url, "root", "");
            
            if(myConn != null){
                JOptionPane.showMessageDialog(null, "Connection Success", "JDBC Connection Status", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            System.getLogger(DatabaseConn.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
      
        return myConn;
    }
    
}
