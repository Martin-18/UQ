package co.edu.uniquindio.poo.proyectofinal.Controller;

import co.edu.uniquindio.poo.proyectofinal.App;
import co.edu.uniquindio.poo.proyectofinal.Model.Administrador;
import co.edu.uniquindio.poo.proyectofinal.Model.Bibliotecario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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
    @FXML private ImageView logoImageView;


    private App app;
    private Administrador administrador;
    private Bibliotecario bibliotecario;

    @FXML
    private void initialize() {
        try {
            // Cargar la imagen usando la ruta relativa desde resources
            Image logo = new Image(getClass().getResourceAsStream("/assets/logo.png"));
            if (logoImageView != null) {
                logoImageView.setImage(logo);

                // Aplicar efecto de sombra al logo
                DropShadow shadow = new DropShadow();
                shadow.setRadius(10.0);
                shadow.setOffsetX(3.0);
                shadow.setOffsetY(3.0);
                shadow.setColor(Color.rgb(0, 0, 0, 0.3));
                logoImageView.setEffect(shadow);
            }
        } catch (Exception e) {
            System.err.println("Error al cargar el logo: " + e.getMessage());
            e.printStackTrace();
        }

        // Configurar eventos
        loginButton.setOnAction(e -> handleAdminLogin());
        bibliotecarioButton.setOnAction(e -> handleBibliotecarioAccess());
        consultaButton.setOnAction(e -> handleConsultaPublica());

        configurarEstilos();

        // Obtener las instancias
        this.administrador = App.getAdministrador();
        this.bibliotecario = App.getBibliotecario();
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
            // Actualizar la ruta para que coincida con la estructura del proyecto
            loader.setLocation(App.class.getResource("/co/edu/uniquindio/poo/proyectofinal/AdministradorView.fxml"));

            Scene scene = new Scene(loader.load());
            // Comentar temporalmente la línea de estilos CSS
            // scene.getStylesheets().add(getClass().getResource("/css/styles.css").toExternalForm());

            AdministradorController controller = loader.getController();
            controller.setAdministrador(administrador);
            controller.setBiblioteca(App.getBiblioteca());

            Stage stage = new Stage();
            stage.setTitle("Panel de Administrador - Biblioteca UQ");
            stage.setScene(scene);
            stage.setMinWidth(1000);
            stage.setMinHeight(700);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace(); // Agregar esto para ver el error completo
            mostrarError("Error al abrir panel de administrador: " + e.getMessage());
        }
    }


    private void abrirVentanaBibliotecario() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/co/edu/uniquindio/poo/proyectofinal/BibliotecarioView.fxml"));

            Scene scene = new Scene(loader.load());
            // Comentar o eliminar la línea del CSS por ahora
            // scene.getStylesheets().add(getClass().getResource("/css/styles.css").toExternalForm());

            BibliotecarioController controller = loader.getController();

            // Configurar el controlador con las dependencias necesarias
            controller.setApp(app);
            controller.setBibliotecario(App.getBibliotecario());
            controller.setBiblioteca(App.getBiblioteca());

            Stage stage = new Stage();
            stage.setTitle("Panel de Bibliotecario - Biblioteca UQ");
            stage.setScene(scene);
            stage.setMinWidth(1000);
            stage.setMinHeight(700);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
            mostrarError("Error al abrir panel de bibliotecario: " + e.getMessage());
        }
    }


    private void abrirVentanaConsulta() {
        try {
            FXMLLoader loader = new FXMLLoader();
            // Modifica la ruta para que coincida con la estructura del proyecto
            loader.setLocation(App.class.getResource("/co/edu/uniquindio/poo/proyectofinal/ConsultaView.fxml"));
            Scene scene = new Scene(loader.load());
            // Comenta temporalmente la línea de estilos
            // scene.getStylesheets().add(getClass().getResource("/css/styles.css").toExternalForm());

            ConsultaController controller = loader.getController();
            controller.setBiblioteca(App.getBiblioteca());

            Stage stage = new Stage();
            stage.setTitle("Consulta Pública - Biblioteca UQ");
            stage.setScene(scene);
            stage.setMinWidth(800);
            stage.setMinHeight(600);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace(); // Agrega esto para ver el error completo
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

    public void setApp(App app) {
        this.app = app;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public void setBibliotecario(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }
}