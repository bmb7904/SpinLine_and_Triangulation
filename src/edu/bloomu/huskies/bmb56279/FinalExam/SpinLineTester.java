package edu.bloomu.huskies.bmb56279.FinalExam;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import oracle.jvm.hotspot.jfr.ThreadLocalTraceBuffer;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * A JavaFX application that will implement the custom SpinLine class that extends Line
 * The scene is initially empty and when the user clicks twice in the scene, a
 * SpinLine object is created with the starting and ending points at the two mouseClicks,
 * respectively. After 5 lines of a random color and a StrokeWidth of 8 are created,
 * each subsequent mouseClick causes all 5 lines to rotate in randomly generated
 * increments.
 *
 * I affirm that I did not communicate with anyone during this exam.
 *
 * @author Brett Bernardi
 */
public class SpinLineTester extends Application {

    // boolean flag that will keep track of mouse clicks.
    private boolean mouseClickOnceAlready = false;

    // these two temporarily hold the FIRST mouse click in the pane
    double clickX;
    double clickY;
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, 600,400, Color.LAVENDER);

        final int strokeWidth = 8;
        ThreadLocalRandom rand = ThreadLocalRandom.current();

        /**
         * This defines and passes an event handler, using a lambda expression, to the
         * root(Pane) node. This defines what happens when a user clicks in the pane.
         * If only one mouseclick was done, mouseclickOnceAlready == false, and the
         * point of the mouseclick is stored as the two fields. After the second
         * mouseclick, the stored first click's fields, combined with the current
         * click's point, are combined to create a line.
         */
        root.setOnMouseClicked(event -> {
            // if there are < 5 lines in scene and this is the first mouse click
            if(!mouseClickOnceAlready && root.getChildren().size() < 5) {
                clickX = event.getX();
                clickY = event.getY();
                mouseClickOnceAlready = true;
            }
            // if there are < 5 lines in scene and this is the second mouseclick
            // resets the boolean flag to start over
            else if(root.getChildren().size() < 5 && mouseClickOnceAlready == true){
                SpinLine line = new SpinLine(clickX, clickY, event.getX(), event.getY()
                        , rand.nextInt(-45,46));
                line.set(strokeWidth, Color.rgb(rand.nextInt(256),rand.nextInt(256),
                        rand.nextInt(256) ).darker());
                root.getChildren().add(line);
                mouseClickOnceAlready = false;
            }
            // if there are 5 lines created and shown in root Pane, go through the list
            // of children of the pane and call their rotate methods.
            else {
                for(Node node: root.getChildren()) {
                    // casting to SpinLine
                    SpinLine sl = (SpinLine)node;
                    sl.spin();
                }
            }

        });

        // boiler-plate javaFX code to set up and show scene
        primaryStage.setScene(scene);
        primaryStage.setTitle("Spin Lines");
        primaryStage.setAlwaysOnTop(true);
        primaryStage.setResizable(false);
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}
