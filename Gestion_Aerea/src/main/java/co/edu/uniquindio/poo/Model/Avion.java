package co.edu.uniquindio.poo.Model;

public class Avion {

    private String aerolinea;
    private int numero;
    private final INotificacion notificacion;
    private Aeropuerto aeropuerto;

    public Avion(String aerolinea, int numero, INotificacion notificacion){
        this.aerolinea = aerolinea;
        this.numero = numero;
        this.notificacion = notificacion;
    }

    public String getAerolinea(){
        return aerolinea;
    }

    public void setAerolinea(String aerolinea){
        this.aerolinea = aerolinea;
    }

    public int getNumero(){
        return numero;
    }

    public void setNumero(int numero){
        this.numero = numero;
    }

    public INotificacion getNotificacion() {
        return notificacion;
    }

    public Aeropuerto getAeropuerto() {
        return aeropuerto;
    }

    public void setAeropuerto(Aeropuerto aeropuerto) {
        this.aeropuerto = aeropuerto;
    }

    public void notificacionAvion(String aerolinea, int numero){
        notificacion.notificar("El avion " + numero + " " + "de aerolinea " + aerolinea + " ha despegado");
    }

    @Override
    public String toString() {
        return "Avion{" +
                "aerolinea='" + aerolinea + '\'' +
                ", numero=" + numero +
                ", notificacion=" + notificacion +
                ", aeropuerto=" + aeropuerto +
                '}';
    }
}
