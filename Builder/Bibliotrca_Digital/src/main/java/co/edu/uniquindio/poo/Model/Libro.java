package co.edu.uniquindio.poo.Model;

public class Libro implements Cloneable{

    private String genero;
    private int numeroHojas;
    private Biblioteca biblioteca;

    public Libro(String genero, int numeroHojas, Biblioteca biblioteca){
        this.genero = genero;
        this.numeroHojas = numeroHojas;
        this.biblioteca = biblioteca;
    }

    public Libro clone() throws CloneNotSupportedException {
        return (Libro) super.clone();
    }

    public String getGenero(){
        return genero;
    }

    public void setGenero(String genero){
        this.genero = genero;
    }

    public int numeroHojas(){
        return numeroHojas;
    }

    public int getNumeroHojas() {
        return numeroHojas;
    }

    public Biblioteca getBiblioteca(){
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca){
        this.biblioteca = biblioteca;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "genero='" + genero + '\'' +
                ", numeroHojas=" + numeroHojas +
                ", biblioteca=" + biblioteca +
                '}';
    }
}
