package ru.geekbrains.javaone.lesson5.zoo;

import ru.geekbrains.javaone.lesson5.Animal;

public class Cat extends Animal {

    public Cat(double runLength, double jumpHeight) {
        super(runLength, jumpHeight);
    }

    @Override
    protected boolean swim(double swimLength) {
        return false;

    }

}
