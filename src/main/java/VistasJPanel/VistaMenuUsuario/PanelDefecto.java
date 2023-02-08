/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VistasJPanel.VistaMenuUsuario;

import Clases.Fuente;
import java.awt.Color;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.text.StyledDocument;

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
        lblTitulo = new JLabel();
        lblTitulo.setBounds(0, 10, 550, 50);
        lblTitulo.setText("Sistema  de  Reservas  Hotel  Bay's");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(Fuente.getFuente().deriveFont(24f));
        lblTitulo.setBackground(new Color(51, 110, 255));
        lblTitulo.setOpaque(true);
        lblTitulo.setForeground(Color.white);
        this.add(lblTitulo);

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        lblHora = new JLabel();
        lblHora.setText("Hoy es " + dateFormat.format(date));
        lblHora.setBounds(0, 50, 550, 30);
        lblHora.setBackground(new Color(51, 110, 255));
        lblHora.setOpaque(true);
        lblHora.setForeground(Color.WHITE);
        this.add(lblHora);



        JTextArea area = new JTextArea();
        area.setBackground(new Color(0, 0, 0, 0));
        area.setText("Sistema de reservas Hotel, Controle y administre de forma optima y \n"
                + "facil el flujo de reservas y huespedes del hotel \n \n"
                + "Esta herramienta le permite llevar un control completo y detallado de \n"
                + "sus recervas y huespedes, tendra acceso a herramientas especiales \n"
                + "para tareas especificas como los son: \n \n"
                + "- Registro de Reservas de huespedes \n"
                + "- Edicion de reservas Y Huespedes Existentes \n"
                + "- Eliminar todo tipo de registros."
        );

        area.setBounds(10, 200, 500, 200);
        area.setFont(new Font("Arial", Font.PLAIN, 16));
        this.add(area);

    }
}
