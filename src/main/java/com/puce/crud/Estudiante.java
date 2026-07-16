package com.puce.crud;

/**
 * Modelo que representa un estudiante de la tabla estudiantes.
 */
public class Estudiante {

    private int id;
    private String nombre;
    private String carrera;
    private int semestre;

    public Estudiante() {
    }

    public Estudiante(String nombre, String carrera, int semestre) {
        this.nombre = nombre;
        this.carrera = carrera;
        this.semestre = semestre;
    }

    public Estudiante(int id, String nombre, String carrera, int semestre) {
        this.id = id;
        this.nombre = nombre;
        this.carrera = carrera;
        this.semestre = semestre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    @Override
    public String toString() {
        return id + " | " + nombre + " | " + carrera + " | Semestre: " + semestre;
    }
}
