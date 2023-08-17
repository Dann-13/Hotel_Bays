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
import java.util.Date;
import javax.sql.DataSource;
import models.Usuario;
import utils.Conexion;

/**
 *
 * @author dan-dev
 */
public class UsuariosDao {

    public ArrayList<Usuario> obtenerClientes() throws CustomDaoException {
        ArrayList<Usuario> clientes = new ArrayList<>();
        String query = "SELECT name, identity_document, date_of_birth, gender, address, city, country, phone, email, username "
                + "FROM clients";
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = Conexion.getInstance().getConnection();
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String identity_document = rs.getString("identity_document");
                Date date_of_birth = rs.getDate("date_of_birth");
                String gender = rs.getString("gender");
                String address = rs.getString("address");
                String city = rs.getString("city");
                String country = rs.getString("country");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String username = rs.getString("username");

                Usuario client = new Usuario(name, identity_document, date_of_birth, gender, address, city, country, phone, email, username);
                clientes.add(client);
                System.out.println(client.toString());
            }
        } catch (SQLException e) {
            throw new CustomDaoException("Error al obtener usuarios", e);
        } finally {
            cerrarRecursos(con, stmt, rs);
        }
        return clientes;
    }

    public boolean actualizarUsuario(Usuario usuario) throws CustomDaoException {
        String query = "UPDATE clients SET name = ?, address = ?, phone = ?, email = ?, username = ? WHERE identity_document = ?";
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = Conexion.getInstance().getConnection();
            stmt = con.prepareStatement(query);
            stmt.setString(1, usuario.getName());
            stmt.setString(2, usuario.getAddress());
            stmt.setString(3, usuario.getPhone());
            stmt.setString(4, usuario.getEmail());
            stmt.setString(5, usuario.getUsername());
            stmt.setString(6, usuario.getIdentity_document());

            int rowsAffected = stmt.executeUpdate();

            return rowsAffected == 1;
        } catch (SQLException e) {
            throw new CustomDaoException("Error al actualizar el usuario", e);
        } finally {
            cerrarRecursos(con, stmt, null);
        }
    }

    public ArrayList<Usuario> buscarUsuarioPorNombre(String nombre) throws CustomDaoException {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String query = "SELECT identity_document, date_of_birth, gender, address, city, country, phone, email, username "
                + "FROM clients WHERE name LIKE ?";

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            con = Conexion.getInstance().getConnection();
            stmt = con.prepareStatement(query);
            stmt.setString(1, "%" + nombre + "%"); // Agregar el nombre como filtro
            rs = stmt.executeQuery();

            while (rs.next()) {
                String identity_document = rs.getString("identity_document");
                Date date_of_birth = rs.getDate("date_of_birth");
                String gender = rs.getString("gender");
                String address = rs.getString("address");
                String city = rs.getString("city");
                String country = rs.getString("country");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String username = rs.getString("username");

                Usuario usuario = new Usuario(nombre, identity_document, date_of_birth, gender, address, city, country, phone, email, username);
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            throw new CustomDaoException("Error al buscar usuario por nombre", e);
        } finally {
            cerrarRecursos(con, stmt, rs);
        }

        return usuarios;
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
