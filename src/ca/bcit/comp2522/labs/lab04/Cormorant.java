package ca.bcit.comp2522.labs.lab04;

public class Cormorant implements Aquatic, Aerial, Terrestrial{
    @Override
    public void fly() {
        System.out.println("The cormorant is flying.");
    }

    @Override
    public void swim() {
        System.out.println("The cormorant is swimming.");
    }

    @Override
    public void walk() {
        System.out.println("The cormorant is walking.");
    }
}
