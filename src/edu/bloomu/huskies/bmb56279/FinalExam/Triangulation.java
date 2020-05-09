package edu.bloomu.huskies.bmb56279.FinalExam;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;


/**
 * A JavaFX application that displays 4 colored triangles depending on if the
 * checkboxes adjacent to them are selected or not. I tried to use Panes for all 5 of
 * the nodes that are added to the root, however, I could not find a way to center the
 * checkboxes in the top,left,right, and bottom panes. There is no method and I
 * "-fx-alignment: Center;" didn't work. To make it look exactly like the test, I used
 * VBox for the 4 outside panes, and I used just a Pane for the center like normal.
 * This allowed me to set alignment of the checkmarks.
 *
 * I affirm that I did not communicate with anyone during this exam.
 *
 * @author Brett Bernardi
 */

public class Triangulation extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        VBox leftPane = new VBox();
        leftPane.setPadding(new Insets(10));
        leftPane.setAlignment(Pos.CENTER);

        VBox rightPane = new VBox();
        rightPane.setAlignment(Pos.CENTER);
        rightPane.setPadding(new Insets(10));

        Pane centerPane = new Pane();
        centerPane.setMinSize(200,200);

        VBox topPane = new VBox();
        topPane.setAlignment(Pos.CENTER);
        topPane.setPadding(new Insets(10));

        VBox bottomPane = new VBox();
        bottomPane.setAlignment(Pos.CENTER);
        bottomPane.setPadding(new Insets(10));

        Scene scene = new Scene(root);

        // styles the panes
        String style = "-fx-background-color: LIGHTGRAY;";
        leftPane.setStyle(style);
        rightPane.setStyle(style);
        centerPane.setStyle(style);
        topPane.setStyle(style);
        bottomPane.setStyle(style);



        // The follow code creates a 4, 3-sided polygons (Triangles) and places them
        // with coordinates wrt to the centerPane.
        Polygon topRed = new Polygon();
        topRed.getPoints().addAll(0.0,0.0,100.0,100.0,200.0,0.0);
        topRed.setStroke(Color.RED);
        topRed.setFill(Color.RED);


        Polygon bottomGreen = new Polygon();
        bottomGreen.getPoints().addAll(0.0,200.0,100.0,100.0,200.0,200.0);
        bottomGreen.setStroke(Color.GREEN);
        bottomGreen.setFill(Color.GREEN);

        Polygon leftBlue = new Polygon();
        leftBlue.getPoints().addAll(0.0,0.0,100.0,100.0,0.0,200.0);
        leftBlue.setStroke(Color.BLUE);
        leftBlue.setFill(Color.BLUE);

        Polygon rightBlack = new Polygon();
        rightBlack.getPoints().addAll(200.0,0.0,100.0,100.0,200.0,200.0);
        rightBlack.setStroke(Color.BLACK);
        rightBlack.setFill(Color.BLACK);

        // creates 4 check boxes that will be adjacent to their respective shape
        CheckBox leftButton = new CheckBox();
        CheckBox rightButton = new CheckBox();
        CheckBox topbutton = new CheckBox();
        CheckBox bottomButton = new CheckBox();


        /**
         * Nested Class that implements event  handler interface and deals with what
         * happens when a checkbox is selected or not selected. If the adjacent
         * checkbox to a triangle is selected, the triangle is visible. Not visible if
         * not selected.
         */
        class BoxHandler implements EventHandler<ActionEvent> {
            @Override
            public void handle(ActionEvent event) {
                if(topbutton.isSelected()) {
                    topRed.setVisible(true);
                }
                else {
                    topRed.setVisible(false);
                }
                if(leftButton.isSelected()) {
                    leftBlue.setVisible(true);
                }
                else {
                    leftBlue.setVisible(false);
                }
                if(bottomButton.isSelected()) {
                    bottomGreen.setVisible(true);
                }
                else {
                    bottomGreen.setVisible(false);
                }
                if(rightButton.isSelected()) {
                    rightBlack.setVisible(true);
                }
                else {
                    rightBlack.setVisible(false);
                }
            }
        }


        // passes the BoxHandler interface
        leftButton.setOnAction(new BoxHandler());
        rightButton.setOnAction(new BoxHandler());
        topbutton.setOnAction(new BoxHandler());
        bottomButton.setOnAction(new BoxHandler());


        // adds all panes to root
        centerPane.getChildren().addAll(topRed,leftBlue,bottomGreen,rightBlack);


        // Adds all buttons and sets the initially to be checked when program starts
        leftPane.getChildren().add(leftButton);
        leftButton.setSelected(true);
        rightPane.getChildren().add(rightButton);
        rightButton.setSelected(true);
        topPane.getChildren().add(topbutton);
        topbutton.setSelected(true);
        bottomPane.getChildren().add(bottomButton);
        bottomButton.setSelected(true);

        // adds are nodes to the root
        root.setCenter(centerPane);
        root.setLeft(leftPane);
        root.setTop(topPane);
        root.setBottom(bottomPane);
        root.setRight(rightPane);

        // boiler plate JavaFX code
        primaryStage.setScene(scene);
        primaryStage.setTitle("Triangulation");
        primaryStage.setAlwaysOnTop(true);
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
