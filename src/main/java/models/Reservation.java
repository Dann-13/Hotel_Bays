/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Date;

/**
 *
 * @author dan-dev
 */
public class Reservation {
    private int id_reservation;
    private int id_client;
    private int id_room;
    private Date check_in_date;
    private Date check_out_date;
    private String reservation_status;

    public Reservation(int id_reservation, int id_client, int id_room, Date check_in_date, Date check_out_date, String reservation_status) {
        this.id_reservation = id_reservation;
        this.id_client = id_client;
        this.id_room = id_room;
        this.check_in_date = check_in_date;
        this.check_out_date = check_out_date;
        this.reservation_status = reservation_status;
    }

    
    public int getId_reservation() {
        return id_reservation;
    }

    public void setId_reservation(int id_reservation) {
        this.id_reservation = id_reservation;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public int getId_room() {
        return id_room;
    }

    public void setId_room(int id_room) {
        this.id_room = id_room;
    }

    public Date getCheck_in_date() {
        return check_in_date;
    }

    public void setCheck_in_date(Date check_in_date) {
        this.check_in_date = check_in_date;
    }

    public Date getCheck_out_date() {
        return check_out_date;
    }

    public void setCheck_out_date(Date check_out_date) {
        this.check_out_date = check_out_date;
    }

    public String getReservation_status() {
        return reservation_status;
    }

    public void setReservation_status(String reservation_status) {
        this.reservation_status = reservation_status;
    }

    @Override
    public String toString() {
        return "Reservation{" + "id_reservation=" + id_reservation + ", id_client=" + id_client + ", id_room=" + id_room + ", check_in_date=" + check_in_date + ", check_out_date=" + check_out_date + ", reservation_status=" + reservation_status + '}';
    }
    
}
