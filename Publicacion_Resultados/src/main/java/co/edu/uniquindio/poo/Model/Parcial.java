package co.edu.uniquindio.poo.Model;

import java.util.ArrayList;
import java.util.List;

public class Parcial {

    private String materia;
    private String fecha;
    private Universidad universidad;
    private List<Parcial> parciales;
    private final INotificable notificacion;

    public Parcial(INotificable notificacion) {
        this.notificacion = notificacion;
    }

    public Parcial(String materia, String fecha, Universidad universidad,  List<Parcial> parciales, INotificable notificacion) {
        this.materia = materia;
        this.fecha = fecha;
        this.universidad = universidad;
        this.parciales = parciales;
        this.notificacion = notificacion;
    }

    public String getMateria(){
        return materia;
    }

    public void setMateria(String materia){
        this.materia = materia;
    }

    public String getFecha(){
        return fecha;
    }

    public void setFecha(String fecha){
        this.fecha = fecha;
    }

    public Universidad getUniversidad(){
        return universidad;
    }

    public void setUniversidad(Universidad universidad){
        this.universidad = universidad;
    }

    public List<Parcial> getParciales(){
        return parciales;
    }

    public void setParciales(List<Parcial> parciales){
        this.parciales = parciales;
    }

    public void notificarParcial(String materia, double nota){
        notificacion.notificar("La materia es " + materia + " y la nota es " + nota);
    }

    @Override
    public String toString() {
        return "Parcial{" +
                "materia='" + materia + '\'' +
                ", fecha='" + fecha + '\'' +
                ", universidad=" + universidad +
                ", parciales=" + parciales +
                '}';
    }
}