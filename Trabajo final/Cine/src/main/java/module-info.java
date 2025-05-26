module co.edu.uniquindio.poo.cine {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.poo.cine to javafx.fxml;
    exports co.edu.uniquindio.poo.cine;
}