/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VistasJPanel.VistaMenuUsuario;

import java.awt.Color;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Daniel
 */
public class leftPanel extends JPanel{
    private JButton btnReservas;
    private JButton btnBusqueda;
    public leftPanel(){
        this.inicializador();
        this.inicializadorObjetos();
    }

    private void inicializador() {
        this.setLayout(null);
        this.setBackground(new Color(52, 43, 255));
    }

    private void inicializadorObjetos() {

        //Imagen Logo
        JLabel LblImgLogoIzquierdo = new JLabel();
        LblImgLogoIzquierdo.setBounds(0, 10, 250, 250);
        ImageIcon icon2 = new ImageIcon("./src/main/java/Source/imgLogoCirculo.png");
        icon2.setImage(icon2.getImage().getScaledInstance(LblImgLogoIzquierdo.getWidth(), LblImgLogoIzquierdo.getHeight(), Image.SCALE_DEFAULT));
        LblImgLogoIzquierdo.setIcon(icon2);
        this.add(LblImgLogoIzquierdo);
        
        btnReservas = new JButton("Registro Reservas");
        btnReservas.setBounds(50, 250, 150, 30);
        btnReservas.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        btnReservas.setFocusPainted(false);
        btnReservas.setContentAreaFilled(false);
        btnReservas.setForeground(Color.white);
        this.add(btnReservas);
        
        btnBusqueda = new JButton("Busqueda");
        btnBusqueda.setBounds(50, 300, 150, 30);
        btnBusqueda.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        btnBusqueda.setFocusPainted(false);
        btnBusqueda.setContentAreaFilled(false);
        btnBusqueda.setForeground(Color.white);
        this.add(btnBusqueda);
        
    }
    public JButton getBtnReservas() {
        return btnReservas;
    }

    public JButton getBtnBusqueda() {
        return btnBusqueda;
    }
}
