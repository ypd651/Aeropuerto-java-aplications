# Sistema de Gestión de Vuelos y Aeropuertos

Proyecto de consola desarrollado en **Java** como parte del **Taller práctico de Java**, enfocado en aplicar fundamentos de programación y conceptos de **Programación Orientada a Objetos**.

---

## Descripción

Este sistema permite administrar de forma básica:

- Aeropuertos
- Pasajeros
- Pilotos
- Vuelos
- Reservas de pasajeros en vuelos
- Estados de vuelos
- Estadísticas generales del sistema

La aplicación funciona completamente por consola, utilizando `Scanner`, estructuras de control, colecciones, herencia, polimorfismo, encapsulamiento, excepciones y clases genéricas.

---

## Contexto

Una aerolínea necesita un sistema básico para gestionar sus vuelos nacionales e internacionales.

El sistema permite:

- Registrar aeropuertos.
- Registrar vuelos.
- Registrar pasajeros.
- Reservar un asiento en un vuelo.
- Consultar vuelos registrados.
- Buscar vuelos por ciudad de destino.
- Consultar pasajeros de un vuelo.
- Cambiar el estado de un vuelo.
- Mostrar estadísticas generales del sistema.

---

## Funcionalidades

| Opción | Funcionalidad |
|---|---|
| 1 | Registrar aeropuerto |
| 2 | Registrar pasajero |
| 3 | Registrar vuelo |
| 4 | Listar vuelos |
| 5 | Buscar vuelos por destino |
| 6 | Reservar vuelo |
| 7 | Ver pasajeros de un vuelo |
| 8 | Cambiar estado de vuelo |
| 9 | Ver estadísticas |
| 10 | Salir |

---

## Requisitos académicos aplicados

Este proyecto implementa los siguientes conceptos:

| Concepto | Aplicación en el proyecto |
|---|---|
| Variables y tipos de datos | Uso de `String`, `int`, `boolean`, `double`, entre otros |
| Operadores | Comparaciones, validaciones y cálculos |
| Condicionales | `if`, `else` |
| `switch` | Menú principal y cambio de estado de vuelos |
| Ciclos | `while`, `for`, `for-each` |
| Cadenas y conversiones | `toLowerCase()`, `trim()`, `contains()`, `Integer.parseInt()` |
| Clases y objetos | Creación de clases como `Aeropuerto`, `Vuelo`, `Pasajero`, `Piloto` |
| Encapsulamiento | Atributos privados con métodos getters y setters |
| Herencia | `Pasajero` y `Piloto` heredan de `Persona` |
| Clase abstracta | `Persona` es una clase abstracta |
| Polimorfismo | Implementación de `obtenerDescripcion()` en diferentes clases |
| Listas | Uso de `List<Pasajero>` y `List<Persona>` |
| Genéricos | Clase `Repositorio<T>` |
| Relaciones entre clases | `Vuelo` tiene `Aeropuerto` origen/destino y lista de `Pasajero` |
| Set | `HashSet<String>` para destinos disponibles |
| Map | `HashMap<String, Integer>` para contar vuelos por destino |
| Enumeraciones | `EstadoVuelo` |
| Manejo de excepciones | Uso de `try/catch` |
| Excepción personalizada | `VueloLlenoException` |

---

## Estructura del proyecto

Esta versión está organizada de forma sencilla, sin paquetes, para facilitar la compilación y el aprendizaje.
