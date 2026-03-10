package co.edu.uniquindio.poo;


import co.edu.uniquindio.poo.Model.Biblioteca;
import co.edu.uniquindio.poo.Model.Libro;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException{

        Biblioteca biblioteca = new Biblioteca("UQ",7000, null);
        Libro libro1 = new Libro("Fantasia", 300, biblioteca);
        Libro clon = libro1.clone();


        System.out.println(biblioteca);
        System.out.println(libro1);

        System.out.println("-------------");
        clon.setGenero("Kevin");
        System.out.println(clon.toString());

    }
}