package co.edu.uniquindio.poo.Model;

import java.util.List;

public class proyectoFinal {

    private String materia;
    private String fecha;
    private Universidad universidad;
    private List<proyectoFinal> proyectos;
    private final INotificable notificacion;

    public proyectoFinal(INotificable notificacion) {
        this.notificacion = notificacion;
    }

    public proyectoFinal(String materia, String fecha, Universidad universidad, List<proyectoFinal> proyectos, INotificable notificacion){
        this.materia = materia;
        this.fecha = fecha;
        this.universidad = universidad;
        this.proyectos = proyectos;
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

    public List<proyectoFinal> getProyectos(){
        return proyectos;
    }

    public void setProyectos(List<proyectoFinal> proyectos){
        this.proyectos = proyectos;
    }

    public void notificarProyectoFinal(String materia, String fecha){
        notificacion.notificar("La fecha del proyecto era " + fecha + " y la materia es " + materia);
    }

    @Override
    public String toString() {
        return "proyectoFinal{" +
                "materia='" + materia + '\'' +
                ", fecha='" + fecha + '\'' +
                ", universidad=" + universidad +
                ", proyectos=" + proyectos +
                '}';
    }
}