package co.edu.uniquindio.poo.proyectofinal.Controller;

import co.edu.uniquindio.poo.proyectofinal.App;
import co.edu.uniquindio.poo.proyectofinal.Model.Administrador;
import co.edu.uniquindio.poo.proyectofinal.Model.Biblioteca;
import co.edu.uniquindio.poo.proyectofinal.Model.Bibliotecario;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;

public class AdministradorController {

    @FXML private TextField nombreEmpleadoField;
    @FXML private TextField idEmpleadoField;
    @FXML private TextField usuarioField;
    @FXML private TextField contrasenaField;
    @FXML private TableView<Bibliotecario> empleadosTable;
    @FXML private TableColumn<Bibliotecario, String> nombreColumn;
    @FXML private TableColumn<Bibliotecario, Integer> idColumn;
    @FXML private TextArea reporteArea;
    @FXML private Label statusLabel;
    @FXML private Button registrarEmpleadoBtn;
    @FXML private Button eliminarEmpleadoBtn;
    @FXML private Button agregarCredencialBtn;
    @FXML private Button generarReporteBtn;

    private App App;
    private Administrador administrador;
    private Biblioteca biblioteca;
    private ObservableList<Bibliotecario> empleadosData = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        // Configurar la tabla de empleados
        nombreColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        empleadosTable.setItems(empleadosData);

        // Configurar eventos de botones
        registrarEmpleadoBtn.setOnAction(e -> registrarEmpleado());
        eliminarEmpleadoBtn.setOnAction(e -> eliminarEmpleado());
        agregarCredencialBtn.setOnAction(e -> agregarCredencial());
        generarReporteBtn.setOnAction(e -> generarReporte());

        // Configurar estilos
        configurarEstilos();

        // Configurar la selección de la tabla
        empleadosTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    eliminarEmpleadoBtn.setDisable(newValue == null);
                }
        );

        eliminarEmpleadoBtn.setDisable(true);
    }

    private void configurarEstilos() {
        // Aplicar estilos CSS a los componentes
        nombreEmpleadoField.getStyleClass().add("text-field-custom");
        idEmpleadoField.getStyleClass().add("text-field-custom");
        usuarioField.getStyleClass().add("text-field-custom");
        contrasenaField.getStyleClass().add("text-field-custom");

        registrarEmpleadoBtn.getStyleClass().add("primary-button");
        eliminarEmpleadoBtn.getStyleClass().add("danger-button");
        agregarCredencialBtn.getStyleClass().add("secondary-button");
        generarReporteBtn.getStyleClass().add("info-button");

        empleadosTable.getStyleClass().add("table-view-custom");
        reporteArea.getStyleClass().add("text-area-custom");
    }

    @FXML
    private void registrarEmpleado() {
        String nombre = nombreEmpleadoField.getText().trim();
        String idTexto = idEmpleadoField.getText().trim();

        if (nombre.isEmpty() || idTexto.isEmpty()) {
            mostrarError("Por favor, complete todos los campos");
            return;
        }

        try {
            int id = Integer.parseInt(idTexto);

            // Verificar que el ID no esté duplicado
            for (Bibliotecario emp : administrador.getEmpleados()) {
                if (emp.getId() == id) {
                    mostrarError("Ya existe un empleado con ese ID");
                    return;
                }
            }

            Bibliotecario nuevoBibliotecario = new Bibliotecario(nombre, id);
            administrador.registrarEmpleado(nuevoBibliotecario);

            // Actualizar la tabla
            actualizarTablaEmpleados();

            // Limpiar campos
            nombreEmpleadoField.clear();
            idEmpleadoField.clear();

            mostrarExito("Empleado registrado exitosamente");

        } catch (NumberFormatException e) {
            mostrarError("El ID debe ser un número válido");
        }
    }

    @FXML
    private void eliminarEmpleado() {
        Bibliotecario empleadoSeleccionado = empleadosTable.getSelectionModel().getSelectedItem();

        if (empleadoSeleccionado == null) {
            mostrarError("Por favor, seleccione un empleado de la tabla");
            return;
        }

        // Mostrar confirmación
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmar eliminación");
        alert.setHeaderText("¿Está seguro de eliminar este empleado?");
        alert.setContentText("Empleado: " + empleadoSeleccionado.getNombre() + " (ID: " + empleadoSeleccionado.getId() + ")");

        if (alert.showAndWait().get() == ButtonType.OK) {
            administrador.eliminarEmpleado(empleadoSeleccionado);
            actualizarTablaEmpleados();
            mostrarExito("Empleado eliminado exitosamente");
        }
    }

    @FXML
    private void agregarCredencial() {
        String usuario = usuarioField.getText().trim();
        String contrasena = contrasenaField.getText().trim();

        if (usuario.isEmpty() || contrasena.isEmpty()) {
            mostrarError("Por favor, complete todos los campos de credenciales");
            return;
        }

        if (administrador.agregarCredencial(usuario, contrasena)) {
            usuarioField.clear();
            contrasenaField.clear();
            mostrarExito("Credencial agregada exitosamente");
        } else {
            mostrarError("Error al agregar credencial");
        }
    }

    @FXML
    private void generarReporte() {
        String reporte = administrador.generarReporteUsoSistema(biblioteca);
        reporteArea.setText(reporte);
        mostrarExito("Reporte generado exitosamente");
    }

    private void actualizarTablaEmpleados() {
        empleadosData.clear();
        empleadosData.addAll(administrador.getEmpleados());
    }

    private void mostrarError(String mensaje) {
        statusLabel.setText(mensaje);
        statusLabel.setStyle("-fx-text-fill: #d32f2f;");

        // Limpiar el mensaje después de 5 segundos
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.seconds(5),
                e -> statusLabel.setText("")
        ));
        timeline.play();
    }

    private void mostrarExito(String mensaje) {
        statusLabel.setText(mensaje);
        statusLabel.setStyle("-fx-text-fill: #2e7d32;");

        // Limpiar el mensaje después de 3 segundos
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.seconds(3),
                e -> statusLabel.setText("")
        ));
        timeline.play();
    }

    // Setters para dependency injection
    public void setMainApp(App App) {
        this.App = App;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
        if (administrador != null) {
            actualizarTablaEmpleados();
        }
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }
}