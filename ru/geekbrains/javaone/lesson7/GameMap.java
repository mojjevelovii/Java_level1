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
    GameMap() {
        setBackground(Color.BLACK);
    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
        System.out.printf("mode=%d, fieldSize=%d, winLen=%d\n", mode, fieldSizeX, winLength);
    }
}
