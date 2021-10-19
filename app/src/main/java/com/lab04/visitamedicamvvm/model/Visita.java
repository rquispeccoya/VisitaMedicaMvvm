package com.lab04.visitamedicamvvm.model;

public class Visita {
    private String codigo;
    private String dni;
    private String peso;
    private String saturacion;
    private String temperatura;
    private String presion;

    public String getPresion(){
        return presion;
    }

    public void setPresion(String presion){
        this.presion = presion;
    }

    public String getPeso(){
        return peso;
    }

    public void setPeso(String peso){
        this.peso = peso;
    }

    public String getDni(){
        return dni;
    }

    public void setDni(String dni){
        this.dni = dni;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo){
        this.codigo = codigo;
    }

    public String getSaturacion() {
        return saturacion;
    }

    public void setSaturacion(String saturacion) {
        this.saturacion = saturacion;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }
}
