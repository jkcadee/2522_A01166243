package ca.bcit.comp2522.labs.lab01;

import java.util.Random;

public class Tortoise {
    private int position;
    Random randomNumber;

    final public void setPosition(int position) {
        this.position = position;
        randomNumber = new Random();
    }

    final public int getPosition() {
        return this.position;
    }

    final public int move() {
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

    public String toString() {
        return Integer.toString(position);
    }

    public boolean equals(Tortoise obj) {
        if (obj.getPosition() == this.position) {
            return true;
        }
        return false;
    }
}
