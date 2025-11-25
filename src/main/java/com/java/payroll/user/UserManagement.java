/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.java.payroll.user;

public interface UserManagement {
    
    public abstract boolean create(User user); //creates a new user in the data base
    public abstract User delete(User user); //deletes a user in the database
    public abstract User retrieve(User user); //retrieve a user from in the database
    public abstract void update(User user); //update a user in the database
    
    public abstract boolean createFull(User user); //creates a new user in the data base
    public abstract User deleteFull(User user); //deletes a user in the database
    public abstract User retrieveFull(User user); //retrieve a user from in the database
    public abstract void updateFull(User user); //update a user in the database
    
}
