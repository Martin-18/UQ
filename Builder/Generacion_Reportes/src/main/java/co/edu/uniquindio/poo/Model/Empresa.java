package co.edu.uniquindio.poo.Model;

import java.util.ArrayList;
import java.util.List;

public class Empresa {

    private String nombre;
    private int nit;
    private List<Reporte> listReportes;


    public Empresa(String nombre, int nit, List<Reporte> listReportes){
        this.nombre = nombre;
        this.nit = nit;
        this.listReportes = new ArrayList<>();
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

    public List getListReportes(){
        return listReportes;
    }

    public void setListReportes(List<Reporte> listReportes){
        this.listReportes = listReportes;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "nombre='" + nombre + '\'' +
                ", nit=" + nit +
                ", listReportes=" + listReportes +
                '}';
    }
}
