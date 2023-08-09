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
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import models.Reservation;
import utils.Conexion;

/**
 *
 * @author dan-dev
 */
public class ReservationDao {

    public ArrayList<Reservation> obtenerReservas() {
        ArrayList<Reservation> reservas = new ArrayList<>();
        String query = "SELECT r.id_reservation, r.id_client, c.name AS client_name, r.check_in_date, r.check_out_date, "
                + "r.reservation_status, r.room_type, p.payment_method "
                + "FROM reservations r "
                + "LEFT JOIN clients c ON r.id_client = c.id_client "
                + "LEFT JOIN payments p ON r.id_reservation = p.id_reservation "
                + "GROUP BY r.id_reservation, r.id_client, c.name, r.check_in_date, r.check_out_date, "
                + "r.reservation_status, r.room_type, p.payment_method";

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            con = Conexion.getInstance().getConnection();
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id_reservation = rs.getInt("id_reservation");
                int id_client = rs.getInt("id_client");
                String client_name = rs.getString("client_name");
                Date check_in_date = rs.getDate("check_in_date");
                Date check_out_date = rs.getDate("check_out_date");
                String reservation_status = rs.getString("reservation_status");
                String room_type = rs.getString("room_type");
                String payment_method = rs.getString("payment_method");

                BigDecimal totalPayment = calcularTotalPayment(check_in_date, check_out_date, room_type);

                Reservation reserva = new Reservation(id_reservation, id_client, client_name, check_in_date, check_out_date,
                        reservation_status, room_type, totalPayment, payment_method);
                reservas.add(reserva);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarRecursos(con, stmt, rs);
        }

        return reservas;
    }

    /**
     * Implementa aquí la lógica para calcular el totalPayment basado en el
     * precio por noche y la duración de la estancia. Esto puede requerir
     * consultas adicionales a la base de datos cálculos locales, dependiendo de
     * tu diseño. Retorna el valor calculado como un BigDecimal.
     *
     * @param checkInDate
     * @param checkOutDate
     * @param roomType
     * @return
     */
    private BigDecimal calcularTotalPayment(Date checkInDate, Date checkOutDate, String roomType) {
        BigDecimal ratePerDayDeluxe = new BigDecimal("200"); // Precio por día en BigDecimal
        BigDecimal ratePerDayStandard = new BigDecimal("100"); // Precio por día en BigDecimal

        //obtenemos la los dias entre cada fecha 
        // Convertir a LocalDate utilizando Instant
        LocalDate localCheckInDate = Instant.ofEpochMilli(checkInDate.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        LocalDate localCheckOutDate = Instant.ofEpochMilli(checkOutDate.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        long days = ChronoUnit.DAYS.between(localCheckInDate, localCheckOutDate);
        // Convertir el valor long a BigDecimal para poder hacer la operacion
        BigDecimal daysBigDecimal = BigDecimal.valueOf(days);
        if (roomType.equals("Deluxe")) {
            // Realizar la multiplicación
            BigDecimal totalPayment = daysBigDecimal.multiply(ratePerDayDeluxe);
            System.out.println(totalPayment);
            return totalPayment;
        } else {
            BigDecimal totalPayment = daysBigDecimal.multiply(ratePerDayStandard);
            return totalPayment;
        }
    }

    public boolean actualizarReserva(Reservation reserva) {
        String queryReservations = "UPDATE reservations SET id_client = ?, check_in_date = ?, check_out_date = ?, "
                + "reservation_status = ?, room_type = ? "
                + "WHERE id_reservation = ?";

        String queryClients = "UPDATE clients SET name = ? WHERE id_client = ?";

        String queryPayments = "UPDATE payments SET total_payment = ?, payment_method = ? WHERE id_reservation = ?";

        try (Connection con = Conexion.getInstance().getConnection()) {
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

    public ArrayList<Reservation> buscarReservaCliente(String nombreCliente) {
        ArrayList<Reservation> reservas = new ArrayList<>();
        String query = "SELECT r.id_reservation, r.id_client, c.name AS client_name, r.check_in_date, r.check_out_date, "
                + "r.reservation_status, r.room_type, p.payment_method "
                + "FROM reservations r "
                + "LEFT JOIN clients c ON r.id_client = c.id_client "
                + "LEFT JOIN payments p ON r.id_reservation = p.id_reservation "
                + "WHERE c.name LIKE ?";

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            con = Conexion.getInstance().getConnection();
            stmt = con.prepareStatement(query);
            stmt.setString(1, "%" + nombreCliente + "%"); // Agregar el nombre del cliente como filtro
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id_reservation = rs.getInt("id_reservation");
                int id_client = rs.getInt("id_client");
                String client_name = rs.getString("client_name");
                Date check_in_date = rs.getDate("check_in_date");
                Date check_out_date = rs.getDate("check_out_date");
                String reservation_status = rs.getString("reservation_status");
                String room_type = rs.getString("room_type");
                String payment_method = rs.getString("payment_method");

                BigDecimal totalPayment = calcularTotalPayment(check_in_date, check_out_date, room_type);

                Reservation reserva = new Reservation(id_reservation, id_client, client_name, check_in_date, check_out_date,
                        reservation_status, room_type, totalPayment, payment_method);
                reservas.add(reserva);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarRecursos(con, stmt, rs);
        }

        System.out.println("Resultado de la búsqueda: " + reservas); // Mensaje de depuración
        return reservas;
    }
    
    private void cerrarRecursos(Connection con, PreparedStatement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

   
}
