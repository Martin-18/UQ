package co.edu.uniquindio.poo.Model;

import java.util.List;

public class Taller {

    private String fecha;
    private double nota;
    private Universidad universidad;
    private List<Taller> talleres;
    private final INotificable notificacion;

    public Taller(INotificable notificacion) {
        this.notificacion = notificacion;
    }

    public Taller(String fecha, double nota, Universidad universidad, List<Taller> talleres, INotificable notificacion) {
        this.fecha = fecha;
        this.nota = nota;
        this.universidad = universidad;
        this.talleres = talleres;
        this.notificacion = notificacion;
    }

    public String getFecha(){
        return fecha;
    }

    public void setFecha(String fecha){
        this.fecha = fecha;
    }

    public double getNota(){
        return nota;
    }

    public void setNota(double nota){
        this.nota = nota;
    }

    public Universidad getUniversidad(){
        return universidad;
    }

    public void setUniversidad(Universidad universidad){
        this.universidad = universidad;
    }

    public List<Taller> getTalleres(){
        return talleres;
    }

    public void setTalleres(List<Taller> talleres){
        this.talleres = talleres;
    }

    public INotificable getNotificacion() {
        return notificacion;
    }

    public void notificarTaller(String fecha, double nota){
        notificacion.notificar("La fecha del taller fue " + fecha + " y la nota es " + nota);
    }

    @Override
    public String toString() {
        return "Taller{" +
                "fecha='" + fecha + '\'' +
                ", nota=" + nota +
                ", universidad=" + universidad +
                ", talleres=" + talleres +
                '}';
    }
}