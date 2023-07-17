/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views.VistasJPanel.VIstaRegister;

import controllers.AdministradorController;
import views.VistasJPanel.VistaLoguin.*;
import views.components.labels.JLabelFactory;
import views.components.checkBox.event.PasswordFieldWithCheckbox;
import views.components.jPasswordField.PasswordFieldFactory;
import views.components.textField.JTextFieldFactory;
import views.components.textField.event.TextFieldFocusListener.TextFieldFocusListener;
import views.components.buttons.JButtonsFactory;
import views.components.jPasswordField.event.PasswordFieldCapsLockListener;
import java.awt.Color;
import java.awt.FontFormatException;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import utils.Conexion;
import views.ContenedoresJFrame.ContenedorInicio;

/**
 *
 * @author Daniel Panel encargado de contener los los objtos como los botones y
 * logo del formulario a su derecha estara un panel sobre-epuesto que servira
 * para decorar y poner la imagen de la empresa
 */
public class JPanelRegister extends JPanel {

    JLabel lblCorreo, LblImgPanelDerecho, lblBienvenido, lblLogin, LblImgLogoIzquierdo, lblUsuario, lblContrasena, capsLockLabel;
    JTextField TxtUsuario, txtNameUser, txtEmail;
    JButton btnEnviar, btnVolver;
    JPasswordField passwordField;
    JCheckBox showPasswordCheckbox;
    JPanel jPanelIzquierdo, jPanelDerecho;

    private ContenedorInicio mainFrame;

    public JPanelRegister(ContenedorInicio mainFrame) throws FontFormatException, IOException {
        this.mainFrame = mainFrame;
        this.inicializador();
        this.inicializadorObjetos();
        inicializadorEventos();
//
    }

    private void inicializador() {
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.white);
    }

    private void inicializadorObjetos() throws FontFormatException, IOException {

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weighty = 1.0; // Expande los paneles verticalmente

        // ------------Panel de la derecha (65%)----------------
        jPanelDerecho = new JPanel();
        jPanelDerecho.setLayout(null);
        jPanelDerecho.setBackground(Color.WHITE);
        constraints.gridx = 1;
        constraints.weightx = 0.65;

        //Imagen Logo
        LblImgLogoIzquierdo = JLabelFactory.labelStandardImg("./src/main/java/views/resources/images/logoHotel.png", 400, 20, 100, 100);
        jPanelDerecho.add(LblImgLogoIzquierdo);

        //Label Login
        lblLogin = JLabelFactory.labelStandardFont("REGISTRO", 70, 20, 32F, Color.white, new Color(52, 43, 255));
        jPanelDerecho.add(lblLogin);

        //Label Login
        lblUsuario = JLabelFactory.labelStandardFont("User Name", 70, 110, 23f, Color.WHITE, new Color(52, 43, 255));
        jPanelDerecho.add(lblUsuario);

        //Caja del usuario 
        TxtUsuario = JTextFieldFactory.textFieldFactory("", 70, 145, 300, 30, 15, new Color(85, 74, 97));

        TxtUsuario.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        FocusListener focusListener = new TextFieldFocusListener(TxtUsuario, "Ingrese su Nombre de Usuario", Color.GRAY, Color.darkGray);
        TxtUsuario.addFocusListener(focusListener);
        TxtUsuario.requestFocus();
        jPanelDerecho.add(TxtUsuario);

        //label name
        lblUsuario = JLabelFactory.labelStandardFont("Name", 70, 175, 23f, Color.WHITE, new Color(52, 43, 255));
        jPanelDerecho.add(lblUsuario);

        //Caja del usuario nommbre completo
        txtNameUser = JTextFieldFactory.textFieldFactory("", 70, 210, 300, 30, 15, new Color(85, 74, 97));
        txtNameUser.setSelectionStart(0);
        txtNameUser.setSelectionEnd(0);
        txtNameUser.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        FocusListener focusListenerTxtNameUser = new TextFieldFocusListener(txtNameUser, "Ingrese su Nombren Completo", Color.GRAY, Color.darkGray);
        txtNameUser.addFocusListener(focusListenerTxtNameUser);
        txtNameUser.requestFocus();
        jPanelDerecho.add(txtNameUser);

        lblCorreo = JLabelFactory.labelStandardFont("Email", 70, 240, 23f, Color.WHITE, new Color(52, 43, 255));
        jPanelDerecho.add(lblCorreo);

        txtEmail = JTextFieldFactory.textFieldFactory("", 70, 270, 300, 30, 15, new Color(85, 74, 97));
        txtEmail.setSelectionStart(0);
        txtEmail.setSelectionEnd(0);
        txtEmail.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        FocusListener focusListenerTxtEmail = new TextFieldFocusListener(txtEmail, "Ingrese su Correo Electronico", Color.GRAY, Color.darkGray);
        txtEmail.addFocusListener(focusListenerTxtEmail);
        txtEmail.requestFocus();
        jPanelDerecho.add(txtEmail);

        //Label Contraseña
        lblContrasena = JLabelFactory.labelStandardFont("Password", 70, 300, 23f, Color.WHITE, new Color(52, 43, 255));
        jPanelDerecho.add(lblContrasena);

        //Caja contraseña 
        passwordField = PasswordFieldFactory.createPasswordField(70, 330, 300, 30, 18f, Color.gray, '*');
        passwordField.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        //Checbox para ver contraseña 
        showPasswordCheckbox = PasswordFieldWithCheckbox.createCheckboxWithPasswordField(passwordField, 380, 300, 20, 30);
        jPanelDerecho.add(showPasswordCheckbox);

        //Aviso mayus
        capsLockLabel = JLabelFactory.labelStandard("Mayus Activado", 70, 325, 300, 20, Color.WHITE, Color.RED);
        capsLockLabel.setVisible(false);
        PasswordFieldCapsLockListener capsLockListener = new PasswordFieldCapsLockListener(passwordField, capsLockLabel);
        passwordField.addKeyListener(capsLockListener);
        jPanelDerecho.add(passwordField);
        jPanelDerecho.add(capsLockLabel);

        //Boton ingresar
        btnEnviar = new JButton();
        btnEnviar = JButtonsFactory.buttonStandardFont("ENVIAR", 70, 380, 150, 30, 23f, new Color(52, 43, 255));
        jPanelDerecho.add(btnEnviar);

        this.add(jPanelDerecho, constraints);
        // -------------Panel de la izquierda (35%)----------------
        jPanelIzquierdo = new JPanel();
        jPanelIzquierdo.setLayout(null);
        jPanelIzquierdo.setBackground(new Color(52, 43, 255));
        constraints.gridx = 0;
        constraints.weightx = 0.35;
        this.add(jPanelIzquierdo, constraints);

        lblBienvenido = JLabelFactory.labelStandardFont("REGISTRO", 80, 50, 33.0f, new Color(52, 43, 255), Color.WHITE);
        jPanelIzquierdo.add(lblBienvenido);

        LblImgPanelDerecho = JLabelFactory.labelStandardImg("./src/main/java/views/resources/images/imgHotel.png", 7, 100, 280, 280);
        jPanelIzquierdo.add(LblImgPanelDerecho);

        //Boton Volver
        btnVolver = new JButton();
        btnVolver = JButtonsFactory.buttonStandardFont("VOLVER", 70, 400, 150, 30, 16F, new Color(52, 43, 255));
        jPanelIzquierdo.add(btnVolver);

    }

    private void inicializadorEventos() {
        ActionListener escuchaBtnEnviar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //registrarUsuario();
                validarEmail();
                validarCamposVacios();
            }

        };
        btnEnviar.addActionListener(escuchaBtnEnviar);
        ActionListener escuchaBtnVolver = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                escuchaBtnVolverClick();

            }
        };
        btnVolver.addActionListener(escuchaBtnVolver);
    }

    private void registrarUsuario() throws SQLException {
        String Name = TxtUsuario.getText();
        String UserName = txtNameUser.getText();
        String Email = txtEmail.getText();
        char[] password = passwordField.getPassword();
        String Pass = new String(password);
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();
        AdministradorController administradorController = new AdministradorController(con);
        administradorController.registrarAdmin(Name, Email, UserName, Pass);
    }

    private void escuchaBtnVolverClick() {
        mainFrame.showMainPanel();
    }

    private void validarCamposVacios() {
        // Obtener el contenido de los campos de texto
        String campo1 = TxtUsuario.getText();
        System.out.println("campo 1: " + campo1);
        String campo2 = txtEmail.getText();
        System.out.println("campo 2: " + campo2);
        String campo3 = txtNameUser.getText();
        System.out.println("campo 3: " + campo3);

        // Obtener los valores de los placeholders
        String placeholderCampo1 = "Ingrese su Nombre de Usuario";
        String placeholderCampo2 = "Ingrese su Email";
        String placeholderCampo3 = "Ingrese su Nombre";

        // Verificar si los campos están vacíos comparándolos con los placeholders
        if (campo1.equals(placeholderCampo1) || campo2.equals(placeholderCampo2) || campo3.equals(placeholderCampo3)) {
            JOptionPane.showMessageDialog(null, "Ingrese su Usuario");
            
        }
         else {
            // Los campos tienen contenido, proceder con el envío de datos
            // Aquí puedes llamar a tu método de registro en la base de datos
            System.out.println("Todos los campos están completos.");
        }

    }

    private void validarEmail() {
        // Patrón para validar el email
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        // El email a validar
        String email = txtEmail.getText();

        Matcher mather = pattern.matcher(email);

        if (mather.find() == true) {
            System.out.println("El email ingresado es válido.");
        } else {
            System.out.println("El email ingresado es inválido.");
        }
    }

}
