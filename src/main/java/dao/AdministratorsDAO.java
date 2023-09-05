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
import models.Administrator;
import utils.Conexion;

/**
 *
 * @author dann-dev
 */
public class AdministratorsDAO {

//    public void registrarAdministrador(Administrator administrador) throws SQLException {
//        String query = "INSERT INTO administrators (name, username, email, password, administrator_type) VALUES (?,?,?,?,?)";
//        try (Connection con = Conexion.getInstance().getConnection(); PreparedStatement stmt = con.prepareStatement(query)) {
//            stmt.setString(1, administrador.getName());
//            stmt.setString(2, administrador.getUserName());
//            stmt.setString(3, administrador.getEmail());
//            stmt.setString(4, administrador.getPassword());
//            stmt.setString(5, administrador.getAdministrator_type());
//            stmt.executeUpdate();
//            System.out.println("Administrador Registrado");
//
//        } catch (SQLException e) {
//            System.out.println(administrador.toString());
//            e.printStackTrace();
//        }
//    }
    public boolean registrarAdministrador(Administrator administrador) throws CustomDaoException {
        String query = "INSERT INTO administrators (name, username, email, password, administrator_type) VALUES (?,?,?,?,?)";
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = Conexion.getInstance().getConnection();
            stmt = con.prepareStatement(query);
            stmt.setString(1, administrador.getName());
            stmt.setString(2, administrador.getUserName());
            stmt.setString(3, administrador.getEmail());
            stmt.setString(4, administrador.getPassword());
            stmt.setString(5, administrador.getAdministrator_type());

            int rowsAffected = stmt.executeUpdate(); // Ejecutar la inserción
            System.out.println("Administrador Registrado");

            return rowsAffected == 1;

        } catch (SQLException e) {
            throw new CustomDaoException("Error al registrar el administrador", e);
        } finally {
            cerrarRecursos(con, stmt, null);
        }
    }

    /**
     *
     * @return
     */
    public int numeroAdministradoresRegistrados() {
        int numAdministradores = 0;
        String query = "SELECT COUNT(*) FROM administrators";
        try (Connection con = Conexion.getInstance().getConnection(); PreparedStatement stmt = con.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                numAdministradores = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return numAdministradores;
    }


    public boolean iniciarSesion(String email, String password) throws CustomDaoException {
        String query = "SELECT count(*) as count FROM administrators WHERE email = ? AND password = ?";
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            con = Conexion.getInstance().getConnection();
            stmt = con.prepareStatement(query);
            stmt.setString(1, email);
            stmt.setString(2, password);
            rs = stmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt("count");
                return count == 1; // Si count es 1, se encontró una coincidencia y se inicia sesión
            } else {
                return false; // No se encontraron coincidencias, no se inicia sesión
            }
        } catch (SQLException e) {
            throw new CustomDaoException("Error al iniciar sesión", e);
        } finally {
            cerrarRecursos(con, stmt, rs);
        }
    }
    
    public Administrator obtenerAdministradorPorEmail(String email) throws CustomDaoException {
        Administrator administrator = null;
        String query = "SELECT name, username, administrator_type FROM administrators WHERE email = ?";
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            con = Conexion.getInstance().getConnection();
            stmt = con.prepareStatement(query);
            stmt.setString(1, email);
            rs = stmt.executeQuery();

            if (rs.next()) {
                
                String name = rs.getString("name");
                String username = rs.getString("username");
                String administratorType = rs.getString("administrator_type");

                administrator = new Administrator(name, email, username, administratorType);
            }
        } catch (SQLException e) {
            throw new CustomDaoException("Error al obtener el administrador por correo electrónico", e);
        } finally {
            cerrarRecursos(con, stmt, rs);
        }

        return administrator;
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
