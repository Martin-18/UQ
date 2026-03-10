package co.edu.uniquindio.poo.Model;

import java.util.List;

public class Evento{

    private String nombre;
    private String fecha;
    private String certificadoDigital;
    private String stream;
    private String traduccion;
    private String refigerio;
    private int capacidadMaxima;
    private String patrocinadores;
    private Modalidad modalidad;
    private List<Evento> listEventos;
    private Universidad universidad;

    public Evento(Builder builder){
        this.nombre = builder.nombre;
        assert this.nombre != null;
        this.fecha = builder.fecha;
        assert this.fecha != null;
        this.certificadoDigital = builder.certificadoDigital;
        this.stream = builder.stream;
        this.traduccion = builder.traduccion;
        this.refigerio = builder.refigerio;
        this.capacidadMaxima = builder.capacidadMaxima;
        this.patrocinadores = builder.patrocinadores;
        this.modalidad = builder.modalidad;
        this.listEventos = builder.listEventos;
        this.universidad = builder.universidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCertificadoDigital() {
        return certificadoDigital;
    }

    public void setCertificadoDigital(String certificadoDigital) {
        this.certificadoDigital = certificadoDigital;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getTraduccion() {
        return traduccion;
    }

    public void setTraduccion(String traduccion) {
        this.traduccion = traduccion;
    }

    public String getRefigerio() {
        return refigerio;
    }

    public void setRefigerio(String refigerio) {
        this.refigerio = refigerio;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public String getPatrocinadores() {
        return patrocinadores;
    }

    public void setPatrocinadores(String patrocinadores) {
        this.patrocinadores = patrocinadores;
    }

    public Modalidad getModalidad() {
        return modalidad;
    }

    public void setModalidad(Modalidad modalidad) {
        this.modalidad = modalidad;
    }

    public List<Evento> getListEventos() {
        return listEventos;
    }

    public void setListEventos(List<Evento> listEventos) {
        this.listEventos = listEventos;
    }

    public Universidad getUniversidad() {
        return universidad;
    }

    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "nombre='" + nombre + '\'' +
                ", fecha='" + fecha + '\'' +
                ", certificadoDigital='" + certificadoDigital + '\'' +
                ", stream='" + stream + '\'' +
                ", traduccion='" + traduccion + '\'' +
                ", refigerio='" + refigerio + '\'' +
                ", capacidadMaxima=" + capacidadMaxima +
                ", patrocinadores='" + patrocinadores + '\'' +
                ", modalidad=" + modalidad +
                ", listEventos=" + listEventos +
                ", universidad=" + universidad +
                '}';
    }

    public static class Builder{
        private String nombre;
        private String fecha;
        private String certificadoDigital;
        private String stream;
        private String traduccion;
        private String refigerio;
        private int capacidadMaxima;
        private String patrocinadores;
        private Modalidad modalidad;
        private List<Evento> listEventos;
        private Universidad universidad;

        public Builder nombre(String nombre){
            this.nombre = nombre;
            return this;
        }

        public Builder fecha(String fecha){
            this.fecha = fecha;
            return this;
        }

        public Builder certificadoDigital(String certificadoDigital){
            this.certificadoDigital = certificadoDigital;
            return this;
        }

        public Builder stream(String stream){
            this.stream = stream;
            return this;
        }

        public Builder traduccion(String traduccion){
            this.traduccion = traduccion;
            return this;
        }

        public Builder refigerio(String refigerio){
            this.refigerio = refigerio;
            return this;
        }

        public Builder capacidadMaxima(int capacidadMaxima){
            this.capacidadMaxima = capacidadMaxima;
            return this;
        }

        public Builder patrocinadores(String patrocinadores){
            this.patrocinadores = patrocinadores;
            return this;
        }

        public Builder modalidad(Modalidad modalidad){
            this.modalidad = modalidad;
            return this;
        }

        public Builder listEventos(List<Evento> listEventos){
            this.listEventos = listEventos;
            return this;
        }

        public Evento build(){
            return new Evento(this);
        }

    }
}
