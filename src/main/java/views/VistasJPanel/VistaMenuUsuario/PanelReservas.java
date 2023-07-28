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
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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

/**
 *
 * @author dan-dev
 */
public class PanelReservas extends JPanel {

    private JTable table;
    private DefaultTableModel tableModel;
    private ReservationController reservationController;
    EdicionReservas jpanelEdicion;
    JLabel lblTitulo;

    public PanelReservas() {
        this.inicializador();
        this.inicializadorObjetos();
        this.inicializadorEventos();
    }

    private void inicializador() {
        this.setBackground(Color.white);
        this.setLayout(new BorderLayout());
    }

    private void inicializadorObjetos() {
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();
        ReservationController reservationController = new ReservationController(con);

        lblTitulo = new JLabel("Lista De Reservas", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setBackground(Colores.MORADO_BASE);
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setOpaque(true);
        // Agregar más espacio al JLabel del título (10 píxeles en la parte superior e inferior)
        int topPadding = 20;
        int bottomPadding = 20;
        int leftPadding = 0;
        int rightPadding = 0;
        lblTitulo.setBorder(new EmptyBorder(topPadding, leftPadding, bottomPadding, rightPadding));
        this.add(lblTitulo, BorderLayout.NORTH);

        //Tabla 
        String[] columnNames = {"ID Reserva", "ID Cliente", "ID Habitación",
            "Check-in", "Check-out", "Estado"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);

        ArrayList<Reservation> reservations = reservationController.obtenerReservas();
        for (Reservation reservation : reservations) {
            Object[] rowData = {
                reservation.getId_reservation(),
                reservation.getId_client(),
                reservation.getId_room(),
                reservation.getCheck_in_date(),
                reservation.getCheck_out_date(),
                reservation.getReservation_status()
            };
            tableModel.addRow(rowData);
        }
        // Cambiar el color de fondo y color de letra de la fila de títulos (celdas de encabezado)
        table.getTableHeader().setBackground(Colores.MORADO_BASE); // Cambia el color de fondo a tu preferencia
        table.getTableHeader().setForeground(Color.white); // Cambia el color de letra a tu preferencia
        table.getTableHeader().setFont(table.getTableHeader().getFont().deriveFont(Font.BOLD, 15)); // Cambia el tamaño de fuente a tu preferencia

        // Agregar la tabla a un JScrollPane para hacerla desplazable
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane, BorderLayout.SOUTH);

        
        // Establecer el tamaño preferido del panel2
        jpanelEdicion = new EdicionReservas();
        int panel2Height = 350; // Tamaño en píxeles, puedes ajustar este valor según tus necesidades
        jpanelEdicion.setPreferredSize(new Dimension(jpanelEdicion.getWidth(), panel2Height));
        jpanelEdicion.setBackground(Colores.MORADO_BASE);
        this.add(jpanelEdicion, BorderLayout.CENTER);

    }

     private void inicializadorEventos() {
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) { // Asegurarse de que la selección se ha completado
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) { // Asegurarse de que se ha seleccionado una fila
                        // Obtener los datos de la fila seleccionada
                        String idReserva = table.getValueAt(selectedRow, 0).toString();
                        String idCliente = table.getValueAt(selectedRow, 1).toString();
                        String idHabitacion = table.getValueAt(selectedRow, 2).toString();
                        String checkIn = table.getValueAt(selectedRow, 3).toString();
                        String checkOut = table.getValueAt(selectedRow, 4).toString();
                        String estado = table.getValueAt(selectedRow, 5).toString();
                        jpanelEdicion.actualizarDatos(idReserva, idCliente, idHabitacion, checkIn, checkOut, estado);
                    }
                }
            }
        });
    }

}
