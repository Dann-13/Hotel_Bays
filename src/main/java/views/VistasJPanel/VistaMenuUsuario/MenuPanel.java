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

    private JButton btnUsuarios;
    private JButton btnReserva;
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

        btnUsuarios = JButtonsFactory.buttonStandardFontWithHoverAndBorder("Usuarios", 40, 250, 170, 30, 25f, Colores.MORADO_BASE, Colores.MORADO_BASE, Colores.MORADO_BASE);
        this.add(btnUsuarios);

        btnReserva = JButtonsFactory.buttonStandardFontWithHoverAndBorder("Reservas", 40, 300, 170, 30, 25f, Colores.MORADO_BASE, Colores.MORADO_BASE, Colores.MORADO_BASE);
        this.add(btnReserva);

        btnHabitaciones = JButtonsFactory.buttonStandardFontWithHoverAndBorder("Habitaciones", 40, 350, 170, 30, 25f, Colores.MORADO_BASE, Colores.MORADO_BASE, Colores.MORADO_BASE);
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

    public JButton getBtnbtnUsuarios() {
        return btnUsuarios;
    }

    public JButton getbtnReserva() {
        return btnReserva;
    }
    
    public JButton getBtnHabitaciones(){
        return btnHabitaciones;
    }
}
