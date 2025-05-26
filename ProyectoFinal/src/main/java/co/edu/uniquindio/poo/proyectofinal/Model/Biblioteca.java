package co.edu.uniquindio.poo.proyectofinal.Model;

import java.util.List;
import java.util.ArrayList;

public class Biblioteca {
    private String nombre;
    private int codigo;
    private List<Libro> libros;
    private List<Usuario> usuarios;
    private List<Prestamo> prestamos;

    /**
     * Metodo contructor de la clase Biblioteca
     * @param nombre
     * @param codigo
     */

    public Biblioteca(String nombre, int codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.libros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.prestamos = new ArrayList<>();
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
     * Metodo para obtener el codigo
     * @return
     */

    public int getCodigo() {
        return codigo;
    }

    /**
     * Metodo para cambiar el codigo
     * @param codigo
     */

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Metodo para obtener los libros
     * @return
     */

    public List<Libro> getLibros() {
        return libros;
    }

    /**
     * Metodo para cambiar los libros
     * @param libros
     */

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    /**
     * Metodo para obtener los usuarios
     * @return
     */

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * Metodo para cambiar los usuarios
     * @param usuarios
     */

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    /**
     * Metodo para obtener los prestamos
    * @return
     */

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    /**
     * Metodo para cambiar los prestamos
     * @param prestamos
     */

    public void setPrestamos(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    /**
     * Metodo para mostrar la informacion de la clase Biblioteca
     * @return
     */

    @Override
    public String toString() {
        return "Biblioteca{" +
                "nombre='" + nombre + '\'' +
                ", codigo=" + codigo +
                ", libros=" + libros +
                ", usuarios=" + usuarios +
                ", prestamos=" + prestamos +
                '}';
    }
}
