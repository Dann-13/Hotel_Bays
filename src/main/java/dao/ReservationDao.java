/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.awt.List;
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
                int id_room = rs.getInt("id_room");
                Date check_in_date = rs.getDate("check_in_date");
                Date check_out_date = rs.getDate("check_out_date");
                String reservation_status = rs.getString("reservation_status");

                Reservation reserva = new Reservation(id_reservation, id_client, id_room, check_in_date,
                        check_out_date, reservation_status);
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

    public boolean updateReservation(Reservation reservation) {

        String query = "UPDATE reservations SET id_client = ?, id_room = ?, "
                + "check_in_date = ?, check_out_date = ?, reservation_status = ? "
                + "WHERE id_reservation = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, reservation.getId_client());
            ps.setInt(2, reservation.getId_room());
            ps.setDate(3, new java.sql.Date(reservation.getCheck_in_date().getTime()));
            ps.setDate(4, new java.sql.Date(reservation.getCheck_out_date().getTime()));
            ps.setString(5, reservation.getReservation_status());
            ps.setInt(6, reservation.getId_reservation());

            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.out.println(reservation.getId_reservation());
            System.out.println(reservation.getId_client());
            System.out.println(reservation.getId_room());
            System.out.println(reservation.getCheck_in_date());
            System.out.println(reservation.getCheck_out_date());
            System.out.println(reservation.getReservation_status());
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
