package ca.bcit.comp2522.labs.lab03;

import java.util.ArrayList;
import java.util.Random;
import ca.bcit.comp2522.labs.lab03.Tree.Species;

public class Plantation {
    private ArrayList<Tree> farm = new ArrayList<>();

    public int size() {
        return farm.size();
    }

    public int add(Tree tree) {
        if (tree == null) {
            throw new NullPointerException();
        }
        farm.add(tree);
        return farm.size();
    }

    public int seed() {
        final int max = 1000;
        final int min = 10;
        final double circumferenceMax = 100.0;
        final double circumferenceMin = 10.0;
        final Random randomNumber = new Random();
        final int previousSize = farm.size();

        int generateRandomNumber = randomNumber.nextInt((max - min + 1)) + min;

        for (int treesPlanted = 0; treesPlanted < generateRandomNumber; treesPlanted++) {
            Species randomTreeType = null;
            int generateTreeType = randomNumber.nextInt(3);
            int generateAge = randomNumber.nextInt(1000);
            double generateTreeCircumference = circumferenceMin + (circumferenceMax - circumferenceMin + 1) * randomNumber.nextDouble();


            for (Species treeSpecies : Species.values()) {
                if (treeSpecies.getValue() == generateTreeType) {
                    randomTreeType = treeSpecies;
                    break;
                }
            }

            Tree newTree = new Tree(randomTreeType, generateAge, generateTreeCircumference);
            farm.add(newTree);
        }

        return farm.size() - previousSize;
    }

    public int harvestCount(double cutOffCircumference) {
        int treesReadyForHarvest = 0;
        for (int plantationSize = 0; plantationSize < farm.size(); plantationSize++) {
            if (farm.get(plantationSize).getTrunkCircumference() >= cutOffCircumference) {
                treesReadyForHarvest++;
            }
        }
        return treesReadyForHarvest;
    }
}
