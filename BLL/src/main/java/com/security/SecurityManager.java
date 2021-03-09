package com.security;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SecurityManager {

    public static void main(String[] args) throws SQLException {
        String myPassword = "myPassword123";

        // Generate Salt. The generated value can be stored in DB.
        String salt = PasswordUtils.getSalt(30);

        // Protect user's password. The generated value can be stored in DB.
        String mySecurePassword = PasswordUtils.generateSecurePassword(myPassword, salt);

        // Print out protected password
        System.out.println("My secure password = " + mySecurePassword);
        System.out.println("Salt value = " + salt);

       boolean test =  PasswordUtils.verifyUserPassword("myPassword123",mySecurePassword,salt);

       System.out.println(test);

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mark1_db","root","Rayquaza123");

        System.out.println(connection.isValid(10000));
        System.out.println("dummy");
    }
}
