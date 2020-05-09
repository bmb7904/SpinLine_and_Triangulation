package edu.bloomu.huskies.bmb56279.FinalExam;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/**
 * A custom class that extends the Line class. This class will provide methods to set a
 * line at a specified startinig and ending point as well as functions to rotate the
 * line a specified amount. Also has functions to set the stroke color and width of the
 * line. Since fields for storing starting and end points are already inherited from
 * the Line Class, there is no need to store the starting and ending points as fields.
 * We only need the rotationIncrement field.
 *
 * I affirm that I did not communicate with anyone during this exam.
 *
 * @author Brett Bernardi
 */
public class SpinLine extends Line {

    // field that holds the amount the line is rotated each time
    // nonstatic. Different for each individual line.
    private int rotationIncrement;

    /**
     * Constructor that will initialize the fields and also call the super(Line)
     * constructor and pass the starting and ending points as parameters to the super.
     * @param rotationIncrement
     */
    public SpinLine(double x1, double y1, double x2, double y2, int rotationIncrement) {
        super(x1, y1, x2, y2);
        this.rotationIncrement = rotationIncrement;
    }

    /**
     * Sets the color and the width of the stroke of the line. These set stroke methods
     * are inherited from the super (Line) class.
     * @param w - width of stroke
     * @param c - color of stroke
     */
    public void set(int w, Color c) {
        super.setStroke(c);
        super.setStrokeWidth(w);
    }

    /**
     * This method will take the current rotation value of the line, and add to it the
     * rotation increment that is set in constructor. This new sum is set as the new
     * rotation value of the line. This causes the line to rotate a certain amount each
     * time the method is called. SetRotate and getRotate are inherited from the super
     * (Line) class.
     */
    public void spin() {
        super.setRotate(super.getRotate() + rotationIncrement);
    }

}
