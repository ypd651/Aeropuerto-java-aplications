/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taller_de_clase;

/**
 *
 * @author camper
 */

// Piloto hereda de Persona
public class Piloto extends Persona {
    // Atributo nuevo: licencia
    private String licencia;

    // Atributo nuevo: horas de vuelo
    private int horasVuelo;

    // Constructor de Piloto
    public Piloto(String documento, String nombre, String licencia, int horasVuelo) {
        // Llama al constructor de Presona
        super(documento, nombre);

        // Guarda la licencia
        this.licencia = licencia;

        // Guarda las horas deñ vuelo
        this.horasVuelo = horasVuelo;
    }

    // Oobtener la licencia
    public String getLicencia() {
        return licencia;
    }

    // Obtener las horas de vuelo
    public int getHorasVuelo() {
        return horasVuelo;
    }

    // Implementacipn del metodo abstracto de Persona
    @Override
    public String obtenerDescripcion() {
        return "Piloto: " + getNombre() + " - " + horasVuelo + " horas de vuelo";
    }
}