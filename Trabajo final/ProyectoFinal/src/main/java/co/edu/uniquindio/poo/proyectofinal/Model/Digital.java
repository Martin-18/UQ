package co.edu.uniquindio.poo.proyectofinal.Model;

public class Digital extends Libro{
    private String enlaceDescarga;
    private Formato formato;

    /**
     * costructor de la clase Digital
     * @param enlaceDescarga
     */

    public Digital(String enlaceDescarga, String Titulo, String Autor, String Genero, int Anio, boolean Prestado, Formato Formato) {
        super(Titulo, Autor, Genero, Anio, Prestado);
        this.enlaceDescarga = enlaceDescarga;
        this.formato = Formato;
    }

    /**
     * Metodo para obtener el enlaceDescarga
     * @return
     */

    public String getEnlaceDescarga() {
        return enlaceDescarga;
    }

    /**
     * Metodo para cambiar el enlaceDescarga
     * @param enlaceDescarga
     */

    public void setEnlaceDescarga(String enlaceDescarga) {
        this.enlaceDescarga = enlaceDescarga;
    }

    /**
     * metodo para obtener el formato
     * @return
     */

    public Formato getFormato() {
        return formato;
    }

/**
 * Metodo para cambiar el formato
 * @param formato
 */

    public void setFormato(Formato formato) {
        this.formato = formato;
    }

    /**
     * Metodo para mostra infromacion de la clase Digital
     * @return
     */

    @Override
    public String toString() {
        return "Digital{" +
                "enlaceDescarga='" + enlaceDescarga + '\'' +
                '}';
    }
}
