/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VistasJPanel.VistaLoguin;

import Clases.Fuente;
import ContenedoresJFrame.ContenedorLogin;
import ContenedoresJFrame.ContenedorMenuUsuario;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Daniel
 */
public class jPanelVistaLoginContenedor extends JPanel {
    
    JLabel LblImgPanelDerecho, lblBienvenido, lblLogin, LblImgLogoIzquierdo, lblUsuario, lblContrasena;
    JTextField TxtUsuario;
    JButton btnIngresar;
    JPasswordField passwordField;
    JCheckBox showPasswordCheckbox;
    ContenedorLogin login;
    JPanel panelIzquierdo, jPanelDerecho;

    public jPanelVistaLoginContenedor(ContenedorLogin login) throws FontFormatException, IOException {
        this.login = login;
        this.inicializador();
        this.inicializadorObjetos();
        inicializadorEventos();
    }

    private void inicializador() {
        this.setLayout(null);
        this.setBackground(Color.white);
    }

    private void inicializadorObjetos() throws FontFormatException, IOException {
        
        //Panel Derecho
        jPanelDerecho = new JPanel();
        jPanelDerecho.setLayout(null);
        jPanelDerecho.setBounds(500, 0, 300, 500);
        jPanelDerecho.setBackground(new Color(52, 43, 255));

        LblImgPanelDerecho = new JLabel();
        LblImgPanelDerecho.setBounds(7, 150, 280, 280);
        ImageIcon icon1 = new ImageIcon("./src/main/java/Source/imgHotel.png");
        icon1.setImage(icon1.getImage().getScaledInstance(LblImgPanelDerecho.getWidth(), LblImgPanelDerecho.getHeight(), Image.SCALE_DEFAULT));
        LblImgPanelDerecho.setIcon(icon1);
        //Agreamos la imagen al panel derecho
        jPanelDerecho.add(LblImgPanelDerecho);
        //Label Bienvenido
        lblBienvenido = new JLabel();
        lblBienvenido.setBounds(70, 100, 200, 50);
        lblBienvenido.setText("Bienvenido");
        lblBienvenido.setForeground(Color.WHITE);
        //lblBienvenido.setFont(font.deriveFont(Font.PLAIN, 25));
        lblBienvenido.setFont(Fuente.getFuente().deriveFont(33f));

        jPanelDerecho.add(lblBienvenido);
        //Aqui agrgamos el panel
        this.add(jPanelDerecho);

        //Parte Izquierda
        //Imagen Logo
        LblImgLogoIzquierdo = new JLabel();
        LblImgLogoIzquierdo.setBounds(70, 20, 100, 100);
        ImageIcon icon2 = new ImageIcon("./src/main/java/Source/logoHotel.png");
        icon2.setImage(icon2.getImage().getScaledInstance(LblImgLogoIzquierdo.getWidth(), LblImgLogoIzquierdo.getHeight(), Image.SCALE_DEFAULT));
        LblImgLogoIzquierdo.setIcon(icon2);
        this.add(LblImgLogoIzquierdo);

        //Label Login
        lblLogin = new JLabel();
        lblLogin.setBounds(70, 110, 200, 50);
        lblLogin.setText("LOG IN");
        lblLogin.setForeground(new Color(52, 43, 255));
        lblLogin.setFont(Fuente.getFuente().deriveFont(27f));
        this.add(lblLogin);

        //Label Login
        lblUsuario = new JLabel();
        lblUsuario.setBounds(70, 170, 200, 50);
        lblUsuario.setText("User");
        lblUsuario.setForeground(new Color(52, 43, 255));
        lblUsuario.setFont(Fuente.getFuente().deriveFont(27f));
        this.add(lblUsuario);

        TxtUsuario = new JTextField(" Ingrese  su  Nombre  de  Usuario");
        TxtUsuario.setFont(Fuente.getFuente().deriveFont(15f));
        TxtUsuario.setForeground(new Color(85, 74, 97));
        TxtUsuario.setBounds(70, 220, 300, 30);
        TxtUsuario.setSelectionStart(0);
        TxtUsuario.setSelectionEnd(0);
        TxtUsuario.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        TxtUsuario.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (TxtUsuario.getText().equals(" Ingrese  su  Nombre  de  Usuario")) {
                    TxtUsuario.setCaretPosition(0);
                    TxtUsuario.setText("");
                    TxtUsuario.setBorder(BorderFactory.createLineBorder(Color.BLUE));

                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (TxtUsuario.getText().isEmpty()) {
                    TxtUsuario.setText(" Ingrese  su  Nombre  de  Usuario");
                    TxtUsuario.setBorder(BorderFactory.createLineBorder(Color.GRAY));

                }
            }
        });
        this.add(TxtUsuario);

        //Label Contraseña
        lblContrasena = new JLabel();
        lblContrasena.setBounds(70, 250, 200, 50);
        lblContrasena.setText("Password");
        lblContrasena.setForeground(new Color(52, 43, 255));
        lblContrasena.setFont(Fuente.getFuente().deriveFont(23f));
        this.add(lblContrasena);

        passwordField = new JPasswordField();
        passwordField.setEchoChar('*');
        passwordField.setBounds(70, 300, 300, 30);
        passwordField.setBackground(Color.WHITE);
        passwordField.setForeground(Color.BLACK);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 18));
        passwordField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        this.add(passwordField);

        showPasswordCheckbox = new JCheckBox(" ͡o ");
        showPasswordCheckbox.setBounds(380, 300, 20, 30);
        showPasswordCheckbox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    passwordField.setEchoChar((char) 0);
                } else {
                    passwordField.setEchoChar('*');
                }
            }
        });
        this.add(showPasswordCheckbox);

        //BtnIngresar
        btnIngresar = new JButton("INGRESAR");
        btnIngresar.setFont(Fuente.getFuente().deriveFont(23f));
        btnIngresar.setBackground(new Color(52, 43, 255));
        btnIngresar.setForeground(Color.white);
        btnIngresar.setBounds(70, 350, 150, 30);
        this.add(btnIngresar);

    }

    private void inicializadorEventos() {
        ActionListener escuchaBtnIngresar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                escuchaBtnEntrarClick();
            }

        };
        btnIngresar.addActionListener(escuchaBtnIngresar);

    }

    private void escuchaBtnEntrarClick() {
        ContenedorMenuUsuario menuUseuario = new ContenedorMenuUsuario();
        menuUseuario.setVisible(true);
        this.login.dispose();
    }

    
}
