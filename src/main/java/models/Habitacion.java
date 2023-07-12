/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author dann-dev
 */
public class Habitacion {

    private int id_habitacion;
    private String tipo;
    private int numero_personas;
    private String nombre_habitacion;
    private double precio_noche;

    public Habitacion(int id_habitacion, String tipo, int numero_personas, String nombre_habitacion, double precio_noche) {
        this.id_habitacion = id_habitacion;
        this.tipo = tipo;
        this.numero_personas = numero_personas;
        this.nombre_habitacion = nombre_habitacion;
        this.precio_noche = precio_noche;
    }
    
    

    public int getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(int id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNumero_personas() {
        return numero_personas;
    }

    public void setNumero_personas(int numero_personas) {
        this.numero_personas = numero_personas;
    }

    public String getNombre_habitacion() {
        return nombre_habitacion;
    }

    public void setNombre_habitacion(String nombre_habitacion) {
        this.nombre_habitacion = nombre_habitacion;
    }

    public double getPrecio_noche() {
        return precio_noche;
    }

    public void setPrecio_noche(double precio_noche) {
        this.precio_noche = precio_noche;
    }

    
    @Override
    public String toString() {
        return "Habitacion{" + "id_habitacion=" + id_habitacion + ", tipo=" + tipo + ", numero_personas=" + numero_personas + ", nombre_habitacion=" + nombre_habitacion + ", precio_noche=" + precio_noche + '}';
    }
    
    
}
