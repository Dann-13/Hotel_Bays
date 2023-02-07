/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ContenedoresJFrame;

import VistasJPanel.VistaMenuUsuario.PanelDefecto;
import VistasJPanel.VistaMenuUsuario.leftPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Daniel
 */
public class ContenedorMenuUsuario extends JFrame{
    leftPanel panelIzquierdo;
    PanelDefecto panelDefecto;
    private JPanel cards;
    private CardLayout cardLayout;
    private JButton button1, button2;
    
    public ContenedorMenuUsuario(){
        this.inicializador();
        this.inicializadorObjetos();
    }

    private void inicializador() {
        this.setMinimumSize(new Dimension(800,550)); //Alto y ancho de nuestro frame
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

        panelIzquierdo = new leftPanel();
        panelIzquierdo.setLayout(null);
        panelIzquierdo.setPreferredSize(new Dimension(250, 0));
        

        JPanel rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(500, 0));

        splitPane.setLeftComponent(panelIzquierdo);
        splitPane.setRightComponent(rightPanel);
        
        //Panel defecto
        splitPane.setRightComponent(panelDefecto);

        /**
         * Utilizamos los botones que creamos en el JPanel Izquierdo, Aqui solo le damos los eventos
         */
        panelIzquierdo.getBtnReservas().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel panel1 = new JPanel();
                panel1.setPreferredSize(new Dimension(500, 0));
                panel1.setBackground(Color.red);
                splitPane.setRightComponent(panel1);
                splitPane.revalidate();
                splitPane.repaint();
            }
        });

        panelIzquierdo.getBtnBusqueda().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel panel2 = new JPanel();
                panel2.setPreferredSize(new Dimension(500, 0));
                panel2.setBackground(Color.BLUE);
                splitPane.setRightComponent(panel2);
                splitPane.revalidate();
                splitPane.repaint();
            }
        });
        this.add(splitPane, BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);
    }
}
