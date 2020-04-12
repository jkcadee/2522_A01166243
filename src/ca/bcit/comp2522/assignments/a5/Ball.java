package ca.bcit.comp2522.assignments.a5;

import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Random;

/**
 *  Ball is a Runnable.  A Ball bounces.
 *
 * @author BCIT
 * @version 2020
 */
public class Ball extends Circle implements Runnable {
    private static final Random GENERATOR = new Random();
    private static final int BALL_SIZE = 10;
    private static final int DX_CHANGE = 5;
    private static final int DY_CHANGE = 5;

    private double dx; // change in horizontal position of ball
    private double dy; // change in vertical position of ball

    /**
     * Constructs an object of type Ball.
     * @param xPosition an int
     * @param yPosition an int
     */
    public Ball(int xPosition, int yPosition) {
        super(BALL_SIZE, Color.RED);

        this.setCenterX(xPosition);
        this.setCenterY(yPosition);

        this.dx = 1 + (DX_CHANGE - 1) * GENERATOR.nextDouble();
        this.dy = 1 + (DY_CHANGE - 1) * GENERATOR.nextDouble();

    }

    /*
     * Calculates the collision of the balls in a realistic manner.
     */
    private void bouncingBalls(Ball ball1, Ball ball2, final double differenceX,
                               final double differenceY) {
        final double ballDistance = Math.sqrt(differenceX * differenceX + differenceY * differenceY);
        final double x = differenceX / ballDistance;
        final double y = differenceY / ballDistance;
        final double ball1NewVelocityX = ball1.dx - (ball1.dx * x + ball1.dy * y) * x;
        final double ball1NewVelocityY = ball1.dy - (ball1.dx * x + ball1.dy * y) * y;
        final double ball2NewVelocityX = ball2.dx - (ball2.dx * x + ball2.dy * y) * x;
        final double ball2NewVelocityY = ball2.dy - (ball2.dx * x + ball2.dy * y) * y;

        ball1.dx = (x + ball1NewVelocityX);
        ball1.dy = (y + ball1NewVelocityY);
        ball2.dx = (x + ball2NewVelocityX);
        ball2.dy = (y + ball2NewVelocityY);
    }

    /*
     * Determines and calculates the collision of each Ball in BALL_LIST.
     *
     * @pre BALL_LIST is not null and has values inside of it.
     * @post If there is a collision, the balls switch their dx and dy values.
     */
    private void collision() {
        BouncingBalls.getBallList().forEach(ball -> {
            double deltaX = this.getCenterX() - ball.getCenterX(); // difference between each ball X
            double deltaY = this.getCenterY() - ball.getCenterY(); // difference between each ball Y
            double sumOfRadius = this.getRadius() + ball.getRadius(); // sum of both radii

            if (deltaX * deltaX + deltaY * deltaY <= sumOfRadius * sumOfRadius) {
                if (deltaX * (this.dx - ball.dx) + deltaY * (this.dy - ball.dy) < 0) {
                    bouncingBalls(this, ball, deltaX, deltaY);
                }
            }
        });
    }

    /**
     * Bounces the Ball perpetually.
     */
    public void run() {
        final int threadSleepTime = 20;
        while (true) {
            try {
                Thread.sleep(threadSleepTime); // sleep for 20 milliseconds
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }

            collision();

            /* Long-running operations must not be run on the JavaFX application
               thread, since this prevents JavaFX from updating the UI, resulting
               in a frozen UI.

               Furthermore any change to a Node that is part of a "live" scene
               graph must happen on the JavaFX application thread.

               Platform.runLater can be used to execute those updates on the
               JavaFX application thread.
             */
            Platform.runLater(() -> {
                // if bounce off top or bottom of Panel
                if (this.getCenterY() <= 0 || this.getCenterY() >= BouncingBalls.MAX_Y) {
                    dy *= -1; // reverses velocity in y direction
                }


                // if bounce off left or right of Panel
                if (this.getCenterX() <= 0 || this.getCenterX() >= BouncingBalls.MAX_X) {
                    dx *= -1; // reverses velocity in x direction
                }

                this.setCenterX(this.getCenterX() + dx); // determines new x-position
                this.setCenterY(this.getCenterY() + dy); // determines new y-position
            });
        }
    }
}
