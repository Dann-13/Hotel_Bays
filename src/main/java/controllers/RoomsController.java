/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dao.RoomsDAO;
import exceptions.CustomDaoException;
import java.sql.Connection;
import java.util.ArrayList;
import models.Room;

/**
 *
 * @author dann-dev
 */
public class RoomsController {

    private RoomsDAO habitacionDAO;

    public RoomsController() {
        habitacionDAO = new RoomsDAO();
    }
    public ArrayList<Room>  obtenerHabitaciones()throws CustomDaoException {
        return habitacionDAO.obtenerHabitaciones();
    }
    public boolean actualizarHabitacion(Room room) throws CustomDaoException {
        return habitacionDAO.actualizarHabitacion(room);
    }

}
