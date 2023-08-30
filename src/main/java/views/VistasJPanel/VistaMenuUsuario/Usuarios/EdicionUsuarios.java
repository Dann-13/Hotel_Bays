/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views.VistasJPanel.VistaMenuUsuario.Usuarios;

import controllers.UsuarioController;
import exceptions.CustomDaoException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import models.Usuario;
import utils.Colores;
import views.components.buttons.JButtonsFactory;
import views.components.labels.JLabelFactory;

/**
 *
 * @author dan-dev
 */
public class EdicionUsuarios extends JPanel {

    JLabel lblName, lblAddress, lblPhone, lblCorreo, lblBuscar;
    JTextField txtName, txtAdress, txtPhone, txtCorreo, txtBuscar, txtIdentify;
    JButton btnSave, btnDelete, btnAdd, btnShare, btnUpdate;
    TablaUsuarios tablaUsuarios;

    public void setPanelTablaUsuarios(TablaUsuarios tablaUsuarios) {
        this.tablaUsuarios = tablaUsuarios;
    }

    public EdicionUsuarios() {
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
        // JLabel y JTextField para "Id Reserva"
        lblName = new JLabel("Nombre:");
        lblName.setPreferredSize(new Dimension(150, 20));
        lblName.setFont(lblName.getFont().deriveFont(Font.BOLD, 15)); // Aumentar tamaño de fuente
        lblName.setForeground(Color.WHITE);
        gbc.gridx = 0; // Columna 0
        gbc.gridy = 0; // Fila 0
        this.add(lblName, gbc);

        txtName = new JTextField();
        txtName.setPreferredSize(new Dimension(180, 25));
        gbc.gridx = 1; // Columna 1
        gbc.gridy = 0; // Fila 0
        this.add(txtName, gbc);

        txtIdentify = new JTextField();

        lblAddress = new JLabel("Direccion");
        lblAddress.setPreferredSize(new Dimension(150, 20));
        lblAddress.setFont(lblAddress.getFont().deriveFont(Font.BOLD, 15)); // Aumentar tamaño de fuente
        lblAddress.setForeground(Color.WHITE);
        gbc.gridx = 0; // Columna 0
        gbc.gridy = 1; // Fila 1
        this.add(lblAddress, gbc);

        txtAdress = new JTextField();
        txtAdress.setPreferredSize(new Dimension(180, 25));
        gbc.gridx = 1; // Columna 1
        gbc.gridy = 1; // Fila 1
        this.add(txtAdress, gbc);

        lblPhone = new JLabel("Telefono");
        lblPhone.setPreferredSize(new Dimension(150, 20));
        lblPhone.setFont(lblPhone.getFont().deriveFont(Font.BOLD, 15)); // Aumentar tamaño de fuente
        lblPhone.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 2;
        this.add(lblPhone, gbc);

        txtPhone = new JTextField();
        txtPhone.setPreferredSize(new Dimension(180, 25));
        gbc.gridx = 1;
        gbc.gridy = 2;
        this.add(txtPhone, gbc);

        lblCorreo = new JLabel("Correo");
        lblCorreo.setPreferredSize(new Dimension(150, 20));
        lblCorreo.setFont(lblCorreo.getFont().deriveFont(Font.BOLD, 15)); // Aumentar tamaño de fuente
        lblCorreo.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 3;
        this.add(lblCorreo, gbc);

        txtCorreo = new JTextField();
        txtCorreo.setPreferredSize(new Dimension(180, 25));
        gbc.gridx = 1;
        gbc.gridy = 3;
        this.add(txtCorreo, gbc);

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
        btnDelete =JButtonsFactory.buttonStandardFont("Eliminar", 0, 0, 0, 0, 16f, Colores.MORADO_BASE);
        btnDelete.setPreferredSize(new Dimension(200,35));
        this.add(btnDelete , gbc);

        gbc.gridy = 2; // Fila 2
        lblBuscar = JLabelFactory.labelStandard("Buscar Usuario", 0, 0, 0, 0, 15f, Colores.MORADO_BASE, Color.WHITE);
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

    /**
     * Recoge los datos proporcionados y los muestra en los campos de texto
     * correspondientes en la interfaz. Establece los valores proporcionados en
     * los campos de texto para el nombre del usuario, dirección, teléfono,
     * correo y documento de identidad del usuario.
     *
     * @param nombreUsuario El nombre del usuario a mostrar en el campo de
     * nombre.
     * @param direccion La dirección del usuario a mostrar en el campo de
     * dirección.
     * @param telefono El teléfono del usuario a mostrar en el campo de
     * teléfono.
     * @param email El correo del usuario a mostrar en el campo de correo.
     * @param idIdentify El documento de identidad del usuario a mostrar en el
     * campo de documento de identidad.
     */
    public void recogerDatos(String nombreUsuario, String direccion, String telefono,
            String email, String idIdentify) {

        txtName.setText(nombreUsuario);
        txtAdress.setText(direccion);
        txtPhone.setText(telefono);
        txtCorreo.setText(email);
        txtIdentify.setText(idIdentify);

    }

    /**
     * Metodo que controla los eventos de los botones
     */
    private void inicializadorEventos() {
        ActionListener escuchaBtnSave = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validarCampos()) {
                    if (actualizarDatos()) {
                        tablaUsuarios.actualizarTabla();
                    }
                } else {
                    System.out.println("Error");
                }
            }
        };
        btnSave.addActionListener(escuchaBtnSave);

        ActionListener escuchaBtnBuscar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validarCampoBuscar()) {
                    if (buscarUsuario()) {

                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario no encontrado: ");

                    }
                }
            }
        };
        btnShare.addActionListener(escuchaBtnBuscar);

        ActionListener escuchaBtnUpdate = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tablaUsuarios.actualizarTabla();
            }
        };
        btnUpdate.addActionListener(escuchaBtnUpdate);

    }

    /**
     * Actualiza los datos del usuario con la información ingresada en los
     * campos de texto. Obtiene los valores ingresados en los campos de texto
     * correspondientes al nombre, dirección, teléfono, correo y documento de
     * identidad del usuario. Luego, crea un objeto Usuario con estos valores y
     * llama al controlador de usuarios para realizar la actualización en la
     * base de datos.
     *
     * @return true si los datos del usuario fueron actualizados correctamente,
     * false si ocurrió un error durante la actualización o si no se pudo
     * completar la operación.
     */
    private boolean actualizarDatos() {
        String name = txtName.getText();
        String adress = txtAdress.getText();
        String phone = txtPhone.getText();
        String correo = txtCorreo.getText();
        String identify = txtIdentify.getText();

        Usuario usuario = new Usuario(name, adress, phone, correo, identify);
        UsuarioController usuarioController = new UsuarioController();
        try {
            boolean actualizado = usuarioController.actualizarUsuarios(usuario);
            if (actualizado) {
                JOptionPane.showMessageDialog(null, "¡Actualizado correctamente!");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar.");
                return false;
            }
        } catch (CustomDaoException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar: " + e.getMessage());
            return false;
        }
    }

    /**
     * Valida si los campos de texto correspondientes a los datos del usuario
     * están llenos. Verifica si los campos de nombre, dirección, teléfono,
     * correo y documento de identidad están llenos. Si alguno de estos campos
     * está vacío, muestra un mensaje de advertencia y retorna false. Si todos
     * los campos están llenos, retorna true.
     *
     * @return true si todos los campos están llenos, false si al menos uno de
     * los campos está vacío.
     */
    private boolean validarCampos() {
        if (txtName.getText().isEmpty()
                || txtAdress.getText().isEmpty()
                || txtPhone.getText().isEmpty()
                || txtCorreo.getText().isEmpty()
                || txtIdentify.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Campos Incompletos", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * Metodo que verifica si el campo de busqueda no este vacio
     *
     * @return true si la validacion es correcta
     */
    private boolean validarCampoBuscar() {
        if (txtBuscar.getText().isEmpty() || txtBuscar.getText() == null) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un nombre de cliente válido.", "Campos Incompletos", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * Este metodo es el encargado de traer el nombre del cliente de su
     * jtextfield, el nombre lo envia al metodo del panel TablaUsuarios y lo
     * envia al metodo actualizarTablaBusqueda
     *
     * @return true si encontro un usuario, false si no hay usuarios uso de el y
     * actualize la tabla
     */
    public boolean buscarUsuario() {
        String nombreCliente = txtBuscar.getText();
        System.out.println(nombreCliente);
        boolean actualizacion = tablaUsuarios.actualizarTablaBusqueda(nombreCliente);
        return actualizacion;
    }

}
