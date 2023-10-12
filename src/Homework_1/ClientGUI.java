package Homework_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ClientGUI extends JFrame {
    private static final int WINDOW_HEIGTH = 300;
    private static final int WINDOW_WIDTH = 400;

    private final JTextArea log = new JTextArea();
    private final JPanel panelTop = new JPanel(new GridLayout(2, 3));
    private final JTextField tfIPAddress = new JTextField("123.0.0.1");
    private final JTextField tfPort = new JTextField("8189");
    private final JTextField tfLogin = new JTextField("ivanov_ivan");
    private final JPasswordField tfPassword = new JPasswordField("123456");
    private final JButton btnLogin = new JButton("Login");

    private final JPanel panelBottom = new JPanel(new BorderLayout());
    private final JTextField tfMessage = new JTextField();
    private final JButton btnSend = new JButton("Send");

    private final JPanel panelRight = new JPanel(new BorderLayout());

    private final JTextArea jtUsers = new JTextArea();

    public ClientGUI(ServerWindow serverWindow) {
        //setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(false);
        setLocationRelativeTo(serverWindow);
        setSize(WINDOW_WIDTH, WINDOW_HEIGTH);
        setTitle("Chat client");

        jtUsers.setEditable(false);
        JList<String> listUsers = new JList<>();
        String users[] = {" Dima Petrov ", " Ivan Nikolaevich ", " Petr "};
        listUsers.setListData(users);
        panelRight.add(jtUsers);
        panelRight.add(listUsers);
        add(panelRight, BorderLayout.EAST);


        panelTop.add(tfIPAddress);
        panelTop.add(tfPort);
        panelTop.add(tfLogin);
        panelTop.add(tfPassword);
        panelTop.add(btnLogin);
        add(panelTop, BorderLayout.NORTH);

        panelBottom.add(tfMessage, BorderLayout.CENTER);
        panelBottom.add(btnSend, BorderLayout.EAST);
        add(panelBottom, BorderLayout.SOUTH);

        log.setEditable(false);
        JScrollPane scrollLog = new JScrollPane(log);
        add(scrollLog);

        setVisible(true);

        btnSend.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                log.append(tfMessage.getText() + String.format("%n"));
            }
        });
    }
}
