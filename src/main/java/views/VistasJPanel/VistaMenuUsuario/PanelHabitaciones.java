/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views.VistasJPanel.VistaMenuUsuario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import utils.Colores;
import views.VistasJPanel.VistaMenuUsuario.Habitaciones.EdicionHabitaciones;
import views.VistasJPanel.VistaMenuUsuario.Habitaciones.TablaHabitaciones;

/**
 *
 * @author dan-dev
 */
public class PanelHabitaciones extends JPanel{
    TablaHabitaciones tablaHabitaciones;
    EdicionHabitaciones edicionHabitaciones;
    public PanelHabitaciones(){
        this.inicializador();
        this.inicializadorObjetos();
        
    }

    private void inicializador() {
        this.setBackground(Color.white);
        this.setLayout(new BorderLayout());
        
    }

    private void inicializadorObjetos() {
        tablaHabitaciones = new TablaHabitaciones();
        edicionHabitaciones = new EdicionHabitaciones();
        edicionHabitaciones.setPanelTablaUsuarios(tablaHabitaciones);
        tablaHabitaciones.setEdicionUsuarios(edicionHabitaciones);
        edicionHabitaciones.setPreferredSize(new Dimension(edicionHabitaciones.getWidth(), 300));
        edicionHabitaciones.setBackground(Colores.MORADO_BASE);
        this.add(edicionHabitaciones, BorderLayout.NORTH);
        this.add(tablaHabitaciones, BorderLayout.CENTER);
    }
}
