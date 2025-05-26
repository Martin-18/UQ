package co.edu.uniquindio.poo.proyectofinal.Model;

import java.util.List;

public class Usuario {
        private String nombre;
        private int id;
        private List<Libro> librosPrestados;
        private int limitePrestamos;
        private int diasMaximoPrestamo;

    /**
     * metodo constructor de la clase usuario
     * @param nombre
     * @param id
     */

    public Usuario(String nombre, int id, List<Libro> librosPrestados, int limitePrestamos, int diasMaximoPrestamo) {
        this.nombre = nombre;
        this.id = id;
        this.librosPrestados = librosPrestados;
        this.limitePrestamos = limitePrestamos;
        this.diasMaximoPrestamo = diasMaximoPrestamo;
    }

    /**
     * Metodo para validar el nombre
     * @param nombre
    */

    public void validarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
    }

    /**
     * metodo para verificar si el usuario puede solicitar más préstamo
     * @return
     */

    public boolean puedePrestarMas() {
        if (librosPrestados == null) {
            return true;
        }
        return librosPrestados.size() < limitePrestamos;
    }

    /**
     * metodo para agregar un libro a la lista de prestados
     * @param libro
     */

    public void agregarLibroPrestado(Libro libro) {
        if (libro != null && puedePrestarMas()) {
            librosPrestados.add(libro);
            libro.setPrestado(true);
        }
    }

    /**
     * metodo para devolver un libro
     * @param libro
     * @return
     */

    public boolean devolverLibro(Libro libro) {
        if (librosPrestados != null && libro != null) {
            for (int i = 0; i < librosPrestados.size(); i++) {
                if (librosPrestados.get(i).getTitulo().equals(libro.getTitulo())) {
                    librosPrestados.remove(i);
                    libro.setPrestado(false);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * metodo para contar libros prestados actualmente
     * @return
     */

    public int contarLibrosPrestados() {
        return librosPrestados.size();
    }

    /**
     * Metodo para obtener los titulos de los libros prestados
     * @return
     */

    public String[] getTitulosPrestados() {
        if (librosPrestados == null) {
            return new String[0];
        }

        String[] titulos = new String[librosPrestados.size()];
        for (int i = 0; i < librosPrestados.size(); i++) {
            titulos[i] = librosPrestados.get(i).getTitulo();
        }
        return titulos;
    }

    /**
     * Metodo para obtener el nombre
     * @return
     */

    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo para cambiar el nombre
     * @param nombre
     */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo para obtener el id
     * @return
     */

    public int getId() {
        return id;
    }

    /**
     * Metodo para cambiar el id
     * @param id
     */

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Metodo para obtener los libros prestados
    * @return
    */

    public List<Libro> getLibrosPrestados() {
        return librosPrestados;
    }

    /**
     * Metodo para cambiar los libros prestados
    * @param librosPrestados
     */

    public void setLibrosPrestados(List<Libro> librosPrestados) {
        this.librosPrestados = librosPrestados;
    }

    /**
     * Metodo para obtener el limite de prestamos
     * @return
     */

    public int getLimitePrestamos() {
        return limitePrestamos;
    }

    /**
    * Metodo para cambiar el limite de prestamos
     * @param limitePrestamos
    */

    public void setLimitePrestamos(int limitePrestamos) {
        this.limitePrestamos = limitePrestamos;
    }

    /**
     * Metodo para obtener el dias maximo de prestamo
     * @return
     */

    public int getDiasMaximoPrestamo() {
        return diasMaximoPrestamo;
    }

    /**
     * Metodo para cambiar el dias maximo de prestamo
    * @param diasMaximoPrestamo
    */

    public void setDiasMaximoPrestamo(int diasMaximoPrestamo) {
        this.diasMaximoPrestamo = diasMaximoPrestamo;
    }

    /**
     * metodo para mostrar la informacion de la clase usuario
     * @return
     */

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                ", librosPrestados=" + librosPrestados +
                ", limitePrestamos=" + limitePrestamos +
                ", diasMaximoPrestamo=" + diasMaximoPrestamo +
                '}';
    }
}
