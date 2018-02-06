package com.hrms.vsoni.hrms;

/**
 * Created by vishwesh on 2/1/18.
 */

public class Employee {
    String firstName;
    String lastName;
    String remaining_sick;

    String remaining_casual;
    String getRemaining_privillages;

    int id;
    String username;
    String password;
    String email;
    String gender;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }




    public String getRemaining_casual() {
        return remaining_casual;
    }

    public void setRemaining_casual(String remaining_casual) {
        this.remaining_casual = remaining_casual;
    }

    public String getGetRemaining_privillages() {
        return getRemaining_privillages;
    }

    public void setGetRemaining_privillages(String getRemaining_privillages) {
        this.getRemaining_privillages = getRemaining_privillages;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRemaining_sick() {
        return remaining_sick;
    }

    public void setRemaining_sick(String remaining_sick) {
        this.remaining_sick = remaining_sick;
    }
}
