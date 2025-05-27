package co.edu.uniquindio.poo.proyectofinal.Controller;

import co.edu.uniquindio.poo.proyectofinal.Model.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;

import java.util.Set;
import java.util.stream.Collectors;

public class ConsultaController {

    @FXML private TextField busquedaField;
    @FXML private ComboBox<String> filtroTipoCombo;
    @FXML private ComboBox<String> filtroGeneroCombo;
    @FXML private TableView<Libro> librosTable;
    @FXML private TableColumn<Libro, String> tituloColumn;
    @FXML private TableColumn<Libro, String> autorColumn;
    @FXML private TableColumn<Libro, String> generoColumn;
    @FXML private TableColumn<Libro, Integer> anioColumn;
    @FXML private TableColumn<Libro, String> tipoColumn;
    @FXML private TableColumn<Libro, String> estadoColumn;
    @FXML private Label totalLibrosLabel;
    @FXML private Label disponiblesLabel;
    @FXML private Label prestadosLabel;
    @FXML private TextArea detallesArea;
    @FXML private Label statusLabel;

    private Biblioteca biblioteca;
    private ObservableList<Libro> librosData = FXCollections.observableArrayList();
    private FilteredList<Libro> librosFiltrados;

    @FXML
    private void initialize() {
        configurarTabla();
        configurarFiltros();
        configurarBusqueda();
        configurarSeleccion();
        configurarEstilos();
    }

    private void configurarTabla() {
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

        librosFiltrados = new FilteredList<>(librosData, p -> true);
        librosTable.setItems(librosFiltrados);
    }

    private void configurarFiltros() {
        filtroTipoCombo.getItems().addAll("Todos", "Físico", "Digital", "Referencia");
        filtroTipoCombo.setValue("Todos");
        filtroTipoCombo.setOnAction(e -> aplicarFiltros());

        // Poblar géneros únicos desde la biblioteca
        filtroGeneroCombo.getItems().add("Todos");
        filtroGeneroCombo.setValue("Todos");
        filtroGeneroCombo.setOnAction(e -> aplicarFiltros());
    }

    private void configurarBusqueda() {
        busquedaField.textProperty().addListener((observable, oldValue, newValue) -> {
            aplicarFiltros();
        });
    }

    private void configurarSeleccion() {
        librosTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> mostrarDetallesLibro(newValue));
    }

    private void configurarEstilos() {
        busquedaField.getStyleClass().add("search-field");
        filtroTipoCombo.getStyleClass().add("filter-combo");
        filtroGeneroCombo.getStyleClass().add("filter-combo");
        librosTable.getStyleClass().add("table-view-custom");
        detallesArea.getStyleClass().add("details-area");
    }

    private void aplicarFiltros() {
        String busqueda = busquedaField.getText().toLowerCase();
        String tipoFiltro = filtroTipoCombo.getValue();
        String generoFiltro = filtroGeneroCombo.getValue();

        librosFiltrados.setPredicate(libro -> {
            boolean cumpleBusqueda = busqueda.isEmpty() ||
                    libro.getTitulo().toLowerCase().contains(busqueda) ||
                    libro.getAutor().toLowerCase().contains(busqueda);

            boolean cumpleTipo = tipoFiltro.equals("Todos") ||
                    libro.getClass().getSimpleName().equals(tipoFiltro);

            boolean cumpleGenero = generoFiltro.equals("Todos") ||
                    libro.getGenero().equals(generoFiltro);

            return cumpleBusqueda && cumpleTipo && cumpleGenero;
        });

        actualizarEstadisticas();
    }

    private void mostrarDetallesLibro(Libro libro) {
        if (libro == null) {
            detallesArea.clear();
            return;
        }

        StringBuilder detalles = new StringBuilder();
        detalles.append("=== DETALLES DEL LIBRO ===\n");
        detalles.append("Título: ").append(libro.getTitulo()).append("\n");
        detalles.append("Autor: ").append(libro.getAutor()).append("\n");
        detalles.append("Género: ").append(libro.getGenero()).append("\n");
        detalles.append("Año: ").append(libro.getAnio()).append("\n");
        detalles.append("Tipo: ").append(libro.getClass().getSimpleName()).append("\n");
        detalles.append("Estado: ").append(libro.isPrestado() ? "Prestado" : "Disponible").append("\n");

        if (libro instanceof Fisico) {
            Fisico fisico = (Fisico) libro;
            detalles.append("\nDetalles Físicos:\n");
            detalles.append("Número de páginas: ").append(fisico.getNumeroPaginas()).append("\n");
            detalles.append("Editorial: ").append(fisico.getEditorial()).append("\n");
            detalles.append("Ubicación: ").append(fisico.getUbicacion()).append("\n");
        } else if (libro instanceof Digital) {
            Digital digital = (Digital) libro;
            detalles.append("\nDetalles Digitales:\n");
            detalles.append("Formato: ").append(digital.getFormato()).append("\n");
        } else if (libro instanceof Referencia) {
            Referencia referencia = (Referencia) libro;
            detalles.append("\nDetalles de Referencia:\n");
        }

        detallesArea.setText(detalles.toString());
    }

    private void actualizarEstadisticas() {
        int total = librosFiltrados.size();
        int prestados = (int) librosFiltrados.stream().filter(Libro::isPrestado).count();
        int disponibles = total - prestados;

        totalLibrosLabel.setText("Total: " + total);
        disponiblesLabel.setText("Disponibles: " + disponibles);
        prestadosLabel.setText("Prestados: " + prestados);
    }

    private void mostrarError(String mensaje) {
        statusLabel.setText(mensaje);
        statusLabel.setStyle("-fx-text-fill: #d32f2f;");

        Timeline timeline = new Timeline(new KeyFrame(
                Duration.seconds(5),
                e -> statusLabel.setText("")
        ));
        timeline.play();
    }

    private void mostrarExito(String mensaje) {
        statusLabel.setText(mensaje);
        statusLabel.setStyle("-fx-text-fill: #2e7d32;");

        Timeline timeline = new Timeline(new KeyFrame(
                Duration.seconds(3),
                e -> statusLabel.setText("")
        ));
        timeline.play();
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        if (biblioteca != null) {
            librosData.clear();
            librosData.addAll(biblioteca.getLibros());

            Set<String> generos = biblioteca.getLibros().stream()
                    .map(Libro::getGenero)
                    .collect(Collectors.toSet());
            filtroGeneroCombo.getItems().addAll(generos);

            actualizarEstadisticas();
        }
    }
}