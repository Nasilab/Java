
//*******************************************************************
//
//   File: CafeWall.java         Assignment No.: 3
//
//   Author: bmn8             
//
//   Class: CafeWall
// 
//   Time spent on this problem: 6
//   --------------------
//    This makes the Cafe Wall Illusion
//
//*******************************************************************
import java.awt.Color;
import java.awt.Graphics2D;

public class CafeWall {
   
    final static int WIDTH = 650;
    final static int HEIGHT = 1000;
    final static int N = 1;
    int motar = 2;

    // set up panel and graphics objects
    static DrawingPanel panel = new DrawingPanel(WIDTH, HEIGHT);
    static Graphics2D g = panel.getGraphics();

    public static void main(String[] args) {

        // TODO:set the background color.
        panel.setBackground(Color.DARK_GRAY);

        drawRow(0, 2, 4, 20);
        drawRow(50, 70, 5, 30);

        drawGrid(10, 339, 4, 25, 0);

        drawGrid(250, 335, 3, 25, 10);

        drawGrid(425, 378, 5, 20, 10);

        drawGrid(400, 131, 2, 35, 35);
    }
        // this method makes a single row
    public static void drawRow(int x, int y, int pairs, int size) {
        for (int row = 0; row < pairs; row++) {
            drawSquare(x, y, size, Color.BLACK);
            x += size;
            int x1 = x - size;
            int y1 = y + size;
            int x2 = x1 + size;
            int y2 = y1 - size;
            g.setColor(Color.BLUE);
            g.drawLine(x1, y1, x2, y2);
            g.drawLine(x1, y2, x2, y1);
            drawSquare(x, y, size, Color.WHITE);
            x += size;
            
        }
    }
    // this method is called by drawRow method to fill the boxes with color
    public static void drawSquare(int x, int y, int size, Color color) {
        g.setColor(color);
        g.fillRect(x, y, size, size);
    }
    // this method draws the grids using drawRow. It offsets every other row by the variable 'int offset'
    public static void drawGrid(int x, int y, int pairs, int size, int offset) {
        int motar = 2;
        for(int row = 0; row < pairs; row++){
            drawRow(x, y, pairs, size);
            drawRow(x + offset, y + size + motar, pairs, size);
            y = y+ 2*(size + motar);           

        }
      
    }
            
}