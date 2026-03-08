package co.edu.uniquindio.poo.Model;

public final class Notificacion implements INotificacion{

    public static Notificacion instance;

    public Notificacion(){}

    public static Notificacion getInstance(){
        if(instance == null){
            instance = new Notificacion();
        }
        return instance;
    }

    public void notificar(String mensaje){
        System.out.println("Torre de control Informa que: " + mensaje);
    }

}
