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

    /**
     *
     * @return
     */
    public ArrayList<Reservation> obtenerReservas() {
        ArrayList<Reservation> reservas = new ArrayList<>();
        String query = "SELECT * FROM reservations";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id_reservation = rs.getInt("id_reservation");
                int id_client = rs.getInt("id_client");
                Date check_in_date = rs.getDate("check_in_date");
                Date check_out_date = rs.getDate("check_out_date");
                String reservation_status = rs.getString("reservation_status");
                String room_type = rs.getString("room_type");
                Reservation reserva = new Reservation(id_reservation, id_client, check_in_date,
                        check_out_date, reservation_status, room_type);
//                reserva.setId_reservation(id_reservation);
//                reserva.setId_client(id_client);
//                reserva.setId_room(id_room);
//                reserva.setCheck_in_date(check_in_date);
//                reserva.setCheck_out_date(check_out_date);
//                reserva.setReservation_status(reservation_status);

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

//    public ArrayList<Reservation> obtenerReservas2() {
//        ArrayList<Reservation> reservas = new ArrayList<>();
//        String query = "SELECT r.id_reservation, c.name AS client_name, r.check_in_date, r.check_out_date, "
//                + "r.reservation_status, r.room_type, COALESCE(SUM(p.total_payment), 0) AS total_payment, "
//                + "p.payment_method "
//                + "FROM reservations r "
//                + "LEFT JOIN clients c ON r.id_client = c.id_client "
//                + "LEFT JOIN payments p ON r.id_reservation = p.id_reservation "
//                + "GROUP BY r.id_reservation, c.name, r.check_in_date, r.check_out_date, "
//                + "r.reservation_status, r.room_type, p.payment_method";
//        try (PreparedStatement stmt = con.prepareStatement(query)) {
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
//                int id_reservation = rs.getInt("id_reservation");
//                String client_name = rs.getString("client_name");
//                Date check_in_date = rs.getDate("check_in_date");
//                Date check_out_date = rs.getDate("check_out_date");
//                String reservation_status = rs.getString("reservation_status");
//                String room_type = rs.getString("room_type");
//                BigDecimal total_payment = rs.getBigDecimal("total_payment");
//                String payment_method = rs.getString("payment_method");
//
//                Reservation reserva = new Reservation(id_reservation, client_name, check_in_date, check_out_date,
//                        reservation_status, room_type, total_payment, payment_method);
//
//                reservas.add(reserva);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            // Cerrar la conexión después de leer todos los datos del ResultSet
//            cerrarConexion();
//        }
//
//        return reservas;
//    }

    public boolean updateReservation(Reservation reservation) {

        String query = "UPDATE reservations SET id_client = ?, "
                + "check_in_date = ?, check_out_date = ?, reservation_status = ? , room_type = ?"
                + "WHERE id_reservation = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, reservation.getId_client());
            ps.setDate(2, new java.sql.Date(reservation.getCheck_in_date().getTime()));
            ps.setDate(3, new java.sql.Date(reservation.getCheck_out_date().getTime()));
            ps.setString(4, reservation.getReservation_status());
            ps.setString(5, reservation.getRoom_type());
            ps.setInt(6, reservation.getId_reservation());

            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.out.println(reservation.getId_reservation());
            System.out.println(reservation.getId_client());
            System.out.println(reservation.getCheck_in_date());
            System.out.println(reservation.getCheck_out_date());
            System.out.println(reservation.getReservation_status());
            System.out.println(reservation.getRoom_type());
            System.err.println("Error al actualizar la reserva: " + e.getMessage());
        }
        return false;
    }

    public void cerrarConexion() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
                System.out.println("Conexión cerrada en HabitacionDAO");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
