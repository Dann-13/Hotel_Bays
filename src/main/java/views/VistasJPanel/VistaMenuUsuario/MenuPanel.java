/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views.VistasJPanel.VistaMenuUsuario;

import views.components.buttons.JButtonsFactory;
import views.components.labels.JLabelFactory;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import utils.Colores;

/**
 *
 * @author Daniel
 */
public class MenuPanel extends JPanel {

    private JButton btnReservas;
    private JButton btnBusqueda;
    private JButton btnHabitaciones;

    public MenuPanel() {
        this.inicializador();
        this.inicializadorObjetos();
    }

    private void inicializador() {
        this.setLayout(null);
        this.setBackground(Color.WHITE);
    }

    private void inicializadorObjetos() {

        //Imagen Logo
        JLabel LblImgLogoIzquierdo = JLabelFactory.labelStandardImg("./src/main/java/views/resources/images/imgLogoCirculo.png", 0, 0, 250, 250);
        this.add(LblImgLogoIzquierdo);

        btnReservas = JButtonsFactory.buttonStandardFont("Usuarios", 40, 250, 170, 30, 25f, Color.BLACK);
        btnReservas.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Colores.MORADO_BASE));
        btnReservas.setFocusPainted(false);
        btnReservas.setContentAreaFilled(false);
        btnReservas.setForeground(Colores.MORADO_BASE);

        this.add(btnReservas);

        btnBusqueda = JButtonsFactory.buttonStandardFont("Reservas", 40, 300, 170, 30, 25f, Color.BLACK);
        btnBusqueda.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Colores.MORADO_BASE));
        btnBusqueda.setFocusPainted(false);
        btnBusqueda.setContentAreaFilled(false);
        btnBusqueda.setForeground(Colores.MORADO_BASE);
        this.add(btnBusqueda);

        btnHabitaciones = JButtonsFactory.buttonStandardFont("Habitaciones", 40, 350, 170, 30, 25f, Color.BLACK);
        btnHabitaciones.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Colores.MORADO_BASE));
        btnHabitaciones.setFocusPainted(false);
        btnHabitaciones.setContentAreaFilled(false);
        btnHabitaciones.setForeground(Colores.MORADO_BASE);
        this.add(btnHabitaciones);
        
        Calendar cal = Calendar.getInstance();
        JLabel labelHora = JLabelFactory.labelStandard(" ", 150, 600, 100, 30, 17f, null, Colores.MORADO_BASE);
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
    
    public JButton getBtnHabitaciones(){
        return btnHabitaciones;
    }
}
