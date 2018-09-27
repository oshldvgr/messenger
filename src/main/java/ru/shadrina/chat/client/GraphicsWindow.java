package ru.shadrina.chat.client;

import javax.swing.*;
import java.awt.*;

public class GraphicsWindow extends JFrame {
    private static String userName = "";
    private static JTextArea messageArea;


    public GraphicsWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 800);
        setTitle("Salut");

        UpperPanel upperPanel = new UpperPanel();
        add(upperPanel, BorderLayout.NORTH);
        BottomPanel bottomPanel = new BottomPanel();
        add(bottomPanel, BorderLayout.SOUTH);

        messageArea = new JTextArea();
        messageArea.setEditable(false);
        JScrollPane scroller = new JScrollPane(messageArea);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(messageArea, BorderLayout.CENTER);
    }

    public static void addMessage(String message) {
        messageArea.append(message + "\n");
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String name) {
        userName = name;
    }
}
