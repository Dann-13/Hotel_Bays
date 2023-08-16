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
