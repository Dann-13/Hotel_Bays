/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dao.ReservationDao;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import models.Reservation;

/**
 *
 * @author dan-dev
 */
public class ReservationController {

    private ReservationDao reservationDao;
    private Connection con;

    public ReservationController(Connection con) {
        this.con = con;
        reservationDao = new ReservationDao(con);
    }

    public ArrayList<Reservation> obtenerReservas() {

        return reservationDao.obtenerReservas();

    }

    public boolean actualizarReservation(Reservation reservation) {
        return reservationDao.actualizarReserva(reservation);
    }
    
    public ArrayList<Reservation> buscarReservaCliente(String nombreCliente){
        return reservationDao.buscarReservaCliente(nombreCliente);
    }

}
