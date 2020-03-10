import javax.swing.*;
/** 
 * Model is a clickable square that will be used later on in my GUI
 * This class represents a Square objects, when combined with the Board.java class,
 * Instances of the Square class can be displayed on the screen.
 */

public class Square
{
    private ImageIcon water = new ImageIcon("Water.png");
    private ImageIcon lilypad = new ImageIcon("Lilypad.png");
    private ImageIcon greenFrog = new ImageIcon("GreenFrog.png");
    public JButton waterButton = new JButton(water);
    public JButton lilyButton = new JButton(lilypad);
    public JButton frogButton = new JButton(greenFrog);
    private int xlocation;
    private int ylocation;

    public Square  (int xlocation_given, int ylocation_given)
    {
        ylocation = ylocation_given;
        xlocation = xlocation_given;
        lilyButton.setIcon(lilypad);
        waterButton.setIcon(water);
        frogButton.setIcon(greenFrog);
        System.out.println("The locations are: "+ xlocation);
        System.out.println("The locations are: "+ ylocation);
    }
}
