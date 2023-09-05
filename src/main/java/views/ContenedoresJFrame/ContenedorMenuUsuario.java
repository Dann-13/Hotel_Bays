/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views.ContenedoresJFrame;

import views.VistasJPanel.VistaMenuUsuario.PanelDefecto;
import views.VistasJPanel.VistaMenuUsuario.MenuPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import views.VistasJPanel.VistaMenuUsuario.PanelHabitaciones;
import views.VistasJPanel.VistaMenuUsuario.PanelReservas;
import views.VistasJPanel.VistaMenuUsuario.PanelUsuarios;

/**
 *
 * @author Daniel
 */
public class ContenedorMenuUsuario extends JFrame {

    MenuPanel panelIzquierdo;
    PanelDefecto panelDefecto;

    public ContenedorMenuUsuario() {
        this.inicializador();
        this.inicializadorObjetos();
    }

    private void inicializador() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        this.setLocation(0, 0);
        this.setTitle("Menu de Usuario");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

    }

    private void inicializadorObjetos() {
        JSplitPane splitPane = new JSplitPane();
        splitPane.setDividerLocation(250);
        splitPane.setContinuousLayout(true);
        splitPane.setEnabled(false);

        panelDefecto = new PanelDefecto();

        panelIzquierdo = new MenuPanel(this);
        panelIzquierdo.setLayout(null);
        panelIzquierdo.setPreferredSize(new Dimension(250, 0));

        JPanel rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(0, 0));

        splitPane.setLeftComponent(panelIzquierdo);
        splitPane.setRightComponent(rightPanel);

        //Panel defecto
        splitPane.setRightComponent(panelDefecto);

        /**
         * Utilizamos los botones que creamos en el JPanel Izquierdo, Aqui solo
         * le damos los eventos
         */
        panelIzquierdo.getBtnbtnUsuarios().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel panelUsuario = new PanelUsuarios();
                panelUsuario.setPreferredSize(new Dimension(500, 0));

                splitPane.setRightComponent(panelUsuario);
                splitPane.revalidate();
                splitPane.repaint();
            }
        });

        panelIzquierdo.getbtnReserva().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel panelReservas = new PanelReservas();
                panelReservas.setPreferredSize(new Dimension(500, 0));
                splitPane.setRightComponent(panelReservas);
                splitPane.revalidate();
                splitPane.repaint();
            }
        });

        panelIzquierdo.getBtnHabitaciones().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel panelHabitaciones = new PanelHabitaciones();
                panelHabitaciones.setPreferredSize(new Dimension(500, 0));
                splitPane.setRightComponent(panelHabitaciones);
                splitPane.revalidate();
                splitPane.repaint();
            }

        });
        this.add(splitPane, BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);
    }
}
