module com.example.table_books {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.example.table_books to javafx.fxml;
    exports com.example.table_books;
}