import javax.swing.*;

/** 
 * Model is a clickable suqare that will be used later on in my GUI
 * This class represents a Square objects, when combined with the Board.java class,
 * Instances of the Square class can be displayed on the screen.
 */

public class Square
{
    public void newSquare()
    {
        ImageIcon i = new ImageIcon("Water.png");
        JButton b = new JButton(i);
        b.setIcon(i);
    }
}