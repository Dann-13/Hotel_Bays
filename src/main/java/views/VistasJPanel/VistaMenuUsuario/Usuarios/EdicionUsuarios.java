/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views.VistasJPanel.VistaMenuUsuario.Usuarios;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import utils.Colores;

/**
 *
 * @author dan-dev
 */
public class EdicionUsuarios extends JPanel {
    JLabel  lblName, lblAddress, lblPhone, lblCorreo, lblBuscar;
    JTextField txtName, txtAdress, txtPhone, txtCorreo, txtBuscar;
    JButton btnSave, btnDelete, btnAdd, btnShare, btnUpdate;
    TablaUsuarios tablaUsuarios;
    public void setPanelTablaUsuarios(TablaUsuarios tablaUsuarios) {
        this.tablaUsuarios = tablaUsuarios;
    }
    public EdicionUsuarios(){
        this.inicializador();
        this.inicializadorObjetos();
//        this.inicializadorEventos();
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

        btnSave = new JButton("Guardar");
        this.add(btnSave, gbc);

        gbc.gridy = 1; // Fila 1
        this.add(new JButton("Eliminar"), gbc);

        gbc.gridy = 2; // Fila 2
        lblBuscar = new JLabel("Buscar Usuario");

        lblBuscar.setFont(lblName.getFont().deriveFont(Font.BOLD, 15)); // Aumentar tamaño de fuente
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
        btnUpdate = new JButton("Actualizar Reservas");
        this.add(btnUpdate, gbc);
    }
    public void recogerDatos(String nombreUsuario, String direccion, String telefono,
            String email) {

        txtName.setText(nombreUsuario);
        txtAdress.setText(direccion);
        txtPhone.setText(telefono);
        txtCorreo.setText(email);

    }
//    private void inicializadorEventos() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
}