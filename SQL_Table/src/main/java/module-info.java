module com.example.sql_table {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.sql;
    requires mysql.connector.j;


    opens com.example.sql_table to javafx.fxml;
    exports com.example.sql_table;
}