/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components.jPasswordField.event;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

/**
 *
 * @author dann-dev
 */
public class PasswordFieldCapsLockListener extends KeyAdapter {

    private JPasswordField passwordField;
    private JLabel capsLockLabel;

    public PasswordFieldCapsLockListener(JPasswordField passwordField, JLabel capsLockLabel) {
        this.passwordField = passwordField;
        this.capsLockLabel = capsLockLabel;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_CAPS_LOCK) {
            boolean capsLockOn = Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK);
            capsLockLabel.setVisible(capsLockOn);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_CAPS_LOCK) {
            boolean capsLockOn = Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK);
            capsLockLabel.setVisible(capsLockOn);
        }
    }

}
