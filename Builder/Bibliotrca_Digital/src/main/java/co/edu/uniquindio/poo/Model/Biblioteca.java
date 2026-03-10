package co.edu.uniquindio.poo.Model;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private String nombre;
    private int numeroLibros;
    private List<Libro> listLibros;

    public Biblioteca(String nombre, int numeroLibros, List<Libro> listLibros){
        this.nombre = nombre;
        this.numeroLibros = numeroLibros;
        this.listLibros = new ArrayList<>();
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public int getNumeroLibros(){
        return numeroLibros;
    }

    public void setNumeroLibros(int numeroLibros){
        this.numeroLibros = numeroLibros;
    }

    public List getListLibros(){
        return listLibros;
    }

    public void setListLibros(List<Libro> listLibros){
        this.listLibros = listLibros;
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "nombre='" + nombre + '\'' +
                ", numeroHojas=" + numeroLibros +
                ", listLibros=" + listLibros +
                '}';
    }
}
