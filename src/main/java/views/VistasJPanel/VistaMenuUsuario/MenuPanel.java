/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views.VistasJPanel.VistaMenuUsuario;

import views.components.buttons.JButtonsFactory;
import views.components.labels.JLabelFactory;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import models.Administrator;
import utils.Colores;
import utils.SessionManager;
import views.ContenedoresJFrame.ContenedorInicio;
import views.ContenedoresJFrame.ContenedorMenuUsuario;
import views.VistasJPanel.VistaLogin.JPanelVistaLoginContenedor;

/**
 *
 * @author Daniel
 */
public class MenuPanel extends JPanel {

    private JButton btnUsuarios;
    private JButton btnReserva;
    private JButton btnHabitaciones;
    private JButton btnCerrarSession;
    JLabel lblAdmin;
    Administrator loggedInAdministrator = SessionManager.getLoggedInAdministrator();
    ContenedorMenuUsuario mainFrame;

    public MenuPanel(ContenedorMenuUsuario mainFrame) {
        this.mainFrame = mainFrame;
        this.inicializador();
        this.inicializadorObjetos();
        this.inicializadorEventos();
    }

    private void inicializador() {
        this.setLayout(null);
        this.setBackground(Color.WHITE);
    }

    private void inicializadorObjetos() {

        if (loggedInAdministrator != null) {
            // Muestra el nombre del administrador en el JLabel
            lblAdmin = new JLabel();
            lblAdmin.setBounds(50, 450, 100, 30);
            lblAdmin.setText("Hola, " + loggedInAdministrator.getName());
            this.add(lblAdmin);
        }

        //Imagen Logo
        JLabel LblImgLogoIzquierdo = JLabelFactory.labelStandardImg("./src/main/java/views/resources/images/imgLogoCirculo.png", 0, 0, 250, 250);
        this.add(LblImgLogoIzquierdo);

        btnUsuarios = JButtonsFactory.buttonStandardFontWithHoverAndBorder("Usuarios", 40, 250, 170, 30, 25f, Colores.MORADO_BASE, Colores.MORADO_BASE, Colores.MORADO_BASE);
        this.add(btnUsuarios);

        btnReserva = JButtonsFactory.buttonStandardFontWithHoverAndBorder("Reservas", 40, 300, 170, 30, 25f, Colores.MORADO_BASE, Colores.MORADO_BASE, Colores.MORADO_BASE);
        this.add(btnReserva);

        btnHabitaciones = JButtonsFactory.buttonStandardFontWithHoverAndBorder("Habitaciones", 40, 350, 170, 30, 25f, Colores.MORADO_BASE, Colores.MORADO_BASE, Colores.MORADO_BASE);
        this.add(btnHabitaciones);

        btnCerrarSession = JButtonsFactory.buttonStandardFontWithHoverAndBorder("Cerrar Sesion", 40, 400, 170, 30, 25f, Colores.MORADO_BASE, Colores.MORADO_BASE, Colores.MORADO_BASE);
        this.add(btnCerrarSession);

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

    public JButton getBtnHabitaciones() {
        return btnHabitaciones;
    }

    private void inicializadorEventos() {
        ActionListener escuchaBtnCerrarSession = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                escuchaBtnCerrarSessionClick();

            }
        };
        btnCerrarSession.addActionListener(escuchaBtnCerrarSession);

    }

    private void escuchaBtnCerrarSessionClick() {
        SessionManager.cerrarSesion();
        mainFrame.dispose();

        ContenedorInicio inicio = new ContenedorInicio();
        inicio.setVisible(true);

    }
}
