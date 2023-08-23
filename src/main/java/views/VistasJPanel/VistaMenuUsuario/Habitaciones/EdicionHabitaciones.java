/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views.VistasJPanel.VistaMenuUsuario.Habitaciones;

import controllers.RoomsController;
import exceptions.CustomDaoException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import models.Room;
import utils.Colores;

/**
 *
 * @author dan-dev
 */
public class EdicionHabitaciones extends JPanel {

    TablaHabitaciones tablaHabitaciones;

    JLabel lblRoomNumber, lblRommType, lblCapacity, lblPrice, lblBuscar;
    JTextField txtRoomNumber, txtRommType, txtCapacity, txtPrice, txtBuscar, txtid;
    JButton btnSave, btnDelete, btnAdd, btnShare, btnUpdate;

    public void setPanelTablaUsuarios(TablaHabitaciones tablaHabitaciones) {
        this.tablaHabitaciones = tablaHabitaciones;
    }

    public EdicionHabitaciones() {
        this.inicializador();
        this.inicializadorObjetos();
        this.inicializadorEventos();

    }

    private void inicializador() {
        this.setBackground(Colores.MORADO_BASE);
        this.setLayout(new GridBagLayout());
    }

    private void inicializadorObjetos() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10); // Márgenes para todos los componentes

        // Columna izquierda
        gbc.anchor = GridBagConstraints.WEST;
        txtid = new JTextField();
        // JLabel y JTextField para "Id Reserva"
        lblRoomNumber = new JLabel("N° Habitacion:");
        lblRoomNumber.setPreferredSize(new Dimension(150, 20));
        lblRoomNumber.setFont(lblRoomNumber.getFont().deriveFont(Font.BOLD, 15)); // Aumentar tamaño de fuente
        lblRoomNumber.setForeground(Color.WHITE);
        gbc.gridx = 0; // Columna 0
        gbc.gridy = 0; // Fila 0
        this.add(lblRoomNumber, gbc);

        txtRoomNumber = new JTextField();
        txtRoomNumber.setPreferredSize(new Dimension(180, 25));
        gbc.gridx = 1; // Columna 1
        gbc.gridy = 0; // Fila 0
        this.add(txtRoomNumber, gbc);

        //txtIdentify = new JTextField();
        lblRommType = new JLabel("Tipo:");
        lblRommType.setPreferredSize(new Dimension(150, 20));
        lblRommType.setFont(lblRommType.getFont().deriveFont(Font.BOLD, 15)); // Aumentar tamaño de fuente
        lblRommType.setForeground(Color.WHITE);
        gbc.gridx = 0; // Columna 0
        gbc.gridy = 1; // Fila 1
        this.add(lblRommType, gbc);

        txtRommType = new JTextField();
        txtRommType.setPreferredSize(new Dimension(180, 25));
        gbc.gridx = 1; // Columna 1
        gbc.gridy = 1; // Fila 1
        this.add(txtRommType, gbc);

        lblCapacity = new JLabel("Capacidad:");
        lblCapacity.setPreferredSize(new Dimension(150, 20));
        lblCapacity.setFont(lblCapacity.getFont().deriveFont(Font.BOLD, 15)); // Aumentar tamaño de fuente
        lblCapacity.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 2;
        this.add(lblCapacity, gbc);

        txtCapacity = new JTextField();
        txtCapacity.setPreferredSize(new Dimension(180, 25));
        gbc.gridx = 1;
        gbc.gridy = 2;
        this.add(txtCapacity, gbc);

        lblPrice = new JLabel("Precio:");
        lblPrice.setPreferredSize(new Dimension(150, 20));
        lblPrice.setFont(lblPrice.getFont().deriveFont(Font.BOLD, 15)); // Aumentar tamaño de fuente
        lblPrice.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 3;
        this.add(lblPrice, gbc);

        txtPrice = new JTextField();
        txtPrice.setPreferredSize(new Dimension(180, 25));
        gbc.gridx = 1;
        gbc.gridy = 3;
        this.add(txtPrice, gbc);

        // Separador vertical
        JSeparator separator = new JSeparator(SwingConstants.VERTICAL);
        separator.setPreferredSize(new Dimension(2, 0));
        gbc.gridx = 2; // Columna 2
        gbc.gridy = 0; // Fila 0
        gbc.gridheight = GridBagConstraints.REMAINDER; // Ocupa todas las filas
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.insets = new Insets(5, 100, 5, 10); // Padding para el separador (derecha)
        this.add(separator, gbc);

        // JButton en la sección derecha
        gbc.gridx = 3; // Columna 3
        gbc.gridy = 0; // Fila 0
        gbc.gridheight = 1; // Volver a un valor predeterminado
        gbc.gridwidth = 1; // Hacer que el botón ocupe 1 columna
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER; // Centro el contenido en la columna
        gbc.insets = new Insets(5, 10, 5, 5); // Ajusta los márgenes izquierdo y derecho del botón

        btnSave = new JButton("Guardar");
        this.add(btnSave, gbc);

        gbc.gridy = 1; // Fila 1
        this.add(new JButton("Eliminar"), gbc);

        gbc.gridy = 2; // Fila 2
        lblBuscar = new JLabel("Buscar Habitacion");

        lblBuscar.setFont(lblBuscar.getFont().deriveFont(Font.BOLD, 15)); // Aumentar tamaño de fuente
        lblBuscar.setForeground(Color.WHITE);
        this.add(lblBuscar, gbc);

        gbc.gridy = 3; // Fila 3
        txtBuscar = new JTextField();
        txtBuscar.setPreferredSize(new Dimension(250, 25));
        this.add(txtBuscar, gbc);

        gbc.gridy = 4;
        btnShare = new JButton("Buscar");
        this.add(btnShare, gbc);

        gbc.gridy = 5;
        btnUpdate = new JButton("Actualizar Tabla");
        this.add(btnUpdate, gbc);
    }

    public void RecogerDatos(int id, String roomNumber, String roomType, int capacity, double pricePerNight) {
        txtid.setText(String.valueOf(id));
        txtRoomNumber.setText(roomNumber);
        txtRommType.setText(roomType);
        txtCapacity.setText(String.valueOf(capacity));
        txtPrice.setText(String.valueOf(pricePerNight));

    }

    private void inicializadorEventos() {
        ActionListener escuchaBtnSave = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (true) {
                    if (actualizarDatos()) {
                        tablaHabitaciones.actualizarTabla();

                    } else {
                        System.out.println("Error");
                    }
                }
            }
        };
        btnSave.addActionListener(escuchaBtnSave);
    }

    public boolean actualizarDatos() {
        // Obtener los datos de los campos de texto
        int id = Integer.parseInt(txtid.getText());
        String roomNumber = txtRoomNumber.getText();
        String roomType = txtRommType.getText();
        int capacity = Integer.parseInt(txtCapacity.getText());
        double price = Double.parseDouble(txtPrice.getText());

        Room room = new Room(id, roomNumber, roomType, capacity, price);
        RoomsController roomsController = new RoomsController();
        try {
            boolean actualizado = roomsController.actualizarHabitacion(room);
            if (actualizado) {
                JOptionPane.showMessageDialog(null, "¡Actualizado correctamente!");
                return actualizado;
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualiza.");
                return actualizado;
            }
        } catch (CustomDaoException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar: " + e.getMessage());
            return false;
        }
    }

}
