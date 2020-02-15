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
    public static void main(String[] args) {
        Road mainStreet = new Road("Main Street", Direction.NORTH);
        Boulevard niagaraBoulevard = new Boulevard("Niagara Boulevard", Direction.SOUTH, true);
        Highway transCanada = new Highway("TransCanada", Direction.EAST, true);

        ArrayList<Road> roads = new ArrayList<>();
        roads.add(mainStreet);
        roads.add(niagaraBoulevard);
        roads.add(transCanada);

        for (Road road : roads) {
            System.out.println(road.toString());
        }
    }
}
