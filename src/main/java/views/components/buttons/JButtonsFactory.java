/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views.components.buttons;

import java.awt.Color;
import utils.Fuente;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
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
    public static JButton buttonStandardFontImg(String text, int x, int y, int width, int height){
        JButton button = new JButton();
        button.setBounds(x, y, width, height);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        ImageIcon icon2 = new ImageIcon(text);
        icon2.setImage(icon2.getImage().getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_DEFAULT));
        button.setIcon(icon2);
        
        return button;
    }
    public static JButton buttonStandardFontImgAndText(String text, String imagePath, int x, int y, int width, int height) {
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);

        // Cargar la imagen y escalarla para ajustarla al JButton
        ImageIcon icon = new ImageIcon(imagePath);
        Image scaledImage = icon.getImage().getScaledInstance(height, height, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        button.setIcon(scaledIcon);

        return button;
    }
}
