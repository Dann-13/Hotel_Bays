/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views.VistasJPanel.VistaMenuUsuario.Reservas;

import controllers.ReservationController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import models.Reservation;
import utils.Colores;
import utils.Conexion;

/**
 *
 * @author dan-dev
 */
public class TablaReservas extends JPanel {

    private JTable table;
    private DefaultTableModel tableModel;
    private ReservationController reservationController;
    EdicionReservas jpanelEdicion;

    public void setEdicionReservas(EdicionReservas jpanelEdicion) {
        this.jpanelEdicion = jpanelEdicion;
    }

    public TablaReservas() {
        this.inicializador();
        inicializarTabla();
        this.inicializadorEventos();
    }

    private void inicializador() {
        this.setBackground(Color.white);
        this.setLayout(new BorderLayout());

    }

    private void inicializarTabla() {
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();
        reservationController = new ReservationController(con);
        //Tabla
        String[] columnNames = {"ID Reserva", "Id Cliente", "Cliente", "Fecha Llegada",
            "Fecha Salida", "Estado", "Tipo", "Pago Total", "Metodo"};
        // Bloquear la edición del TableModel asociado a la tabla
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Todas las celdas se vuelven no editables
                return false;
            }
        };
        table = new JTable(tableModel);
        // Actualizar los títulos de columna con saltos de línea
        TableColumnModel columnModel = table.getColumnModel();
        for (int i = 0; i < columnNames.length; i++) {
            TableColumn column = columnModel.getColumn(i);
            if (columnNames[i].equals("Fecha Llegada")){
                column.setHeaderValue("<html>Fecha <br> Llegada </html>");
            }
            else if (columnNames[i].equals("Fecha Salida")) {
                column.setHeaderValue("<html>Fecha<br>Salida</html>");
            } else if (columnNames[i].equals("Pago Total")) {
                column.setHeaderValue("<html>Pago<br>Total</html>");
            }
        }

        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setReorderingAllowed(false);

        ArrayList<Reservation> reservations = reservationController.obtenerReservas();
        for (Reservation reservation : reservations) {
            Object[] rowData = {
                reservation.getId_reservation(),
                reservation.getId_client(),
                reservation.getClient_name(),
                reservation.getCheck_in_date(),
                reservation.getCheck_out_date(),
                reservation.getReservation_status(),
                reservation.getRoom_type(),
                reservation.getTotal_payment(),
                reservation.getPayment_method()
            };
            tableModel.addRow(rowData);
        }

        // Cambiar el color de fondo y color de letra de la fila de títulos (celdas de encabezado)
        table.getTableHeader().setBackground(Colores.MORADO_BASE); // Cambia el color de fondo a tu preferencia
        table.getTableHeader().setForeground(Color.white); // Cambia el color de letra a tu preferencia
        table.getTableHeader().setFont(table.getTableHeader().getFont().deriveFont(Font.BOLD, 15)); // Cambia el tamaño de fuente a tu preferencia
        table.setRowHeight(30);
        tableHeader.setPreferredSize(new Dimension(tableHeader.getPreferredSize().width, 50));
        // Agregar la tabla a un JScrollPane para hacerla desplazable
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane, BorderLayout.CENTER);
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
                        String idClient = table.getValueAt(selectedRow, 1).toString();
                        String clienteName = table.getValueAt(selectedRow, 2).toString();
                        Date checkIn = (Date) table.getValueAt(selectedRow, 3);
                        Date checkOut = (Date) table.getValueAt(selectedRow, 4);
                        String estado = table.getValueAt(selectedRow, 5).toString();
                        String typeRooms = table.getValueAt(selectedRow, 6).toString();
                        String total_payment = table.getValueAt(selectedRow, 7).toString();
                        String metodo_payment = table.getValueAt(selectedRow, 8).toString();

                        jpanelEdicion.recogerDatos(idReserva, idClient, clienteName, checkIn, checkOut,
                                estado, typeRooms, total_payment, metodo_payment);
                    }
                }
            }
        });
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
                reservation.getClient_name(),
                reservation.getCheck_in_date(),
                reservation.getCheck_out_date(),
                reservation.getReservation_status(),
                reservation.getRoom_type(),
                reservation.getTotal_payment(),
                reservation.getPayment_method(),};
            tableModel.addRow(rowData);
        }
    }

    public void actualizarTablaBusqueda(String nombreCliente) {
        tableModel.setRowCount(0); // Limpia todos los datos de la tabla
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();
        reservationController = new ReservationController(con);
        // Obtiene una lista de las últimas reservas desde la base de datos
        ArrayList<Reservation> reservations = reservationController.buscarReservaCliente(nombreCliente);
        // Recorre la lista de reservas y agrega cada reserva como una nueva fila en la tabla
        for (Reservation reservation : reservations) {

            Object[] rowData = {
                reservation.getId_reservation(),
                reservation.getId_client(),
                reservation.getClient_name(),
                reservation.getCheck_in_date(),
                reservation.getCheck_out_date(),
                reservation.getReservation_status(),
                reservation.getRoom_type(),
                reservation.getTotal_payment(),
                reservation.getPayment_method(),};
            tableModel.addRow(rowData);
        }
    }

}
