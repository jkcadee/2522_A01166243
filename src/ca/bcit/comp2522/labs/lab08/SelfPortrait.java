package ca.bcit.comp2522.labs.lab08;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class SelfPortrait extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Ellipse ellipse1 = new Ellipse(250, 120, 85, 100);
        ellipse1.setFill(Color.BISQUE);

        Arc arc1 = new Arc(250, 110, 80, 100, 100, 90);
        arc1.setFill(Color.BLACK);

        Arc arc2 = new Arc(250, 110, 110, 100, 100, 90);
        arc2.setFill(Color.BLACK);

        Arc arc4 = new Arc(250, 110, 95, 100, 100, 90);
        arc4.setFill(Color.BLACK);

        Arc arc3 = new Arc(270, 100, 77, 100, 165, -190);
        arc3.setFill(Color.BLACK);

        Arc arc5 = new Arc(200, 130, 150, 90, 50, -90);
        arc5.setFill(Color.BLACK);

//        Rectangle

        Group root = new Group(arc5, ellipse1, arc1, arc2, arc3, arc4);
        Scene scene = new Scene(root, 500, 350, Color.LIGHTCORAL);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
