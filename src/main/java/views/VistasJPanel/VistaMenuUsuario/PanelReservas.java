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
    EdicionReservas jpanelEdicion;
    JLabel lblTitulo;
    private ReservationController reservationController;

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
        reservationController = new ReservationController(con);

        lblTitulo = new JLabel("Lista De Reservas", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setBackground(Colores.MORADO_BASE);
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setOpaque(true);
        // Agregar más espacio al JLabel del título (10 píxeles en la parte superior e inferior)
        lblTitulo.setBorder(new EmptyBorder(20, 0, 20, 0));
        this.add(lblTitulo, BorderLayout.NORTH);

        //Tabla 
        String[] columnNames = {"ID Reserva", "ID Cliente", "Tipo de Habitacion",
            "Check-in", "Check-out", "Estado"};
        // Bloquear la edición del TableModel asociado a la tabla
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Todas las celdas se vuelven no editables
                return false;
            }
        };
        table = new JTable(tableModel);

        ArrayList<Reservation> reservations = reservationController.obtenerReservas();
        for (Reservation reservation : reservations) {
            Object[] rowData = {
                reservation.getId_reservation(),
                reservation.getId_client(),
                reservation.getRoom_type(),
                reservation.getCheck_in_date(),
                reservation.getCheck_out_date(),
                reservation.getReservation_status()

            };
            tableModel.addRow(rowData);
        }
        // Después de agregar los datos a la tabla, establecer el nuevo TableModel
        table.setModel(tableModel);

        // Cambiar el color de fondo y color de letra de la fila de títulos (celdas de encabezado)
        table.getTableHeader().setBackground(Colores.MORADO_BASE); // Cambia el color de fondo a tu preferencia
        table.getTableHeader().setForeground(Color.white); // Cambia el color de letra a tu preferencia
        table.getTableHeader().setFont(table.getTableHeader().getFont().deriveFont(Font.BOLD, 15)); // Cambia el tamaño de fuente a tu preferencia
        table.setRowHeight(30);
        // Agregar la tabla a un JScrollPane para hacerla desplazable
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane, BorderLayout.SOUTH);

        // Establecer el tamaño preferido del panel2
        jpanelEdicion = new EdicionReservas();
        jpanelEdicion.setPreferredSize(new Dimension(jpanelEdicion.getWidth(), 200));
        jpanelEdicion.setBackground(Colores.MORADO_BASE);
        this.add(jpanelEdicion, BorderLayout.CENTER);

    }

    private void inicializadorEventos() {
        /**
         * *
         * Evento que sirbe ára saber que fila de la tabla a seleccionado el
         * usuario Segun la fila sellecionada se envia esos datos al panel de
         * edicion por medio de recogerDatos() para que actualize los campos de
         * edicion.
         */
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) { // Asegurarse de que la selección se ha completado
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) { // Asegurarse de que se ha seleccionado una fila
                        // Obtener los datos de la fila seleccionada
                        String idReserva = table.getValueAt(selectedRow, 0).toString();
                        String idCliente = table.getValueAt(selectedRow, 1).toString();
                        String type_room = table.getValueAt(selectedRow, 2).toString();
                        Date checkIn = (Date) table.getValueAt(selectedRow, 3);
                        Date checkOut = (Date) table.getValueAt(selectedRow, 4);
                        String estado = table.getValueAt(selectedRow, 5).toString();
                        jpanelEdicion.recogerDatos(idReserva, idCliente, type_room, checkIn, checkOut, estado);
                    }
                }
            }
        });

        //
    }

    /**
     * *
     * Este metodo actualiza la tabla reservas con las ultimas reservas
     * existente en la base de datos a su vez servira para cargar actulizat la
     * tabla cuando se lo requiera (Editar, eliminar etc )
     *
     */
    public void actualizarTabla() {
        tableModel.setRowCount(0); // Limpia todos los datos de la tabla
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();
        reservationController = new ReservationController(con);
        // Obtiene una lista de las últimas reservas desde la base de datos
        ArrayList<Reservation> reservations = reservationController.obtenerReservas();
        // Recorre la lista de reservas y agrega cada reserva como una nueva fila en la tabla
        for (Reservation reservation : reservations) {
            Object[] rowData = {
                reservation.getId_reservation(),
                reservation.getId_client(),
                reservation.getRoom_type(),
                reservation.getCheck_in_date(),
                reservation.getCheck_out_date(),
                reservation.getReservation_status(),};
            tableModel.addRow(rowData);
        }
    }
}
