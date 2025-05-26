package co.edu.uniquindio.poo.cine;

public class Funcion {
    private String NombrePelicula;
    private String DuracionPelicula;
    private String FechaPelicula;
    private String PrecioPelicula;

    public Funcion(String nombrePelicula, String DuracionPelicula, String FechaPelicula, String Precio) {
        this.NombrePelicula = nombrePelicula;
        this.DuracionPelicula = DuracionPelicula;
        this.FechaPelicula = FechaPelicula;
        this.PrecioPelicula = Precio;
    }

    public String getNombrePelicula() {
        return NombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        NombrePelicula = nombrePelicula;
    }

    public String getPrecioPelicula() {
        return PrecioPelicula;
    }

    public void setPrecioPelicula(String precioPelicula) {
        PrecioPelicula = precioPelicula;
    }

    public String getFechaPelicula() {
        return FechaPelicula;
    }

    public void setFechaPelicula(String fechaPelicula) {
        FechaPelicula = fechaPelicula;
    }

    public String getDuracionPelicula() {
        return DuracionPelicula;
    }

    public void setDuracionPelicula(String duracionPelicula) {
        DuracionPelicula = duracionPelicula;
    }

    @Override
    public String toString() {
        return "Funcion{" +
                "NombrePelicula='" + NombrePelicula + '\'' +
                ", DuracionPelicula='" + DuracionPelicula + '\'' +
                ", FechaPelicula='" + FechaPelicula + '\'' +
                ", PrecioPelicula='" + PrecioPelicula + '\'' +
                '}';
    }
}
