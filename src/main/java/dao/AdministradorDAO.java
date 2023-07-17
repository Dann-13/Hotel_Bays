/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            stmt.setString(1, administrador.getName());
            stmt.setString(2, administrador.getUserName());
            stmt.setString(3, administrador.getEmail());
            stmt.setString(4, administrador.getPassword());
            stmt.setString(5, administrador.getRol());
            stmt.executeUpdate();
            System.out.println("Administrador Registrado");
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    /**
     *
     * @return
     */
    public int numeroAdministradoresRegistrados(){
        int numAdministradores = 0;
        String query = "SELECT COUNT(*) FROM administradores";
        try(PreparedStatement stmt = con.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                numAdministradores = rs.getInt(1);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return numAdministradores;
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
