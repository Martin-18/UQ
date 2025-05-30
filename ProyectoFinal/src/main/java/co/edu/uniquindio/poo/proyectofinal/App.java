package co.edu.uniquindio.poo.proyectofinal;

import co.edu.uniquindio.poo.proyectofinal.Controller.AdministradorController;
import co.edu.uniquindio.poo.proyectofinal.Controller.LoginController;
import co.edu.uniquindio.poo.proyectofinal.Model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.ArrayList;

import java.io.IOException;

public class App extends Application {

    private static Biblioteca biblioteca;
    private static Administrador administrador;
    private static Bibliotecario bibliotecario;
    private Stage primaryStage;



    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Sistema de Gestión Biblioteca UQ");

        try {
            Image icon = new Image(getClass().getResourceAsStream("/co/edu/uniquindio/poo/proyectofinal/images/logo.png"));
            this.primaryStage.getIcons().add(icon);
        } catch (Exception e) {
            System.err.println("Error al cargar el ícono de la aplicación: " + e.getMessage());
        }

        openViewPrincipal();
    }


    private void inicializarData() {
        biblioteca = new Biblioteca("Biblioteca UQ", 1001);

        administrador = new Administrador("Juan Pérez", 100);
        administrador.agregarCredencial("admin", "1234");
        administrador.agregarCredencial("root", "admin");

        bibliotecario = new Bibliotecario("María González", 200);
        administrador.registrarEmpleado(bibliotecario);

        cargarDatosEjemplo();
    }

    private void cargarDatosEjemplo() {
        Fisico libro1 = new Fisico(300, "Planeta", "Estante A1",
                "Cien Años de Soledad", "Gabriel García Márquez",
                "Realismo Mágico", 1967, false);

        Fisico libro2 = new Fisico(250, "Alfaguara", "Estante B2",
                "El Principito", "Antoine de Saint-Exupéry",
                "Infantil", 1943, false);

        Fisico libro3 = new Fisico(400, "Editorial Sudamericana", "Estante C3",
                "Rayuela", "Julio Cortázar",
                "Literatura Contemporánea", 1963, false);

        Digital libro4 = new Digital("https://ejemplo.com/don-quijote.pdf",
                "Don Quijote de la Mancha", "Miguel de Cervantes",
                "Clásico", 1605, false, Formato.PDF);

        Digital libro5 = new Digital("https://ejemplo.com/1984.epub",
                "1984", "George Orwell",
                "Distopía", 1949, false, Formato.EPUB);

        Digital libro6 = new Digital("https://ejemplo.com/fundacion.mobi",
                "Fundación", "Isaac Asimov",
                "Ciencia Ficción", 1951, false, Formato.MOBI);

        Referencia libro7 = new Referencia("Enciclopedia Británica Vol. 1", "Varios Autores",
                "Referencia", 2020, "Sección Consulta A");

        Referencia libro8 = new Referencia("Manual de Programación Java", "Oracle Corporation",
                "Técnico", 2023, "Sección Informática");

        biblioteca.getLibros().add(libro1);
        biblioteca.getLibros().add(libro2);
        biblioteca.getLibros().add(libro3);
        biblioteca.getLibros().add(libro4);
        biblioteca.getLibros().add(libro5);
        biblioteca.getLibros().add(libro6);
        biblioteca.getLibros().add(libro7);
        biblioteca.getLibros().add(libro8);

        bibliotecario.agregarLibro(libro1);
        bibliotecario.agregarLibro(libro2);
        bibliotecario.agregarLibro(libro3);
        bibliotecario.agregarLibro(libro4);
        bibliotecario.agregarLibro(libro5);
        bibliotecario.agregarLibro(libro6);
        bibliotecario.agregarLibro(libro7);
        bibliotecario.agregarLibro(libro8);

        Estudiante estudiante1 = new Estudiante("Ana López", 1001, new ArrayList<>(), 3, 15);
        Estudiante estudiante2 = new Estudiante("Carlos Ruiz", 1002, new ArrayList<>(), 3, 15);
        Estudiante estudiante3 = new Estudiante("Sofia Herrera", 1003, new ArrayList<>(), 3, 15);

        Docente docente1 = new Docente("Dr. Roberto Silva", 2001, new ArrayList<>(), 5, 30);
        Docente docente2 = new Docente("Dra. Carmen Vega", 2002, new ArrayList<>(), 5, 30);

        Visitante visitante1 = new Visitante("Laura Martín", 3001, new ArrayList<>(), 0, 0);
        Visitante visitante2 = new Visitante("Pedro Jiménez", 3002, new ArrayList<>(), 0, 0);

        biblioteca.getUsuarios().add(estudiante1);
        biblioteca.getUsuarios().add(estudiante2);
        biblioteca.getUsuarios().add(estudiante3);
        biblioteca.getUsuarios().add(docente1);
        biblioteca.getUsuarios().add(docente2);
        biblioteca.getUsuarios().add(visitante1);
        biblioteca.getUsuarios().add(visitante2);

        bibliotecario.agregarUsuario(estudiante1);
        bibliotecario.agregarUsuario(estudiante2);
        bibliotecario.agregarUsuario(estudiante3);
        bibliotecario.agregarUsuario(docente1);
        bibliotecario.agregarUsuario(docente2);
        bibliotecario.agregarUsuario(visitante1);
        bibliotecario.agregarUsuario(visitante2);

        bibliotecario.realizarPrestamo(1001, "El Principito");
        bibliotecario.realizarPrestamo(2001, "1984");
        bibliotecario.realizarPrestamo(1002, "Cien Años de Soledad");
    }

    private void openViewPrincipal() {
        inicializarData();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/co/edu/uniquindio/poo/proyectofinal/LoginView.fxml"));
            Scene scene = new Scene(loader.load());
            LoginController loginController = loader.getController();
            loginController.setApp(this);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void abrirVistaAdministrador() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/co/edu/uniquindio/poo/proyectofinal/AdministradorView.fxml"));
            Scene scene = new Scene(loader.load());

            AdministradorController controller = loader.getController();
            controller.setAdministrador(administrador);
            controller.setBiblioteca(biblioteca);

            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public static Administrador getAdministrador() {
        return administrador;
    }

    public static Bibliotecario getBibliotecario() {
        return bibliotecario;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch();
    }
}