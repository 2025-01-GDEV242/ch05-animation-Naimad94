import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Write a description of class BoxBall here.
 *
 * @author Damian Nunez
 * @version 2025.03.07
 */
public class BoxBall
{
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private final int groundPosition;       // y position of ground
    private final int ceilingPosition;      // y position of ceiling
    private final int leftWallPosition;     // x position of left wall
    private final int rightWallPosition;    // x position of right wall
    private Canvas canvas;
    private int xSpeed;                   // initial horizontal speed
    private int ySpeed;                   // initial vertical speed

    /**
     * Constructor for objects of class BoxBall
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param groundPos  the position of the ground (where the wall will bounce)
     * @param drawingCanvas  the canvas to draw this ball on
     */
    
    public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor,
                        int groundPos, int ceilingPos, int leftPos, 
                        int rightPos, Canvas drawingCanvas, int xSpd,
                        int ySpd)
    {
        // initialise instance variables
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        groundPosition = groundPos;
        ceilingPosition = ceilingPos;
        leftWallPosition = leftPos;
        rightWallPosition = rightPos;
        canvas = drawingCanvas;
        xSpeed = xSpd;
        ySpeed = ySpd;
    }

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }
    //erases ball.
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }

    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move()
    {
        // remove from canvas at the current position
        erase();
        
        Random speedModifier = new Random();
        if(xSpeed > 0)
        {
            xPosition += (speedModifier.nextInt(7) + 1);
        }
        else
        {
            xPosition -= (speedModifier.nextInt(7) + 1);
        }
        
        if(ySpeed > 0)
        {
            yPosition += (speedModifier.nextInt(7) + 1);
        }
        else
        {
            yPosition -= (speedModifier.nextInt(7) + 1);
        }
        
        // made for bouncing.
        if(yPosition >= (groundPosition - diameter))
        {
            yPosition = groundPosition - diameter;
            ySpeed = -1 * ySpeed;
        }
        else if(yPosition <= ceilingPosition)
        {
            yPosition = ceilingPosition;
            ySpeed = -1 * ySpeed;
        }
        else if(xPosition >= (rightWallPosition - diameter))
        {
            xPosition = rightWallPosition - diameter;
            xSpeed = -1 * xSpeed;
        }
        else if(xPosition <= leftWallPosition)
        {
            xPosition = leftWallPosition;
            xSpeed = -1 * xSpeed;
        }

        // draw in a new location.
        draw();
    }  
    
    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    } 
}