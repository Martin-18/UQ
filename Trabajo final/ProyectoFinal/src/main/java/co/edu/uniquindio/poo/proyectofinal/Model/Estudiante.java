package co.edu.uniquindio.poo.proyectofinal.Model;

import java.util.List;

public class Estudiante extends Usuario {

    /**
     * metodo constructor de la clase Estudiante
     * @param nombre
     * @param id
     */

    public Estudiante(String nombre, int id, List<Libro> librosPrestados, int limitePrestamos, int diasMaximoPrestamo){
        super(nombre, id, librosPrestados, limitePrestamos, diasMaximoPrestamo);
    }

    /**
     * metodo para obtener la informacion del estudiante
     * @return
     */

    public String getInformacionEstudiante() {
        return "Estudiante: " + getNombre() +
                " - Libros prestados: " + contarLibrosPrestados() +
                "/" + getLimitePrestamos();
    }
}
