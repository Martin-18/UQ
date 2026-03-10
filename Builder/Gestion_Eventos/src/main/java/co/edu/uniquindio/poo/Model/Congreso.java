
package co.edu.uniquindio.poo.Model;

public class Congreso extends Evento {

    public Congreso(Builder builder) {
        super(builder);
    }

    public static class Builder extends Evento.Builder {

        @Override
        public Builder nombre(String nombre) {
            super.nombre(nombre);
            return this;
        }

        @Override
        public Builder fecha(String fecha) {
            super.fecha(fecha);
            return this;
        }

        @Override
        public Builder certificadoDigital(String certificadoDigital) {
            super.certificadoDigital(certificadoDigital);
            return this;
        }

        @Override
        public Builder stream(String stream) {
            super.stream(stream);
            return this;
        }

        @Override
        public Builder traduccion(String traduccion) {
            super.traduccion(traduccion);
            return this;
        }

        @Override
        public Builder refigerio(String refigerio) {
            super.refigerio(refigerio);
            return this;
        }

        @Override
        public Builder capacidadMaxima(int capacidadMaxima) {
            super.capacidadMaxima(capacidadMaxima);
            return this;
        }

        @Override
        public Builder patrocinadores(String patrocinadores) {
            super.patrocinadores(patrocinadores);
            return this;
        }

        @Override
        public Builder modalidad(Modalidad modalidad) {
            super.modalidad(modalidad);
            return this;
        }

        @Override
        public Congreso build() {
            return new Congreso(this);
        }
    }
}