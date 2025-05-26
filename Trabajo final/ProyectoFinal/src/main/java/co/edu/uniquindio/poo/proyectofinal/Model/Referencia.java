package co.edu.uniquindio.poo.proyectofinal.Model;

public class Referencia extends Libro {
    private String seccion;

    /**
     * Constructor de la clase Referencia
     * @param titulo
     * @param autor
     * @param genero
     * @param anio
     * @param seccion
     */

    public Referencia(String titulo, String autor, String genero, int anio, String seccion) {
        super(titulo, autor, genero, anio, false);
        this.seccion = seccion;
    }

    /**
     * Metodo para obtener la seccion
     * @return
     */

    public String getSeccion() {
        return seccion;
    }
    /**
 * Metodo para cambiar la seccion
 * @param seccion
 */

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }
/**
 * Metodo para mostrar la informacion de la clase Referencia
 * @return
 */

    @Override
    public void setPrestado(boolean prestado) {
        if (prestado) {
            throw new IllegalArgumentException("Los libros de referencia no pueden prestarse");
        }
    }
}