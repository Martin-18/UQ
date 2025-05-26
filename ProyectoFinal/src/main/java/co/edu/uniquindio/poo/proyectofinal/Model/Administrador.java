package co.edu.uniquindio.poo.proyectofinal.Model;

import java.util.ArrayList;
import java.util.List;

public class Administrador {
    private String nombre;
    private int id;
    private List<Bibliotecario> empleados;
    private List<String> credenciales;

    /**
     * metodo constructor de la clase usuario
     * @param nombre
     * @param id
     */

    public Administrador(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
        this.empleados = new ArrayList<>();
        this.credenciales = new ArrayList<>();
    }

    /**
     * Metodo para registrar empleados
     * @param bibliotecario
     */

    public void registrarEmpleado(Bibliotecario bibliotecario) {
            empleados.add(bibliotecario);
    }

    /**
     * Metodo para eliminar empleados
     * @param bibliotecario
     */

    public void eliminarEmpleado(Bibliotecario bibliotecario) {
            empleados.remove(bibliotecario);
    }

    /**
     * Método para agregar credenciales de acceso
     * @param usuario
     * @param contrasenia
     * @return
     */

    public boolean agregarCredencial(String usuario, String contrasenia) {
        if (usuario != null && contrasenia != null && !usuario.trim().isEmpty() && !contrasenia.trim().isEmpty()) {
            String credencial = usuario + ":" + contrasenia;
            credenciales.add(credencial);
            return true;
        }
        return false;
    }

    /**
     * Método para validar credenciales de acceso
     * @param usuario
     * @param contrasenia
     * @return
     */

    public boolean validarCredenciales(String usuario, String contrasenia) {
        String credencialBuscada = usuario + ":" + contrasenia;

        for(int i = 0; i < credenciales.size(); i++) {
            if (credenciales.get(i).equals(credencialBuscada)) {
                return true;
            }
        }
        return false;
    }


    /**
     * Método para generar reporte de uso del sistema
     * @param biblioteca
     * @return
     */

    public String generarReporteUsoSistema(Biblioteca biblioteca) {
        int totalEmpleados = empleados.size();
        int totalCredenciales = credenciales.size();
        int porcentajeUso = 0;

        if (biblioteca.getLibros().size() > 0) {
            int librosPrestados = 0;
            for (int i = 0; i < biblioteca.getLibros().size(); i++) {
                if (biblioteca.getLibros().get(i).isPrestado()) {
                    librosPrestados++;
                }
            }
            porcentajeUso = (librosPrestados * 100) / biblioteca.getLibros().size();
        }

        return "=== REPORTE DE USO DEL SISTEMA ===\n" +
                "Empleados registrados: " + totalEmpleados + "\n" +
                "Credenciales activas: " + totalCredenciales + "\n" +
                "Porcentaje de uso de libros: " + porcentajeUso + "%\n" +
                "Fecha del reporte: " + java.time.LocalDate.now();
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
     * Metodo para obtener los empleados
     * @return
     */

    public List<Bibliotecario> getEmpleados() {
        return empleados;
    }

    /**
     * Metodo para cambiar los empleados
     * @param empleados
     */

    public void setEmpleados(List<Bibliotecario> empleados) {
        this.empleados = empleados;
    }

    /**
    * Metodo para obtener las credenciales
     * @return
    */

    public List<String> getCredenciales() {
        return credenciales;
    }
    /**
     * Metodo para cambiar las credenciales
     * @param credenciales
     */

    public void setCredenciales(List<String> credenciales) {
        this.credenciales = credenciales;
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
                '}';
    }
}

