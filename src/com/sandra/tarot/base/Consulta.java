package com.sandra.tarot.base;

import java.time.LocalDate;

public abstract class Consulta {

    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private int numeroSuerte;


    public Consulta() {
    }


    public Consulta(String nombre, String apellido,
                    LocalDate fechaNacimiento, int numeroSuerte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.numeroSuerte = numeroSuerte;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getNumeroSuerte() {
        return numeroSuerte;
    }

    public void setNumeroSuerte(int numeroSuerte) {
        this.numeroSuerte = numeroSuerte;
    }


    public abstract String consultarAmor();

    public abstract String consultarTrabajo();

    public abstract String consultarSuerte();
}
