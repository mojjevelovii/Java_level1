package ru.geekbrains.javaone.lesson5;

import ru.geekbrains.javaone.lesson5.zoo.Bird;
import ru.geekbrains.javaone.lesson5.zoo.Cat;
import ru.geekbrains.javaone.lesson5.zoo.Dog;
import ru.geekbrains.javaone.lesson5.zoo.Horse;

public class Main {

    public static void main(String[] args) {


        Animal[] zoo = {
                new Cat(200.0, 2.0),
                new Dog(500.0, 0.5, 10.0),
                new Bird(5.0, 0.2),
                new Horse(1500, 3.0, 100.0),
                new Animal(100.0, 0.5, 15000),

                new Cat(200.0, 2.0),
                new Dog(500.0, 0.5, 10.0),
                new Bird(5.0, 0.2),
                new Horse(1500, 3.0, 100.0),
                new Animal(100.0, 0.5, 15000)};


        for (int i = 0; i < zoo.length; i++) {
            printAction(zoo[i]);
        }


    }


    public static String getAnimalType(Animal animal) {

        if (animal instanceof Cat) {
            return "Котик";

        } else if (animal instanceof Dog) {
            return "Пёсик";


        } else if (animal instanceof Bird) {
            return "Чижик";


        } else if (animal instanceof Horse) {
            return "Коник БоДжек";


        } else {
            return "Неведома зверушка, вероятно утконосик,";
        }
    }

    public static void printAction(Animal animal) {
        String animalType = getAnimalType(animal);

        double runRange = getRandom(700.0);
        double jumpRange = getRandom(2.0);
        double swimRange = getRandom(70);
        String message = "%s%s %s %.2f %s";

        System.out.printf(message, animalType, not(animal.run(runRange)), "пробежал", runRange, "метров! \n");
        System.out.printf(message, animalType, not(animal.jump(jumpRange)), "прыгнул на", jumpRange, "метров! \n");
        System.out.printf(message, animalType, not(animal.swim(swimRange)), "проплыл", swimRange, "метров! \n");

    }

    public static double getRandom(double range) {
        return Math.random() * range;
    }

    public static String not(boolean isCan) {
        if (isCan) {
            return "";
        } else {
            return " не";
        }
    }
}
