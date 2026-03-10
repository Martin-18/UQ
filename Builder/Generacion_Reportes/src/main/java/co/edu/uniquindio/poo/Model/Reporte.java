package co.edu.uniquindio.poo.Model;

import java.time.LocalDate;
import java.util.List;

public class Reporte {

    private String titulo;
    private String autor;
    private String grafico;
    private String tablaDatos;
    private String resumen;
    private String firma;
    private String logo;
    private LocalDate fecha;
    private List<Reporte> listReportes;
    private Empresa empresa;
    private NivelConfidencialidad nivelConfidencialidad;

    public Reporte(String titulo, String autor, String grafico, String tablaValores, String resumen, String firma, String logo, LocalDate fecha,
                   List<Reporte> listReportes, Empresa empresa, NivelConfidencialidad nivelConfidencialidad){
        this.titulo = titulo;
        this.autor = autor;
        this.grafico = grafico;
        this.tablaDatos = tablaDatos;
        this.resumen = resumen;
        this.firma = firma;
        this.logo = logo;
        this.fecha = fecha;
        this.listReportes = listReportes;
        this.empresa = empresa;
        this.nivelConfidencialidad = nivelConfidencialidad;
    }

    public Reporte(Builder builder){
        this.titulo = builder.titulo;
        assert builder.autor != null;
        this.autor = builder.autor;
        this.grafico = builder.grafico;
        this.tablaDatos = builder.tablaDatos;
        this.resumen = builder.resumen;
        this.firma = builder.firma;
        this.logo = builder.logo;
        this.fecha = builder.fecha;
        this.listReportes = builder.listReportes;
        this.empresa = builder.empresa;
        this.nivelConfidencialidad = builder.nivelConfidencialidad;
    }

    public String getTitulo(){
        return titulo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getAutor(){
        return autor;
    }

    public void setAutor(String autor){
        this.autor = autor;
    }

    public String getGrafico(){
        return grafico;
    }

    public void setGrafico(String grafico){
        this.grafico = grafico;
    }

    public String getTablaDatos(){
        return tablaDatos;
    }

    public void setTablaDatos(String tablaDatos){
        this.tablaDatos = tablaDatos;
    }

    public String getResumen(){
        return resumen;
    }

    public void setResumen(String resumen){
        this.resumen = resumen;
    }

    public String getFirma(){
        return firma;
    }

    public void setFirma(String firma){
        this.firma = firma;
    }

    public String getLogo(){
        return logo;
    }

    public void setLogo(String logo){
        this.logo = logo;
    }

    public LocalDate getFecha(){
        return fecha;
    }

    public void setFecha(LocalDate fecha){
        this.fecha = fecha;
    }

    public List getListReportes(){
        return listReportes;
    }

    public void setListReportes(List<Reporte> listReportes){
        this.listReportes = listReportes;
    }

    public Empresa getEmpresa(){
        return empresa;
    }

    public void setEmpresa(Empresa empresa){
        this.empresa = empresa;
    }

    public NivelConfidencialidad getNivelConfidencialidad(){
        return nivelConfidencialidad;
    }

    public void setNivelConfidencialidad(NivelConfidencialidad nivelConfidencialidad){
        this.nivelConfidencialidad = nivelConfidencialidad;
    }

    @Override
    public String toString() {
        return "Reporte{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", grafico='" + grafico + '\'' +
                ", tablaDatos='" + tablaDatos + '\'' +
                ", resumen='" + resumen + '\'' +
                ", firma='" + firma + '\'' +
                ", logo='" + logo + '\'' +
                ", fecha=" + fecha +
                ", listReportes=" + listReportes +
                ", empresa=" + empresa +
                ", nivelConfidencialidad=" + nivelConfidencialidad +
                '}';
    }

    public static class Builder{

        private String titulo;
        private String autor;
        private String grafico;
        private String tablaDatos;
        private String resumen;
        private String firma;
        private String logo;
        private LocalDate fecha;
        private List<Reporte> listReportes;
        private Empresa empresa;
        private NivelConfidencialidad nivelConfidencialidad;

        public Builder titulo(String titulo){
            this.titulo = titulo;
            return this;
        }

        public Builder autor(String autor){
            this.autor = autor;
            return this;
        }

        public Builder grafico(String grafico){
            this.grafico = this.grafico;
            return this;
        }

        public Builder tablaDatos(String tablaDatos){
                this.tablaDatos = tablaDatos;
                return this;
        }

        public Builder resumen(String resumen){
            this.resumen = resumen;
            return this;
        }

        public Builder firma(String firma){
            this.firma = firma;
            return this;
        }

        public Builder logo(String logo){
            this.logo = logo;
            return this;
        }

        public Builder fecha(LocalDate fecha){
            this.fecha = fecha;
            return this;
        }

        public Builder listReportes(List<Reporte> listReportes){
            this.listReportes = listReportes;
            return this;
        }

        public Builder empresa(Empresa empresa){
            this.empresa = empresa;
            return this;
        }

        public Builder nivelConfidencialidad(NivelConfidencialidad nivelConfidencialidad){
            this.nivelConfidencialidad = nivelConfidencialidad;
            return this;
        }

        public Reporte build(){
            return new Reporte(this);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "titulo='" + titulo + '\'' +
                    ", autor='" + autor + '\'' +
                    ", graficos='" + grafico + '\'' +
                    ", tablaDatos='" + tablaDatos + '\'' +
                    ", resumen='" + resumen + '\'' +
                    ", firma='" + firma + '\'' +
                    ", logo='" + logo + '\'' +
                    ", fecha=" + fecha +
                    ", listReportes=" + listReportes +
                    ", empresa=" + empresa +
                    ", nivelConfidencialidad=" + nivelConfidencialidad +
                    '}';
        }
    }
}

