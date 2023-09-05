/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views.ContenedoresJFrame;

import java.awt.FontFormatException;
import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import views.VistasJPanel.VIstaRegister.JPanelRegister;
import views.VistasJPanel.VistaInicio.MainPanelInicio;
import views.VistasJPanel.VistaLogin.JPanelVistaLoginContenedor;

/**
 *
 * @author Daniel
 */
public class ContenedorInicio extends JFrame {

    MainPanelInicio mainInicio;
    JPanelRegister registerPanel;
    JPanelVistaLoginContenedor loginPanel;

    public ContenedorInicio(){
         try {
            
            this.inicializador();
            this.inicializadorObjetos();
            
        } catch (FontFormatException | IOException e) {
            // Manejar las excepciones aquí, por ejemplo, mostrando un mensaje de error.
            JOptionPane.showMessageDialog(null, "Error en la carga de fuentes o archivo de entrada/salida: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * Este metedo contendra las propiedades que el JFrame Tomara Ej: Tamaño de
     * Ventana
     */
    private void inicializador() throws FontFormatException, IOException {
        //este metodo se encarga de dar las propiedades de la ventana contenedora del panel
        this.setSize(800, 500); //Alto y ancho de nuestro frame
        this.setTitle("Hotel Bay's");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        //creamos la instancia de los paneles
        mainInicio = new MainPanelInicio(this);
        loginPanel = new JPanelVistaLoginContenedor(this);
        registerPanel = new JPanelRegister(this);

    }

    private void inicializadorObjetos() {
        //Agregamos el jpanel Principal
        this.add(mainInicio);
    }

    public void showLoginPanel() {
        setContentPane(loginPanel);
        revalidate();
        repaint();
    }

    public void showRegisterPanel() {
        setContentPane(registerPanel);
        revalidate();
        repaint();
    }

    public void showMainPanel() {
        setContentPane(mainInicio);
        revalidate();
        repaint();
    }

}
