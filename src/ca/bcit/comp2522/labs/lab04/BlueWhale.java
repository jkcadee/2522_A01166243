package ca.bcit.comp2522.labs.lab04;

public class BlueWhale implements Aquatic {
    public interface FilterFeeder {
        void filter();
    }


    @Override
    public void swim() {
        System.out.println("The whale is swimming.");

    }
}
