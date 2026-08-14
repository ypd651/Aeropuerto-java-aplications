/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taller_de_clase;

/**
 *
 * @author camper
 */

// Manejo de errores persolaizados.
// Se usará cuando el vuelo esté lleno.
public class VueloLlenoException extends Exception {

    // Constructor de la excepción.
    // Recibe un mensaje de error.
    public VueloLlenoException(String mensaje) {

        // super(mensaje) guarda el mensaje dentro de la excepción.
        super(mensaje);
    }
}