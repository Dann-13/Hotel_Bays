/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components.buttons;

import utils.Fuente;
import java.awt.Font;
import javax.swing.JButton;

/**
 *
 * @author dann-dev
 */
public class JButtonsFactory {
    public static JButton buttonStandardFont(String text, int x, int y, int width, int height, float fontSize) {
    JButton button = new JButton(text);
    button.setBounds(x, y, width, height);

    Font customFont = Fuente.getFuente(fontSize);
    button.setFont(customFont);

    return button;
}
}
