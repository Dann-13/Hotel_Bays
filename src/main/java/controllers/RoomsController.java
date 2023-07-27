/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dao.RoomsDAO;
import java.awt.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Rooms;
import utils.Conexion;

/**
 *
 * @author dann-dev
 */
public class RoomsController {

    private RoomsDAO habitacionDAO;
    private Connection con;

    public RoomsController(Connection con) {
        this.con = con;
        habitacionDAO = new RoomsDAO(con);
    }

    

}
