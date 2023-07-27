/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dao.AdministratorsDAO;
import dao.RoomsDAO;
import java.sql.Connection;
import java.sql.SQLException;
import models.Administrator;

/**
 *
 * @author dann-dev
 */
public class AdministratorsController {

    private AdministratorsDAO administradorDAO;
    private Connection con;

    public AdministratorsController(Connection con) {
        this.con = con;
        administradorDAO = new AdministratorsDAO(con);
    }

    public void registrarAdmin(String Name, String UserName, String Email, String Password) throws SQLException {
        int numAdmin = administradorDAO.numeroAdministradoresRegistrados();
        if (numAdmin != 1) {
            Administrator nuevoAdministrador = new Administrator(Name, UserName, Email, Password, "principal");
            administradorDAO.registrarAdministrador(nuevoAdministrador);
            administradorDAO.cerrarConexion();
        }else{
            Administrator nuevoAdministrador = new Administrator(Name, UserName, Email, Password, "contenido");
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
