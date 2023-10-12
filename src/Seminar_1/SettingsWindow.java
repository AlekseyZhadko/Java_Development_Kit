package Seminar_1;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {

    private static final int WINDOW_HEIGTH = 400;
    private static final int WINDOW_WIDTH = 550;


    JButton btnStart = new JButton("Start new game");

    SettingsWindow(GameWindow gameWindow) {
        setLocationRelativeTo(gameWindow);
        setSize(WINDOW_WIDTH, WINDOW_HEIGTH);

        JPanel panBottom = new JPanel(new GridLayout(10, 1));
        JLabel labelMode = new JLabel(" Выберите режим игры:");
        panBottom.add(labelMode);

        ButtonGroup groupButtonMode = new ButtonGroup();
        JRadioButton modeHuman = new JRadioButton(" Человек против человека");
        JRadioButton modeAI = new JRadioButton(" Человек против компьютера");
        groupButtonMode.add(modeHuman);
        groupButtonMode.add(modeAI);
        panBottom.add(modeHuman);
        panBottom.add(modeAI);

        JLabel labelMap = new JLabel(" Выберите размеры поля:");
        int min_map = 3;
        JLabel labelSlider = new JLabel(" Установленный размер поля: " + min_map);
        JSlider sliderMap = new JSlider(3, 10, 3);
        panBottom.add(labelMap);
        panBottom.add(labelSlider);
        panBottom.add(sliderMap);

        JLabel labelLineWin = new JLabel(" Выберите длину для победы:");
        int min_line = 3;
        JLabel labelLine = new JLabel(" Установленная длина: " + min_line);
        JSlider sliderLine = new JSlider(3, 3 , 3);
        panBottom.add(labelLineWin);
        panBottom.add(labelLine);
        panBottom.add(sliderLine);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int gameMode;
                if (modeHuman.isSelected()) {
                    gameMode = Map.MODE_HVA;
                } else if (modeAI.isSelected()) {
                    gameMode = Map.MODE_HVH;
                } else {
                    throw new RuntimeException("Unkown game mode");
                }
                gameWindow.startNewGame(gameMode, sliderMap.getValue(),
                        sliderMap.getValue(), sliderLine.getValue());
                setVisible(false);
            }
        });

        sliderMap.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                labelSlider.setText(" Установленный размер поля: " + sliderMap.getValue());
                sliderLine.setMaximum(sliderMap.getValue());
            }
        });

        sliderLine.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                labelLine.setText(" Установленная длина: " + sliderLine.getValue());
            }
        });

        panBottom.add(btnStart);
        add(panBottom, BorderLayout.CENTER);
    }
}
