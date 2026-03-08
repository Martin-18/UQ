package co.edu.uniquindio.poo.Model;

import java.util.ArrayList;
import java.util.List;

public class Aeropuerto {

    private String nombre;
    private String lugar;
    private List<Avion> listAviones;

    public Aeropuerto(String nombre, String lugar){
        this.nombre = nombre;
        this.lugar = lugar;
        this.listAviones = new ArrayList<>();
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getLugar(){
        return lugar;
    }

    public void setLugar(String lugar){
        this.lugar = lugar;
    }

    public List<Avion> getListAviones(){
        return listAviones;
    }

    public void setListAviones(List<Avion> listAviones){
        this.listAviones = listAviones;
    }

}
