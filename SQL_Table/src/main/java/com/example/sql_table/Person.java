package com.example.sql_table;

public class Person {

    public int id;
    public String userName;
    public String email;
    public String active;

    public Person() {}

    public Person(int id, String userName, String email, String active) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String isActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return id + " "
                + userName + " "
                + email + " "
                + active + ";";
    }

}