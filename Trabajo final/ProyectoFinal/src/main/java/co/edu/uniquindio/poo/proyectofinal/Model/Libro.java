package co.edu.uniquindio.poo.proyectofinal.Model;

public class Libro {
    private String titulo;
    private String autor;
    private String genero;
    private int anio;
    private boolean prestado;

    /**
     * metodo costructor de la clase Libro
     * @param titulo
     * @param autor
     * @param genero
     * @param anio
     * @param prestado
     */

    public Libro(String titulo, String autor, String genero, int anio, boolean prestado) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.anio = anio;
        this.prestado = prestado;
    }

    /**
     * Metodo para validar el titulo
     * @param titulo
     */

    public void validarTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("El título no puede estar vacío");
        }
    }

    /**
     * Metodo para validar el año de publicacion
     * @param anio
     */

    public void validarAnioPublicacion(int anio) {
        int anioActual = 2024;
        int anioMinimo = 1450;

        if (anio < anioMinimo || anio > anioActual) {
            throw new IllegalArgumentException("El año debe estar entre " + anioMinimo + " y " + anioActual);
        }
    }

    /**
     * Metodo para validar el id
     * @param id
     */

    public void validarRangoId(int id) {
        int idMinimo = 1;
        int idMaximo = 9999;

        if (id < idMinimo || id > idMaximo) {
            throw new IllegalArgumentException("El ID debe estar entre " + idMinimo + " y " + idMaximo);
        }
    }

    /**
     * Metodo para obtener el titulo
     * @return
     */

    public String getTitulo() {
        return titulo;
    }

    /**
     * Metodo para cambiar el titulo
     * @param titulo
     */

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Metodo para obtener el Autor
     * @return
     */

    public String getAutor() {
        return autor;
    }

    /**
     * Metodo para cambiar el Autor
     * @param autor
     */

    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Metodo para obtener el Genero
     * @return
     */

    public String getGenero() {
        return genero;
    }

    /**
     * Metodo para cambiar el genero
     * @param genero
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Metodo para obtener el año
     * @return
     */

    public int getAnio() {
        return anio;
    }

    /**
     * Metodo para cambiar el año
     * @param anio
     */

    public void setAnio(int anio) {
        this.anio = anio;
    }

    /**
     * Metodo para obtener el prestamo
     * @return
     */

    public boolean isPrestado() {
        return prestado;
    }

    /**
     * Metodo para cambiar el prestamo
     * @param prestado
     */
    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    /**
     * metodo para mostrar la informacion de la clase Libro
     * @return
     */

    @Override
    public String toString() {
        return "Libro{" +
                "Titulo='" + titulo + '\'' +
                ", Autor='" + autor + '\'' +
                ", Genero='" + genero + '\'' +
                ", anio=" + anio +
                ", Prestado=" + prestado +
                '}';
    }
}
