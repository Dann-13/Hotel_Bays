/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dao.AdministratorsDAO;
import exceptions.CustomDaoException;
import models.Administrator;

/**
 *
 * @author dann-dev
 */
public class AdministratorsController {

    private AdministratorsDAO administradorDAO;

    public AdministratorsController() {
        administradorDAO = new AdministratorsDAO();
    }

    public boolean registrarAdministrador(String name, String userName, String email, String password) {
        try {
            // Crear un objeto Administrator con los datos proporcionados este administrador siempre sera de contenido
            Administrator administrator = new Administrator(name, userName, email, password, "contenido");

            // Llamar al método del DAO para registrar el administrador
            return administradorDAO.registrarAdministrador(administrator);
        } catch (CustomDaoException e) {
            // Manejo de excepciones, puedes mostrar un mensaje de error en la interfaz de usuario
            e.printStackTrace();
            return false; // Opcionalmente, puedes lanzar la excepción para un manejo superior
        }
    }

    public boolean verificarAdministrador(String Email, String Password) throws CustomDaoException {
        boolean result = administradorDAO.iniciarSesion(Email, Password);
        return result;
    }

    public Administrator obtenerAdministradorPorEmail(String email) throws CustomDaoException {
        return administradorDAO.obtenerAdministradorPorEmail(email);
    }

}
