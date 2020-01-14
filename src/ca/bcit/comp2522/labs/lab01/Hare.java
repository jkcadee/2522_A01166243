package ca.bcit.comp2522.labs.lab01;

import java.util.Random;

public class Hare {
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

        if (generateRandomNum <= 20) {
            return position;
        }
        else if (generateRandomNum <= 30) {
            return position += 9;
        }
        else if (generateRandomNum <= 40) {
            return position -= 12;
        }
        else if (generateRandomNum <= 70) {
            return position += 1;
        }
        else {
            return position -= 2;
        }
    }

    public String toString() {
        return Integer.toString(position);
    }

    public boolean equals(Hare obj) {
        if (obj.getPosition() == this.position) {
            return true;
        }
        return false;
    }

}
