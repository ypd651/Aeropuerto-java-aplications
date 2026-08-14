/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taller_de_clase;

/**
 *
 * @author camper
 */

// Un vuelo solo pudee estar en uno de estos estados.
public enum EstadoVuelo {
    // Enums:
    // El vuelo está registrado y se puede reservar.
    PROGRAMADO,

    // El vuelo está en proceso de abrodaje.
    ABORDANDO,

    // El vuelo ya está volando.
    EN_VUELO,

    // El vuelo termino.
    FINALIZADO,

    // El vuelo fue cancelao.
    CANCELADO
}