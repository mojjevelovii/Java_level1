package ru.geekbrains.javaone.lesson5.zoo;

import ru.geekbrains.javaone.lesson5.Animal;

public class Bird extends Animal {

    public Bird(double runLength, double jumpHeight) {
        super(runLength, jumpHeight);
    }


    @Override
    protected boolean swim(double swimLength) {
        return super.swim(swimLength);
    }
}
