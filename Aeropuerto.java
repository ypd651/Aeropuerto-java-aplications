/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taller_de_clase;

/**
 *
 * @author camper
 */

// Clase Aeropuerto
// Representa un aeropuerto del sistema
public class Aeropuerto {
    // Codigo aeropuerto
    private String codigo;

    // Nombre del aeropureto
    private String nombre;

    // Ciudad del aeropuerto
    private String ciudad;

    // Paus del aerppuerto
    private String pais;

    // Constructo raeropuerto
    public Aeropuerto(String codigo, String nombre, String ciudad, String pais) {
        // Guarda el codigo
        this.codigo = codigo;

        // Guarda el nombre
        this.nombre = nombre;

        // Guarda la ciudad
        this.ciudad = ciudad;

        // Guarda le pais
        this.pais = pais;
    }

    // Getter para obtener el codigo
    public String getCodigo() {
        return codigo;
    }

    // Getter para obtener el nombre
    public String getNombre() {
        return nombre;
    }

    // Getter para obtener la ciudad
    public String getCiudad() {
        return ciudad;
    }

    // Getter para obtener el pais
    public String getPais() {
        return pais;
    }
}