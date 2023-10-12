package Seminar_2;

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
    private final JPanel panelBottom = new JPanel(new BorderLayout());

    private final JPanel panelButton = new JPanel(new GridLayout(1, 2));
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

        panelButton.add(btnStart);
        panelButton.add(btnStop);
        add(panelButton, BorderLayout.NORTH);
        panelBottom.add(log);
        add(panelBottom, BorderLayout.EAST);

        log.setEditable(false);
        JScrollPane scrollLog = new JScrollPane(log);
        add(scrollLog);
        setVisible(true);
        clients = new ClientGUI(this);


        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isServerWorking) {
                    isServerWorking = false;
                    log.append("Server stop" + String.format("%n"));
                } else {
                    log.append("Server is stop" + String.format("%n"));
                }
            }
        });

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isServerWorking) {
                    log.append("Server run" + String.format("%n"));
                } else {
                    isServerWorking = true;
                    log.append("Server is run" + String.format("%n"));
                    clients.setVisible(true);
                }
            }
        });
    }
}
