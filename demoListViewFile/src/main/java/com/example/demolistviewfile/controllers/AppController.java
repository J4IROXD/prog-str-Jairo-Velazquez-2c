package com.example.demolistviewfile.controllers;
import com.example.demolistviewfile.services.PersonService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.List;

public class AppController {

    @FXML
    private Label lblMsg;
    @FXML
    private ListView<String> listView;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtAge;

    private ObservableList<String> data = FXCollections.observableArrayList();
    PersonService service= new PersonService();

    @FXML
    public void initialize(){
        listView.setItems(data);
        listView.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldValue, newValue) -> {
                    String[] parts = newValue.split("-");
                    txtName.setText(parts[0]);
                    txtAge.setText(parts[1]);
                    txtEmail.setText(parts[2]);
                }
        );
        loadFromFile();
    }

    @FXML
    public void onReload(){
        loadFromFile();
    }

    @FXML
    public void onDelate() {
        try {
            int index = listView.getSelectionModel().getSelectedIndex();
            service.Delate(index);
            loadFromFile();
            txtName.clear();
            txtEmail.clear();
            txtAge.clear();
            lblMsg.setText("Se Elimino el regitro correctamente");

        } catch (IllegalArgumentException e) {
            lblMsg.setText(e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        } catch (IOException e) {
            lblMsg.setText("Error al escribir en el archivo");
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }

    @FXML
    public void onAddPerson() {
        try {
            String name = txtName.getText();
            String email = txtEmail.getText();
            String edadTexto = txtAge.getText();
            int edadNumero = Integer.parseInt(edadTexto);
            service.addPerson(name, email, edadNumero);
            lblMsg.setText("La persona se agrego correctamente");
            lblMsg.setStyle("-fx-text-fill: green");
            txtName.clear();
            txtEmail.clear();
            txtAge.clear();
            loadFromFile();

        } catch (NumberFormatException e) {
            lblMsg.setText("La edad debe de ser una edad valida");
            lblMsg.setStyle("-fx-text-fill: red");
        } catch (IllegalArgumentException e) {
            lblMsg.setText(e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        } catch (IOException e) {
            lblMsg.setText("Error al escribir en el archivo");
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }
    @FXML
    public void onUpdate(){
        try{
            int index = listView.getSelectionModel().getSelectedIndex();
            String name = txtName.getText();
            String email = txtEmail.getText();
            String ageTexto = txtAge.getText();
            int ageNumero = Integer.parseInt(ageTexto);
            service.updatePerson(index, name, email, ageNumero);
            loadFromFile();
            txtName.clear();
            txtEmail.clear();
            txtAge.clear();
            lblMsg.setText("Se actualizo el regitro correctamente");
        } catch (IllegalArgumentException e) {
            lblMsg.setText("Hubo un error con los datos: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
            // lblMsg.setText("Hubo un error con el archivo");
        }
    }

    private void loadFromFile(){
        try{
            List<String> items = service.loadForListView();
            data.setAll(items);
            lblMsg.setText("Datos cargados correctamente");
            lblMsg.setStyle("-fx-text-fill: green");
        } catch (IOException e) {
            lblMsg.setText("Error: "+e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }
}
