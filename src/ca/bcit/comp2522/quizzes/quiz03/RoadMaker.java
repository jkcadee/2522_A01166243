package ca.bcit.comp2522.quizzes.quiz03;

import java.util.ArrayList;

/**
 * A class to drive the Road simulation.
 *
 * @author Janelle A01166243
 * @author Kayden A01174919
 */
public class RoadMaker {
    /**
     * Drives the Road simulation.
     *
     * @param args command-line arguments
     */
    public static void main(final String[] args) {
        final Road mainStreet = new Road("Main Street", Direction.NORTH);
        final Boulevard niagaraBoulevard = new Boulevard("Niagara Boulevard", Direction.SOUTH, true);
        final Highway transCanada = new Highway("TransCanada", Direction.EAST, true);

        final ArrayList<Road> roads = new ArrayList<>();
        roads.add(mainStreet);
        roads.add(niagaraBoulevard);
        roads.add(transCanada);

        for (final Road road : roads) {
            System.out.println(road.toString());
        }
    }
}
