/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views.components.textField;

import utils.Fuente;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

/**
 *
 * @author dann-dev
 */
public class JTextFieldFactory {

    public static JTextField textFieldFactory(String text, int x, int y, int width, int height, int fontSize, Color color) {
        JTextField jTextField = new JTextField();
        jTextField.setToolTipText(text);  // Establecer el texto de marcador de posición
        jTextField.setBounds(x, y, width, height);
        Font font = new Font("Agency FB", Font.BOLD, fontSize);
        jTextField.setFont(font);
        jTextField.setForeground(color);
        return jTextField;
    }

}
