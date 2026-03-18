module com.example.demolistviewfile {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demolistviewfile to javafx.fxml;
    exports com.example.demolistviewfile;
    opens com.example.demolistviewfile.controllers to javafx.fxml;
}