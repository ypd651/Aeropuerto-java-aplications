/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taller_de_clase;

/**
 *
 * @author camper
 */

// Pasajero hereda de Pesrona
public class Pasajero extends Persona {
    // Atributo del pasajero
    private int edad;

    // Constructor de Pasajero
    public Pasajero(String documento, String nombre, int edad) {
        // super(documento, nombre) --> llama al constructor de Persona.
        // Le envía documento y nombere
        super(documento, nombre);

        // Guarda la edad
        this.edad = edad;
    }

    // Ibtener la edad
    public int getEdad() {
        return edad;
    }

    // Implementación del metodo abstracto de Persona
    @Override
    public String obtenerDescripcion() {
        return "Pasajero: " + getNombre();
    }
}