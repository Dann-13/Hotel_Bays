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
import views.VistasJPanel.VistaMenuUsuario.Reservas.EdicionReservas;
import views.VistasJPanel.VistaMenuUsuario.Reservas.TablaReservas;

/**
 *
 * @author dan-dev
 */
public class PanelReservas extends JPanel {

    EdicionReservas jpanelEdicion;
    TablaReservas tablaReservas;

    public PanelReservas() {
        this.inicializador();
        this.inicializadorObjetos();
    }

    private void inicializador() {
        this.setBackground(Color.white);
        this.setLayout(new BorderLayout());
    }

    private void inicializadorObjetos() {

        tablaReservas = new TablaReservas();
        jpanelEdicion = new EdicionReservas();
        jpanelEdicion.setPanelTablaReservas(tablaReservas);
        tablaReservas.setEdicionReservas(jpanelEdicion);
        jpanelEdicion.setPreferredSize(new Dimension(jpanelEdicion.getWidth(), 300));
        jpanelEdicion.setBackground(Colores.MORADO_BASE);
        this.add(jpanelEdicion, BorderLayout.NORTH);
        
        
        this.add(tablaReservas, BorderLayout.CENTER);
        
        


    }

}
