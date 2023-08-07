/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.awt.List;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import models.Reservation;

/**
 *
 * @author dan-dev
 */
public class ReservationDao {

    private Connection con;

    public ReservationDao(Connection con) {
        this.con = con;
    }

    public ArrayList<Reservation> obtenerReservas() {
        ArrayList<Reservation> reservas = new ArrayList<>();
        String query = "SELECT r.id_reservation, r.id_client, c.name AS client_name, r.check_in_date, r.check_out_date, "
                + "r.reservation_status, r.room_type, COALESCE(SUM(p.total_payment), 0) AS total_payment, "
                + "p.payment_method "
                + "FROM reservations r "
                + "LEFT JOIN clients c ON r.id_client = c.id_client "
                + "LEFT JOIN payments p ON r.id_reservation = p.id_reservation "
                + "GROUP BY r.id_reservation, r.id_client, c.name, r.check_in_date, r.check_out_date, "
                + "r.reservation_status, r.room_type, p.payment_method";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id_reservation = rs.getInt("id_reservation");
                int id_client = rs.getInt("id_client");
                String client_name = rs.getString("client_name");
                Date check_in_date = rs.getDate("check_in_date");
                Date check_out_date = rs.getDate("check_out_date");
                String reservation_status = rs.getString("reservation_status");
                String room_type = rs.getString("room_type");
                BigDecimal total_payment = rs.getBigDecimal("total_payment");
                String payment_method = rs.getString("payment_method");

                Reservation reserva = new Reservation(id_reservation, id_client, client_name, check_in_date, check_out_date,
                        reservation_status, room_type, total_payment, payment_method);
                reservas.add(reserva);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar la conexión después de leer todos los datos del ResultSet
            cerrarConexion();
        }

        return reservas;
    }

    public boolean actualizarReserva(Reservation reserva) {
        String queryReservations = "UPDATE reservations SET id_client = ?, check_in_date = ?, check_out_date = ?, "
                + "reservation_status = ?, room_type = ? "
                + "WHERE id_reservation = ?";

        String queryClients = "UPDATE clients SET name = ? WHERE id_client = ?";

        String queryPayments = "UPDATE payments SET total_payment = ?, payment_method = ? WHERE id_reservation = ?";

        try {
            // Actualizar datos en la tabla 'reservations'
            try (PreparedStatement psReservations = con.prepareStatement(queryReservations)) {
                psReservations.setInt(1, reserva.getId_client());
                psReservations.setDate(2, new java.sql.Date(reserva.getCheck_in_date().getTime()));
                psReservations.setDate(3, new java.sql.Date(reserva.getCheck_out_date().getTime()));
                psReservations.setString(4, reserva.getReservation_status());
                psReservations.setString(5, reserva.getRoom_type());
                psReservations.setInt(6, reserva.getId_reservation());

                psReservations.executeUpdate();
            }

            // Actualizar datos en la tabla 'clients'
            try (PreparedStatement psClients = con.prepareStatement(queryClients)) {
                psClients.setString(1, reserva.getClient_name());
                psClients.setInt(2, reserva.getId_client());

                psClients.executeUpdate();
            }

            // Actualizar datos en la tabla 'payments'
            try (PreparedStatement psPayments = con.prepareStatement(queryPayments)) {
                psPayments.setBigDecimal(1, reserva.getTotal_payment());
                psPayments.setString(2, reserva.getPayment_method());
                psPayments.setInt(3, reserva.getId_reservation());

                psPayments.executeUpdate();
            }

            return true; // Si todo se actualiza correctamente, retornar true
        } catch (SQLException e) {
            System.err.println("Error al actualizar la reserva: " + e.getMessage());
        }
        return false; // Si hay algún error, retornar false
    }

    public void cerrarConexion() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
                System.out.println("Conexión cerrada en Reservation");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
