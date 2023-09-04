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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import models.Room;
import utils.Colores;
import views.components.buttons.JButtonsFactory;
import views.components.labels.JLabelFactory;

/**
 *
 * @author dan-dev
 */
public class EdicionHabitaciones extends JPanel {

    TablaHabitaciones tablaHabitaciones;

    JLabel lblRoomNumber, lblRommType, lblCapacity, lblPrice, lblBuscar, lblImgUrl, lblTitle;
    JTextField txtRoomNumber, txtRommType, txtCapacity, txtPrice, txtBuscar, txtid, txtImgUrl;
    JButton btnSave, btnDelete, btnAdd, btnShare, btnUpdate;
    String[] roomOptions = {"Deluxe", "Standard"};
    JComboBox<String> cmbRoomOptions;

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
        GridBagConstraints gbcTitle = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10); 
        gbcTitle.insets = new Insets(5, 10, 5, 10);
        // Columna izquierda
        gbc.anchor = GridBagConstraints.WEST;
        txtid = new JTextField();
        
        // JLabel y JTextField
        lblTitle = JLabelFactory.labelStandardFont("Formulario  Habitaciones", 0, 0, 25f, Colores.MORADO_BASE, Color.WHITE);
        gbcTitle.gridx = 0; // Columna 0
        gbcTitle.gridy = 0; // Fila 0
        gbcTitle.anchor = GridBagConstraints.CENTER;
        gbcTitle.gridwidth = 2; // Indicar que ocupe dos columnas
        this.add(lblTitle, gbcTitle);
        
        
        lblRoomNumber = new JLabel("N° Habitacion:");
        lblRoomNumber.setPreferredSize(new Dimension(150, 20));
        lblRoomNumber.setFont(lblRoomNumber.getFont().deriveFont(Font.BOLD, 15)); // Aumentar tamaño de fuente
        lblRoomNumber.setForeground(Color.WHITE);
        gbc.gridx = 0; // Columna 0
        gbc.gridy = 2; // Fila 0
        this.add(lblRoomNumber, gbc);

        txtRoomNumber = new JTextField();
        txtRoomNumber.setPreferredSize(new Dimension(180, 25));
        gbc.gridx = 1; // Columna 1
        gbc.gridy = 2; // Fila 0
        this.add(txtRoomNumber, gbc);

        //txtIdentify = new JTextField();
        lblRommType = new JLabel("Tipo:");
        lblRommType.setPreferredSize(new Dimension(150, 20));
        lblRommType.setFont(lblRommType.getFont().deriveFont(Font.BOLD, 15)); // Aumentar tamaño de fuente
        lblRommType.setForeground(Color.WHITE);
        gbc.gridx = 0; // Columna 0
        gbc.gridy = 3; // Fila 1
        this.add(lblRommType, gbc);
        
        cmbRoomOptions = new JComboBox<>(roomOptions);
        cmbRoomOptions.setPreferredSize(new Dimension(180, 25));
        gbc.gridx = 1;
        gbc.gridy = 3;
        this.add(cmbRoomOptions, gbc);

        lblCapacity = new JLabel("Capacidad:");
        lblCapacity.setPreferredSize(new Dimension(150, 20));
        lblCapacity.setFont(lblCapacity.getFont().deriveFont(Font.BOLD, 15)); // Aumentar tamaño de fuente
        lblCapacity.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 4;
        this.add(lblCapacity, gbc);

        txtCapacity = new JTextField();
        txtCapacity.setPreferredSize(new Dimension(180, 25));
        gbc.gridx = 1;
        gbc.gridy = 4;
        this.add(txtCapacity, gbc);

        lblPrice = new JLabel("Precio:");
        lblPrice.setPreferredSize(new Dimension(150, 20));
        lblPrice.setFont(lblPrice.getFont().deriveFont(Font.BOLD, 15)); // Aumentar tamaño de fuente
        lblPrice.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 5;
        this.add(lblPrice, gbc);

        txtPrice = new JTextField();
        txtPrice.setPreferredSize(new Dimension(180, 25));
        gbc.gridx = 1;
        gbc.gridy = 5;
        this.add(txtPrice, gbc);
        
        lblImgUrl = new JLabel("Imagen Url:");
        lblImgUrl.setPreferredSize(new Dimension(150, 20));
        lblImgUrl.setFont(lblPrice.getFont().deriveFont(Font.BOLD, 15)); // Aumentar tamaño de fuente
        lblImgUrl.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 6;
        this.add(lblImgUrl, gbc);
        
        txtImgUrl = new JTextField();
        txtImgUrl.setPreferredSize(new Dimension(180, 25));
        gbc.gridx = 1;
        gbc.gridy = 6;
        this.add(txtImgUrl, gbc);
        
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

         btnSave = JButtonsFactory.buttonStandardFont("Guardar Cambios", 0, 0, 0, 0, 15f, Colores.MORADO_BASE);
        btnSave.setPreferredSize(new Dimension(200,35));
        this.add(btnSave, gbc);

        gbc.gridy = 1; // Fila 1
        this.add(new JButton("Eliminar"), gbc);

        gbc.gridy = 2; // Fila 2
        btnAdd = new JButton("Agregar");
        this.add(btnAdd, gbc);

        gbc.gridy = 3; // Fila 3
        lblBuscar = JLabelFactory.labelStandard("Buscar Habitacion", 0, 0, 0, 0, 15f, Colores.MORADO_BASE, Color.WHITE);
        lblBuscar.setPreferredSize(new Dimension(200,35));
        lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);

        lblBuscar.setFont(lblBuscar.getFont().deriveFont(Font.BOLD, 15)); // Aumentar tamaño de fuente
        lblBuscar.setForeground(Color.WHITE);
        this.add(lblBuscar, gbc);

        gbc.gridy = 4; 
        txtBuscar = new JTextField();
        txtBuscar.setPreferredSize(new Dimension(250, 25));
        this.add(txtBuscar, gbc);

        gbc.gridy = 5;
        btnShare = JButtonsFactory.buttonStandardFont("Buscar", 0, 0, 0, 0, 16f, Colores.MORADO_BASE);
        btnShare.setPreferredSize(new Dimension(200,35));
        this.add(btnShare, gbc);

        gbc.gridy = 6;
        btnUpdate = JButtonsFactory.buttonStandardFont("Actualizar Tabla", 0, 0, 0, 0, 16f, Colores.MORADO_BASE);
        btnUpdate.setPreferredSize(new Dimension(200,35));
        this.add(btnUpdate, gbc);
    }

    public void RecogerDatos(int id, String roomNumber, String roomType, int capacity, 
            double pricePerNight, String imgUrl) {
        txtid.setText(String.valueOf(id));
        txtRoomNumber.setText(roomNumber);
        cmbRoomOptions.setSelectedItem(roomType);
        txtCapacity.setText(String.valueOf(capacity));
        txtPrice.setText(String.valueOf(pricePerNight));
        txtImgUrl.setText(imgUrl);

    }

    private void inicializadorEventos() {
        ActionListener escuchaBtnSave = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validarCampos()) {
                    if (actualizarDatos()) {
                        tablaHabitaciones.actualizarTabla();

                    } else {
                        System.out.println("Error");
                    }
                }
            }
        };
        btnSave.addActionListener(escuchaBtnSave);
        
        ActionListener escuchaBtnAdd = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validarCampos()) {
                    if (agregarHabitacion()) {
                        tablaHabitaciones.actualizarTabla();

                    } else {
                        System.out.println("Error");
                    }
                }
            }
        };
        btnAdd.addActionListener(escuchaBtnAdd);
    }

    public boolean actualizarDatos() {
        // Obtener los datos de los campos de texto
        int id = Integer.parseInt(txtid.getText());
        String roomNumber = txtRoomNumber.getText();        
        // Obtener el valor seleccionado del JComboBox 
        Object selectedOptionCmb = cmbRoomOptions.getSelectedItem();
        String selectedValueTypeRoom = selectedOptionCmb.toString();
        
        int capacity = Integer.parseInt(txtCapacity.getText());
        double price = Double.parseDouble(txtPrice.getText());
        String imageUrl = txtImgUrl.getText();

        Room room = new Room(id, roomNumber, selectedValueTypeRoom, capacity, price,imageUrl);
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

    public boolean agregarHabitacion() {
        
        // Obtener los datos de los campos de texto
 
        String roomNumber = txtRoomNumber.getText();
        // Obtener el valor seleccionado del JComboBox 
        Object selectedOptionCmb = cmbRoomOptions.getSelectedItem();
        String selectedValueTypeRoom = selectedOptionCmb.toString();
        int capacity = Integer.parseInt(txtCapacity.getText());
        double price = Double.parseDouble(txtPrice.getText());
        String imageUrl = txtImgUrl.getText();

        Room room = new Room( roomNumber, selectedValueTypeRoom, capacity, price,imageUrl);
        RoomsController roomsController = new RoomsController();

        try {
            boolean actualizado = roomsController.agregarHabitacion(room);
            if (actualizado) {
                JOptionPane.showMessageDialog(null, "¡Agregado correctamente!");
                return actualizado;
            } else {
                JOptionPane.showMessageDialog(null, "Error al Agregar.");
                return actualizado;
            }
        } catch (CustomDaoException e) {
            JOptionPane.showMessageDialog(null, "Error al Agregar: " + e.getMessage());
            return false;
        }
    }

    private boolean validarCampos() {
        if (txtRoomNumber.getText().isEmpty()
                || txtCapacity.getText().isEmpty()
                || txtPrice.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Campos Incompletos", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

}
