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
import models.Administrator;
import utils.Colores;
import utils.SessionManager;

/**
 *
 * @author Daniel
 */
public class PanelDefecto extends JPanel {

    JLabel lblHora, lblTitulo, lblAdmin;
    JTextArea area;
    Administrator loggedInAdministrator = SessionManager.getLoggedInAdministrator();

    public PanelDefecto() {
        this.inicializador();
        this.inicializadorObjetos();

    }

    private void inicializador() {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.white);
    }

    private void inicializadorObjetos() {

        if (loggedInAdministrator != null) {
            // Muestra el nombre del administrador en el JLabel
            lblAdmin = new JLabel();
            lblAdmin.setBounds(50, 450, 100, 30);
            lblAdmin.setText("Hola, " + loggedInAdministrator.getName());
            this.add(lblAdmin);
        }

        lblTitulo = JLabelFactory.labelStandard("Sistemas de Reservas Hotel Playa Cristal", 0, 0, 0, 0, 25f, Colores.MORADO_BASE, Color.WHITE);
        lblTitulo.setPreferredSize(new Dimension(0, 80));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(lblTitulo, BorderLayout.NORTH);

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        lblHora = JLabelFactory.labelStandard(" Hoy es " + dateFormat.format(date), 0, 0, 0, 60, 14f, Colores.MORADO_BASE, Color.white);

        this.add(lblHora, BorderLayout.CENTER);

        JPanel areaPanel = new JPanel(new BorderLayout()); // Panel intermedio para JTextArea
        area = createConfiguredTextArea(""
                + "Sistema de reserva del Hotel playa crystal, aqui podras encontrar diferentes opciones"
                + "que te ayudaran a controlar, ver y editar el flijo de huespedes, y a su vez otras opciones"
                + "como las habitaciones y reservas, tu como administrador principal tendras funcioalodades"
                + "mas avanzadas como la creacion, edicion y eliminacion de administradores principales y de"
                + "contenido"
                + "Muchas Gracias por usar este sistema");

        this.add(areaPanel, BorderLayout.SOUTH);

    }

    private JTextArea createConfiguredTextArea(String text) {
        JTextArea area = new JTextArea();
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setBackground(new Color(0, 0, 0, 0));
        area.setText(text);
        area.setFont(new Font("Arial", Font.PLAIN, 16));

        Border marginBorder = BorderFactory.createEmptyBorder(50, 10, 10, 10);
        Border compoundBorder = BorderFactory.createCompoundBorder(area.getBorder(), marginBorder);
        area.setBorder(compoundBorder);

        return area;
    }

}
