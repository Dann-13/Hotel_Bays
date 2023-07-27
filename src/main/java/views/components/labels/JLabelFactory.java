/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views.components.labels;

import utils.Fuente;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author dann-dev
 */
public class JLabelFactory {

    public static JLabel labelStandardFont(String text, int x, int y, float fontSize, Color colorBackground, Color colorForeground) {
        JLabel label = new JLabel(text);
        label.setOpaque(true);
        Font customFont = Fuente.getFuente(fontSize);
        label.setFont(customFont);
        label.setForeground(colorForeground);
        label.setBackground(colorBackground);

        label.setBounds(x, y, label.getPreferredSize().width, label.getPreferredSize().height);

        return label;
    }

    public static JLabel labelStandard(String text, int x, int y, int width, int height,float fontSize, Color colorBackground, Color colorForeground) {
        JLabel label = new JLabel(text);
        Font customFont = label.getFont().deriveFont(fontSize);
        label.setFont(customFont);
        label.setBounds(x, y, width, height);
        label.setForeground(colorForeground);
        label.setBackground(colorBackground);
        label.setOpaque(true);

        return label;
    }

    public static JLabel labelStandardImg(String imagePath, int x, int y, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        JLabel label = new JLabel(imageIcon);
        label.setBounds(x, y, width, height);
        label.setIcon(imageIcon);

        return label;
    }
}
