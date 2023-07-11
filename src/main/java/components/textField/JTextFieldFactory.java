/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components.textField;

import utils.Fuente;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

/**
 *
 * @author dann-dev
 */
public class JTextFieldFactory {

    public static JTextField textFieldFactory(String text, int x, int y, int width, int height, float fontSize, Color color) {
        JTextField jTextField = new JTextField();
        jTextField.setToolTipText(text);  // Establecer el texto de marcador de posición
        jTextField.setBounds(x, y, width, height);
        Font customFont = Fuente.getFuente(fontSize);
        jTextField.setFont(customFont);
        jTextField.setForeground(color);
        return jTextField;
    }

}
