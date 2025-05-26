package App;

public class libros {
    private String Titulo;
    private String Autor;
    private String Editorial;
    private String Genero;
    private int anioPublicacion;
    private boolean Disponibilidad;

    public libros(String Titulo, String Autor, String Editorial, String Genero, int anioPublicacion) {
        this.Titulo = Titulo;
        this.Autor = Autor;
        this.Editorial = Editorial;
        this.Genero = Genero;
        this.anioPublicacion = anioPublicacion;
        this.Disponibilidad = true;
    }
    //clase hija libro fisico
    public class libroFisico extends libros {
         private int NumeroPaginas;
         private String Ubicacion;

        public libroFisico(int NumeroPaginas, String Ubicacion) {
            super(Titulo, Autor, Editorial, Genero, NumeroPaginas);
            this.NumeroPaginas = NumeroPaginas;
            this.Ubicacion = Ubicacion;
        }
    }



    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public String getEditorial() {
        return Editorial;
    }

    public void setEditorial(String editorial) {
        Editorial = editorial;
    }
    public String getGenero() {
        return Genero;
    }
    public void setGenero(String genero) {
        Genero = genero;
    }
    public int getAnioPublicacion() {
        return anioPublicacion;
    }
    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }
    public boolean isDisponibilidad() {
        return Disponibilidad;
    }

    public void mostrarLibros() {
        System.out.println("Titulo: " + Titulo);
        System.out.println("Autor: " + Autor);
        System.out.println("Editorial: " + Editorial);
        System.out.println("Genero: " + Genero);

        System.out.println("Anio Publicacion: " + anioPublicacion);
        System.out.println("Disponibilidad: " + Disponibilidad);
    }
}

