package com.taskflow.model;

/**
 * Represent a user in TaskFlow System.
 * Demonstrate class definition, encapsulation, constructors, and methods.
 */
public class User {
    // Instance variables - private for encapsulation
    private String id;
    private String username;
    private String email;
    private String fullName;

    /**
     * Constructor with all parameters.
     * Demonstrate constructor with multiple parameters
     *
     * @param id unique identifier for a user
     * @param username user's login name
     * @param email user's email address
     * @param fullName user's full name
     */
    public User(String id, String username, String email, String fullName) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.fullName = fullName;
    }

    /**
     * Constructor without id - for creating new users.
     * Demonstrate constructor overloading
     * ID will be generated later by the service layer
     *
     * @param username user's login name
     * @param email user's email address
     * @param fullName user's full name
     */
    public User(String username, String email, String fullName) {
        this(null, username, email, fullName); // Calls the other constructor
    }

    // Getter methods - demonstrates getters for accessing private fields


    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return fullName;
    }

    // Setter methods - demonstrates setters for modifying private fields

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Returns a string representation of the user
     * Demonstrate method overriding (from Object class).
     *
     * @return formatted string with user information
     */
    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username'" + username + '\'' +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }

    /**
     * Checks if this user's email is valid (basic validation).
     * Demonstrate boolean methods and String operations.
     *
     * @return true if email contains '@' and '.' false otherwise
     */
    public boolean hasValidEmail() {
        // Basic validation: email must contain @ and .
        if (email == null || email.isEmpty()) {
            return false;
        }
        return email.contains("@") && email.contains(".");
    }

    /**
     * Display user information in a formatted way.
     * Demonstrate void method and printing data
     */
    public void displayInfo() {
        String display = "=== User Information ===\n" +
                "ID: " + id + "\n" +
                "Username: " + username + "\n" +
                "Full Name: " + fullName + "\n" +
                "Email: " + email + "\n" +
                "========================\n";
        System.out.println(display);
    }
}
