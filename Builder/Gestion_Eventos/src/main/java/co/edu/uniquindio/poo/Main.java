package co.edu.uniquindio.poo;

import co.edu.uniquindio.poo.Model.Congreso;
import co.edu.uniquindio.poo.Model.Evento;
import co.edu.uniquindio.poo.Model.Modalidad;

public class Main {
    public static void main(String[] args) {

        Evento evento1 = new Evento.Builder()
                .nombre("El despeluque")
                .fecha("hoy")
                .certificadoDigital("fesdcd")
                .stream("obvio")
                .traduccion("ingles")
                .refigerio("salchipapa")
                .capacidadMaxima(600)
                .patrocinadores("EL inge")
                .build();

        System.out.println("Evento: " + evento1);

        Congreso congreso1 = new Congreso.Builder()
                .nombre("Los inges")
                .fecha("Hoy")
                .certificadoDigital("Sí")
                .stream("Zoom")
                .traduccion("Español")
                .refigerio("Café")
                .capacidadMaxima(100)
                .patrocinadores("EmpresaX")
                .modalidad(Modalidad.PRESENCIAL)
                .build();

        System.out.println("Congreso: " + congreso1);
    }
}