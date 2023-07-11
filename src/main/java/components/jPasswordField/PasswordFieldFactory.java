/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components.jPasswordField;

import utils.Fuente;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPasswordField;
/**
 *
 * @author dann-dev
 */
public class PasswordFieldFactory {
    public static JPasswordField createPasswordField(int x, int y, int width, int heigth, float fontSize, Color color, char echoChar){
        JPasswordField jPasswordField = new JPasswordField();
        jPasswordField.setToolTipText("Ingrese su contrasena");
        jPasswordField.setEchoChar(echoChar);
        jPasswordField.setBounds(x, y, width, heigth);
        
        jPasswordField.setFont(new Font("Arial", Font.PLAIN, 18));
        jPasswordField.setBackground(Color.WHITE);
        jPasswordField.setForeground(color);
        return jPasswordField;
    }
}
