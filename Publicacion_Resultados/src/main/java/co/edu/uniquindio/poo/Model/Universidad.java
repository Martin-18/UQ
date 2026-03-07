package co.edu.uniquindio.poo.Model;

import java.util.ArrayList;
import java.util.List;

public class Universidad {

    private String nombre;
    private int nit;
    private List<Parcial> listParciales;
    private List<Taller> listTalleres;
    private List<proyectoFinal> listProyectosFinales;
    private Parcial parcial;
    private Taller taller;
    private proyectoFinal proyectoFinal;

    public Universidad(String nombre, int nit){
        this.nombre = nombre;
        this.nit = nit;
        this.listParciales = new ArrayList<>();
        this.listTalleres = new ArrayList<>();
        this.listProyectosFinales = new ArrayList<>();
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

    public List<Parcial> getListParciales() {
        return listParciales;
    }

    public void setParciales(List<Parcial> parciales){
        this.listParciales = parciales;
    }

    public List<Taller> getListTalleres() {
        return listTalleres;
    }

    public void setListTalleres(List<Taller> listTalleres) {
        this.listTalleres = listTalleres;
    }

    public List<proyectoFinal> getListProyectosFinales() {
        return listProyectosFinales;
    }

    public void setListProyectosFinales(List<proyectoFinal> listProyectosFinales) {
        this.listProyectosFinales = listProyectosFinales;
    }

    public Parcial getParcial() {
        return parcial;
    }

    public void setParcial(Parcial parcial) {
        this.parcial = parcial;
    }

    public Taller getTaller() {
        return taller;
    }

    public void setTaller(Taller taller) {
        this.taller = taller;
    }

    public proyectoFinal getProyectoFinal() {
        return proyectoFinal;
    }

    public void setProyectoFinal(proyectoFinal proyectoFinal) {
        this.proyectoFinal = proyectoFinal;
    }

    @Override
    public String toString() {
        return "Universidad{" +
                "nombre='" + nombre + '\'' +
                ", nit=" + nit +
                ", listParciales=" + listParciales +
                ", listtalleres=" + listTalleres +
                ", listProyectosFinales=" + listProyectosFinales +
                ", parcial=" + parcial +
                ", taller=" + taller +
                ", proyectoFinal=" + proyectoFinal +
                '}';
    }
}
