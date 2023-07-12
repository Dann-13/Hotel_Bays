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
    public void registrarAdmin(String Nombre, String Usuario, String Password) throws SQLException{
        Administrador nuevoAdministrador = new Administrador(Nombre, Usuario, Password);
        administradorDAO.registrarAdministrador(nuevoAdministrador);
    }
}
