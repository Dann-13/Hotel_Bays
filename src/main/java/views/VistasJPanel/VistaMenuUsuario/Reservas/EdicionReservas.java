/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views.VistasJPanel.VistaMenuUsuario.Reservas;

import com.toedter.calendar.JDateChooser;
import controllers.ReservationController;
import exceptions.CustomDaoException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import models.Reservation;
import utils.Colores;
import utils.Conexion;
import views.components.buttons.JButtonsFactory;
import views.components.labels.JLabelFactory;

/**
 *
 * @author dan-dev
 */
public class EdicionReservas extends JPanel {

    JLabel lblTitle, lblClient_name, lblCheck_in_date, lblCheck_out_date, lblReservation_status,
            lblRoom_type, lblTotal_payment, lblPayment_method, lblBuscar;
    JTextField txtId_reserva, txtClientName, txtTotal_payment, txtBuscar, txtIdClient;
    JButton btnSave, btnDelete, btnAdd, btnShare, btnUpdate;
    JDateChooser checkInDatePicker, checkOutDatePicker;
    //ComboBox's
    String[] disponibilidadOptions = {"pendiente", "confirmada"};
    JComboBox<String> cmbReservation_status;

    String[] typeRooms = {"Standard", "Deluxe"};
    JComboBox<String> cmbTypeRooms;

    String[] metodo_payment = {"efectivo", "targeta"};
    JComboBox<String> cmbMetodo_payment;

    private TablaReservas tablaReservas;

    public void setPanelTablaReservas(TablaReservas tablaReservas) {
        this.tablaReservas = tablaReservas;
    }

    public EdicionReservas() {
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
        gbc.insets = new Insets(5, 10, 5, 10); // Márgenes para todos los componentes
        gbcTitle.insets = new Insets(5, 10, 5, 10); // Márgenes para todos los componentes

        txtIdClient = new JTextField("");

        // Columna izquierda
        gbc.anchor = GridBagConstraints.WEST;
        // JLabel y JTextField para "Title"

        lblTitle = JLabelFactory.labelStandardFont("Formulario  Reserva", 0, 0, 25f, Colores.MORADO_BASE, Color.WHITE);
        gbcTitle.gridx = 0; // Columna 0
        gbcTitle.gridy = 0; // Fila 0
        gbcTitle.anchor = GridBagConstraints.CENTER;
        gbcTitle.gridwidth = 2; // Indicar que ocupe dos columnas
        this.add(lblTitle, gbcTitle);

        txtId_reserva = new JTextField();

        // JLabel y JTextField para "Id Cliente"
        lblClient_name = JLabelFactory.labelStandard("Cliente:", 0, 0, 150, 20, 15f, Colores.MORADO_BASE, Color.WHITE);
        gbc.gridx = 0; // Columna 0
        gbc.gridy = 1; // Fila 1
        this.add(lblClient_name, gbc);

        txtClientName = new JTextField();
        txtClientName.setPreferredSize(new Dimension(180, 25));
        gbc.gridx = 1; // Columna 1
        gbc.gridy = 1; // Fila 1
        this.add(txtClientName, gbc);

        lblCheck_in_date = JLabelFactory.labelStandard("Fecha Llegada", 0, 0, 150, 20, 15f, Colores.MORADO_BASE, Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 2;
        this.add(lblCheck_in_date, gbc);

        checkInDatePicker = new JDateChooser();
        checkInDatePicker.setPreferredSize(new Dimension(180, 25));
        gbc.gridx = 1;
        gbc.gridy = 2;
        this.add(checkInDatePicker, gbc);

        lblCheck_out_date = JLabelFactory.labelStandard("Fecha Salida", 0, 0, 150, 20, 15f, Colores.MORADO_BASE, Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 3;
        this.add(lblCheck_out_date, gbc);

        checkOutDatePicker = new JDateChooser();
        checkOutDatePicker.setPreferredSize(new Dimension(180, 25));
        gbc.gridx = 1;
        gbc.gridy = 3;
        this.add(checkOutDatePicker, gbc);

        lblReservation_status = JLabelFactory.labelStandard("Estado Reserva", 0, 0, 150, 20, 15f, Colores.MORADO_BASE, Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 4;
        this.add(lblReservation_status, gbc);

        cmbReservation_status = new JComboBox<>(disponibilidadOptions);
        cmbReservation_status.setPreferredSize(new Dimension(180, 25));
        gbc.gridx = 1;
        gbc.gridy = 4;
        this.add(cmbReservation_status, gbc);

        lblRoom_type = JLabelFactory.labelStandard("Tipo de Habitacion", 0, 0, 150, 20, 15f, Colores.MORADO_BASE, Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 5;
        this.add(lblRoom_type, gbc);

        cmbTypeRooms = new JComboBox<>(typeRooms);
        cmbTypeRooms.setPreferredSize(new Dimension(180, 25));
        gbc.gridx = 1;
        gbc.gridy = 5;
        this.add(cmbTypeRooms, gbc);

        txtTotal_payment = new JTextField(10);

        lblPayment_method = JLabelFactory.labelStandard("Metodo", 0, 0, 150, 20, 15f, Colores.MORADO_BASE, Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 7;
        this.add(lblPayment_method, gbc);

        cmbMetodo_payment = new JComboBox<>(metodo_payment);
        cmbMetodo_payment.setPreferredSize(new Dimension(180, 25));
        gbc.gridx = 1;
        gbc.gridy = 7;
        this.add(cmbMetodo_payment, gbc);

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
        gbc.gridy = 1; // Fila 0
        gbc.gridheight = 1; // Volver a un valor predeterminado
        gbc.gridwidth = 1; // Hacer que el botón ocupe 1 columna
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER; // Centro el contenido en la columna
        gbc.insets = new Insets(5, 10, 5, 5); // Ajusta los márgenes izquierdo y derecho del botón

        btnSave = JButtonsFactory.buttonStandardFont("Guardar Cambios", 0, 0, 0, 0, 15f, Colores.MORADO_BASE);
        btnSave.setPreferredSize(new Dimension(200,35));
        this.add(btnSave, gbc);
        
        gbc.gridy = 2; // Fila 2
        lblBuscar = JLabelFactory.labelStandard("Buscar Reserva", 0, 0, 0, 0, 15f, Colores.MORADO_BASE, Color.WHITE);
        lblBuscar.setPreferredSize(new Dimension(200,35));
        lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(lblBuscar, gbc);

        gbc.gridy = 3; // Fila 3
        txtBuscar = new JTextField();
        txtBuscar.setPreferredSize(new Dimension(250, 25));
        this.add(txtBuscar, gbc);

        gbc.gridy = 4;
        btnShare = JButtonsFactory.buttonStandardFont("Buscar", 0, 0, 0, 0, 16f, Colores.MORADO_BASE);
        btnShare.setPreferredSize(new Dimension(200,35));
        this.add(btnShare, gbc);

        gbc.gridy = 5;
        btnUpdate = JButtonsFactory.buttonStandardFont("Actualizar Tabla", 0, 0, 0, 0, 16f, Colores.MORADO_BASE);
        btnUpdate.setPreferredSize(new Dimension(200,35));
        this.add(btnUpdate, gbc);

    }

    public void recogerDatos(String idReserva, String idClient, String client_name,
            Date checkIn, Date checkOut, String reservation_status, String room_type,
            String total_payment, String payment_method) {

        txtId_reserva.setText(idReserva);
        txtIdClient.setText(idClient);
        txtClientName.setText(client_name);
        checkInDatePicker.setDate(checkIn);
        checkOutDatePicker.setDate(checkOut);
        // Establecer el valor seleccionado en el JComboBox según el estado de la reserva
        cmbReservation_status.setSelectedItem(reservation_status);
        cmbTypeRooms.setSelectedItem(room_type);
        txtTotal_payment.setText(total_payment);
        cmbMetodo_payment.setSelectedItem(payment_method);

    }

    private void inicializadorEventos() {
        ActionListener escuchaBtnSave = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validarCampos()) {
                    if (actualizarDatos()) {
                        tablaReservas.actualizarTabla();

                    } else {
                        System.out.println("Error");
                    }
                }
            }
        };
        btnSave.addActionListener(escuchaBtnSave);

        ActionListener escuchaBtnShare = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validarCampoBuscar()) {
                    if (buscarReservaCliente()) {

                    } else {
                        JOptionPane.showMessageDialog(null, "Reserva no encontrada: ");

                    }
                } else {
                    System.err.println("Error en la busqueda, campo vacio o null");
                }

            }
        };

        btnShare.addActionListener(escuchaBtnShare);

        ActionListener escuchaBtnUpdate = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tablaReservas.actualizarTabla();
            }
        };
        btnUpdate.addActionListener(escuchaBtnUpdate);
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

        // Obtener los datos de los campos de texto
        int idReserva = Integer.parseInt(txtId_reserva.getText());
        String clientName = txtClientName.getText();
        int idCliente = Integer.parseInt(txtIdClient.getText());
        // Obtener las fechas seleccionadas de los JDateChooser
        Date checkInDate = checkInDatePicker.getDate();
        Date checkOutDate = checkOutDatePicker.getDate();
        // Obtener el valor seleccionado del JComboBox 
        Object selectedOptionCmb = cmbReservation_status.getSelectedItem();
        String selectedValue = selectedOptionCmb.toString();

        Object selectedOptionRooms = cmbTypeRooms.getSelectedItem();
        String SelectedRoom = selectedOptionRooms.toString();

        String totalPaymentString = txtTotal_payment.getText();
        BigDecimal totalPayment = new BigDecimal(totalPaymentString);
        System.out.println(totalPayment);
        Object selectedOptionPayment = cmbMetodo_payment.getSelectedItem();
        String SelectedPayment = selectedOptionPayment.toString();

        Reservation reservation = new Reservation(idReserva, idCliente, clientName, checkInDate,
                checkOutDate, selectedValue, SelectedRoom, totalPayment, SelectedPayment);
        ReservationController reservationController = new ReservationController();
        try {
            boolean actualizado = reservationController.actualizarReservation(reservation);
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

    private boolean validarCampos() {
        if (txtId_reserva.getText().isEmpty()
                || txtIdClient.getText().isEmpty()
                || txtClientName.getText().isEmpty()
                || txtTotal_payment.getText().isEmpty()
                || checkInDatePicker.getDate() == null
                || checkOutDatePicker.getDate() == null
                || cmbReservation_status.getSelectedItem() == null
                || cmbReservation_status.getSelectedItem().toString().isEmpty()
                || cmbTypeRooms.getSelectedItem().toString().isEmpty()
                || txtTotal_payment.getText().isEmpty()
                || cmbMetodo_payment.getSelectedItem().toString().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Campos Incompletos", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
    /**
     * Valida el campo buscar
     * @return false si el admin no ingreso campos de texto
     */
    private boolean validarCampoBuscar() {
        if (txtBuscar.getText().isEmpty() || txtBuscar.getText() == null) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un nombre de cliente válido.", "Campos Incompletos", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * Busca reservas de un cliente específico en la tabla de reservas. Obtiene
     * el nombre del cliente desde el campo de búsqueda en la interfaz. Luego,
     * llama al método para actualizar la tabla con las reservas filtradas por
     * el nombre.
     *
     * @return true si se actualizó la tabla con las reservas del cliente, false
     * si no se encontraron reservas para el cliente y la tabla permaneció sin
     * cambios.
     */
    public boolean buscarReservaCliente() {
        // Obtener el nombre del cliente desde el campo de búsqueda en la interfaz
        String nombreCliente = txtBuscar.getText();
        // Llamar al método para actualizar la tabla con las reservas filtradas por el nombre del cliente
        boolean actualizacion = tablaReservas.actualizarTablaBusqueda(nombreCliente);
        // Retornar true si se actualizó la tabla con las reservas del cliente, o false si no se encontraron
        // reservas para el cliente y la tabla permaneció sin cambios.
        return actualizacion;
    }

}
