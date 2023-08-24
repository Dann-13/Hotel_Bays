/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views.components.buttons;

import java.awt.Color;
import utils.Fuente;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;
import utils.Colores;

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
        addHoverEffect(button, Color.WHITE, Colores.MORADO_BASE);
        return button;
    }

    public static JButton buttonStandardFontImg(String text, int x, int y, int width, int height) {
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

    public static JButton buttonStandardFontWithHoverAndBorder(String text, int x, int y, int width, int height, float fontSize, Color textColor, Color borderColor, Color hoverColor) {
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.setForeground(textColor);
        Font customFont = Fuente.getFuente(fontSize);
        button.setFont(customFont);

        
        setCustomBorder(button, borderColor);

        return button;
    }

    private static void addHoverEffect(JButton button, Color colorBackground, Color colorForeground) {
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(colorBackground);
                button.setForeground(colorForeground);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(Colores.MORADO_BASE);
                button.setForeground(Color.WHITE);
            }
        });
    }

    private static void setCustomBorder(JButton button, Color borderColor) {
        button.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, borderColor));
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
    }
}
