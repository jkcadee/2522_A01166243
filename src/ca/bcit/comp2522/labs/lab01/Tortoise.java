package ca.bcit.comp2522.labs.lab01;

import java.util.Random;

public class Tortoise {
    private int position;
    Random randomNumber;

    final public void setPosition(int position) {
        this.position = position;
    }

    final public int getPosition() {
        return this.position;
    }

    final public int move() {
        randomNumber = new Random();
        int generateRandomNum = randomNumber.nextInt(101);

        if (generateRandomNum <= 50) {
            return position += 3;
        }
        else if (generateRandomNum <= 70) {
            return position -= 6;
        }
        else {
            return position += 1;
        }
    }

    final public String toString() {
        return "Tortoise's position is: " + position;
    }

    final public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Tortoise object = (Tortoise) obj;

        if (object.getPosition() == this.position) {
            return true;
        }
        else {
            return false;
        }
    }
}
