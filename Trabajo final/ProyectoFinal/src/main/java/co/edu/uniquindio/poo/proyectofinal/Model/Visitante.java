package co.edu.uniquindio.poo.proyectofinal.Model;

import java.util.List;

public class Visitante extends Usuario {

    /**
     * metodo constructor de la clase Visitante
     * @param nombre
     * @param id
     */

    public Visitante(String nombre, int id, List<Libro> librosPrestados, int limitePrestamos, int diasMaximoPrestamo) {
        super(nombre, id, librosPrestados, limitePrestamos, diasMaximoPrestamo);
    }

    /**
     * metodo para verificar si puede prestar libros
     * @return
     */

    @Override
    public boolean puedePrestarMas() {
        return false;
    }

    /**
     * metodo para verificar si puede consultar libros
     * @return
     */

    public boolean puedeConsultarEnBiblioteca() {
        return true;
    }
}
