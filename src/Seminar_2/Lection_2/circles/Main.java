package Seminar_2.Lection_2.circles;

import Seminar_2.Lection_2.common.CanvasRepaintListener;
import Seminar_2.Lection_2.common.Interactable;
import Seminar_2.Lection_2.common.MainCanvas;
import Seminar_2.Lection_2.common.Sprite;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame implements CanvasRepaintListener {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    private final Interactable[] interactables = new Interactable[10];
    MainCanvas canvas;

    private Main() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");
        for (int i = 0; i < interactables.length; i++) {
            interactables[i] = new Ball();
        }
        canvas = new MainCanvas(this);
        add(canvas);
        setVisible(true);
    }


    public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(MainCanvas canvas, float deltaTime) {
        for (int i = 0; i < interactables.length; i++) {
            interactables[i].update(canvas, deltaTime);
        }
    }

    private void render(MainCanvas canvas, Graphics g) {
        for (int i = 0; i < interactables.length; i++) {
            interactables[i].render(canvas, g);
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}