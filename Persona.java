/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taller_de_clase;

/**
 *
 * @author camper
 */

// Clase abstracta
// No se pueden crear objetos Persona directamente
// Solo sirve como clase padre para Pasajero y Piloto --> son perosans
public abstract class Persona {
    // Atributo documento
    private String documento;

    // Atributo nombre
    private String nombre;

    // Constructor
    // Se usa cuando una clase hija crea un objeto
    public Persona(String documento, String nombre) {
        // Guarda el documento
        this.documento = documento;

        // Guarda el nobmre
        this.nombre = nombre;
    }

    // obtener el documento
    public String getDocumento() {
        return documento;
    }

    // obtener el nombre
    public String getNombre() {
        return nombre;
    }

    // Metodo abstracto
    // Las clases hijas deberan implementarlo
    public abstract String obtenerDescripcion();
}