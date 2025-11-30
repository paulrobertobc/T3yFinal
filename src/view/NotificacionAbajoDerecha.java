/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author PAUL
 */
import javax.swing.*;
import java.awt.*;

public class NotificacionAbajoDerecha extends JWindow {
    private final int duration = 5000;

    public NotificacionAbajoDerecha(JFrame owner, String message) {
        super(owner);
        JLabel label = new JLabel(message);
        label.setOpaque(true);
        label.setBackground(new Color(40, 40, 40));
        label.setForeground(Color.WHITE);
        label.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        add(label);
        pack();
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = screen.width - getWidth() - 50;
        int y = screen.height - getHeight() - 80;
        setLocation(x, y);
    }

    public void showToast() {
        setVisible(true);
        new Timer(duration, e -> setVisible(false)).start();
    }

    public static void show(JFrame owner, String msg) {
        NotificacionAbajoDerecha t = new NotificacionAbajoDerecha(owner, msg);
        t.showToast();
    }
}

