package co.edu.uniquindio.poo.Model;

public final class Notificacion implements INotificable{

    private static Notificacion instance;

    private Notificacion() {}

    public static Notificacion getInstance() {
        if (instance == null){
            instance = new Notificacion();
        }
        return instance;
    }

    @Override
    public void notificar(String mensaje) {
        System.out.println("La universidad Informa que:" + mensaje);
    }
}
