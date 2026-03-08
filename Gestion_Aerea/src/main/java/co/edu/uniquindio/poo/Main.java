package co.edu.uniquindio.poo;

import co.edu.uniquindio.poo.Model.Avion;
import co.edu.uniquindio.poo.Model.INotificacion;
import co.edu.uniquindio.poo.Model.Notificacion;

public class Main {
    public static void main(String[] args) {


        INotificacion notificacion = Notificacion.getInstance();
        Avion avion = new Avion("Embraer", 1234, notificacion);

        avion.notificacionAvion(avion.getAerolinea(), avion.getNumero());
    }

}