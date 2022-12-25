package com.example.sql_table;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import com.google.gson.Gson;

import java.io.*;
import java.sql.*;

public class HelloController {
    private final ObservableList<Person> PersonData = FXCollections.observableArrayList();

    public Button create_button;

    public Button update_button;

    public Button json_button;

    public TextField path;
    public TextField deleteField;
    public Button delete_button;

    @FXML
    private TableView<Person> tableUsers;

    @FXML
    private TableColumn<Person, Integer> id;

    @FXML
    private TableColumn<Person, String> username;

    @FXML
    private TableColumn<Person, String> email;

    @FXML
    public TableColumn<Person, String> active;

    @FXML
    public void Create() throws Exception {
        getUserList();

        id.setCellValueFactory(new PropertyValueFactory<Person, Integer>("id"));
        username.setCellValueFactory(new PropertyValueFactory<Person, String>("userName"));
        email.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));
        active.setCellValueFactory(new PropertyValueFactory<Person, String>("active"));

        tableUsers.setItems(PersonData);
    }

    int i = 0;

    public void Delete() throws Exception {
        DbHandler db = new DbHandler();
        DbHandler.getInstance();

        db.deletePerson(deleteField.getText());

        getUserList();
    }

    public void Delete_All() throws Exception {
        DbHandler db = new DbHandler();
        DbHandler.getInstance();

        db.deleteAllPerson();
        getUserList();
    }

    private void getUserList() throws Exception {
        PersonData.removeAll(PersonData);

        Connection conn = DbHandler.getConnection();
        Statement statement = conn.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM People");
        while(resultSet.next())
        {
            Person a = new Person(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                    resultSet.getString(4));
            PersonData.add(a);
        }
    }
    public void readJson(ActionEvent actionEvent) throws IOException, SQLException {
        Gson gson = new Gson();

        BufferedReader br = new BufferedReader(new FileReader("input.json"));
        PersonList _json = gson.fromJson(br, PersonList.class);

        DbHandler db = new DbHandler();
        DbHandler.getInstance();

        for (int j = 0; j < _json.count; j++) {
            _json.persons[j].id = i + 1;
            i++;

            try {
                db.addPerson(_json.persons[j]);
            }
            catch (SQLIntegrityConstraintViolationException e) {
                _json.persons[j].id = i + 1;
                db.addPerson(_json.persons[j]);
            }
        }
    }
}