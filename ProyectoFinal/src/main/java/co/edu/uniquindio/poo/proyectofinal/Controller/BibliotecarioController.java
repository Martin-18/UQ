package co.edu.uniquindio.poo.proyectofinal.Controller;

import co.edu.uniquindio.poo.proyectofinal.App;
import co.edu.uniquindio.poo.proyectofinal.Model.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public class BibliotecarioController {

    @FXML private TextField tituloLibroField;
    @FXML private TextField autorLibroField;
    @FXML private TextField generoLibroField;
    @FXML private TextField anioLibroField;
    @FXML private ComboBox<String> tipoLibroCombo;

    @FXML private TextField nombreUsuarioField;
    @FXML private TextField idUsuarioField;
    @FXML private ComboBox<String> tipoUsuarioCombo;

    @FXML private TextField idUsuarioPrestamoField;
    @FXML private TextField tituloPrestamoField;

    @FXML private TableView<Libro> librosTable;
    @FXML private TableView<Usuario> usuariosTable;
    @FXML private TableView<Prestamo> prestamosTable;

    @FXML private Label bibliotecarioLabel;
    @FXML private TextArea estadisticasArea;
    @FXML private Label statusLabel;

    @FXML private Button agregarLibroBtn;
    @FXML private Button limpiarCamposBtn;
    @FXML private Button registrarUsuarioBtn;
    @FXML private Button eliminarUsuarioBtn;
    @FXML private Button realizarPrestamoBtn;
    @FXML private Button devolverLibroBtn;
    @FXML private Button consultarPrestamosBtn;
    @FXML private Button generarEstadisticasBtn;
    @FXML private Button exportarEstadisticasBtn;

    private App app;
    private Biblioteca biblioteca;
    private Bibliotecario bibliotecario;

    private ObservableList<Libro> librosData = FXCollections.observableArrayList();
    private ObservableList<Usuario> usuariosData = FXCollections.observableArrayList();
    private ObservableList<Prestamo> prestamosData = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        try {
            librosData = FXCollections.observableArrayList();
            usuariosData = FXCollections.observableArrayList();
            prestamosData = FXCollections.observableArrayList();

            if (tipoLibroCombo != null) {
                tipoLibroCombo.getItems().addAll("Físico", "Digital", "Referencia");
            }
            if (tipoUsuarioCombo != null) {
                tipoUsuarioCombo.getItems().addAll("Estudiante", "Docente", "Visitante");
            }

            if (agregarLibroBtn != null) agregarLibroBtn.setOnAction(e -> agregarLibro());
            if (limpiarCamposBtn != null) limpiarCamposBtn.setOnAction(e -> limpiarCamposLibro());
            if (registrarUsuarioBtn != null) registrarUsuarioBtn.setOnAction(e -> registrarUsuario());
            if (eliminarUsuarioBtn != null) eliminarUsuarioBtn.setOnAction(e -> eliminarUsuario());
            if (realizarPrestamoBtn != null) realizarPrestamoBtn.setOnAction(e -> realizarPrestamo());
            if (devolverLibroBtn != null) devolverLibroBtn.setOnAction(e -> devolverLibro());
            if (generarEstadisticasBtn != null) generarEstadisticasBtn.setOnAction(e -> generarEstadisticas());
            if (exportarEstadisticasBtn != null) exportarEstadisticasBtn.setOnAction(e -> exportarEstadisticas());

            configurarTablas();
            
            configurarEstilos();
            
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error en la inicialización: " + e.getMessage());
        }
    }

    private void configurarTablas() {
        TableColumn<Libro, String> tituloColumn = new TableColumn<>("Título");
        TableColumn<Libro, String> autorColumn = new TableColumn<>("Autor");
        TableColumn<Libro, String> generoColumn = new TableColumn<>("Género");
        TableColumn<Libro, Integer> anioColumn = new TableColumn<>("Año");
        TableColumn<Libro, String> tipoColumn = new TableColumn<>("Tipo");
        TableColumn<Libro, String> estadoColumn = new TableColumn<>("Estado");

        tituloColumn.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        autorColumn.setCellValueFactory(new PropertyValueFactory<>("autor"));
        generoColumn.setCellValueFactory(new PropertyValueFactory<>("genero"));
        anioColumn.setCellValueFactory(new PropertyValueFactory<>("anio"));
        tipoColumn.setCellValueFactory(cellData -> 
            javafx.beans.binding.Bindings.createStringBinding(() -> 
                cellData.getValue().getClass().getSimpleName()));
        estadoColumn.setCellValueFactory(cellData -> 
            javafx.beans.binding.Bindings.createStringBinding(() -> 
                cellData.getValue().isPrestado() ? "Prestado" : "Disponible"));

        librosTable.getColumns().addAll(tituloColumn, autorColumn, generoColumn, 
                                      anioColumn, tipoColumn, estadoColumn);
        librosTable.setItems(librosData);

        TableColumn<Usuario, String> nombreColumn = new TableColumn<>("Nombre");
        TableColumn<Usuario, Integer> idColumn = new TableColumn<>("ID");
        TableColumn<Usuario, String> tipoUsuarioColumn = new TableColumn<>("Tipo");
        TableColumn<Usuario, Integer> prestadosColumn = new TableColumn<>("Libros Prestados");

        nombreColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        tipoUsuarioColumn.setCellValueFactory(cellData -> 
            javafx.beans.binding.Bindings.createStringBinding(() -> 
                cellData.getValue().getClass().getSimpleName()));
        prestadosColumn.setCellValueFactory(cellData -> 
            javafx.beans.binding.Bindings.createObjectBinding(() -> 
                cellData.getValue().contarLibrosPrestados()));

        usuariosTable.getColumns().addAll(nombreColumn, idColumn, tipoUsuarioColumn, prestadosColumn);
        usuariosTable.setItems(usuariosData);

        TableColumn<Prestamo, String> usuarioPrestamoColumn = new TableColumn<>("Usuario");
        TableColumn<Prestamo, String> libroPrestamoColumn = new TableColumn<>("Libro");
        TableColumn<Prestamo, String> fechaPrestamoColumn = new TableColumn<>("Fecha Préstamo");
        TableColumn<Prestamo, String> fechaVencimientoColumn = new TableColumn<>("Fecha Vencimiento");
        TableColumn<Prestamo, String> estadoPrestamoColumn = new TableColumn<>("Estado");

        usuarioPrestamoColumn.setCellValueFactory(cellData -> 
            javafx.beans.binding.Bindings.createStringBinding(() -> 
                cellData.getValue().getUsuario().getNombre()));
        libroPrestamoColumn.setCellValueFactory(cellData -> 
            javafx.beans.binding.Bindings.createStringBinding(() -> 
                cellData.getValue().getLibro().getTitulo()));
        fechaPrestamoColumn.setCellValueFactory(new PropertyValueFactory<>("fechaPrestamo"));
        fechaVencimientoColumn.setCellValueFactory(new PropertyValueFactory<>("fechaVencimiento"));
        estadoPrestamoColumn.setCellValueFactory(cellData -> 
            javafx.beans.binding.Bindings.createStringBinding(() -> 
                cellData.getValue().isActivo() ? "Activo" : "Devuelto"));

        prestamosTable.getColumns().addAll(usuarioPrestamoColumn, libroPrestamoColumn,
                                         fechaPrestamoColumn, fechaVencimientoColumn, 
                                         estadoPrestamoColumn);
        prestamosTable.setItems(prestamosData);
    }

    private void agregarLibro() {
        try {
            String titulo = tituloLibroField.getText().trim();
            String autor = autorLibroField.getText().trim();
            String genero = generoLibroField.getText().trim();
            int anio = Integer.parseInt(anioLibroField.getText().trim());
            String tipo = tipoLibroCombo.getValue();

            if (titulo.isEmpty() || autor.isEmpty() || genero.isEmpty() || tipo == null) {
                mostrarError("Por favor, complete todos los campos");
                return;
            }

            Libro nuevoLibro = null;
            switch (tipo) {
                case "Físico":
                    nuevoLibro = new Fisico(300, "Editorial", "Estante A1",
                            titulo, autor, genero, anio, false);
                    break;
                case "Digital":
                    nuevoLibro = new Digital("url://ejemplo.com",
                            titulo, autor, genero, anio, false, Formato.PDF);
                    break;
                case "Referencia":
                    nuevoLibro = new Referencia(titulo, autor, genero, anio, "Sección Referencia");
                    break;
            }

            if (nuevoLibro != null) {
                bibliotecario.agregarLibro(nuevoLibro);
                actualizarTablaLibros();
                limpiarCamposLibro();
                mostrarExito("Libro agregado exitosamente");
            }

        } catch (NumberFormatException e) {
            mostrarError("El año debe ser un número válido");
        }
    }

    private void registrarUsuario() {
        try {
            String nombre = nombreUsuarioField.getText().trim();
            int id = Integer.parseInt(idUsuarioField.getText().trim());
            String tipo = tipoUsuarioCombo.getValue();

            if (nombre.isEmpty() || tipo == null) {
                mostrarError("Por favor, complete todos los campos");
                return;
            }

            Usuario nuevoUsuario = null;
            switch (tipo) {
                case "Estudiante":
                    nuevoUsuario = new Estudiante(nombre, id, new ArrayList<>(), 3, 15);
                    break;
                case "Docente":
                    nuevoUsuario = new Docente(nombre, id, new ArrayList<>(), 5, 30);
                    break;
                case "Visitante":
                    nuevoUsuario = new Visitante(nombre, id, new ArrayList<>(), 1, 7);
                    break;
            }

            if (nuevoUsuario != null) {
                bibliotecario.agregarUsuario(nuevoUsuario);
                actualizarTablaUsuarios();
                limpiarCamposUsuario();
                mostrarExito("Usuario registrado exitosamente");
            }

        } catch (NumberFormatException e) {
            mostrarError("El ID debe ser un número válido");
        }
    }

    private void eliminarUsuario() {
        Usuario usuarioSeleccionado = usuariosTable.getSelectionModel().getSelectedItem();
        if (usuarioSeleccionado == null) {
            mostrarError("Por favor, seleccione un usuario de la tabla");
            return;
        }

        if (usuarioSeleccionado.contarLibrosPrestados() > 0) {
            mostrarError("No se puede eliminar un usuario con libros prestados");
            return;
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmar eliminación");
        alert.setHeaderText("¿Está seguro de eliminar este usuario?");
        alert.setContentText("Usuario: " + usuarioSeleccionado.getNombre());

        if (alert.showAndWait().get() == ButtonType.OK) {
            bibliotecario.getUsuarios().remove(usuarioSeleccionado);
            actualizarTablaUsuarios();
            mostrarExito("Usuario eliminado exitosamente");
        }
    }

    private void realizarPrestamo() {
        try {
            int idUsuario = Integer.parseInt(idUsuarioPrestamoField.getText().trim());
            String tituloLibro = tituloPrestamoField.getText().trim();

            if (tituloLibro.isEmpty()) {
                mostrarError("Por favor, complete todos los campos");
                return;
            }

            if (bibliotecario.realizarPrestamo(idUsuario, tituloLibro)) {
                actualizarTablaPrestamos();
                actualizarTablaLibros();
                actualizarTablaUsuarios();
                limpiarCamposPrestamo();
                mostrarExito("Préstamo realizado exitosamente");
            } else {
                mostrarError("No se pudo realizar el préstamo. Verifique la disponibilidad del libro y los límites del usuario");
            }

        } catch (NumberFormatException e) {
            mostrarError("El ID de usuario debe ser un número válido");
        }
    }

    private void devolverLibro() {
        try {
            int idUsuario = Integer.parseInt(idUsuarioPrestamoField.getText().trim());
            String tituloLibro = tituloPrestamoField.getText().trim();

            if (tituloLibro.isEmpty()) {
                mostrarError("Por favor, complete todos los campos");
                return;
            }

            if (bibliotecario.devolverLibro(idUsuario, tituloLibro)) {
                actualizarTablaPrestamos();
                actualizarTablaLibros();
                actualizarTablaUsuarios();
                limpiarCamposPrestamo();
                mostrarExito("Libro devuelto exitosamente");
            } else {
                mostrarError("No se pudo realizar la devolución. Verifique los datos");
            }

        } catch (NumberFormatException e) {
            mostrarError("El ID de usuario debe ser un número válido");
        }
    }

    private void generarEstadisticas() {
        String estadisticas = bibliotecario.generarEstadisticasPrestamos(biblioteca);
        estadisticasArea.setText(estadisticas);
    }

    private void exportarEstadisticas() {
        String estadisticas = estadisticasArea.getText();
        if (estadisticas.isEmpty()) {
            mostrarError("Primero debe generar las estadísticas");
            return;
        }

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Guardar Estadísticas");
        fileChooser.getExtensionFilters().add(
            new FileChooser.ExtensionFilter("Archivos de texto", "*.txt")
        );

        File file = fileChooser.showSaveDialog(app.getPrimaryStage());
        if (file != null) {
            try {
                Files.write(file.toPath(), estadisticas.getBytes());
                mostrarExito("Estadísticas exportadas exitosamente");
            } catch (IOException e) {
                mostrarError("Error al exportar las estadísticas: " + e.getMessage());
            }
        }
    }

    private void actualizarTablaLibros() {
        librosData.setAll(bibliotecario.getLibros());
    }

    private void actualizarTablaUsuarios() {
        usuariosData.setAll(bibliotecario.getUsuarios());
    }

    private void actualizarTablaPrestamos() {
        prestamosData.setAll(bibliotecario.getPrestamos());
    }

    private void limpiarCamposLibro() {
        tituloLibroField.clear();
        autorLibroField.clear();
        generoLibroField.clear();
        anioLibroField.clear();
        tipoLibroCombo.setValue(null);
    }

    private void limpiarCamposUsuario() {
        nombreUsuarioField.clear();
        idUsuarioField.clear();
        tipoUsuarioCombo.setValue(null);
    }

    private void limpiarCamposPrestamo() {
        idUsuarioPrestamoField.clear();
        tituloPrestamoField.clear();
    }

    private void mostrarError(String mensaje) {
        statusLabel.setText(mensaje);
        statusLabel.getStyleClass().setAll("error-label");
        
        Timeline timeline = new Timeline(
            new KeyFrame(Duration.seconds(5), event -> statusLabel.setText(""))
        );
        timeline.play();
    }

    private void mostrarExito(String mensaje) {
        statusLabel.setText(mensaje);
        statusLabel.getStyleClass().setAll("success-label");
        
        Timeline timeline = new Timeline(
            new KeyFrame(Duration.seconds(3), event -> statusLabel.setText(""))
        );
        timeline.play();
    }

    public void setApp(App app) {
        this.app = app;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        if (biblioteca != null) {
            this.biblioteca = biblioteca;
            try {
                librosData.clear();
                librosData.addAll(biblioteca.getLibros());
                actualizarTablaLibros();
            } catch (Exception e) {
                mostrarError("Error al cargar los datos de la biblioteca: " + e.getMessage());
            }
        }
    }

    public void setBibliotecario(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
        bibliotecarioLabel.setText("Bibliotecario: " + bibliotecario.getNombre());
    }

    private void configurarCombos() {
        tipoLibroCombo.getItems().addAll("Físico", "Digital", "Referencia");
        tipoUsuarioCombo.getItems().addAll("Estudiante", "Docente", "Visitante");
    }

    private void configurarBotones() {
        agregarLibroBtn.setOnAction(e -> agregarLibro());
        limpiarCamposBtn.setOnAction(e -> limpiarCamposLibro());
        registrarUsuarioBtn.setOnAction(e -> registrarUsuario());
        eliminarUsuarioBtn.setOnAction(e -> eliminarUsuario());
        realizarPrestamoBtn.setOnAction(e -> realizarPrestamo());
        devolverLibroBtn.setOnAction(e -> devolverLibro());
        generarEstadisticasBtn.setOnAction(e -> generarEstadisticas());
        exportarEstadisticasBtn.setOnAction(e -> exportarEstadisticas());
    }

    private void configurarEstilos() {
        agregarLibroBtn.getStyleClass().add("primary-button");
        limpiarCamposBtn.getStyleClass().add("secondary-button");
        registrarUsuarioBtn.getStyleClass().add("primary-button");
        eliminarUsuarioBtn.getStyleClass().add("danger-button");
        realizarPrestamoBtn.getStyleClass().add("success-button");
        devolverLibroBtn.getStyleClass().add("warning-button");
        consultarPrestamosBtn.getStyleClass().add("info-button");
        generarEstadisticasBtn.getStyleClass().add("primary-button");
        exportarEstadisticasBtn.getStyleClass().add("secondary-button");

        bibliotecarioLabel.getStyleClass().add("title-label");
        estadisticasArea.getStyleClass().add("statistics-area");
    }
}