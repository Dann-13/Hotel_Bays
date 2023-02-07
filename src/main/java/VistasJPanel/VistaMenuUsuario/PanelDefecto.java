/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VistasJPanel.VistaMenuUsuario;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Daniel
 */
public class PanelDefecto extends JPanel{
    public PanelDefecto() {
        this.inicializador();
        this.inicializadorObjetos();

    }

    private void inicializador() {
        this.setLayout(null);
    }

    private void inicializadorObjetos() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        JLabel hora = new JLabel();
        hora.setText(dateFormat.format(date));
        hora.setBounds(50, 50,200, 30);
        this.add(hora);
    }
}
