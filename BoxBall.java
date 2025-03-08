import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

/**
 * Write a description of class BoxBall here.
 *
 * @author Damian Nunez
 * @version 2025.03.07
 */
public class BoxBall
{
    // instance variables - replace the example below with your own
    private Color color;
    private int xPosition;
    private int yPosition;
    private final int groundPosition;      // y position of ground
    private final int ceilingPosition;      // y position of ceiling
    private final int leftWallPosition;     // x position of left wall
    private final int rightWallPosition;    // x position of right wall
    private Canvas canvas;

    /**
     * Constructor for objects of class BoxBall
     */
    public BoxBall(int xPos, int yPos, int groundPos, int ceilingPos, int leftWallPos, int rightWallPos, 
    Canvas drawingCanvas)
    {
        xPosition = xPos;
        yPosition = yPos;
        groundPosition = groundPos;
        ceilingPosition = ceilingPos;
        leftWallPosition = leftWallPos;
        rightWallPosition = rightWallPos;
        canvas = drawingCanvas;
    }
    
    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
    }
}
