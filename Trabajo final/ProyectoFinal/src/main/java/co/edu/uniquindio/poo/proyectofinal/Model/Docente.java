package co.edu.uniquindio.poo.proyectofinal.Model;

import java.util.List;

public class Docente extends Usuario{

    /**
     * metodo constructor de la clase Docente
     * @param nombre
     * @param id
     */

    public Docente(String nombre, int id, List<Libro> librosPrestados, int limitePrestamos, int diasMaximoPrestamo) {
        super(nombre, id, librosPrestados, limitePrestamos, diasMaximoPrestamo);
    }

    /**
     * metodo para obtener la informacion del docente
     * @return
     */

    public String getInformacionDocente() {
        return "Docente: " + getNombre() +
                " - Libros prestados: " + contarLibrosPrestados() +
                "/" + getLimitePrestamos() +
                " - Días máximo: " + getDiasMaximoPrestamo();
    }
}
