/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VistasJPanel.VistaInicio;

import utils.Fuente;
import components.labels.JLabelFactory;
import ContenedoresJFrame.ContenedorInicio;
import ContenedoresJFrame.ContenedorLogin;
import java.awt.Color;
import static java.awt.Component.TOP_ALIGNMENT;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Daniel
 */
public class JPanelContenedor extends JPanel {

    ContenedorInicio inicio;
    JPanel jPanelIzquierdo;

    //Objetos
    JLabel labelImg, LblPie, lblLogo, lbLloguin;
    JButton btnlImgLoguin;

    public JPanelContenedor(ContenedorInicio inicio) {
        this.inicio = inicio;
        this.inicializador();
        this.inicializadorObjetos();
        this.inicializadorEventos();
    }

    private void inicializador() {
        this.setLayout(null);
    }

    private void inicializadorObjetos() {

//        Imamgen
//        importamos imagen
        labelImg = new JLabel();
        labelImg.setBounds(0, 0, 550, 431);
        ImageIcon icon = new ImageIcon("./src/main/java/resources/imageninicio.png");
        icon.setImage(icon.getImage().getScaledInstance(labelImg.getWidth(), labelImg.getHeight(), Image.SCALE_DEFAULT));
        labelImg.setIcon(icon);
        this.add(labelImg);

        LblPie = new JLabel();
        LblPie.setText("Desarrollado Por: Daniel Gomez ©");
        LblPie.setHorizontalAlignment(JLabel.CENTER);
        LblPie.setForeground(Color.white);
        LblPie.setBounds(0, 431, 800, 30);
        LblPie.setOpaque(true);
        LblPie.setBackground(new Color(52, 43, 255));
        this.add(LblPie);

        jPanelIzquierdo = new JPanel();
        jPanelIzquierdo.setLayout(null);
        jPanelIzquierdo.setBounds(550, 0, 250, 500);

        //Imagen Logo
        lblLogo = new JLabel();
        lblLogo.setBounds(20, 30, 200, 200);
        ImageIcon iconLogo = new ImageIcon("./src/main/java/resources/logoHotel.png");
        iconLogo.setImage(iconLogo.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_DEFAULT));
        lblLogo.setIcon(iconLogo);
        jPanelIzquierdo.add(lblLogo);

        lbLloguin = JLabelFactory.labelStandardFont("Login",95, 280, 100, 30, 23.0f, new Color(52, 43, 255));
        jPanelIzquierdo.add(lbLloguin);

        //Imagen Loguin
        btnlImgLoguin = new JButton();
        btnlImgLoguin.setBounds(90, 320, 60, 60);
        btnlImgLoguin.setBorderPainted(false);
        btnlImgLoguin.setContentAreaFilled(false);
        ImageIcon icon2 = new ImageIcon("./src/main/java/resources/user.png");
        icon2.setImage(icon2.getImage().getScaledInstance(btnlImgLoguin.getWidth(), btnlImgLoguin.getHeight(), Image.SCALE_DEFAULT));
        btnlImgLoguin.setIcon(icon2);
        jPanelIzquierdo.add(btnlImgLoguin);
        this.add(jPanelIzquierdo);

    }

    private void inicializadorEventos() {
        ActionListener escuchaBtnLogin = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    escuchaBtnLoginClick();
                } catch (FontFormatException ex) {
                    Logger.getLogger(JPanelContenedor.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(JPanelContenedor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        };
        btnlImgLoguin.addActionListener(escuchaBtnLogin);

    }

    public void escuchaBtnLoginClick() throws FontFormatException, IOException {
        ContenedorLogin login = new ContenedorLogin();
        login.setVisible(true);
        this.inicio.dispose();
    }

}
