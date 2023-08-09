/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views.VistasJPanel.VistaMenuUsuario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import views.VistasJPanel.VistaMenuUsuario.Usuarios.EdicionUsuarios;
import views.VistasJPanel.VistaMenuUsuario.Usuarios.TablaUsuarios;

/**
 *
 * @author dan-dev
 */
public class PanelUsuarios extends JPanel {

    EdicionUsuarios edicionUsuarios;
    TablaUsuarios tablaUsuarios;
    public PanelUsuarios() {
        this.inicializador();
        this.inicializadorObjetos();
//        this.inicializadorEventos();

    }

    private void inicializador() {
        this.setBackground(Color.blue);
        this.setLayout(new BorderLayout());
    }

    private void inicializadorObjetos() {
        
        tablaUsuarios = new TablaUsuarios();
        edicionUsuarios = new EdicionUsuarios();
        edicionUsuarios.setPanelTablaUsuarios(tablaUsuarios);
        tablaUsuarios.setEdicionUsuarios(edicionUsuarios);
        edicionUsuarios.setPreferredSize(new Dimension(edicionUsuarios.getWidth(), 300));
        this.add(edicionUsuarios, BorderLayout.NORTH);
        this.add(tablaUsuarios, BorderLayout.CENTER);
    }

}
