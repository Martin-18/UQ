module co.edu.uniquindio.poo.proyectofinal {
    requires javafx.controls;
    requires javafx.fxml;

    opens co.edu.uniquindio.poo.proyectofinal to javafx.fxml;
    opens co.edu.uniquindio.poo.proyectofinal.Controller to javafx.fxml;
    opens co.edu.uniquindio.poo.proyectofinal.Model to javafx.fxml;

    exports co.edu.uniquindio.poo.proyectofinal;
    exports co.edu.uniquindio.poo.proyectofinal.Controller;
    exports co.edu.uniquindio.poo.proyectofinal.Model;
}