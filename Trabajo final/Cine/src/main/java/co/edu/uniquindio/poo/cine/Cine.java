package co.edu.uniquindio.poo.cine;

public class Cine {
    private String nombre;
    private int NIT;

    public Cine(String nombre, int NIT) {
        this.nombre = nombre;
        this.NIT = NIT;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNIT() {
        return NIT;
    }

    public void setNIT(int NIT) {
        this.NIT = NIT;
    }

    @Override
    public String toString() {
        return "Cine{" +
                "nombre='" + nombre + '\'' +
                ", NIT=" + NIT +
                '}';
    }
}
