package ru.shadrina.chat.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class BottomPanel extends JPanel {
    private JTextField newMessage;
    private String message;

    public BottomPanel() {
        setBackground(new Color(253, 226, 246, 255));
        JLabel messageLabel = new JLabel("Enter text");
        add(messageLabel);
        newMessage = new JTextField(12);
        add(newMessage);
        newMessage.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendButtonPressed();
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        JButton clearButton = new JButton("Clear");
        clearButton.setBackground(new Color(253, 146, 166, 255));
        add(clearButton);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newMessage.setText("");
            }
        });
        JButton sendButton = new JButton("Send");
        sendButton.setBackground(new Color(107, 132, 253, 255));
        add(sendButton);
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendButtonPressed();
            }
        });
    }

    public void sendButtonPressed() {
        if (!newMessage.getText().trim().isEmpty()) {
            message = newMessage.getText().trim();
            GraphicsWindow.addMessage(GraphicsWindow.getUserName().isEmpty() ?
                    "Аноним" + ": " + message : GraphicsWindow.getUserName() + ": " + message);
            message = "";
            newMessage.setText("");
        }
    }

}
