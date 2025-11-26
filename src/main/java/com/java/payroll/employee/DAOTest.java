/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.payroll.employee;

import com.java.payroll.user.User;
// Ensure your User class is correctly imported, even if it's in a different package.

public class DAOTest {

    public static void main(String[] args) {
        
        System.out.println("--- Starting Data Access Object Retrieval Tests ---");
        DataAccessObject dao = new DataAccessObject();

        // --- Test Case 1: Valid Employee ID (EMP001) ---
        // This ID is taken from your Staff table screenshot.
        System.out.println("\n--- 1. Testing Valid ID: EMP001 ---");
        
        User inputUserValid = new User();
        inputUserValid.setUserId("EMP001");
        
        // Call the retrieve method
        User resultValid = dao.retrieve(inputUserValid);
        
        // Check the result against the expected ID
        if (resultValid.getUserId().equals("EMP001")) {
            System.out.println("✅ SUCCESS: Employee EMP001 found.");
            System.out.println("Retrieved Details (toString): " + resultValid.toString());
        } else {
            System.err.println("❌ FAILURE: Expected EMP001, but retrieval failed (Received sentinel ID: '" + resultValid.getUserId() + "').");
            System.err.println("Action: Check your DatabaseConn.java credentials and MySQL server status.");
        }
        
        // --- Test Case 2: Invalid Employee ID (99999) ---
        System.out.println("\n--- 2. Testing Invalid ID: 99999 ---");
        User inputUserInvalid = new User();
        inputUserInvalid.setUserId("99999");
        
        // Call the retrieve method
        User resultInvalid = dao.retrieve(inputUserInvalid);
        
        // Check the result against the expected sentinel value ("")
        if (resultInvalid.getUserId().equals("")) {
            System.out.println("✅ SUCCESS: Employee 99999 NOT found (received expected sentinel ID '').");
        } else {
            System.err.println("❌ FAILURE: Expected sentinel ID (''), but an employee was unexpectedly found: " + resultInvalid.getUserId());
        }
        
        System.out.println("\n--- Tests Complete ---");
    }
}