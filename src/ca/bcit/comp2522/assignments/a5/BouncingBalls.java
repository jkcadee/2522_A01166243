package ca.bcit.comp2522.assignments.a5;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

/**
 * BouncingBalls, an introduction to threading and JavaFX.
 *
 * @author BCIT
 * @author Janelle Kwok
 * @version 2020
 */
public class BouncingBalls extends Application {
    /**
     * Max X space for the scene.
     */
    public static final int MAX_X = 500; // horizontal edge of enclosing Panel
    /**
     * Max Y space for the scene.
     */
    public static final int MAX_Y = 500; // vertical edge of enclosing Panel

    private static final List<Ball> BALL_LIST = new ArrayList<>();
    private static final Random RANDOM = new Random();
    
    /**
     * Getter for BALL_LIST.
     *
     * @pre true
     * @post true
     * @return The List of created Balls.
     */
    public static List<Ball> getBallList() {
        return BALL_LIST;
    }

    /*
     * Populates the BALL_LIST and the canvas simultaneously.
     */
    private void populatingTheListAndCanvas(Pane canvas, int amountOfBalls) {
        for (int index = 0; index < amountOfBalls; index++) {
            final Ball newBall = new Ball(RANDOM.nextInt(MAX_X), RANDOM.nextInt(MAX_Y));
            canvas.getChildren().add(newBall);
            BALL_LIST.add(newBall);
        }
    }

    /*
     * Starts the Thread for each Ball object in BALL_LIST.
     */
    private void startingTheThreads() {
        BALL_LIST.forEach(ball -> {
            final Thread bouncer = new Thread(ball);
            bouncer.setDaemon(true);
            bouncer.start();
        });
    }

    /**
     * Demonstrates threading in JavaFX.
     * @param primaryStage contains the Scene
     */
    public void start(Stage primaryStage) {
        final Scanner scanner = new Scanner(System.in);

        final Pane canvas = new Pane();
        final Scene scene = new Scene(canvas, MAX_X, MAX_Y);

        System.out.println("How many balls would you like?");

        populatingTheListAndCanvas(canvas, scanner.nextInt());

        primaryStage.setTitle("Threads and Balls");
        primaryStage.setScene(scene);
        primaryStage.show();

        startingTheThreads();
    }

    /**
     * Launches the JavaFX application.  We still need a main method in our
     * JavaFX applications.  The main method must do one thing.  Pass
     * the command line arguments (args) to the launch method inherited from
     * the Application class.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
