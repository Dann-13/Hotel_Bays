/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dao.ReservationDao;
import dao.UsuariosDao;
import java.sql.Connection;
import java.util.ArrayList;
import models.Usuario;

/**
 *
 * @author dan-dev
 */
public class UsuarioController {
    private Connection con;
    private UsuariosDao usuariosDao;
    public UsuarioController(Connection con) {
        this.con = con;
        usuariosDao = new UsuariosDao(con);
    }
    
    public ArrayList<Usuario>obtenerUsuario(){
        return usuariosDao.obtenerClientes();
    }
}
