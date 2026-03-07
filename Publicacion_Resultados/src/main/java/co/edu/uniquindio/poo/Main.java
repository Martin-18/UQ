package co.edu.uniquindio.poo;

import co.edu.uniquindio.poo.Model.*;

public class Main {


    public static void main(String[] args) {

        Universidad u = new Universidad("UQ", 1212);

        INotificable notificacionPersonal = Notificacion.getInstance();
        Taller taller = new Taller(notificacionPersonal);
        Parcial parcial = new Parcial(notificacionPersonal);
        proyectoFinal proyectofinal = new proyectoFinal(notificacionPersonal);

        taller.notificarTaller("20/20/50", 5);
        parcial.notificarParcial("diferencial", 4);
        proyectofinal.notificarProyectoFinal("diferencial", "4767r4");

    }
}