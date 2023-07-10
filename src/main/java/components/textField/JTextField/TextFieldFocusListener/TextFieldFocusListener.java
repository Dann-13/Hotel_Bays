/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components.textField.JTextField.TextFieldFocusListener;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.JTextField;

/**
 *
 * @author dann-dev
 */
public class TextFieldFocusListener implements FocusListener {

    private JTextField textField;
    private String placeholderText;
    private Color defaultBorderColor;
    private Color focusBorderColor;

    public TextFieldFocusListener(JTextField textField, String placeholderText, Color defaultBorderColor, Color focusBorderColor) {
        this.textField = textField;
        this.placeholderText = placeholderText;
        this.defaultBorderColor = defaultBorderColor;
        this.focusBorderColor = focusBorderColor;
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (textField.getText().equals(placeholderText)) {
            textField.setCaretPosition(0);
            textField.setText("");
            textField.setBorder(BorderFactory.createLineBorder(focusBorderColor));

        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (textField.getText().isEmpty()) {
            textField.setText(placeholderText);
            textField.setBorder(BorderFactory.createLineBorder(defaultBorderColor));
        }
    }

}
