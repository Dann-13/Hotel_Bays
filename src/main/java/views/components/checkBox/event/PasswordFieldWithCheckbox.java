/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views.components.checkBox.event;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;

/**
 *
 * @author dann-dev
 */
public class PasswordFieldWithCheckbox {
    
    public static JCheckBox createCheckboxWithPasswordField(JPasswordField passwordField, int x, int y, int width, int height) {
        JCheckBox showPasswordCheckbox = new JCheckBox(" ͡o ");
        showPasswordCheckbox.setBounds(x, y, width, height);
        
        showPasswordCheckbox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    passwordField.setEchoChar((char) 0);
                } else {
                    passwordField.setEchoChar('*');
                }
            }
        });

        return showPasswordCheckbox;
    }

}
