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
import java.util.ArrayList;
import models.Habitacion;
import utils.Conexion;

/**
 *
 * @author dann-dev
 */
public class HabitacionDAO {

    private Connection con;

    public HabitacionDAO(Connection con) {
        this.con = con;
    }

    public ArrayList<Habitacion> obtenerHabitaciones() {
        ArrayList<Habitacion> habitaciones = new ArrayList<>();

        String query = "SELECT * FROM habitaciones";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_habitacion");
                String tipo = rs.getString("tipo");
                int numeroPersonas = rs.getInt("numero_personas");
                String nombreHabitacion = rs.getString("nombre_habitacion");
                double precio = rs.getDouble("precio_noche");
                Habitacion habitacion = new Habitacion(id, tipo, numeroPersonas, nombreHabitacion, precio);
                habitaciones.add(habitacion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        

        return habitaciones;

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
