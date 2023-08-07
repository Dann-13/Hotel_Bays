/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views.VistasJPanel.VistaMenuUsuario;

import controllers.ReservationController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.List;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import models.Reservation;
import utils.Colores;
import utils.Conexion;
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
