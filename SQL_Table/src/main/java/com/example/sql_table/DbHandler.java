package com.example.sql_table;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.*;

public class DbHandler {

    private static final String CON_STR = "jdbc:mysql://localhost/persons?serverTimezone=Europe/Moscow&useSSL=false";

    private static DbHandler instance = null;

    public DbHandler() throws SQLException, IOException {
    }

    public static synchronized DbHandler getInstance() throws SQLException, IOException {
        if (instance == null)
            instance = new DbHandler();
        return instance;
    }

    public static Connection getConnection() throws SQLException, IOException {

        Properties props = new Properties();
        try(InputStream in = Files.newInputStream(Paths.get("database.properties"))){
            props.load(in);
        }
        String url = props.getProperty("url");
        String username = props.getProperty("username");
        String password = props.getProperty("password");

        return DriverManager.getConnection(url, username, password);
    }

    private Connection connection = getConnection();

    public void addPerson(Person newPerson) throws SQLException {
        Statement statement = connection.createStatement();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO People (id, userName, email, activ) value (?, ?, ?, ?)");

        preparedStatement.setInt(1, newPerson.getId());
        preparedStatement.setNString(2, newPerson.getUserName());
        preparedStatement.setNString(3, newPerson.getEmail());
        preparedStatement.setNString(4, newPerson.isActive());
        preparedStatement.execute();
    }

    public void deletePerson(String oldPerson) throws SQLException {
        Statement statement = connection.createStatement();

        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM People WHERE userName =" + "'" + oldPerson + "'" + ";");

        preparedStatement.execute();
    }

    public void deleteAllPerson() throws SQLException {
        Statement statement = connection.createStatement();

        PreparedStatement preparedStatement = connection.prepareStatement("TRUNCATE People;");

        preparedStatement.execute();
    }
}