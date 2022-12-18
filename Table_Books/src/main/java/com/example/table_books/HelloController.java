package com.example.table_books;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import com.google.gson.Gson;

import java.io.*;
import java.util.Scanner;

public class HelloController {
    private final ObservableList<Books> BookShelfData = FXCollections.observableArrayList();

    @FXML
    private Button button_json;

    @FXML
    private Button button_txt;

    @FXML
    private TableView<Books> tableUsers;

    @FXML
    private TableColumn<Books, Integer> id;

    @FXML
    private TableColumn<Books, String> author;

    @FXML
    private TableColumn<Books, String> name;

    @FXML
    public void onClickJson() throws IOException {
        initData_json();

        id.setCellValueFactory(new PropertyValueFactory<Books, Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<Books, String>("name"));
        author.setCellValueFactory(new PropertyValueFactory<Books, String>("author"));

        tableUsers.setItems(BookShelfData);
    }

    @FXML
    public void onClickTxt() throws IOException {
        initData_txt();

        id.setCellValueFactory(new PropertyValueFactory<Books, Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<Books, String>("name"));
        author.setCellValueFactory(new PropertyValueFactory<Books, String>("author"));

        tableUsers.setItems(BookShelfData);
    }

    int i = 0;

    private void initData_txt() throws IOException {
        Books A1 = new Books();

        FileReader fr = new FileReader("input.txt");
        Scanner in = new Scanner(fr);

        String Name;
        String Author;

        while(in.hasNextLine()) {
            Name = in.nextLine();
            Author = in.nextLine();

            Books book = new Books(Name, Author, i + 1);

            BookShelfData.add(book);
            i++;
        }

        fr.close();
    }

    private void initData_json() throws IOException {
        Gson gson = new Gson();

        BufferedReader br = new BufferedReader(new FileReader("input.json"));

        BookShelf _json = gson.fromJson(br, BookShelf.class);

        for (int j = 0; j < _json.count; j++) {
            _json.shelf[j].Id = i + 1;
            BookShelfData.add(_json.shelf[j]);
            i++;
        }
    }
}