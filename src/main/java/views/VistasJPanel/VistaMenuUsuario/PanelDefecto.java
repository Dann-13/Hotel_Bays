/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views.VistasJPanel.VistaMenuUsuario;

import java.awt.BorderLayout;
import views.components.labels.JLabelFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import utils.Colores;

/**
 *
 * @author Daniel
 */
public class PanelDefecto extends JPanel {

    JLabel lblHora, lblTitulo;
    JTextArea area;

    public PanelDefecto() {
        this.inicializador();
        this.inicializadorObjetos();

    }

    private void inicializador() {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.white);
    }

    private void inicializadorObjetos() {
        lblTitulo = JLabelFactory.labelStandard("Sistemas de Reservas Hotel Bay's", 0, 0, 0, 0, 25f, Colores.MORADO_BASE, Color.WHITE);
        lblTitulo.setPreferredSize(new Dimension(0, 60));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(lblTitulo, BorderLayout.NORTH);

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        lblHora = JLabelFactory.labelStandard(" Hoy es " + dateFormat.format(date), 0, 0, 0, 60, 14f, Colores.MORADO_BASE, Color.white);

        this.add(lblHora, BorderLayout.CENTER);

        JPanel areaPanel = new JPanel(new BorderLayout()); // Panel intermedio para JTextArea
        area = new JTextArea();
        area.setLineWrap(true); // Activa el ajuste automático de línea
        area.setWrapStyleWord(true); // Activa el ajuste de palabras
        area.setBackground(new Color(0, 0, 0, 0));
        area.setText("Sistema de reservas Hotel, Controle y administre de forma óptima y fácil el flujo de reservas y huéspedes del hotel.\n"
                + "Esta herramienta le permite llevar un control completo y detallado de sus reservas y huéspedes,\n"
                + "tendrá acceso a herramientas especiales para tareas específicas como el registro de reservas de huéspedes,\n"
                + "edición de reservas y huéspedes existentes, y eliminación de todo tipo de registros.\n"
                + "En el lado derecho encontrarás 2 botones, huéspedes y reservas, que te llevarán a la interfaz con las funcionalidades mencionadas.\n"
                + "Gracias por leer esto!"
        );
        area.setFont(new Font("Arial", Font.PLAIN, 16));
        // Agrega un margen al JTextArea para separar el texto del borde
        Border marginBorder = BorderFactory.createEmptyBorder(50, 10, 10, 10);
        Border compoundBorder = BorderFactory.createCompoundBorder(area.getBorder(), marginBorder);
        area.setBorder(compoundBorder);

        JScrollPane scrollPane = new JScrollPane(area);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        areaPanel.add(scrollPane, BorderLayout.CENTER);
        areaPanel.setPreferredSize(new Dimension(0, 650)); // Ajusta el alto aquí

        this.add(areaPanel, BorderLayout.SOUTH);

    }
}
