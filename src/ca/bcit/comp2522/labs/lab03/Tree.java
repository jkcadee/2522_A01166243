package ca.bcit.comp2522.labs.lab03;

import java.util.Objects;

public class Tree {
    enum Species { MAPLE(0), ARBUTUS(1), BLUE_SPRUCE(2);
        private int value;

        Species(final int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private Species treeType;
    private int ageInYears;
    private double trunkCircumference;

    public Tree(final Species newTreeType, final int newAgeInYears, final double newTrunkCircumference) {
        if (newAgeInYears < 0 || newTrunkCircumference < 0.0) {
            throw new IllegalArgumentException();
        }

        this.treeType = newTreeType;
        this.ageInYears = newAgeInYears;
        this.trunkCircumference = newTrunkCircumference;
    }

    public Tree(final int newAgeInYears, final double newTrunkCircumference) {
        this(Species.MAPLE, newAgeInYears, newTrunkCircumference);
    }

    public final void setAgeInYears(int ageInYears) {
        this.ageInYears = ++ageInYears;
    }

    public void setTrunkCircumference(final double trunkCircumference) {
        if (trunkCircumference >= this.trunkCircumference) {
            this.trunkCircumference = trunkCircumference;
        }
    }

    public int getAgeInYears() {
        return ageInYears;
    }

    public double getTrunkCircumference() {
        return trunkCircumference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tree tree = (Tree) o;
        return ageInYears == tree.ageInYears &&
                Double.compare(tree.trunkCircumference, trunkCircumference) == 0 &&
                treeType == tree.treeType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(treeType, ageInYears, trunkCircumference);
    }

    @Override
    public String toString() {
        return "Tree{" +
                "treeType=" + treeType +
                ", ageInYears=" + ageInYears +
                ", trunkCircumference=" + trunkCircumference +
                '}';
    }
}
