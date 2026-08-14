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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

// Clase principal
public class Taller_de_clase {
    // input
    static Scanner scanner = new Scanner(System.in);

    // Repositorio para guardar aeropuertos
    static Repositorio<Aeropuerto> aeropuertos = new Repositorio<>();

    // Repositorio para guardar paasjeros
    static Repositorio<Pasajero> pasajeros = new Repositorio<>();

    // Repositorio para guardar vuelos
    static Repositorio<Vuelo> vuelos = new Repositorio<>();

    // Lista de personas --> herencia y polimorfismo
    // Puede contener Pasajero y Piloto
    static List<Persona> personas = new ArrayList<>();

    // Contador de resevras
    static int totalReservas = 0;

    // MAIN
    public static void main(String[] args) {
        // Datos iniciales
        cargarDatosIniciales();

        // Aplicar polimorfismo
        System.out.println("::::: DEMOSTRACIÓN DE POLIMORFISMO :::::");

        // Recorre lista de Personas
        // Cada objeto puede ser Pasajero o Piloto
        for (Persona persona : personas) {
            System.out.println(persona.obtenerDescripcion());
        }

        // Variables menu
        boolean activo = true;

        // Mientras activo sea true, el menu sigue
        while (activo) {

            // Mostrar menu
            imprimirMenu();

            // Leer opcion
            int opcion = leerEntero("Seleccione una opción: ");

            // switch case para realizar cada caso de eleccion
            switch (opcion) {

                case 1:
                    registrarAeropuerto();
                    break;

                case 2:
                    registrarPasajero();
                    break;

                case 3:
                    registrarVuelo();
                    break;

                case 4:
                    listarVuelos();
                    break;

                case 5:
                    buscarVuelosPorDestino();
                    break;

                case 6:
                    reservarVueloConMenu();
                    break;

                case 7:
                    verPasajerosDeVuelo();
                    break;

                case 8:
                    cambiarEstadoVuelo();
                    break;

                case 9:
                    verEstadisticas();
                    break;

                case 10:
                    activo = false;
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    // Mmostrar el menu principal
    private static void imprimirMenu() {
        System.out.println("==================================");
        System.out.println("AEROPUERTO JSON");
        System.out.println("==================================");
        System.out.println("1. Registrar aeropuerto");
        System.out.println("2. Registrar pasarjero");
        System.out.println("3. Registrar vuelo");
        System.out.println("4. Listar vuelos");
        System.out.println("5. Buscar vuelos por destino");
        System.out.println("6. Reservar vuelo");
        System.out.println("7. Ver pasajeros de un vuelo");
        System.out.println("8. Cambiar estado de vuelo");
        System.out.println("9. Ver estadísticas");
        System.out.println("10. Salir");
    }

    // Cargar los datos iniciales
    private static void cargarDatosIniciales() {

        // Aeropuertos iniciales
        aeropuertos.agregar(new Aeropuerto("BOG", "El Dorado", "Bogotá", "Colombia"));
        aeropuertos.agregar(new Aeropuerto("MDE", "José María Córdova", "Medellín", "Colombia"));
        aeropuertos.agregar(new Aeropuerto("CLO", "Alfonso Bonilla Aragón", "Cali", "Colombia"));
        aeropuertos.agregar(new Aeropuerto("CTG", "Rafael Núñez", "Cartagena", "Colombia"));
        aeropuertos.agregar(new Aeropuerto("PSO", "Antonio Nariño", "Pasto", "Colombia"));

        // Crear pasajeros iniciales
        Pasajero p1 = new Pasajero("1001", "Laura Gómez", 25);
        Pasajero p2 = new Pasajero("1002", "Andrés Martínez", 32);
        Pasajero p3 = new Pasajero("1003", "Carolina Díaz", 28);
        Pasajero p4 = new Pasajero("1004", "Daniel Torres", 41);

        // Agregar los pasajreos
        pasajeros.agregar(p1);
        pasajeros.agregar(p2);
        pasajeros.agregar(p3);
        pasajeros.agregar(p4);
     
        // Agregar los persoans, tanto pasjeros como pilostos
        personas.add(p1);
        personas.add(p2);
        personas.add(p3);
        personas.add(p4);

        // Piloto inicial --> polimorfismo
        personas.add(new Piloto("P001", "Carlos Rodríguez", "LIC-777", 2500));

        // Vuelos iniciales
        vuelos.agregar(new Vuelo("AV101", buscarAeropuerto("BOG"), buscarAeropuerto("MDE"), 180));
        vuelos.agregar(new Vuelo("AV202", buscarAeropuerto("BOG"), buscarAeropuerto("CTG"), 150));
        vuelos.agregar(new Vuelo("AV303", buscarAeropuerto("MDE"), buscarAeropuerto("CLO"), 120));
        vuelos.agregar(new Vuelo("AV404", buscarAeropuerto("CLO"), buscarAeropuerto("BOG"), 100));
        vuelos.agregar(new Vuelo("AV505", buscarAeropuerto("BOG"), buscarAeropuerto("PSO"), 90));
    }

    // Registrar aeropuerto
    private static void registrarAeropuerto() {
        // Datos de los usuarios
        String codigo = leerLinea("Código: ");
        String nombre = leerLinea("Nombre: ");
        String ciudad = leerLinea("Ciudad: ");
        String pais = leerLinea("País: ");

        // Ningun dato debe estar vacio
        if (codigo.isEmpty() || nombre.isEmpty() || ciudad.isEmpty() || pais.isEmpty()) {
            System.out.println("Error: todos los datos son obligatorios.");
            return;
        }

        // No deben haber aeropuerts repetirdos
        if (buscarAeropuerto(codigo) != null) {
            System.out.println("Error: ya existe un aeropuerto con ese código.");
            return;
        }

        // Creamos y guardamos el aeropuerto+
        aeropuertos.agregar(new Aeropuerto(codigo, nombre, ciudad, pais));

        System.out.println("Aeropuerto registrado correctamente.");
    }

    // Registrar pasajero
    private static void registrarPasajero() {
        // Datos de usuarios
        String documento = leerLinea("Documento: ");
        String nombre = leerLinea("Nombre: ");
        int edad = leerEntero("Edad: ");

        // Validamos documento y nomber
        if (documento.isEmpty() || nombre.isEmpty()) {
            System.out.println("Error: documento y nombre son obligatorios.");
            return;
        }

        // Validamos que la edad != 0
        if (edad <= 0) {
            System.out.println("Error: la edad debe ser mayor que 0.");
            return;
        }

        // Validamos que no esten repetidos los documnetos
        if (buscarPasajero(documento) != null) {
            System.out.println("Error: ese documento ya está registrado.");
            return;
        }

        // Creamos el nuevo pasajero
        Pasajero nuevo = new Pasajero(documento, nombre, edad);

        // Guardamos el pasajero en el repositorio
        pasajeros.agregar(nuevo);

        // Lo agregamos a la lista de personas
        personas.add(nuevo);

        System.out.println("Pasajero registrado correctamente.");
    }

    // Registrar vuelo
    private static void registrarVuelo() {
        // Datos del usuario
        String codigo = leerLinea("Código del vuelo: ");
        String codigoOrigen = leerLinea("Código aeropuerto origen: ");
        String codigoDestino = leerLinea("Código aeropuerto destino: ");
        int capacidad = leerEntero("Capacidad máxima: ");

        // Validamos codigo del vuelo
        if (codigo.isEmpty()) {
            System.out.println("Error: el código del vuelo es obligatorio.");
            return;
        }

        // Validamos max capacidad de vuelos
        if (capacidad <= 0) {
            System.out.println("Error: la capacidad debe ser mayor que 0.");
            return;
        }

        // Buscamos aeropuerto origen
        Aeropuerto origen = buscarAeropuerto(codigoOrigen);

        // Buscamos aeropuerto destino
        Aeropuerto destino = buscarAeropuerto(codigoDestino);

        // Validamos que el origen exista
        if (origen == null) {
            System.out.println("Error: el aeropuerto de origen no existe.");
            return;
        }

        // Validamos que el destino exista
        if (destino == null) {
            System.out.println("Error: el aeropuerto de destino no existe.");
            return;
        }

        // Validamos que origen y destino sean diferentes
        if (origen.getCodigo().equalsIgnoreCase(destino.getCodigo())) {
            System.out.println("Error: el origen y el destino deben ser diferentes.");
            return;
        }

        // Validamos que no exista otro vuelo con el mismo codigo
        if (buscarVuelo(codigo) != null) {
            System.out.println("Error: ya existe un vuelo con ese código.");
            return;
        }

        // Creamos y guardamos el vuelo
        vuelos.agregar(new Vuelo(codigo, origen, destino, capacidad));

        System.out.println("Vuelo registrado correctamente.");
    }

    // Listar vuelos
    private static void listarVuelos() {
        // Si no hay vuelos, mostrar la esepcion
        if (vuelos.obtenerTodos().isEmpty()) {
            System.out.println("No hay vuelos registrados.");
            return;
        }

        // Recorremos todos los vuelos
        for (Vuelo vuelo : vuelos.obtenerTodos()) {
            System.out.println("--------------------------------");
            System.out.println("Vuelo: " + vuelo.getCodigo());
            System.out.println("Origen: " + vuelo.getOrigen().getCiudad());
            System.out.println("Destino: " + vuelo.getDestino().getCiudad());
            System.out.println("Capacidad: " + vuelo.getCapacidad());
            System.out.println("Pasajeros: " + vuelo.getPasajeros().size());
            System.out.println("Estado: " + vuelo.getEstado());
        }

        System.out.println("--------------------------------");
    }

    // Bbuscar vuelos por destino
    private static void buscarVuelosPorDestino() {
        // Pedir la ciudad destino
        String ciudad = leerLinea("Ingrese destino: ");

        // Convertimos a minusculas y quitamos espacios
        ciudad = ciudad.toLowerCase().trim();

        // Validamos que sea vacia
        if (ciudad.isEmpty()) {
            System.out.println("Error: ingrese una ciudad válida.");
            return;
        }

        // Variable para guardar los resultados
        String resultado = "";

        // Contador de vuelos encontrados
        int encontrados = 0;

        // Recorremos todos los vuelos
        for (Vuelo vuelo : vuelos.obtenerTodos()) {

            // Obtenemos la ciudad destino en minúsculas y sin espacios
            String ciudadDestino = vuelo.getDestino().getCiudad().toLowerCase().trim();

            // contains() verifica si la ciudad destino contiene el texto buscado
            if (ciudadDestino.contains(ciudad)) {
                encontrados++;

                resultado += "--------------------------------\n";
                resultado += "Vuelo: " + vuelo.getCodigo() + "\n";
                resultado += vuelo.getOrigen().getCiudad() + " -> " + vuelo.getDestino().getCiudad() + "\n";
                resultado += "Estado: " + vuelo.getEstado() + "\n";
            }
        }

        // Si no encontró vuelos, envia la excepcion
        if (encontrados == 0) {
            System.out.println("No se encontraron vuelos.");
        } else {
            System.out.println("Resultados encontrados:");
            System.out.println(resultado);
        }
    }

    // Pedir datos para reservar y su excepcion
    private static void reservarVueloConMenu() {
        // Pedir datos al usuario
        String documento = leerLinea("Documento del pasajero: ");
        String codigoVuelo = leerLinea("Código del vuelo: ");

        // try/catch para manejar la excepción personalizada.
        try {
            String mensaje = reservarVuelo(documento, codigoVuelo);
            System.out.println(mensaje);
        } catch (VueloLlenoException e) {
            System.out.println(e.getMessage());
        }
    }

    // Validaciones y reservas
    private static String reservarVuelo(String documento, String codigoVuelo) throws VueloLlenoException {

        // Buscamos el pasajero
        Pasajero pasajero = buscarPasajero(documento);

        // Validar que el pasajero exista
        if (pasajero == null) {
            return "Error: el pasajero no existe.";
        }

        // Buscar el vuelo
        Vuelo vuelo = buscarVuelo(codigoVuelo);

        // Validar que el vuelo exista
        if (vuelo == null) {
            return "Error: el vuelo no existe.";
        }

        // Validación 3: el vuelo debe estar PROGRAMADO.
        if (vuelo.getEstado() != EstadoVuelo.PROGRAMADO) {
            return "Error: solo se puede reservar un vuelo PROGRAMADO.";
        }

        // Valida rque el pasajero no estae repetido en el vuelo
        if (vuelo.tienePasajero(documento)) {
            return "Error: el pasajero ya está registrado en este vuelo.";
        }

        // Validar que gregarPasajero lance excepcion si esta lleno
        vuelo.agregarPasajero(pasajero);

        // Si llega = la reserva fue exitosa
        totalReservas++;

        return "Reserva realizada correctamente.";
    }

    // Ver pasajeros de un vuelo
    private static void verPasajerosDeVuelo() {
        // Pedimos el codigo del vuelo
        String codigo = leerLinea("Código del vuelo: ");

        // Buscamos el vuelo
        Vuelo vuelo = buscarVuelo(codigo);

        // Validamos que el vuelo existe
        if (vuelo == null) {
            System.out.println("Error: el vuelo no existe.");
            return;
        }

        // Validamos si tiene pasjeeros
        if (vuelo.getPasajeros().isEmpty()) {
            System.out.println("Este vuelo no tiene pasajeros.");
            return;
        }

        // Mostramos pasajeros
        for (Pasajero pasajero : vuelo.getPasajeros()) {
            System.out.println(pasajero.obtenerDescripcion());
        }
    }

    // Cambiar el estado de vuelo
    private static void cambiarEstadoVuelo() {

        // Pedimos el codigo del vuelo
        String codigo = leerLinea("Código del vuelo: ");

        // Buscamos el vuelo
        Vuelo vuelo = buscarVuelo(codigo);

        // Validamos que el vuelo exista
        if (vuelo == null) {
            System.out.println("Error: el vuelo no existe.");
            return;
        }

        // Mostramos las opciones de estado
        System.out.println("1. PROGRAMADO");
        System.out.println("2. ABORDANDO");
        System.out.println("3. EN_VUELO");
        System.out.println("4. FINALIZADO");
        System.out.println("5. CANCELADO");

        // Leer opción elegida
        int opcion = leerEntero("Nuevo estado: ");

        // Cambiar el estado segun la opcion
        switch (opcion) {
            case 1:
                vuelo.setEstado(EstadoVuelo.PROGRAMADO);
                System.out.println("Estado actualizado.");
                break;

            case 2:
                vuelo.setEstado(EstadoVuelo.ABORDANDO);
                System.out.println("Estado actualizado.");
                break;

            case 3:
                vuelo.setEstado(EstadoVuelo.EN_VUELO);
                System.out.println("Estado actualizado.");
                break;

            case 4:
                vuelo.setEstado(EstadoVuelo.FINALIZADO);
                System.out.println("Estado actualizado.");
                break;

            case 5:
                vuelo.setEstado(EstadoVuelo.CANCELADO);
                System.out.println("Estado actualizado.");
                break;

            default:
                System.out.println("Opción de estado inválida.");
        }
    }

    // Ver estadísticas
    private static void verEstadisticas() {
        // Contadores para estados
        int programados = 0;
        int abordando = 0;
        int enVuelo = 0;
        int finalizados = 0;
        int cancelados = 0;

        // Variables para encontrar el vuelo con mayor ocupacoin
        Vuelo mayorOcupacion = null;
        int maximaOcupacion = -1;

        // Recorremos todos los vuelos
        for (Vuelo vuelo : vuelos.obtenerTodos()) {

            // Contamos vuelos por estado
            switch (vuelo.getEstado()) {
                case PROGRAMADO:
                    programados++;
                    break;

                case ABORDANDO:
                    abordando++;
                    break;

                case EN_VUELO:
                    enVuelo++;
                    break;

                case FINALIZADO:
                    finalizados++;
                    break;

                case CANCELADO:
                    cancelados++;
                    break;
            }

            // Obtenemos la cantidad de pasajeros del vuelo
            int ocupacion = vuelo.getPasajeros().size();

            // Si es mayor que la maxima registrada, guardamos el vuelo
            if (ocupacion > maximaOcupacion) {
                maximaOcupacion = ocupacion;
                mayorOcupacion = vuelo;
            }
        }

        // Mostrar estadísticas generales
        System.out.println("========= ESTADÍSTICAS =========");
        System.out.println("Aeropuertos registrados: " + aeropuertos.obtenerTodos().size());
        System.out.println("Vuelos registrados: " + vuelos.obtenerTodos().size());
        System.out.println("Pasajeros registrados: " + pasajeros.obtenerTodos().size());
        System.out.println("Vuelos programados: " + programados);
        System.out.println("Vuelos abordando: " + abordando);
        System.out.println("Vuelos en vuelo: " + enVuelo);
        System.out.println("Vuelos finalizados: " + finalizados);
        System.out.println("Vuelos cancelados: " + cancelados);
        System.out.println("Total reservas realizadas: " + totalReservas);

        // Mostramos el vuelo con mayor ocupacion
        if (mayorOcupacion != null) {
            System.out.println(
                "Vuelo con mayor ocupación: " +
                mayorOcupacion.getCodigo() + " - " +
                mayorOcupacion.getOrigen().getCiudad() + " -> " +
                mayorOcupacion.getDestino().getCiudad() + " " +
                maximaOcupacion + "/" + mayorOcupacion.getCapacidad() + " pasajeros"
            );
        } else {
            System.out.println("Vuelo con mayor ocupación: no hay vuelos.");
        }

        // Set --> no permite elementos repetidos
        Set<String> ciudadesDestino = new HashSet<>();

        // Agregamos ciudades destino al Set
        for (Vuelo vuelo : vuelos.obtenerTodos()) {
            ciudadesDestino.add(vuelo.getDestino().getCiudad());
        }

        System.out.println("=== DESTINOS DISPONIBLES ===");

        // Mostramos ciudades sin repetidos
        for (String ciudad : ciudadesDestino) {
            System.out.println(ciudad);
        }

        // Map --> guarda clave y valor
        // La clave sera la ciudad destino
        // El valor sera la cantidad de vuelos hacia esa ciudad
        Map<String, Integer> vuelosPorDestino = new HashMap<>();

        // Recorremos todos los vuelos.
        for (Vuelo vuelo : vuelos.obtenerTodos()) {

            String ciudad = vuelo.getDestino().getCiudad();

            // Si la ciudad ya esta en el mapa, aumentamos la cantidad
            if (vuelosPorDestino.containsKey(ciudad)) {
                int cantidadActual = vuelosPorDestino.get(ciudad);
                vuelosPorDestino.put(ciudad, cantidadActual + 1);
            } else {
                // Si no este, la agregamos con valor 1.
                vuelosPorDestino.put(ciudad, 1);
            }
        }

        System.out.println("=== VUELOS POR DESTINO ===");

        // Mostramos el resumen del mapa.
        for (Map.Entry<String, Integer> entrada : vuelosPorDestino.entrySet()) {
            System.out.println(entrada.getKey() + ": " + entrada.getValue());
        }
    }

    // Metodo para buscar aeropuerto por cpdigo
    private static Aeropuerto buscarAeropuerto(String codigo) {

        // Recorremos todos los aeropuertos
        for (Aeropuerto aeropuerto : aeropuertos.obtenerTodos()) {

            // Comparamos codigos ignorando mayúsculas y espacios
            if (aeropuerto.getCodigo().equalsIgnoreCase(codigo.trim())) {
                return aeropuerto;
            }
        }

        // Si no encontra el aeropuerto, retorna null.
        return null;
    }

    // Método para buscar pasajero por documento.
    private static Pasajero buscarPasajero(String documento) {

        // Recorremos todos los pasajeros.
        for (Pasajero pasajero : pasajeros.obtenerTodos()) {

            // Comparamos documentos.
            if (pasajero.getDocumento().equalsIgnoreCase(documento.trim())) {
                return pasajero;
            }
        }

        // Si no encontró el pasajero, retorna null.
        return null;
    }

    // Método para buscar vuelo por código.
    private static Vuelo buscarVuelo(String codigo) {

        // Recorremos todos los vuelos.
        for (Vuelo vuelo : vuelos.obtenerTodos()) {

            // Comparamos códigos.
            if (vuelo.getCodigo().equalsIgnoreCase(codigo.trim())) {
                return vuelo;
            }
        }

        // Si no encontró el vuelo, retorna null.
        return null;
    }

    // Método para leer texto.
    private static String leerLinea(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine().trim();
    }

    // Método para leer números enteros de forma segura.
    private static int leerEntero(String mensaje) {

        // El ciclo se repite hasta que el usuario escriba un número válido.
        while (true) {  

            System.out.print(mensaje);
            String linea = scanner.nextLine().trim();

            try {
                // Intentamos convertir el texto a entero.
                return Integer.parseInt(linea);
            } catch (NumberFormatException e) {
                System.out.println("Dato inválido. Ingrese un número entero.");
            }
        }
    }
}