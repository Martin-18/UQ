package co.edu.uniquindio.poo.Model;

import java.util.List;

public class Universidad {

    private String nombre;
    private int nit;
    private List<Evento> listEventos;

    public Universidad(String nombre, int nit, List<Evento> listEventos){
        this.nombre = nombre;
        this.nit = nit;
        this.listEventos = listEventos;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public int getNit(){
        return nit;
    }

    public void setNit(int nit){
        this.nit = nit;
    }

    public List<Evento> getListEventos(){
        return listEventos;
    }

    public void setListEventos(List<Evento> listEventos){
        this.listEventos = listEventos;
    }

    @Override
    public String toString() {
        return "Universidad{" +
                "nombre='" + nombre + '\'' +
                ", nit=" + nit +
                ", listEventos=" + listEventos +
                '}';
    }
}
