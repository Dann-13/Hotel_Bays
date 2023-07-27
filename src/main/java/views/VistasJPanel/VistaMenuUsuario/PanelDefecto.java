/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views.VistasJPanel.VistaMenuUsuario;

import views.components.labels.JLabelFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import utils.Colores;

/**
 *
 * @author Daniel
 */
public class PanelDefecto extends JPanel {

    JLabel lblHora, lblTitulo;

    public PanelDefecto() {
        this.inicializador();
        this.inicializadorObjetos();

    }

    private void inicializador() {
        this.setLayout(null);
        this.setBackground(Color.white);
    }

    private void inicializadorObjetos() {
        lblTitulo = JLabelFactory.labelStandard("Sistemas de Reservas Hotel Bay's", 0, 0,550,60, 24f,Colores.MORADO_BASE, Color.WHITE);
        
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(lblTitulo);

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        lblHora = JLabelFactory.labelStandard(" Hoy es " + dateFormat.format(date), 0, 50, 550, 30,14f, Colores.MORADO_BASE, Color.white);
        this.add(lblHora);

        JTextArea area = new JTextArea();
        area.setBackground(new Color(0, 0, 0, 0));
        area.setText("Sistema de reservas Hotel, Controle y administre de forma  \n"
                + "optima y facil el flujo de reservas y huespedes del hotel \n \n"
                + "Esta herramienta le permite llevar un control completo y \n"
                + "detallado sus recervas y huespedes, tendra acceso a herramientas \n"
                + "especiales para tareas especificas como los son: \n \n"
                + "- Registro de Reservas de huespedes \n"
                + "- Edicion de reservas Y Huespedes Existentes \n"
                + "- Eliminar todo tipo de registros. \n"
                + "En el lado derecho encontraras 2 botones huespedes y \n "
                + "reservas que te llevaran a la interfaz con las funcionalodades\n"
                + "anteriormente mensionadas, \n"
                + "Gracias por leer esto!"
        );

        area.setBounds(10, 150, 500, 270);
        area.setFont(new Font("Arial", Font.PLAIN, 16));
        this.add(area);

    }
}
