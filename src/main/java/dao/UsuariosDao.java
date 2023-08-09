/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import models.Usuario;

/**
 *
 * @author dan-dev
 */
public class UsuariosDao {
    private Connection con;
    
    public UsuariosDao(Connection con) {
        this.con = con;
    }
    
    public ArrayList<Usuario> obtenerClientes() {
        ArrayList<Usuario> clientes = new ArrayList<>();
        String query = "SELECT name, identity_document, date_of_birth, gender, address, city, country, phone, email, username "
                + "FROM clients";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
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
            e.printStackTrace();
        }
        return clientes;
    }
}
