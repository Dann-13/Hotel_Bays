/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dao.AdministradorDAO;
import dao.HabitacionDAO;
import java.sql.Connection;
import java.sql.SQLException;
import models.Administrador;

/**
 *
 * @author dann-dev
 */
public class AdministradorController {

    private AdministradorDAO administradorDAO;
    private Connection con;

    public AdministradorController(Connection con) {
        this.con = con;
        administradorDAO = new AdministradorDAO(con);
    }

    public void registrarAdmin(String Name, String Email, String UserName, String Password) throws SQLException {
        int numAdmin = administradorDAO.numeroAdministradoresRegistrados();
        if (numAdmin != 1) {
            Administrador nuevoAdministrador = new Administrador(Name, Email, UserName, Password, "administrador de contenido");
            administradorDAO.registrarAdministrador(nuevoAdministrador);
            administradorDAO.cerrarConexion();
        }else{
            Administrador nuevoAdministrador = new Administrador(Name, Email, UserName, Password, "administrador principal");
            administradorDAO.registrarAdministrador(nuevoAdministrador);
            administradorDAO.cerrarConexion();
        }

    }
    
    public boolean verificarAdministrador(String Email, String Password){
       boolean result = administradorDAO.iniciarSesion(Email, Password);
       administradorDAO.cerrarConexion();
       return result;
    }
    
   
}
