package co.edu.uniquindio.poo.proyectofinal.Model;

import java.time.LocalDate;

public class Prestamo {
    private Usuario usuario;
    private Libro libro;
    private LocalDate fechaPrestamo;
    private LocalDate fechaVencimiento;
    private boolean activo;

    /**
     * metodo constructor de la clase Prestamo
     * @param usuario
     * @param libro
     * @param fechaPrestamo
     * @param fechaVencimiento
     * @param activo
     */

    public Prestamo(Usuario usuario, Libro libro, LocalDate fechaPrestamo, LocalDate fechaVencimiento, boolean activo) {
    this.usuario = usuario;
    this.libro = libro;
    this.fechaPrestamo = fechaPrestamo;
    this.fechaVencimiento = fechaVencimiento;
    this.activo = activo;
    }

    /**
    * Metodo para mostrar la informacion de la clase Prestamo
     * @return
     */

    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Metodo para cambiar el usuario
     * @param usuario
    */

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
    * Metodo para obtener el libro
    * @return
     */

    public Libro getLibro() {
        return libro;
    }

    /**
     * Metodo para cambiar el libro
     * @param libro
     */

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    /**
    * Metodo para obtener la fecha de prestamo
    * @return
    */

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    /**
     * Metodo para cambiar la fecha de prestamo
    * @param fechaPrestamo
    */

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    /**
    * Metodo para obtener la fecha de vencimiento
    * @return
    */

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    /**
     * Metodo para cambiar la fecha de vencimiento
     * @param fechaVencimiento
    */

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    /**
     * Metodo para obtener el estado del prestamo
    * @return
    */

    public boolean isActivo() {
        return activo;
    }

    /**
     * Metodo para cambiar el estado del prestamo
     * @param activo
    */

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    /**
     * Metodo para mostrar la informacion de la clase
    * @return
     */

    @Override
    public String toString() {
        return "Prestamo{" +
                "usuario=" + usuario +
                ", libro=" + libro +
                ", fechaPrestamo=" + fechaPrestamo +
                ", fechaVencimiento=" + fechaVencimiento +
                ", activo=" + activo +
                '}';
    }
}