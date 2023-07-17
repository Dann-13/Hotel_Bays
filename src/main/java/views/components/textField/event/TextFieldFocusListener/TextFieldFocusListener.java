/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views.components.textField.event.TextFieldFocusListener;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JTextField;

/**
 *
 * @author dann-dev
 */
public class TextFieldFocusListener implements FocusListener, MouseListener {

    private JTextField textField;
    private String placeholderText;
    private Color defaultBorderColor;
    private Color focusBorderColor;
    private boolean isPlaceholderShown;

    public TextFieldFocusListener(JTextField textField, String placeholderText, Color defaultBorderColor, Color focusBorderColor) {
        this.textField = textField;
        this.placeholderText = placeholderText;
        this.defaultBorderColor = defaultBorderColor;
        this.focusBorderColor = focusBorderColor;
        this.isPlaceholderShown = true;

        textField.setForeground(defaultBorderColor);
        textField.setText(placeholderText);
        textField.addMouseListener(this);
        textField.addFocusListener(this);
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (isPlaceholderShown) {
            if (textField.getText().equals(placeholderText)) {
                textField.setText("");
            }
            textField.setForeground(focusBorderColor);
            isPlaceholderShown = false;
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (textField.getText().isEmpty() || textField.getText().equals(placeholderText)) {
            textField.setForeground(defaultBorderColor);
            textField.setText(placeholderText);
            isPlaceholderShown = true;
        } else {
            textField.setForeground(focusBorderColor);
            isPlaceholderShown = false;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (isPlaceholderShown) {
            textField.setCaretPosition(0);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
