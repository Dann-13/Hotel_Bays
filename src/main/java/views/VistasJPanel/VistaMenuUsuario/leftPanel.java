/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views.VistasJPanel.VistaMenuUsuario;

import views.components.buttons.JButtonsFactory;
import views.components.labels.JLabelFactory;
import java.awt.Color;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Daniel
 */
public class leftPanel extends JPanel {

    private JButton btnReservas;
    private JButton btnBusqueda;

    public leftPanel() {
        this.inicializador();
        this.inicializadorObjetos();
    }

    private void inicializador() {
        this.setLayout(null);
        this.setBackground(new Color(52, 43, 255));
    }

    private void inicializadorObjetos() {

        //Imagen Logo
        JLabel LblImgLogoIzquierdo = JLabelFactory.labelStandardImg("./src/main/java/views/resources/images/imgLogoCirculo.png", 0, 0, 250, 250);
        this.add(LblImgLogoIzquierdo);

        btnReservas = JButtonsFactory.buttonStandardFont("Reservas", 40, 250, 170, 30, 17f, Color.BLACK);
        btnReservas.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
        btnReservas.setFocusPainted(false);
        btnReservas.setContentAreaFilled(false);
        btnReservas.setForeground(Color.white);

        this.add(btnReservas);

        btnBusqueda = JButtonsFactory.buttonStandardFont("Clientes", 40, 300, 170, 30, 17f, Color.BLACK);
        btnBusqueda.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
        btnBusqueda.setFocusPainted(false);
        btnBusqueda.setContentAreaFilled(false);
        btnBusqueda.setForeground(Color.white);
        this.add(btnBusqueda);

        Calendar cal = Calendar.getInstance();
        JLabel labelHora = JLabelFactory.labelStandardFont("", 180, 450, 17f, new Color(52, 43, 255), Color.WHITE);
        labelHora.setForeground(Color.white);

        new Thread() {
            @Override
            public void run() {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                while (true) {
                    labelHora.setText(sdf.format(new Date()));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                    }
                }
            }
        }.start();

        this.add(labelHora);

    }

    public JButton getBtnReservas() {
        return btnReservas;
    }

    public JButton getBtnBusqueda() {
        return btnBusqueda;
    }
}
