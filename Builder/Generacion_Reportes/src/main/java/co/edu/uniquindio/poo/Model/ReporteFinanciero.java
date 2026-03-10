package co.edu.uniquindio.poo.Model;

import java.time.LocalDate;

public class ReporteFinanciero extends Reporte{

    public ReporteFinanciero(Builder builder){
        super(builder);
    }

    public static class Builder extends Reporte.Builder{

        @Override
        public Builder titulo(String titulo){
            super.titulo(titulo);
            return this;
        }

        @Override
        public Builder autor(String autor){
            super.autor(autor);
            return this;
        }

        @Override
        public Builder grafico(String grafico){
            super.grafico(grafico);
            return this;
        }

        @Override
        public Builder tablaDatos(String tablaDatos){
            super.tablaDatos(tablaDatos);
            return this;
        }

        @Override
        public Builder resumen(String resumen){
            super.resumen(resumen);
            return this;
        }

        @Override
        public Builder firma(String firma){
            super.firma(firma);
            return this;
        }

        @Override
        public Builder logo(String logo){
            super.firma(logo);
            return this;
        }

        @Override
        public Builder fecha(LocalDate fecha){
            super.fecha(fecha);
            return this;
        }

        @Override
        public Builder empresa(Empresa empresa){
            super.empresa(empresa);
            return this;
        }

        @Override
        public Builder nivelConfidencialidad(NivelConfidencialidad nivelConfidencialidad){
            super.nivelConfidencialidad(nivelConfidencialidad);
            return this;
        }

        @Override
        public ReporteFinanciero build(){
            return new ReporteFinanciero(this);
        }

    }

}
