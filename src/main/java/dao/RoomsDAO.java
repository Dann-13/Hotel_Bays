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
import models.Rooms;
import utils.Conexion;

/**
 *
 * @author dann-dev
 */
public class RoomsDAO {

    private Connection con;

    public RoomsDAO(Connection con) {
        this.con = con;
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
