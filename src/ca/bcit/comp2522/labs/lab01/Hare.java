package ca.bcit.comp2522.labs.lab01;

import java.util.Random;

public class Hare {
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
        return "Hare's position is: " + position;
    }

    public boolean equals(Object obj) {
        if(obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Hare object = (Hare) obj;

        if (object.getPosition() == this.position) {
            return true;
        }
        else {
            return false;
        }
    }
}
