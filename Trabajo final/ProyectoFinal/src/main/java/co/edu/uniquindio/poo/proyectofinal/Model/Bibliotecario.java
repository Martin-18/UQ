package co.edu.uniquindio.poo.proyectofinal.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Bibliotecario {
    private String nombre;
    private int id;
    private List<Libro> libros;
    private List<Usuario> usuarios;
    private List<Prestamo> prestamos;

    public Bibliotecario(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
        this.libros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }

    /**
     * Método para generar estadísticas de préstamos por biblioteca
     * @param biblioteca
     * @return
     */

    public String generarEstadisticasPrestamos(Biblioteca biblioteca) {
        int totalLibros = biblioteca.getLibros().size();
        int librosPrestados = 0;
        int usuariosActivos = 0;
        int prestamosActivos = 0;

        for (int i = 0; i < biblioteca.getLibros().size(); i++) {
            if (biblioteca.getLibros().get(i).isPrestado()) {
                librosPrestados++;
            }
        }

        for (int i = 0; i < biblioteca.getUsuarios().size(); i++) {
            if (biblioteca.getUsuarios().get(i).contarLibrosPrestados() > 0) {
                usuariosActivos++;
            }
        }

        for (int i = 0; i < biblioteca.getPrestamos().size(); i++) {
            if (biblioteca.getPrestamos().get(i).isActivo()) {
                prestamosActivos++;
            }
        }

        return "=== ESTADÍSTICAS DE LA BIBLIOTECA ===\n" +
                "Total de libros: " + totalLibros + "\n" +
                "Libros prestados: " + librosPrestados + "\n" +
                "Libros disponibles: " + (totalLibros - librosPrestados) + "\n" +
                "Usuarios activos: " + usuariosActivos + "\n" +
                "Préstamos activos: " + prestamosActivos + "\n" +
                "Total de usuarios: " + biblioteca.getUsuarios().size();
    }
    /**
     * Metodo para agregar un libro a la biblioteca
     * @param libro
     */

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    /**
     * Metodo para agregar un usuario a la biblioteca
     * @param usuario
     */

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    /**
     * Metodo para buscar un usuario
     * @param
     * @return
     */

    public Usuario buscarUsuarioPorId(int id) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == id) {
                return usuarios.get(i);
            }
        }
        return null;
    }

    /**
     * Metodo para buscar un libro por su titulo
     * @param
     * @return
     */

    public Libro buscarLibroPorTitulo(String titulo) {
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getTitulo().equals(titulo)) {
                return libros.get(i);
            }
        }
        return null;
    }

    /**
     * Metodo para obtener los prestamos de un usuario
     * @param
     * @return
     */

    public String[] obtenerPrestamosUsuario(int idUsuario) {
        Usuario usuario = buscarUsuarioPorId(idUsuario);
        if (usuario != null) {
            return usuario.getTitulosPrestados();
        }
        return new String[0];
    }

    /**
     * Metodo para realizar prestamos
     * @param idUsuario
     * @return
     */

    public boolean realizarPrestamo(int idUsuario, String tituloLibro) {
        Usuario usuario = buscarUsuarioPorId(idUsuario);
        Libro libro = buscarLibroPorTitulo(tituloLibro);

        if (usuario != null && libro != null && !libro.isPrestado() && usuario.puedePrestarMas()) {
            usuario.agregarLibroPrestado(libro);

            LocalDate fechaPrestamo = LocalDate.now();
            LocalDate fechaVencimiento = fechaPrestamo.plusDays(usuario.getDiasMaximoPrestamo());

            Prestamo prestamo = new Prestamo(usuario, libro, fechaPrestamo, fechaVencimiento, true);
            prestamos.add(prestamo);

            return true;
        }
        return false;
    }

    /**
     * Método para devolver un libro
     * @param idUsuario
     * @param tituloLibro
     * @return true si la devolución se realizó correctamente
     */

    public boolean devolverLibro(int idUsuario, String tituloLibro) {
        Usuario usuario = buscarUsuarioPorId(idUsuario);
        Libro libro = buscarLibroPorTitulo(tituloLibro);

        if (usuario != null && libro != null && libro.isPrestado()) {
            boolean devuelto = usuario.devolverLibro(libro);

            if (devuelto) {
                for(int i = 0; i < prestamos.size(); i++) {
                    Prestamo prestamo = prestamos.get(i);
                    if (prestamo.getUsuario().getId() == idUsuario &&
                            prestamo.getLibro().getTitulo().equals(tituloLibro) &&
                            prestamo.isActivo()) {
                        prestamo.setActivo(false);
                        break;
                    }
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Método para verificar si un libro está disponible
     * @param titulo
     * @return true si está disponible para préstamo
     */

    public boolean libroDisponible(String titulo) {
        Libro libro = buscarLibroPorTitulo(titulo);
        if (libro != null) {
            return !libro.isPrestado();
        }
        return false;
    }

    /**
     * Método para obtener todos los libros prestados
     * @return array con títulos de libros prestados
     */

    public String[] reporteLibrosPrestados() {
        String[] librosPrestados = new String[libros.size()];
        int contador = 0;

        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).isPrestado()) {
                librosPrestados[contador] = libros.get(i).getTitulo();
                contador++;
            }
        }

        String[] resultado = new String[contador];
        for (int i = 0; i < contador; i++) {
            resultado[i] = librosPrestados[i];
        }

        return resultado;
    }

    /**
     * Método para contar usuarios con préstamos activos
     * @return número de usuarios que tienen libros prestados
     */

    public int reporteUsuariosConPrestamos() {
        int contador = 0;

        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).contarLibrosPrestados() > 0) {
                contador++;
            }
        }

        return contador;
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
     * Metodo para mostrar la informacion de la clase Bibliotecario
     * @return
     */

    @Override
    public String toString() {
        return "Bibliotecario{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                ", libros=" + libros +
                ", usuarios=" + usuarios +
                ", prestamos=" + prestamos +
                '}';
    }
}
