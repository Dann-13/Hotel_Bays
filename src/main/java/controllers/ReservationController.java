/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dao.ReservationDao;
import exceptions.CustomDaoException;
import java.util.ArrayList;
import models.Reservation;

/**
 *
 * @author dan-dev
 */
public class ReservationController {

    private ReservationDao reservationDao;

    public ReservationController() {

        reservationDao = new ReservationDao();
    }

    public ArrayList<Reservation> obtenerReservas() throws CustomDaoException{

        return reservationDao.obtenerReservas();

    }

    public boolean actualizarReservation(Reservation reservation)  throws CustomDaoException {
        return reservationDao.actualizarReserva(reservation);
    }
    
    public ArrayList<Reservation> buscarReservaCliente(String nombreCliente)  throws CustomDaoException{
        return reservationDao.buscarReservaCliente(nombreCliente);
    }

}
