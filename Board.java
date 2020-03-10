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
    private Square[][] square = new Square[5][5];

    public Board(int width, int height, String title)
    {    
            this.window = new JFrame();
            this.window.setTitle(title);
            this.window.setSize(width, height);
            // added frame 

            panel = new JPanel();
            panel.setLayout(new GridLayout(5,5));
            // added panel
            
            for (int i=0; i<square.length; i++)//use a for loop to add the button 25 times
            {
                for (int j=0; j<square[i].length; j++)
                {
                square[i][j] = new Square(i,j);
                if (i % 2 ==0)
                {
                    if ( j % 2 != 0)
                    {
                        panel.add(square[i][j].waterButton);
                    }
                    else 
                    {
                        panel.add(square[i][j].lilyButton);
                    }
                }
                else
                {
                    if ( j % 2 == 0)
                    {
                        panel.add(square[i][j].waterButton);
                    }
                    else
                    {
                        panel.add(square[i][j].lilyButton);
                    }
                }
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