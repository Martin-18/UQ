package co.edu.uniquindio.poo.proyectofinal.Model;

public class Fisico extends Libro {
    private int numeroPaginas;
    private String editorial;
    private String ubicacion;

    /**
     * Costructor de la clase Fisico
     * @param numeroPaginas
     * @param editorial
     * @param ubicacion
     */
    public Fisico(int numeroPaginas, String editorial, String ubicacion, String titulo, String autor, String genero, int anio, boolean prestado) {
        super(titulo, autor, genero, anio, prestado);
        this.numeroPaginas = numeroPaginas;
        this.editorial = editorial;
        this.ubicacion = ubicacion;
    }

    /**
     * Metodo para obtener el numeroPaginas
     * @return
     */
    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    /**
     * Metodo para cambiar el numeroPaginas
     * @param numeroPaginas
     */

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    /**
     * Metodo para obtener la ubicacion
     * @return
     */

    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * Metodo para cambiar la ubicacion
     * @param ubicacion
     */

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * Metodo para obtener la editorial
     * @return
     */

    public String getEditorial() {
        return editorial;
    }

    /**
     * Metodo para cambiar la editorial
     * @param editorial
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    /**
     * metodo para mostrar la informacion de la clase
     * @return
     */

    @Override
    public String toString() {
        return "Fisico{" +
                "numeroPaginas=" + numeroPaginas +
                ", Editorial='" + editorial + '\'' +
                ", Ubicacion='" + ubicacion + '\'' +
                '}';
    }
}
