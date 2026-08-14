/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taller_de_clase;

/**
 *
 * @author camper
 */

import java.util.ArrayList;
import java.util.List;

// Clase generica
// <T> porque no saebmos el tipo de objeto
public class Repositorio<T> {
    // Lista para guardar elemntos
    private List<T> elementos = new ArrayList<>();

    // Agregar un elemento
    public void agregar(T elemento) {
        elementos.add(elemento);
    }

    // Obtener todos los elementos
    public List<T> obtenerTodos() {
        return elementos;
    }
}