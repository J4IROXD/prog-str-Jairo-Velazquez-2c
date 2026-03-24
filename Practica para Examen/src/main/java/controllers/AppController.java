package controllers;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modelo.Contacto;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
public class AppController {
    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTelefono;

    @FXML
    private ComboBox<String> cmbParentesco;

    @FXML
    private ListView<Contacto> listaContactos;

    private ObservableList<Contacto> listaObservable = FXCollections.observableArrayList();

    String[] items = {"Padre", "Madre", "Hermano", "Hermana", "Abuelo", "Abuela", "Tío", "Tía"};
    @FXML
    public void initialize(){
        cmbParentesco.getItems().addAll(items);
        listaContactos.setItems(listaObservable);
    }
    @FXML
    public void onAgregar(){
        String nombre = txtNombre.getText();
        String telefono = txtTelefono.getText();
        String parentesco = cmbParentesco.getValue();
        if (nombre.isEmpty() || telefono.isEmpty() || parentesco == null) {
            System.out.println("Error: Faltan datos por llenar");
            return;
        }

        if (telefono.length() != 10) {
            System.out.println("Error: el teléfono debe tener 10 dígitos");
            return;
        }

        for (Contacto c : listaObservable) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Error: ya existe un contacto con ese nombre");
                return;
            }
        }
        if (!nombre.isEmpty() && !telefono.isEmpty() && parentesco != null){
            Contacto nuevoContacto = new Contacto(nombre, telefono, parentesco);
            listaObservable.add(nuevoContacto);
            txtNombre.setText("");
            txtTelefono.setText("");
            cmbParentesco.setValue(null);
        } else {
            System.out.println("Error: faltan datos por llenar");
        }
    }

    @FXML
    public void onEliminar(){
        Contacto seleccionado = listaContactos.getSelectionModel().getSelectedItem();
        if (seleccionado != null){
            listaObservable.remove(seleccionado);
            onLimpiar();
        } else {
            System.out.println("Error: debe seleccionar un contacto para eliminar");
        }
    }

    @FXML
    public void onBuscar(){
        String nombreBuscando = txtNombre.getText();
        boolean encontrado = false;

        for (Contacto c : listaObservable){
            if (c.getNombre().equalsIgnoreCase(nombreBuscando)) {
                listaContactos.getSelectionModel().select(c);
                txtNombre.setText(c.getNombre());
                txtTelefono.setText(c.getNumero());
                cmbParentesco.setValue(c.getParentesco());
                System.out.println("Contacto encontrado: " + c.getNumero());
                encontrado = true;
                break;
            }
        }
        if (!encontrado){
            System.out.println("Error: no se encontró al contacto con ese nombre");
        }
    }

    @FXML
    public void onActualizar(){
        Contacto seleccionado = listaContactos.getSelectionModel().getSelectedItem();
        if (seleccionado != null){
            seleccionado.setNombre(txtNombre.getText());
            seleccionado.setNumero(txtTelefono.getText());
            seleccionado.setParentesco(cmbParentesco.getValue());
            listaContactos.refresh();
            System.out.println("El contacto se actualizó correctamente");
        } else {
            System.out.println("Error: seleccione un contacto para poder actualizarlo");
        }
    }

    @FXML
    public void onLimpiar(){
        txtNombre.setText("");
        txtTelefono.setText("");
        cmbParentesco.setValue(null);
        listaContactos.getSelectionModel().clearSelection();
    }
}
