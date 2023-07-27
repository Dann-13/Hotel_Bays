/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views.VistasJPanel.VistaInicio;

import views.components.labels.JLabelFactory;
import views.ContenedoresJFrame.ContenedorInicio;
import views.components.buttons.JButtonsFactory;
import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import utils.Conexion;

/**
 *
 * @author Daniel
 */
public class MainPanelInicio extends JPanel {

    ContenedorInicio mainFrame;
    JPanel jPanelIzquierdo, jPanelDerecho;

    //Objetos
    JLabel labelImg, LblPie, lblLogo, lbLloguin, lblRegister;

    JButton btnlImgLoguin, btnRegister;

    public MainPanelInicio(ContenedorInicio mainFrame) {
        this.mainFrame = mainFrame;
        this.inicializador();
        this.inicializadorObjetos();
        this.inicializadorEventos();
       
    }

    private void inicializador() {
        this.setLayout(null);
    }

    private void inicializadorObjetos() {

        labelImg = JLabelFactory.labelStandardImg("./src/main/java/views/resources/images/imageninicio.png", 0, 0, 550, 431);
        this.add(labelImg);

        LblPie = JLabelFactory.labelStandard("Desarrollado Por: FlashDev ©", 0, 431, 800, 30,17f, new Color(52, 43, 255), Color.WHITE);
        LblPie.setHorizontalAlignment(JLabel.CENTER);
        this.add(LblPie);

        jPanelDerecho = new JPanel();
        jPanelDerecho.setLayout(null);
        jPanelDerecho.setBackground(Color.WHITE);
        jPanelDerecho.setBounds(550, 0, 250, 500);

        //Imagen Logo
        lblLogo = JLabelFactory.labelStandardImg("./src/main/java/views/resources/images/logoHotel.png", 20, 10, 200, 200);
        jPanelDerecho.add(lblLogo);

        lbLloguin = JLabelFactory.labelStandardFont("Login", 95, 220, 23.0f, Color.WHITE, new Color(52, 43, 255));
        jPanelDerecho.add(lbLloguin);

        //Imagen Loguin
        btnlImgLoguin = JButtonsFactory.buttonStandardFontImg("./src/main/java/views/resources/images/user.png", 90, 260, 60, 60);
        jPanelDerecho.add(btnlImgLoguin);

        lblRegister = JLabelFactory.labelStandardFont("Register", 85, 330, 23.0f, Color.WHITE, new Color(52, 43, 255));
        jPanelDerecho.add(lblRegister);

        //Images Registro
        btnRegister = JButtonsFactory.buttonStandardFontImg("./src/main/java/views/resources/images/user.png", 90, 370, 60, 60);
        jPanelDerecho.add(btnRegister);

        this.add(jPanelDerecho);

    }

    private void inicializadorEventos() {
        ActionListener escuchaBtnLogin = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    escuchaBtnLoginClick();
                } catch (FontFormatException ex) {
                    Logger.getLogger(MainPanelInicio.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MainPanelInicio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        };
        btnlImgLoguin.addActionListener(escuchaBtnLogin);

        ActionListener escuchaBtnRegister = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                escuchaBtnRegisterClick();
            }
        };
        btnRegister.addActionListener(escuchaBtnRegister);
    }

    public void escuchaBtnLoginClick() throws FontFormatException, IOException {
        mainFrame.showLoginPanel();
    }

    public void escuchaBtnRegisterClick() {
        mainFrame.showRegisterPanel();
    }

}
