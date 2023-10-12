package Seminar_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Map extends JPanel {

    public static final int MODE_HVA = 0;
    public static final int MODE_HVH = 1;
    private static final Random RANDOM = new Random();
    private final int HUMAN_DOT = 1;
    private final int AI_DOT = 2;
    private final int EMPTY_DOT = 0;
    private static final int DOT_PADDING = 5;

    private int gameOverType;
    private static final int STATE_DRAW = 0;
    private static final int STATE_WIN_HUMAN = 1;
    private static final int STATE_WIN_AI = 2;

    private static final String MSG_WIN_HUMAN = "WIN HUMAN!";
    private static final String MSG_WIN_AI = "WIN AI!";
    private static final String MSG_DRAW = "NOT WIN!";

    private int fieldSizeY = 3;
    private int fieldSizeX = 3;
    private char[][] field;
    private int panelWidth;
    private int panelHeigth;
    private int cellHeigth;
    private int cellWidth;

    Map() {
        setBackground(Color.WHITE);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                update(e);
            }
        });
    }

    private void update(MouseEvent e) {
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeigth;
        if (!isValidCell(cellX, cellY) || isEmptyCell(cellX, cellY)) return;
        field[cellX][cellY] = HUMAN_DOT;
        if (checkEndGame(HUMAN_DOT, STATE_WIN_HUMAN)) return;
        aiTurn();
        repaint();
        if (checkEndGame(AI_DOT, STATE_WIN_AI)) return;
    }

    private boolean checkEndGame(int dot, int gameOverType) {
        char dot_win;
        if (dot == 1) dot_win = HUMAN_DOT;
        else dot_win = AI_DOT;

        if (checkWin(dot_win)) {
            this.gameOverType = gameOverType;
            repaint();
            return true;
        }
        if (isMapFull()) {
            this.gameOverType = STATE_DRAW;
            repaint();
            return true;
        }
        return false;
    }

    void startNewGame(int mode, int fSzX, int fSzY, int wLen) {
        initMap(fSzX,fSzY);
        System.out.printf("Mode: %d;\nSize: x=%d, y=%d; \nWin Length: %d",
                mode, fSzX, fSzY, wLen);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponents(g);
        render(g);
    }

    private void render(Graphics g) {
        panelWidth = getWidth();
        panelHeigth = getHeight();
        cellHeigth = panelHeigth / fieldSizeY;
        cellWidth = panelWidth / fieldSizeX;

        g.setColor(Color.BLACK);
        for (int h = 0; h < fieldSizeY; h++) {
            int y = h * cellHeigth;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int w = 0; w < fieldSizeY; w++) {
            int x = w * cellWidth;
            g.drawLine(x, 0, x, panelHeigth);
        }
        repaint();

//        for (int y = 0; y < fieldSizeY; y++) {
//            for (int x = 0; x < fieldSizeX; x++) {
//                if (field[y][x] == EMPTY_DOT) continue;
//
//                if (field[y][x] == HUMAN_DOT) {
//                    g.setColor(Color.blue);
//                    g.fillOval(x * cellWidth + DOT_PADDING,
//                            y * cellHeigth + DOT_PADDING,
//                            cellWidth - DOT_PADDING * 2,
//                            cellHeigth - DOT_PADDING * 2);
//                } else if (field[y][x] == AI_DOT) {
//                    g.setColor(new Color(0xff0000));
//                    g.fillOval(x * cellWidth + DOT_PADDING,
//                            y * cellHeigth + DOT_PADDING,
//                            cellWidth - DOT_PADDING * 2,
//                            cellHeigth - DOT_PADDING * 2);
//                } else {
//                    throw new RuntimeException("Exception value" + field[x][y] +
//                            " in cel: x=" + x + "y=" + y);
//                }
//            }
//        }
////        if (isGameOver) showMessageGameOver(g);
//        repaint();
    }

    private void initMap(int fSzX, int fSzY) {
        fieldSizeY = fSzX;
        fieldSizeX = fSzY;
        field = new char[fieldSizeY][fieldSizeX];
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
    }

    private boolean isValidCell(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    private boolean isEmptyCell(int x, int y) {
        return field[y][x] == EMPTY_DOT;
    }


    private void aiTurn() {
        int x, y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (isEmptyCell(x, y));
        field[y][x] = AI_DOT;
    }

    private boolean checkWin(char c) {
        if (field[0][0] == c && field[0][1] == c && field[0][2] == c) return true;
        if (field[1][0] == c && field[1][1] == c && field[1][2] == c) return true;
        if (field[2][0] == c && field[2][1] == c && field[2][2] == c) return true;

        if (field[0][0] == c && field[1][0] == c && field[2][0] == c) return true;
        if (field[0][1] == c && field[1][1] == c && field[2][1] == c) return true;
        if (field[0][2] == c && field[1][2] == c && field[2][2] == c) return true;

        if (field[0][0] == c && field[1][1] == c && field[2][2] == c) return true;
        if (field[0][2] == c && field[1][1] == c && field[2][0] == c) return true;
        return false;
    }

    private boolean isMapFull() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[i][j] == EMPTY_DOT) return false;
            }
        }
        return true;
    }

}
