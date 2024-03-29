/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import exceptions.CustomDaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Room;
import utils.Conexion;

/**
 *
 * @author dann-dev
 */
public class RoomsDAO {

    public ArrayList<Room> obtenerHabitaciones() throws CustomDaoException {
        ArrayList<Room> habitaciones = new ArrayList<>();
        String query = "SELECT id_room, room_number, room_type, capacity, price_per_night, image_url "
                + "FROM rooms";
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = Conexion.getInstance().getConnection();
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_room");
                String room_number = rs.getString("room_number");
                String room_type = rs.getString("room_type");
                int capacity = rs.getInt("capacity");
                double price_per_night = rs.getDouble("price_per_night");
                String img_url = rs.getString("image_url");

                Room rooms = new Room(id, room_number, room_type, capacity, price_per_night, img_url);
                habitaciones.add(rooms);
            }
        } catch (SQLException e) {
            throw new CustomDaoException("Error al obtener Habitaciones para la tabla", e);
        } finally {
            cerrarRecursos(con, stmt, rs);
            System.out.println("Cerrando Recursos en RoomsDAO Metodo obtenerHabitaciones");
        }
        return habitaciones;
    }

    public boolean actualizarHabitacion(Room room) throws CustomDaoException {
        String query = "UPDATE rooms SET room_number = ?, room_type = ?, capacity = ?, price_per_night = ?, image_url = ? WHERE id_room = ?";
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = Conexion.getInstance().getConnection();
            stmt = con.prepareStatement(query);
            stmt.setString(1, room.getRoom_number());
            stmt.setString(2, room.getRoom_type());
            stmt.setInt(3, room.getCapacity());
            stmt.setDouble(4, room.getPrice_per_night());
            stmt.setString(5, room.getImage_url());
            stmt.setInt(6, room.getId_room());

            int rowsAffected = stmt.executeUpdate();

            return rowsAffected == 1;
        } catch (SQLException e) {
            throw new CustomDaoException("Error al actualizar el usuario", e);
        } finally {
            cerrarRecursos(con, stmt, null);
        }
    }

    /**
     * Agrega una nueva habitación a la base de datos.
     *
     * @param room La habitación a agregar.
     * @return true si la habitación se agregó con éxito, false si no se agregó.
     * @throws CustomDaoException Si ocurre un error durante la inserción.
     */
    public boolean agregarHabitacion(Room room) throws CustomDaoException {
        String query = "INSERT INTO rooms (room_number, room_type, capacity, price_per_night) VALUES (?, ?, ?, ?)";
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = Conexion.getInstance().getConnection();
            stmt = con.prepareStatement(query);
            stmt.setString(1, room.getRoom_number());
            stmt.setString(2, room.getRoom_type());
            stmt.setInt(3, room.getCapacity());
            stmt.setDouble(4, room.getPrice_per_night());

            int rowsAffected = stmt.executeUpdate();

            return rowsAffected == 1;
        } catch (SQLException e) {
            throw new CustomDaoException("Error al agregar la habitación", e);
        } finally {
            cerrarRecursos(con, stmt, null);
        }
    }

    /**
     * Cierra los recursos de conexión, sentencia preparada y conjunto de
     * resultados. Este método asegura que los recursos se cierren adecuadamente
     * y maneja excepciones de SQLException.
     *
     * @param con La conexión a la base de datos que se cerrará.
     * @param stmt La sentencia preparada que se cerrará.
     * @param rs El conjunto de resultados que se cerrará.
     */
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
