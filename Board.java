import javax.swing.*;
/** 
 * Model is a class that will use Square.java to build a Graphical User Interface(GUI)
 */

public class Board
{
    private String title;
    private int numOfSquare = 10;
    private int height, width;
    public void addWindow(String c, int x, int y)
        {
            title = c;
            height = x;
            width = y;
            JFrame window = new JFrame(title);
            window.setSize(height, width);
            window.setVisible(true);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

    public void addSquare(int n)
        {
            numOfSquare = n;
            for (int i = 0; i < numOfSquare; i++)
            {
                Square a = new Square();
                a.newSquare();
            }
        }
}