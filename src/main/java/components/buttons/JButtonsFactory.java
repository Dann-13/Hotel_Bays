/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components.buttons;

import java.awt.Color;
import utils.Fuente;
import java.awt.Font;
import javax.swing.JButton;

/**
 *
 * @author dann-dev
 */
public class JButtonsFactory {
    public static JButton buttonStandardFont(String text, int x, int y, int width, int height, float fontSize, Color color) {
    JButton button = new JButton(text);
    button.setBounds(x, y, width, height);
    button.setBackground(color);
    button.setForeground(Color.WHITE);
    Font customFont = Fuente.getFuente(fontSize);
    button.setFont(customFont);

    return button;
}
}
