/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import models.Administrador;

/**
 *
 * @author dann-dev
 */
public class AdministradorDAO {
    private Connection con;
    
    public AdministradorDAO(Connection con) {
        this.con = con;
    }
    
    public void registrarAdministrador(Administrador administrador) throws SQLException{
        String query = "INSERT INTO administradores (nombre, usuario, password) VALUES (?,?,?)";
        try(PreparedStatement stmt = con.prepareStatement(query)){
            stmt.setString(1, administrador.getNombre());
            stmt.setString(2, administrador.getUsuario());
            stmt.setString(3, administrador.getPassword());
            stmt.executeUpdate();
            System.out.println("Administrador Registrado");
        }catch(SQLException e){
            e.printStackTrace();
        }
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
