/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dao.HabitacionDAO;
import java.awt.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Habitacion;
import utils.Conexion;

/**
 *
 * @author dann-dev
 */
public class HabitacionController {

    private HabitacionDAO habitacionDAO;
    private Connection con;

    public HabitacionController(Connection con) {
        this.con = con;
        habitacionDAO = new HabitacionDAO(con);
    }

    public void imprimirHabitaciones() {
        try {
            ArrayList<Habitacion> habitaciones = habitacionDAO.obtenerHabitaciones();
            for (Habitacion habitacion : habitaciones) {
                System.out.println(habitacion.getId_habitacion() + " - " + habitacion.getTipo() + " - "
                        + habitacion.getNumero_personas() + "-" + habitacion.getNombre_habitacion() +" - " + habitacion.getPrecio_noche());
            }
            habitacionDAO.cerrarConexion(); // Cerrar la conexión después de usarla
        } catch (Exception e) {
            e.printStackTrace(); // Mostrar la excepción en la consola
        }
    }

}
