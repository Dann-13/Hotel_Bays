/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dann-dev
 */
public class Conexion {

    private static final String DB_ENV_FILE_PATH = "./"; // Ubicación del archivo .env
    private static final String DB_ENV_FILE_NAME = ".env"; // Nombre del archivo .env
    private static final String DB_USER_KEY = "USUARIO";
    private static final String DB_URL_KEY = "JDBCURL";
    private static final String DB_PASSWORD_KEY = "PASSWORD";
    
    private static Conexion instancia;
    Connection con;
    private HikariDataSource dataSource;

    public Conexion() {
        Dotenv dotenv = Dotenv.configure().directory(DB_ENV_FILE_PATH).load();

        String user = dotenv.get(DB_USER_KEY);
        String url = dotenv.get(DB_URL_KEY);
        String password = dotenv.get(DB_PASSWORD_KEY);
        
        HikariConfig config = new HikariConfig();
        
        config.setJdbcUrl(url);
        config.setUsername(user);
        config.setPassword(password);
        dataSource = new HikariDataSource(config);
        System.out.println("Conexión exitosa a la base de datos");
    }
    
    public static Conexion getInstance() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public void cerrarConexion(Connection connection, PreparedStatement stmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Conexión cerrada");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
