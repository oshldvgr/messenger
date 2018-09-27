package ru.shadrina.chat.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class UpperPanel extends JPanel {
    private JTextField nameField;
    private JPanel logginPanel;
    private JPanel loggoutPanel;
    private JLabel salutLabel;
    private String name = "";

    public UpperPanel() {
        setBackground(new Color(253, 226, 246, 255));

        logginPanel = new JPanel();
        logginPanel.setBackground(new Color(253, 226, 246, 255));
        add(logginPanel);
        logginPanel.setVisible(true);
        JLabel nameLabel = new JLabel("Name");
        logginPanel.add(nameLabel);
        nameField = new JTextField();
        nameField.setColumns(10);
        logginPanel.add(nameField);
        JButton loginButton = new JButton("Log in");
        loginButton.setBackground(new Color(107, 132, 253, 255));
        logginPanel.add(loginButton);

        loggoutPanel = new JPanel();
        loggoutPanel.setBackground(new Color(253, 226, 246, 255));
        add(loggoutPanel);
        loggoutPanel.setVisible(false);
        salutLabel = new JLabel();
        loggoutPanel.add(salutLabel);
        JButton logoutButton = new JButton("Log out");
        logoutButton.setBackground(new Color(253, 146, 166, 255));
        loggoutPanel.add(logoutButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!nameField.getText().trim().isEmpty()) {
                    name = nameField.getText().trim();
                    GraphicsWindow.setUserName(name);
                    salutLabel.setText("Salut, " + nameField.getText().trim() + "!");
                    logginPanel.setVisible(false);
                    loggoutPanel.setVisible(true);
                    GraphicsWindow.addMessage("Пользователь " + name + " вошел в чат");

                }
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GraphicsWindow.addMessage("Пользователь " + name + " вышел из чата");
                nameField.setText("");
                GraphicsWindow.setUserName("");
                name = "";
                loggoutPanel.setVisible(false);
                logginPanel.setVisible(true);
            }
        });
    }
}
