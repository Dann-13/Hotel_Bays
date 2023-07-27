/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author dann-dev
 */
public class Conexion {

    Dotenv dotenv = Dotenv.configure().directory("./").load();

    String USER = dotenv.get("USUARIO");
    String URL = dotenv.get("JDBCURL");
    String PASSWORD = dotenv.get("PASSWORD");
    Connection con;

    public Conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            // Imprimir mensaje de conexión exitosa
            System.out.println("Conexión exitosa a la base de datos");
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    public Connection getConnection() {
        return con;
    }
    public void cerrarConexion() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
                System.out.println("Conexión cerrada");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
