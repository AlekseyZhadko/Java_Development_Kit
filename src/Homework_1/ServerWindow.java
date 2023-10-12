package Homework_1;

import Seminar_1.SettingsWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ServerWindow extends JFrame {

    private static final int WINDOW_HEIGTH = 300;
    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_POSX = 500;
    private static final int WINDOW_POSY = 550;


    private final JButton btnStart = new JButton("Start");
    private final JButton btnStop = new JButton("Stop");
    private JTextArea log = new JTextArea();
    private boolean isServerWorking;
    ClientGUI clients;

    ServerWindow() {
        isServerWorking = false;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGTH);
        setTitle("Char server");
        setResizable(false);
        setAlwaysOnTop(true);
        setLayout(new GridLayout(1, 2));
        add(btnStart);
        add(btnStop);
        setVisible(true);

        clients = new ClientGUI(this);

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isServerWorking = false;
            }
        });

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isServerWorking = true;
                clients.setVisible(true);
            }
        });
    }
}
