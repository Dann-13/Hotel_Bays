/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ContenedoresJFrame;

import VistasJPanel.VistaInicio.JPanelContenedor;
import javax.swing.JFrame;

/**
 *
 * @author Daniel
 */
public class ContenedorInicio extends JFrame{
    JPanelContenedor contenedor;
    public ContenedorInicio(){
        //en donde vamos a inicializar dos metodos
        this.inicializador();
        this.inicializadorObjetos();
    }
    /**
     * Este metedo contendra las propiedades que el JFrame Tomara 
     * Ej: Tamaño de Ventana
     */
    private void inicializador() {
         //este metodo se encarga de dar las propiedades de la ventana contenedora del panel
        this.setSize(800,500); //Alto y ancho de nuestro frame
        this.setTitle("Hotel Bay's");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
//        //icono
//        ImageIcon icon = new ImageIcon("./src/main/java/source/convertirblack.png");
//        this.setIconImage(icon.getImage());
    }

    private void inicializadorObjetos() {
        contenedor = new JPanelContenedor(this);
        this.getContentPane().add(contenedor);
    }
}
