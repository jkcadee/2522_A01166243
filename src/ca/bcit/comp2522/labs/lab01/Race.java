package ca.bcit.comp2522.labs.lab01;

import java.util.Random;

public class Race {
    private int length;
    Hare hare;
    Tortoise tortoise;
    Random randomNumber;

    public Race(int length) {
        this.length = length;
        hare = new Hare();
        tortoise = new Tortoise();
        randomNumber = new Random();
    }

    final public void reset() {
        hare.setPosition(0);
        tortoise.setPosition(0);
    }

    private String race() {
        do {
            int generateRandomNum = randomNumber.nextInt(101);

            if (generateRandomNum <= 50) {
                hare.move();
                tortoise.move();
            }
            else if (generateRandomNum <= 100) {
                tortoise.move();
                hare.move();
            }

        } while (tortoise.getPosition() < length && hare.getPosition() < length);

        if (tortoise.getPosition() >= length) {
            return "Tortoise wins!";
        }
        else {
            return "Hare wins!";
        }
    }

    final public String simulateRace() {
        reset();
        return race();
    }
}
