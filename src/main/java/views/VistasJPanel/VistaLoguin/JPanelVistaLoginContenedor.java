/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views.VistasJPanel.VistaLoguin;

import controllers.AdministratorsController;
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
import views.ContenedoresJFrame.ContenedorMenuUsuario;

/**
 *
 * @author Daniel Panel encargado de contener los los objtos como los botones y
 * logo del formulario a su derecha estara un panel sobre-epuesto que servira
 * para decorar y poner la imagen de la empresa
 */
public class JPanelVistaLoginContenedor extends JPanel {

    JLabel LblImgPanelDerecho, lblBienvenido, lblLogin, LblImgLogoIzquierdo, lblUsuario, lblContrasena, capsLockLabel;
    JTextField TxtUsuario;
    JButton btnIngresar, btnVolver;
    JPasswordField passwordField;
    JCheckBox showPasswordCheckbox;
    JPanel jpanelIzquierdo, jPanelDerecho;

    private ContenedorInicio mainFrame;

    public JPanelVistaLoginContenedor(ContenedorInicio mainFrame) throws FontFormatException, IOException {
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

        // ------------Panel de la derecha (35%)----------------
        jPanelDerecho = new JPanel();
        jPanelDerecho.setLayout(null);
        jPanelDerecho.setBackground(new Color(52, 43, 255));
        constraints.gridx = 1;
        constraints.weightx = 0.35;
        this.add(jPanelDerecho, constraints);

        lblBienvenido = JLabelFactory.labelStandardFont("Bienvenido", 70, 50, 33.0f, new Color(52, 43, 255), Color.WHITE);
        jPanelDerecho.add(lblBienvenido);

        LblImgPanelDerecho = JLabelFactory.labelStandardImg("./src/main/java/views/resources/images/imgHotel.png", 7, 100, 280, 280);
        jPanelDerecho.add(LblImgPanelDerecho);

        //Boton Volver
        btnVolver = new JButton();
        btnVolver = JButtonsFactory.buttonStandardFont("VOLVER", 70, 400, 150, 30, 16F, new Color(52, 43, 255));
        jPanelDerecho.add(btnVolver);

        // -------------Panel de la izquierda (65%)----------------
        jpanelIzquierdo = new JPanel();
        jpanelIzquierdo.setLayout(null);
        jpanelIzquierdo.setBackground(Color.WHITE);
        constraints.gridx = 0;
        constraints.weightx = 0.65;
        this.add(jpanelIzquierdo, constraints);

//        //Imagen Logo
//        LblImgLogoIzquierdo = JLabelFactory.labelStandardImg("./src/main/java/views/resources/images/logoHotel.png", 380, 20, 120, 120);
//        jpanelIzquierdo.add(LblImgLogoIzquierdo);
        //Label Login
        lblLogin = JLabelFactory.labelStandardFont("LOG I N", 70, 50, 37F, Color.white, new Color(52, 43, 255));
        jpanelIzquierdo.add(lblLogin);

        //Label Login
        lblUsuario = JLabelFactory.labelStandardFont("Email", 70, 180, 27f, Color.WHITE, new Color(52, 43, 255));
        jpanelIzquierdo.add(lblUsuario);

        //Caja del usuario 
        TxtUsuario = JTextFieldFactory.textFieldFactory("Ingrese su Correo Electronico", 70, 220, 300, 30, 15, new Color(85, 74, 97));
        TxtUsuario.setSelectionStart(0);
        TxtUsuario.setSelectionEnd(0);
        TxtUsuario.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        FocusListener focusListener = new TextFieldFocusListener(TxtUsuario, "Ingrese su Nombre de Usuario", Color.GRAY, Color.darkGray);
        TxtUsuario.addFocusListener(focusListener);
        jpanelIzquierdo.add(TxtUsuario);

        //Label Contraseña
        lblContrasena = JLabelFactory.labelStandardFont("Password", 70, 270, 23f, Color.WHITE, new Color(52, 43, 255));
        jpanelIzquierdo.add(lblContrasena);

        //Caja contraseña 
        passwordField = PasswordFieldFactory.createPasswordField(70, 300, 300, 30, 18f, Color.gray, '*');
        passwordField.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        //Checbox para ver contraseña 
        showPasswordCheckbox = PasswordFieldWithCheckbox.createCheckboxWithPasswordField(passwordField, 380, 300, 20, 30);
        jpanelIzquierdo.add(showPasswordCheckbox);

        //Aviso mayus
        capsLockLabel = JLabelFactory.labelStandard("Mayus Activado", 70, 325, 300, 20,17f, Color.WHITE, Color.RED);
        capsLockLabel.setVisible(false);
        PasswordFieldCapsLockListener capsLockListener = new PasswordFieldCapsLockListener(passwordField, capsLockLabel);
        passwordField.addKeyListener(capsLockListener);
        jpanelIzquierdo.add(passwordField);
        jpanelIzquierdo.add(capsLockLabel);

        //Boton ingresar
        btnIngresar = new JButton();
        btnIngresar = JButtonsFactory.buttonStandardFont("INGRESAR", 70, 350, 150, 30, 23f, new Color(52, 43, 255));
        jpanelIzquierdo.add(btnIngresar);

    }

    private void inicializadorEventos() {
        ActionListener escuchaBtnIngresar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                if (validarCampos()) {
//                    if (iniciarSesion()) {
//                        escuchaBtnEntrarClick();
//                    } else {
//                        JOptionPane.showMessageDialog(null, "Inicio de Sesion Incorrecto, Usuario o contraseña no validos", "Sesion", JOptionPane.WARNING_MESSAGE);
//                    }
//
//                } else {
//                    System.out.println("Campis no validos ");
//                }
                escuchaBtnEntrarClick();
                
            }

        };
        btnIngresar.addActionListener(escuchaBtnIngresar);
        ActionListener escuchaBtnVolver = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                escuchaBtnVolverClick();
            }
        };
        btnVolver.addActionListener(escuchaBtnVolver);
    }

    private boolean validarCampos() {
        String email = TxtUsuario.getText();
        String pass = new String(passwordField.getPassword());
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        if (esPlaceholder(email) || esPlaceholder(pass)) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            Matcher matcher = pattern.matcher(email);
            if (!matcher.find()) {
                JOptionPane.showMessageDialog(null, "El Correo debe contener un nombre de usuario seguido de un símbolo '@', \n"
                        + "seguido de un dominio y una extensión (por ejemplo, ejemplo@dominio.com)", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            } else {

                return true;
            }

        }

    }

    private boolean esPlaceholder(String texto) {
        // Compara el texto con el contenido del placeholder
        return texto.equals("Ingrese su Nombre de Usuario") || texto.equals("");
    }

//    private boolean iniciarSesion() {
//        String user = TxtUsuario.getText();
//        String pass = new String(passwordField.getPassword());
//        Conexion conexion = new Conexion();
//        Connection con = conexion.getConnection();
//        AdministratorsController administradorController = new AdministratorsController(con);
//        return administradorController.verificarAdministrador(user, pass);
//    }

    private void escuchaBtnEntrarClick() {
        ContenedorMenuUsuario menuUseuario = new ContenedorMenuUsuario();
        menuUseuario.setVisible(true);
        this.mainFrame.dispose();
    }

    private void escuchaBtnVolverClick() {
        mainFrame.showMainPanel();
    }

}
