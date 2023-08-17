/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dao.UsuariosDao;
import exceptions.CustomDaoException;
import java.util.ArrayList;
import models.Usuario;

/**
 *
 * @author dan-dev
 */
public class UsuarioController {

    private UsuariosDao usuariosDao;

    public UsuarioController() {
        usuariosDao = new UsuariosDao(); 
    }
    

    public ArrayList<Usuario> obtenerUsuario()throws CustomDaoException {
        return usuariosDao.obtenerClientes();
    }
    public boolean actualizarUsuarios(Usuario usuario) throws CustomDaoException {
        return usuariosDao.actualizarUsuario(usuario);
    }
    
    public ArrayList<Usuario> buscarUsuario(String nombre) throws CustomDaoException{
        return usuariosDao.buscarUsuarioPorNombre(nombre);
    }
    
    
}
