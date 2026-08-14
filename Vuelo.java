/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taller_de_clase;

/**
 *
 * @author camper
 */

// Improtamos ArrayList y List porque un vuelo tiene muchos pasajeros
import java.util.ArrayList;
import java.util.List;

// Clase Vuelo
// Representa un vuelo del sistema
public class Vuelo {
    // Codigo del vuelo
    private String codigo;

    // Areopuerto de origen
    private Aeropuerto origen;

    // Aeropuerto de destino
    private Aeropuerto destino;

    // Capacidad maxima del vuelo
    private int capacidad;

    // Estado del vuelo
    private EstadoVuelo estado;

    // Lista de pasajeros
    private List<Pasajero> pasajeros;

    // Constrctor del vuelo
    public Vuelo(String codigo, Aeropuerto origen, Aeropuerto destino, int capacidad) {

        // Guarda el codigo
        this.codigo = codigo;

        // Guarda el origen
        this.origen = origen;

        // Guarda el destino
        this.destino = destino;

        // Guarda la capacidad
        this.capacidad = capacidad;

        // Todo vuelo nuevo inicia en PROGRAMADO
        this.estado = EstadoVuelo.PROGRAMADO;

        // Inicializamos la lista de pasajeros, sino null
        this.pasajeros = new ArrayList<>();
    }

    // Getter para obtener el codigo
    public String getCodigo() {
        return codigo;
    }

    // Getter para obtener el origen
    public Aeropuerto getOrigen() {
        return origen;
    }

    // Getter para obtener el destino
    public Aeropuerto getDestino() {
        return destino;
    }

    // Getter para obtener la capacidad
    public int getCapacidad() {
        return capacidad;
    }

    // Getter para obtener el estado
    public EstadoVuelo getEstado() {
        return estado;
    }

    // Getter para obtener la litsa de pasajeros
    public List<Pasajero> getPasajeros() {
        return pasajeros;
    }

    // cAMBIAR  EL ESTADO
    public void setEstado(EstadoVuelo estado) {
        this.estado = estado;
    }

    // Saber si un pasajero ya esta a bordo
    public boolean tienePasajero(String documento) {
        // Si el documento es null => falso
        if (documento == null) {
            return false;
        }

        // Recorremos todos los pasajeros del vuelo
        for (Pasajero pasajero : pasajeros) {
            // Comparra documentos
            if (pasajero.getDocumento().equalsIgnoreCase(documento.trim())) {
                return true;
            }
        }

        // Si no encontra el pasajero, da falso
        return false;
    }

    // Añadir un pasajero
    // VueloLlenoException si se lleno
    public void agregarPasajero(Pasajero pasajero) throws VueloLlenoException {
        // Si la cantidad de pasaejros ya llego a la max capacidad
        // lanzamos el error
        if (pasajeros.size() >= capacidad) {
            throw new VueloLlenoException("No existen asientos disponibles.");
        }

        // Si hay cupo, agregamos el pasajero
        pasajeros.add(pasajero);
    }
}