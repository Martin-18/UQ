package co.edu.uniquindio.poo;

import co.edu.uniquindio.poo.Model.Reporte;
import co.edu.uniquindio.poo.Model.ReporteFinanciero;

public class Main {


    public static void main(String[] args) {

        Reporte reporte1 = new Reporte.Builder()
                .titulo("El equipo")
                .autor("yo")
                .grafico("Melos")
                .tablaDatos("Ganamos")
                .resumen("Goleada")
                .firma("El inge")
                .logo("Java fc")
                .build();

        System.out.println(reporte1);

        ReporteFinanciero finaciero = new ReporteFinanciero.Builder()
                .titulo("Uq")
                .autor("Yo")
                .grafico("Melos")
                .tablaDatos("Vacia")
                .resumen("Estubvo bueno")
                .firma("El inge")
                .build();

        System.out.println(finaciero);
    }
}