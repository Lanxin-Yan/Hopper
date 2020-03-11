import java.awt.*;
import javax.swing.*;

/** 
* Model is a class that will use Square.java to build a Graphical User Interface(GUI)
*/

public class Board//inherits all methods from Square class
{
    //declared all the variables to be used
    private JFrame window;
    private JPanel panel;
    private Square a = new Square();

    public Board(int width, int height, String title)
    {    
            this.window = new JFrame();
            this.window.setTitle(title);
            this.window.setSize(width, height);
            // added frame 

            panel = new JPanel();
            panel.setLayout(new GridLayout(5,5));
            // added panel
            
            a.changeButton();
            
            for (int x = 0; x < 5; x++)
            {
                for (int y =0; y < 5; y++)
                {
                    panel.add(a.getSquare(x, y));
                }
            }
            
            window.setContentPane(panel); //adding panel to windown frame
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //set exit on close
            window.setVisible(true); //set window frame visible
    }
    public static void main (String[] args)
    {
        Board c = new Board(700, 700, "Hopper!");

    }
}