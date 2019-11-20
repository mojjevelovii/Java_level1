package ru.geekbrains.javaone.lesson7;

import javax.swing.*;
import java.awt.*;

/*
1. Полностью разобраться с кодом
(попробовать полностью самостоятельно переписать одно из окон)

2. Составить список вопросов и приложить в виде комментария к домашней работе

3. * Рачертить панель Map на поле для игры, согласно fieldSize

* */

public class GameMap extends JPanel {
    public static final int GM_HVH = 0;
    public static final int GM_HVA = 1;
    private static final int GAP = 3;

    GameMap() {
        setBackground(Color.BLACK);
    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
        System.out.printf("mode=%d, fieldSize=%d, winLen=%d\n", mode, fieldSizeX, winLength);

        initLayout(fieldSizeX, fieldSizeY);

        fillField(fieldSizeX, fieldSizeY);

        this.updateUI();
    }

    private void initLayout(int fieldSizeX, int fieldSizeY) {
        GridLayout grid = new GridLayout(fieldSizeX, fieldSizeY, GAP, GAP);
        grid.preferredLayoutSize(this);
        this.setLayout(grid);
    }

    private void fillField(int fieldSizeX, int fieldSizeY) {
        int buttonQuantity = fieldSizeX * fieldSizeY;
        for (int i = 0; i < buttonQuantity; i++) {
            this.add(new JButton());
        }
    }


}
