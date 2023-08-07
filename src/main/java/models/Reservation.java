/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author dan-dev
 */
public class Reservation {
    private int id_reservation;
    private int id_client;
    private String client_name;
    private Date check_in_date;
    private Date check_out_date;
    private String reservation_status;
    private String room_type;
    private BigDecimal total_payment;
    private String payment_method;

    public Reservation(int id_reservation,int id_cliente, String client_name, Date check_in_date, Date check_out_date, String reservation_status, String room_type, BigDecimal total_payment, String payment_method) {
        this.id_reservation = id_reservation;
        this.id_client = id_cliente;
        this.client_name = client_name;
        this.check_in_date = check_in_date;
        this.check_out_date = check_out_date;
        this.reservation_status = reservation_status;
        this.room_type = room_type;
        this.total_payment = total_payment;
        this.payment_method = payment_method;
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
    

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
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

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public BigDecimal getTotal_payment() {
        return total_payment;
    }

    public void setTotal_payment(BigDecimal total_payment) {
        this.total_payment = total_payment;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    @Override
    public String toString() {
        return "Reservation{" + "id_reservation=" + id_reservation + ", id_client=" + id_client + ", client_name=" + client_name + ", check_in_date=" + check_in_date + ", check_out_date=" + check_out_date + ", reservation_status=" + reservation_status + ", room_type=" + room_type + ", total_payment=" + total_payment + ", payment_method=" + payment_method + '}';
    }

    
    
}
