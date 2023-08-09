/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.Administrator;
import utils.Conexion;

/**
 *
 * @author dann-dev
 */
public class AdministratorsDAO {

    public void registrarAdministrador(Administrator administrador) throws SQLException {
        String query = "INSERT INTO administrators (name, username, email, password, administrator_type) VALUES (?,?,?,?,?)";
        try (Connection con = Conexion.getInstance().getConnection(); PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, administrador.getName());
            stmt.setString(2, administrador.getUserName());
            stmt.setString(3, administrador.getEmail());
            stmt.setString(4, administrador.getPassword());
            stmt.setString(5, administrador.getAdministrator_type());
            stmt.executeUpdate();
            System.out.println("Administrador Registrado");

        } catch (SQLException e) {
            System.out.println(administrador.toString());
            e.printStackTrace();
        }
    }

    /**
     *
     * @return
     */
    public int numeroAdministradoresRegistrados() {
        int numAdministradores = 0;
        String query = "SELECT COUNT(*) FROM administrators";
        try (Connection con = Conexion.getInstance().getConnection();
                PreparedStatement stmt = con.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                numAdministradores = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return numAdministradores;
    }

    public boolean iniciarSesion(String Email, String Password) {
        String query = "SELECT * FROM administrators WHERE email=? AND password=?";
        try (Connection con = Conexion.getInstance().getConnection();
                PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, Email);
            stmt.setString(2, Password);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}
