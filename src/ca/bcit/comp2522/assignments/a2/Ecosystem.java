package ca.bcit.comp2522.assignments.a2;

import java.util.ArrayList;

public class Ecosystem {
    private ArrayList<Pool> pools;

    public Ecosystem() {
        this.pools = new ArrayList<>();
    }

    public void addPool(Pool newPool) {
        if (newPool != null) {
            pools.add(newPool);
        }
    }

    public void reset() {
        pools.clear();
    }

    public int getGuppyPopulation() {
        int totalGuppies = 0;
        for (Pool currentPool : pools) {
            totalGuppies += currentPool.getPopulation();
        }
        return totalGuppies;
    }

    public int adjustForCrowding() {
        int destroyedGuppies = 0;
        for (Pool currentPool : pools) {
            destroyedGuppies += currentPool.adjustForCrowding();
        }
        return destroyedGuppies;
    }

    public void setupSimulation() {
        final double vol1 = 3000.0;
        final double temp1 = 42.0;
        final double pH1 = 7.9;
        final double nutcoe1 = 0.9;

        final double vol2 = 15000.0;
        final double temp2 = 39.0;
        final double pH2 = 7.7;
        final double nutcoe2 = 0.85;

        final double vol3 = 4500.0;
        final double temp3 = 37.0;
        final double pH3 = 7.5;
        final double nutcoe3 = 1.0;

        final int maxAmountOfGuppies1 = 300;
        final int maxAmountOfGuppies2 = 100;
        final int maxAmountOfGuppies3 = 200;

        Pool Skookumchuk = new Pool("Skookumchuk", vol1, temp1, pH1, nutcoe1);
        Pool Squamish = new Pool("Squamish", vol2, temp2, pH2, nutcoe2);
        Pool Semiahmoo = new Pool("Semiahmoo", vol3, temp3, pH3, nutcoe3);

//        for (int guppies = 0; guppies < maxAmountOfGuppies1; guppies++) {
//            Guppy guppy = new Guppy("Poecilia reticulata", )
//        }
    }
}
