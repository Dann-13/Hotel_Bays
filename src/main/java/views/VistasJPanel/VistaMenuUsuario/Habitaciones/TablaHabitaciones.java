/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views.VistasJPanel.VistaMenuUsuario.Habitaciones;

import controllers.RoomsController;
import exceptions.CustomDaoException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import models.Room;
import utils.Colores;

/**
 *
 * @author dan-dev
 */
public class TablaHabitaciones extends JPanel {

    private JTable table;
    private DefaultTableModel tableModel;
    EdicionHabitaciones edicionHabitaciones;
    RoomsController roomsController;

    public void setEdicionUsuarios(EdicionHabitaciones edicionHabitaciones) {
        this.edicionHabitaciones = edicionHabitaciones;
    }

    public TablaHabitaciones() {
        try {
            this.inicializador();
            this.inicializarTabla();
            this.inicializadorEventos();
        } catch (CustomDaoException e) {
            JOptionPane.showMessageDialog(this, "Error al obtener usuarios", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void inicializador() throws CustomDaoException {
        this.setBackground(Color.white);
        this.setLayout(new BorderLayout());
    }

    private void inicializarTabla() throws CustomDaoException {
        RoomsController roomsController = new RoomsController();

        // Columnas de la tabla
        String[] columnNames = {"ID", "N° Habitacion", "Tipo Habitacion", "Capacidad", "Precio Noche", "Url img"};

        // Crear el TableModel con los nombres de las columnas
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Crear la tabla con el TableModel
        table = new JTable(tableModel);

        // Permitir ajuste de ancho de columnas arrastrando
        table.getTableHeader().setResizingAllowed(true);
        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setResizable(true);
        }
        // Actualizar los títulos de columna con saltos de línea
        TableColumnModel columnModel = table.getColumnModel();
        for (int i = 0; i < columnNames.length; i++) {
            TableColumn column = columnModel.getColumn(i);
            if (columnNames[i].equals("Tipo Habitacion")) {
                column.setHeaderValue("<html>Tipo <br> Habitacion </html>");
            } else if (columnNames[i].equals("Precio Noche")) {
                column.setHeaderValue("<html>Precio<br>Noche</html>");
            }
        }
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setReorderingAllowed(false);

        try {
            // Listar los usuarios existentes y agregarlos a la tabla
            ArrayList<Room> habitaciones = roomsController.obtenerHabitaciones();
            for (Room habitacion : habitaciones) {
                Object[] rowData = {
                    habitacion.getId_room(),
                    habitacion.getRoom_number(),
                    habitacion.getRoom_type(),
                    habitacion.getCapacity(),
                    habitacion.getPrice_per_night(),
                    habitacion.getImage_url(),
                };
                tableModel.addRow(rowData);
            }
        } catch (CustomDaoException e) {
            throw new CustomDaoException("Error al obtener habitaciones para la tabla", e);
        }
        // Personalizar el aspecto de la tabla
        table.getTableHeader().setBackground(Colores.MORADO_BASE);
        table.getTableHeader().setForeground(Color.white);
        table.getTableHeader().setFont(table.getTableHeader().getFont().deriveFont(Font.BOLD, 15));
        table.setRowHeight(30);
        tableHeader.setPreferredSize(new Dimension(tableHeader.getPreferredSize().width, 50));
        // Agregar la tabla a un JScrollPane para hacerla desplazable
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane, BorderLayout.CENTER);
    }

    private void inicializadorEventos() {
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        int id = (int) table.getValueAt(selectedRow, 0);
                        String numeroHabitacion = table.getValueAt(selectedRow, 1).toString();
                        String tipo = table.getValueAt(selectedRow, 2).toString();
                        int capacidad = (int) table.getValueAt(selectedRow, 3);
                        double precioNoche = (double) table.getValueAt(selectedRow, 4);
                        String image_Url = table.getValueAt(selectedRow, 5).toString();
                        edicionHabitaciones.RecogerDatos(id, numeroHabitacion, tipo, capacidad, precioNoche, image_Url);
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
        roomsController = new RoomsController();
        try {
            // Obtiene una lista de las últimas reservas desde la base de datos
            ArrayList<Room> habitaciones = roomsController.obtenerHabitaciones();
            // Recorre la lista de reservas y agrega cada reserva como una nueva fila en la tabla
            for (Room habitacion : habitaciones) {
                Object[] rowData = {
                    habitacion.getId_room(),
                    habitacion.getRoom_number(),
                    habitacion.getRoom_type(),
                    habitacion.getCapacity(),
                    habitacion.getPrice_per_night(),
                    habitacion.getImage_url(),
                };
                tableModel.addRow(rowData);
            }
        } catch (CustomDaoException e) {
            // Manejar la excepción aquí
            JOptionPane.showMessageDialog(null, "Error al obtener las Habitaciones: " + e.getMessage());

        }

    }

}
