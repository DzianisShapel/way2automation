package org.andersen.lab.objects;

public class User {
    private String firstName;
    private String lastName;
    private String country;
    private String phoneNumber;
    private String username;
    private String password;
    private String email;

    public User () {}

    public User(String firstName, String lastName, String country, String phoneNumber, String username, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCountry() {
        return country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
