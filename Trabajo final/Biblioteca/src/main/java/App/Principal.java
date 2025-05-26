package App;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Principal {
    public static void main(String[] args) {
        List<libros> libro = new ArrayList<>();
        libro.add(new libros("el inquisidor", "Philippa Gregory" ,"Panamericana", "Fantasia",2010 ));
        libro.add(new libros("La cruzada", "Philippa Gregory" ,"Panamericana", "Fantasia",2011 ));
        libro.add(new libros("Oro de tontos", "Philippa Gregory" ,"Panamericana", "Fantasia",2012 ));
        libro.add(new libros("Sendas Oscuras", "Philippa Gregory" ,"Panamericana", "Fantasia",2013 ));
        guardarLibros(libro);
    }

    private static void guardarLibros(List<libros> list) {
        try{
            BufferedWriter escritor = new BufferedWriter(new FileWriter("D:\\Universidad\\Programacion-I\\Trabajo final\\libros.txt",true));
            for (libros lib : list) {
                escritor.newLine();
            }
            escritor.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

