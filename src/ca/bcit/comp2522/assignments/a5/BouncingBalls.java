package ca.bcit.comp2522.assignments.a5;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * BouncingBalls, an introduction to threading and JavaFX.
 *
 * @author BCIT
 * @author Janelle Kwok
 * @version 2020
 */
public class BouncingBalls extends Application {
    /**
     * Demonstrates threading in JavaFX.
     * @param primaryStage contains the Scene
     */
    public void start(Stage primaryStage) {
        final Scanner scanner = new Scanner(System.in);
        final Random random = new Random();
        Pane canvas = new Pane();
        Scene scene = new Scene(canvas, 500, 500);
        List<Ball> ballList = new ArrayList<>();
        Ball ballSingle = new Ball(250, 250);

        System.out.println("How many balls would you like?");
        int amountOfBalls = scanner.nextInt();
//
        for (int index = 0; index < amountOfBalls; index++) {
            Ball newBall = new Ball(random.nextInt(500), random.nextInt(500));
            ballList.add(newBall);
        }

//        canvas.getChildren().add(ballSingle);

        for (Ball ball : ballList) {
            canvas.getChildren().add(ball);
        }

        primaryStage.setTitle("Threads and Balls");
        primaryStage.setScene(scene);
        primaryStage.show();

//        Thread bounce = new Thread(ballSingle);
//        bounce.setDaemon(true);
//        bounce.start();

        for (Ball ball : ballList) {
            Thread bouncer = new Thread(ball);
            bouncer.setDaemon(true);
            bouncer.start();
        }
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
