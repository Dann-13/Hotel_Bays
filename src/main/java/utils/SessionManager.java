/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import models.Administrator;

/**
 *
 * @author dan-dev
 */
public class SessionManager {
    private static Administrator loggedInAdministrator;

    public static void setLoggedInAdministrator(Administrator administrator) {
        loggedInAdministrator = administrator;
    }

    public static Administrator getLoggedInAdministrator() {
        return loggedInAdministrator;
    }
    public static void cerrarSesion() {
        loggedInAdministrator = null;
    }
}
