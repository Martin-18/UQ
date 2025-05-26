package co.edu.uniquindio.poo.proyectofinal.Controller;

import co.edu.uniquindio.poo.proyectofinal.App;
import co.edu.uniquindio.poo.proyectofinal.Model.Administrador;
import co.edu.uniquindio.poo.proyectofinal.Model.Bibliotecario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginController {

    @FXML private VBox loginContainer;
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Button loginButton;
    @FXML private Button bibliotecarioButton;
    @FXML private Button consultaButton;
    @FXML private Label titleLabel;
    @FXML private Label statusLabel;

    private App App;
    private Administrador administrador;
    private Bibliotecario bibliotecario;

    @FXML
    private void initialize() {
        // Configurar eventos
        loginButton.setOnAction(e -> handleAdminLogin());
        bibliotecarioButton.setOnAction(e -> handleBibliotecarioAccess());
        consultaButton.setOnAction(e -> handleConsultaPublica());

        // Configurar estilos CSS
        configurarEstilos();
    }

    private void configurarEstilos() {
        loginContainer.getStyleClass().add("login-container");
        titleLabel.getStyleClass().add("title-label");
        usernameField.getStyleClass().add("text-field-custom");
        passwordField.getStyleClass().add("text-field-custom");
        loginButton.getStyleClass().add("primary-button");
        bibliotecarioButton.getStyleClass().add("secondary-button");
        consultaButton.getStyleClass().add("tertiary-button");
    }

    @FXML
    private void handleAdminLogin() {
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();

        if (username.isEmpty() || password.isEmpty()) {
            mostrarError("Por favor, complete todos los campos");
            return;
        }

        if (administrador.validarCredenciales(username, password)) {
            statusLabel.setText("¡Acceso autorizado!");
            statusLabel.setStyle("-fx-text-fill: #2e7d32;");
            abrirVentanaAdministrador();
        } else {
            mostrarError("Credenciales incorrectas");
        }

        limpiarCampos();
    }

    @FXML
    private void handleBibliotecarioAccess() {
        abrirVentanaBibliotecario();
    }

    @FXML
    private void handleConsultaPublica() {
        abrirVentanaConsulta();
    }

    private void abrirVentanaAdministrador() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/fxml/AdministradorView.fxml"));

            Scene scene = new Scene(loader.load());
            scene.getStylesheets().add(getClass().getResource("/css/styles.css").toExternalForm());

            AdministradorController controller = loader.getController();
            controller.setApp(App);
            controller.setAdministrador(administrador);
            controller.setBiblioteca(App.getBiblioteca());

            Stage stage = new Stage();
            stage.setTitle("Panel de Administrador - Biblioteca UQ");
            stage.setScene(scene);
            stage.setMinWidth(1000);
            stage.setMinHeight(700);
            stage.show();

        } catch (Exception e) {
            mostrarError("Error al abrir panel de administrador: " + e.getMessage());
        }
    }

    private void abrirVentanaBibliotecario() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/fxml/BibliotecarioView.fxml"));

            Scene scene = new Scene(loader.load());
            scene.getStylesheets().add(getClass().getResource("/css/styles.css").toExternalForm());

            BibliotecarioController controller = loader.getController();
            controller.setApp(App);
            controller.setBibliotecario(bibliotecario);
            controller.setBiblioteca(App.getBiblioteca());

            Stage stage = new Stage();
            stage.setTitle("Panel de Bibliotecario - Biblioteca UQ");
            stage.setScene(scene);
            stage.setMinWidth(1000);
            stage.setMinHeight(700);
            stage.show();

        } catch (Exception e) {
            mostrarError("Error al abrir panel de bibliotecario: " + e.getMessage());
        }
    }

    private void abrirVentanaConsulta() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/fxml/ConsultaView.fxml"));

            Scene scene = new Scene(loader.load());
            scene.getStylesheets().add(getClass().getResource("/css/styles.css").toExternalForm());

            ConsultaController controller = loader.getController();
            controller.setBiblioteca(App.getBiblioteca());

            Stage stage = new Stage();
            stage.setTitle("Consulta Pública - Biblioteca UQ");
            stage.setScene(scene);
            stage.setMinWidth(800);
            stage.setMinHeight(600);
            stage.show();

        } catch (Exception e) {
            mostrarError("Error al abrir consulta pública: " + e.getMessage());
        }
    }

    private void mostrarError(String mensaje) {
        statusLabel.setText(mensaje);
        statusLabel.setStyle("-fx-text-fill: #d32f2f;");
    }

    private void limpiarCampos() {
        usernameField.clear();
        passwordField.clear();
    }

    // Setters para dependency injection
    public void setMainApp(App mainApp) {
        this.mainApp = mainApp;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public void setBibliotecario(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }
}