/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views.VistasJPanel.VistaMenuUsuario.Reservas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import utils.Colores;
import views.components.labels.JLabelFactory;

/**
 *
 * @author dan-dev
 */
public class EdicionReservas extends JPanel {

    JLabel lblId_reserva, lblId_cliente, lblId_room, lblCheck_in_date, lblCheck_out_date, lblReservation_status;
    JTextField txtId_reserva, txtId_cliente, txtid_room, txtCheck_in_date, txtCheck_out_date, txtReservation_status;

    public EdicionReservas() {
        this.inicializador();
        this.inicializadorEventos();

    }

    private void inicializador() {
        this.setBackground(Colores.MORADO_BASE);
        this.setLayout(null);
    }

    private void inicializadorEventos() {
        lblId_reserva = JLabelFactory.labelStandard("Id Reserva", 66, 10, 150, 20, 15, Colores.MORADO_BASE, Color.WHITE);
        lblId_reserva.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(lblId_reserva);

        txtId_reserva = new JTextField();
        txtId_reserva.setBounds(66, 40, 150, 25);
        this.add(txtId_reserva);

        lblId_cliente = JLabelFactory.labelStandard("Id Cliente", 348, 10, 150, 20, 15, Colores.MORADO_BASE, Color.WHITE);
        lblId_cliente.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(lblId_cliente);

        txtId_cliente = new JTextField();
        txtId_cliente.setBounds(348, 40, 150, 25);
        this.add(txtId_cliente);

        lblId_room = JLabelFactory.labelStandard("Id Habitacion", 630, 10, 150, 20, 15, Colores.MORADO_BASE, Color.WHITE);
        lblId_room.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(lblId_room);

        txtid_room = new JTextField();
        txtid_room.setBounds(630, 40, 150, 25);
        this.add(txtid_room);

        lblCheck_in_date = JLabelFactory.labelStandard("Fecha LLegada", 66, 70, 150, 20, 15, Colores.MORADO_BASE, Color.WHITE);
        lblCheck_in_date.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(lblCheck_in_date);

        txtCheck_in_date = new JTextField();
        txtCheck_in_date.setBounds(66, 90, 150, 25);
        this.add(txtCheck_in_date);

        lblCheck_out_date = JLabelFactory.labelStandard("Fecha Salida", 340, 70, 150, 20, 15, Colores.MORADO_BASE, Color.WHITE);
        lblCheck_out_date.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(lblCheck_out_date);

        txtCheck_out_date = new JTextField();
        txtCheck_out_date.setBounds(348, 90, 150, 25);
        this.add(txtCheck_out_date);

        lblReservation_status = JLabelFactory.labelStandard("Disponibilidad", 630, 70, 150, 20, 15, Colores.MORADO_BASE, Color.WHITE);
        lblReservation_status.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(lblReservation_status);

        txtReservation_status = new JTextField();
        txtReservation_status.setBounds(630, 90, 150, 25);
        this.add(txtReservation_status);

    }

    public void actualizarDatos(String idReserva, String idCliente, String idHabitacion,
            String checkIn, String checkOut, String estado) {
        txtId_reserva.setText(idReserva);
        txtId_cliente.setText(idCliente);
        txtid_room.setText(idHabitacion);
        txtCheck_in_date.setText(checkIn);
        txtCheck_out_date.setText(checkOut);
        txtReservation_status.setText(estado);

    }

}
