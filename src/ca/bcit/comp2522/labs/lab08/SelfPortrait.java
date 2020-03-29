package ca.bcit.comp2522.labs.lab08;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Shear;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

/**
 * Class that creates a Self Portrait in JavaFX.
 * @author Janelle Kwok
 * @version 2020
 */
public class SelfPortrait extends Application {

    /**
     * Constructs the self portrait.
     *
     * @param stage The Stage object to run the JavaFX application.
     * @pre true
     * @post Will display the JavaFX application.
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Ellipse head = new Ellipse(250, 120, 85, 100);
        head.setFill(Color.BISQUE);

        Arc bangs1 = new Arc(250, 110, 80, 100, 100, 90);
        bangs1.setFill(Color.BLACK);

        Arc bangs2 = new Arc(250, 110, 110, 100, 100, 90);
        bangs2.setFill(Color.BLACK);

        Arc bangs3 = new Arc(250, 110, 95, 100, 100, 90);
        bangs3.setFill(Color.BLACK);

        Arc bangs4 = new Arc(270, 100, 77, 100, 165, -190);
        bangs4.setFill(Color.BLACK);

        Arc hair1 = new Arc(200, 130, 150, 90, 50, -90);
        hair1.setFill(Color.BLACK);

        Arc hair2 = new Arc(90, 130, 100, 90, 50, -90);
        hair2.setFill(Color.BLACK);

        Group hairFront = new Group(bangs1, bangs2, bangs4, bangs3);
        Group hairBack = new Group(hair2, hair1);

        Rectangle neck = new Rectangle(219, 210, 60, 70);
        neck.setFill(Color.rgb(250, 216, 175));

        Rectangle torso = new Rectangle(170, 235, 160, 115);
        torso.setFill(Color.rgb(13, 14, 71));

        Arc collar = new Arc(250, 340, 120, 115, 50, 80);
        collar.setFill(Color.rgb(13, 14, 71));

        Arc shoulderLeft = new Arc(175, 345, 60, 115, 50, 110);
        shoulderLeft.setFill(Color.rgb(12, 12, 66));

        Arc shoulderRight = new Arc(325, 345, 60, 115, 130, -110);
        shoulderRight.setFill(Color.rgb(12, 12, 66));

        Ellipse armLeft = new Ellipse(153, 350, 40, 90);
        armLeft.setFill(Color.rgb(12, 12, 66));

        Ellipse armRight = new Ellipse(347, 350, 40, 90);
        armRight.setFill(Color.rgb(12, 12, 66));

        Group body = new Group(neck, shoulderLeft, shoulderRight, armLeft, armRight, torso, collar);

        Rectangle zipper1 = new Rectangle(220, 250, 5, 80);
        zipper1.setFill(Color.rgb(183, 188, 188));

        Rectangle zipper2 = new Rectangle(275, 250, 5, 80);
        zipper2.setFill(Color.rgb(183, 188, 188));

        Rectangle zipper3 = new Rectangle(247.5, 227.5, 5, 120);
        zipper3.setFill(Color.rgb(183, 188, 188));
        zipper3.getTransforms().add(new Shear(0, 0, 0.2, 0.3));

        Line jacketZipper = new Line(250.0, 400.0, 250.0, 226.0);
        jacketZipper.setFill(Color.rgb(183, 188, 188));

        Group zippers = new Group(zipper1, zipper2, zipper3, jacketZipper);

        Polygon nose = new Polygon();
        nose.getPoints().addAll(
                235.0, 150.0,
                250.0, 165.0,
                265.0, 150.0);
        nose.getTransforms().add(new Rotate(180, 180, 180));
        nose.getTransforms().add(new Translate(-137, 55));
        nose.setFill(Color.rgb(221, 188, 148));

        Arc mouth = new Arc(15, 20, 20, 20, 20, 270);
        mouth.setFill(Color.rgb(255, 156, 169));
        mouth.getTransforms().add(new Rotate(250, 200, 40));
        mouth.getTransforms().add(new Translate(30, 10));

        Group face = new Group(head, nose, mouth);

        Rectangle glassesLensLeft = new Rectangle(185, 110, 50, 30);
        glassesLensLeft.setFill(Color.rgb(227, 232, 232));

        Rectangle glassesLensLeftShine = new Rectangle(202, 112, 17, 27);
        glassesLensLeftShine.setFill(Color.rgb(241, 246, 246));

        Rectangle glassesFrameLeft = new Rectangle(181.5, 107, 57, 37);
        glassesFrameLeft.setFill(Color.rgb(37, 41, 41));
        glassesFrameLeft.getTransforms().add(new Scale(1.0, 1.0, 1.1,1.1));

        Rectangle glassesLensRight = new Rectangle(260, 110, 50, 30);
        glassesLensRight.setFill(Color.rgb(227, 232, 232));

        Rectangle glassesLensRightShine = new Rectangle(276, 112, 17, 27);
        glassesLensRightShine.setFill(Color.rgb(241, 246, 246));

        Rectangle glassesFrameRight = new Rectangle(256.5, 107, 57, 37);
        glassesFrameRight.setFill(Color.rgb(37, 41, 41));
        glassesFrameRight.getTransforms().add(new Scale(1.0, 1.0, 1.1,1.1));

        Rectangle glassesFrameMiddle = new Rectangle(238, 120, 19, 7.5);
        glassesFrameMiddle.setFill(Color.rgb(37, 41, 41));

        Group glasses = new Group(glassesFrameLeft, glassesFrameRight, glassesFrameMiddle, glassesLensLeft,
                glassesLensRight, glassesLensLeftShine, glassesLensRightShine);

        Image image = new Image("https://www.atlus.com/holiday2015/img/bottom-stars.jpg");

        ImageView background = new ImageView(image);
        background.setX(0);
        background.setY(0);
        background.setFitHeight(350);
        background.setFitWidth(550);

        Group root = new Group(background, hairBack, body,
                zippers, face, glasses, hairFront);

        Scene scene = new Scene(root, 500, 350, Color.LIGHTCORAL);

        stage.setScene(scene);
        stage.show();
    }


    /**
     * Runs the JavaFX program.
     *
     * @pre true
     * @post true
     * @param args Uses any command line arguments passed in.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
