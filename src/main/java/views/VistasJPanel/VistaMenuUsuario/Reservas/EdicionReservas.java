/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views.VistasJPanel.VistaMenuUsuario.Reservas;

import com.toedter.calendar.JDateChooser;
import controllers.ReservationController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import models.Reservation;
import utils.Colores;
import utils.Conexion;
import views.VistasJPanel.VistaMenuUsuario.PanelReservas;
import views.components.buttons.JButtonsFactory;
import views.components.labels.JLabelFactory;

/**
 *
 * @author dan-dev
 */
public class EdicionReservas extends JPanel {

    JLabel lblTitulo, lblId_reserva, lblId_cliente, lblId_room, lblCheck_in_date, lblCheck_out_date, lblReservation_status;
    JTextField txtId_reserva, txtId_cliente, txtType_room, txtReservation_status;
    JButton btnSave, btnDelete, btnAdd;
    JDateChooser checkInDatePicker, checkOutDatePicker;
    String[] disponibilidadOptions = {"pendiente", "confirmada"};
    JComboBox<String> cmbReservation_status;

    public EdicionReservas() {
        this.inicializador();
        this.inicializadorObjetos();
        this.inicializadorEventos();
    }

    private void inicializador() {
        this.setBackground(Colores.MORADO_BASE);
        this.setLayout(null);
    }

    private void inicializadorObjetos() {
        lblTitulo = JLabelFactory.labelStandard("Listado de Reservas", 0, 0, 850 , 50, 20f, Colores.ROJO_DESTACADO, Color.WHITE);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(lblTitulo);
        
        lblId_reserva = JLabelFactory.labelStandard("Id Reserva", 66, 10, 150, 20, 15, Colores.MORADO_BASE, Color.WHITE);
        lblId_reserva.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(lblId_reserva);

        txtId_reserva = new JTextField();
        txtId_reserva.setBounds(66, 40, 150, 25);
        txtId_reserva.setEnabled(false);
        this.add(txtId_reserva);

        lblId_cliente = JLabelFactory.labelStandard("Id Cliente", 348, 10, 150, 20, 15, Colores.MORADO_BASE, Color.WHITE);
        lblId_cliente.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(lblId_cliente);

        txtId_cliente = new JTextField();
        txtId_cliente.setBounds(348, 40, 150, 25);
        txtId_cliente.setEnabled(false);
        this.add(txtId_cliente);

        lblId_room = JLabelFactory.labelStandard("Id Habitacion", 630, 10, 150, 20, 15, Colores.MORADO_BASE, Color.WHITE);
        lblId_room.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(lblId_room);

        txtType_room = new JTextField();
        txtType_room.setBounds(630, 40, 150, 25);
        this.add(txtType_room);

        lblCheck_in_date = JLabelFactory.labelStandard("Fecha LLegada", 66, 70, 150, 20, 15, Colores.MORADO_BASE, Color.WHITE);
        lblCheck_in_date.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(lblCheck_in_date);

        checkInDatePicker = new JDateChooser();
        checkInDatePicker.setBounds(66, 90, 150, 25);
        this.add(checkInDatePicker);

        lblCheck_out_date = JLabelFactory.labelStandard("Fecha Salida", 340, 70, 150, 20, 15, Colores.MORADO_BASE, Color.WHITE);
        lblCheck_out_date.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(lblCheck_out_date);

        checkOutDatePicker = new JDateChooser();
        checkOutDatePicker.setBounds(348, 90, 150, 25);
        this.add(checkOutDatePicker);

        lblReservation_status = JLabelFactory.labelStandard("Disponibilidad", 630, 70, 150, 20, 15, Colores.MORADO_BASE, Color.WHITE);
        lblReservation_status.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(lblReservation_status);

        cmbReservation_status = new JComboBox<>(disponibilidadOptions);
        cmbReservation_status.setBounds(630, 90, 150, 25);
        this.add(cmbReservation_status);

        btnSave = JButtonsFactory.buttonStandardFontImgAndText("Guardar", "./src/main/java/views/resources/images/cheque.png", 100, 140, 150, 30);
        btnSave.setBackground(Color.WHITE);
        btnSave.setOpaque(true);
        btnSave.setForeground(Colores.MORADO_BASE);
        this.add(btnSave);

    }

    public void recogerDatos(String idReserva, String idCliente, String type_room,
            Date checkIn, Date checkOut, String estado) {
        txtId_reserva.setText(idReserva);
        txtId_cliente.setText(idCliente);
        txtType_room.setText(type_room);
        checkInDatePicker.setDate(checkIn);
        checkOutDatePicker.setDate(checkOut);

        // Establecer el valor seleccionado en el JComboBox según el estado de la reserva
        cmbReservation_status.setSelectedItem(estado);

    }

    private void inicializadorEventos() {
        ActionListener escuchaBtnSave = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (actualizarDatos()) {
                    // Si la actualización fue exitosa, llamamos al método para actualizar la tabla en PanelReservas
                    TablaReservas parentPanel = (TablaReservas) EdicionReservas.this.getParent();
                    parentPanel.actualizarTabla();

                } else {
                    System.out.println("Error");
                }
            }
        };
        btnSave.addActionListener(escuchaBtnSave);
    }

    /**
     * Actualiza los datos de una reserva utilizando los valores ingresados en
     * los campos de texto y componentes de la interfaz.
     *
     * @return true si la reserva fue actualizada exitosamente; false en caso
     * contrario.
     *
     *
     */
    public boolean actualizarDatos() {
        if (validarCampos()) {
            // Obtener los datos de los campos de texto
            int idReserva = Integer.parseInt(txtId_reserva.getText());
            int idCliente = Integer.parseInt(txtId_cliente.getText());
            String type_room = txtType_room.getText();
            // Obtener las fechas seleccionadas de los JDateChooser
            Date checkInDate = checkInDatePicker.getDate();
            Date checkOutDate = checkOutDatePicker.getDate();
            // Obtener el valor seleccionado del JComboBox para el estado de la reserva
            Object selectedOptionCmb = cmbReservation_status.getSelectedItem();
            String selectedValue = selectedOptionCmb.toString();
            Reservation reservation = new Reservation(idReserva, idCliente, checkInDate, checkOutDate, selectedValue, type_room);
            Conexion conexion = new Conexion();
            Connection con = conexion.getConnection();
            ReservationController reservationController = new ReservationController(con);
            boolean actualizado = reservationController.actualizarReservation(reservation);
            if (actualizado) {
                JOptionPane.showMessageDialog(null, "¡Actualizado correctamente!");

            } else {
                JOptionPane.showMessageDialog(null, "Error al actualiza.");
            }
            return actualizado;
        } else {
            return false;
        }

    }

    private boolean validarCampos() {
        if (txtId_reserva.getText().isEmpty()
                || txtId_cliente.getText().isEmpty()
                || txtType_room.getText().isEmpty()
                || checkInDatePicker.getDate() == null
                || checkOutDatePicker.getDate() == null
                || cmbReservation_status.getSelectedItem() == null
                || cmbReservation_status.getSelectedItem().toString().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Campos Incompletos", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

}
