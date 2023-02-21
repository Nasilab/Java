
//***********************************************************************
//
//   File: Animation.java        Assignment No.: 4
//
//   Author: bmn8            
//
//   Class: Animation
// 
//   Time spent on this problem: 6 hour
//   --------------------
//      This program implements animation for PS 4
//
//***********************************************************************
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.time.Duration;
import java.awt.BasicStroke;
import java.util.Scanner;
import static java.lang.Math.*;

public class Animation {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 450;
    public static final int FRAME_T = 17; // in ms
    public static final double GRAVITY = 9.81; // in pixels/frame^2

    // Setup DrawingPanel
    public static DrawingPanel panel = new DrawingPanel(WIDTH, HEIGHT);
    public static Graphics2D g = panel.getGraphics();

    public static BufferedImage offscreen = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    public static Graphics2D osg = offscreen.createGraphics();

    // main method
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        
        // use Scanner object to read in the user's values

        System.out.print("How many seconds should the clock count down? ");
        double countdown = console.nextDouble();

         System.out.print("How big do you want to smiley face to be? ");
         double figureSize = console.nextDouble();

         System.out.print("What initial velocity launch do you want? ");
         double velocity = console.nextDouble();
         
         System.out.print("What initial launch angle do you want? ");
         double angle = console.nextDouble();
        
         System.out.print("How many seconds should the animation show? ");
         double duration = console.nextDouble(); 


        // // start animations one after the other
        animateClock(countdown);
        animateFace(figureSize, velocity, angle, duration);
        // test just drawFace: drawFace(1, 1,100);

        // close the Scanner object
        console.close();
    }

    // draws the clock with the hand pointing in the correct direction based on the currentTime (, double currentTime, double totalTime)
    public static void drawClock(double cx, double cy, double diameter, double currentTime, double totalTime) {
        osg.setColor(Color.BLACK);
        osg.drawOval(round(cx-diameter/2), round(cy - diameter/2), round(diameter),round(diameter));

        osg.setColor(Color.BLACK);
        double lineX = (cx + diameter/2 * Math.sin((currentTime/totalTime)*2 * Math.PI));
        double lineY = (cy - diameter/2 * Math.cos((currentTime/totalTime)*2 * Math.PI));
        osg.drawLine((int) cx, (int) cy, (int) lineX, (int)lineY);




    }

    // animation the clock with one full revolution taking countdown seconds
    public static void animateClock(double countdown) {

        for (double t = 0; t < countdown; t += FRAME_T / 1000.0) {
            // // how do i declare a variable???  
            // // int angle = (currentTime/totalTime) * 2 + Math.PI - Math.PI/2; 
            // // int angle = (currentTime/totalTime)
            // double cx =(int)(cx + HEIGHT/4 * Math.cos(angle));
            // double cy = (int)(cx + HEIGHT/4 * Math.sin(angle));
          
            // clear the image
            osg.setColor(Color.WHITE);
            osg.fillRect(0, 0, WIDTH, HEIGHT);

            // draw the cars
           drawClock(WIDTH/2, HEIGHT/2,HEIGHT/2, t,countdown);

            // copy buffered image to the screen and pause
            g.drawImage(offscreen, 0, 0, null);
            panel.sleep(FRAME_T);
            
        }
    }                                                                                                           

    // draws the smiley face using 3 ovals and 1 arc
    public static void drawFace(double x, double y, double size) {
        // Draw Yellow circle 
        osg.setColor(Color.YELLOW);
        osg.fillOval(round(x), round(y), round(size),round(size));

       // Draw Smile arc 
       osg. setColor(Color.BLACK);
       osg.drawArc(round(x + size/4), round(y + (5 * size/8)), round(size/2), round(size/10),200,140);


        // Draw eyes 
        osg.setColor(Color.BLACK);
        osg.fillOval(round(x + size/4), round(y + size/4), round(size/8), round(size/7));
        
        osg.setColor(Color.BLACK);
        osg.fillOval(round(x + (5 * size/8)), round(y + size/4), round(size/8), round(size/7));
    }

    // animation the face launched across the screen for duration seconds
    public static void animateFace(double figureSize, double velocity, double angle, double duration) {
        // FILL ME IN
         // initial heights and velocities
         double launchAngle = degreesToRadians(angle);
         int h1 = HEIGHT/2, v1x = round(velocity*cos(launchAngle)), v1y = -round(velocity*sin(launchAngle));


         for (double t = 0; t < 10; t += FRAME_T / 1000.0) {
             // compute next position for both cars
            //  x = initial x + (velocity * cos(angle) * time)
            //  y = initial y + (velocity * sin(angle) * time) - (0.5 * gravity * time * time)
             
             double x = position(0, v1x, 0, t);
             double y = position(h1, v1y, GRAVITY, t);
             
 
             // clear the image
             osg.setColor(Color.WHITE);
             osg.fillRect(0, 0, WIDTH, HEIGHT);
 
             // draw the cars
             drawFace(x, y, figureSize);
 
             // copy buffered image to the screen and pause
             g.drawImage(offscreen, 0, 0, null);
             panel.sleep(FRAME_T); 
            }
    }

	// converts degrees to radians
	// assume degrees only range from 0 to 360
	// and radians range from 0 to 2pi
    //     // HINT: You can make use of scale as a "helper method"

    public static double degreesToRadians(double degrees) {
        double radians = 2 * PI * (degrees/360);
        return (double) radians; 
    }

    public static double position(double initPos, double v, double a, double t) {
        return initPos + v * t + .5 * a * t * t;
    }

     // round a double to the nearest int
    public static int round(double d) {
        return (int) Math.round(d);
    }
   

}
