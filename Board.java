import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Model is a class that will use Square.java to build a Graphical User
 * Interface(GUI)
 */
public class Board implements ActionListener // inherits all methods from Square class 
{

    // declared all the variables to be used
    private JFrame window;
    public JPanel panel;
    private Square a = new Square();
    private ImageIcon greenFrog = a.greenFrog;
    private ImageIcon greenFrog2 = a.greenFrog2;
    private ImageIcon redFrog = a.redFrog;
    private ImageIcon redFrog2 = a.redFrog2;
    private ImageIcon lilypad = a.lilypad;

    public Board(int width, int height, String title) 
    {
        this.window = new JFrame();
        this.window.setTitle(title);
        this.window.setSize(width, height);
        // added frame
        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 5));
        // added panel
       // a.levelSelector();
        a.changeButton();

        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                a.getSquare(x, y).addActionListener(this);
                panel.add(a.getSquare(x, y));
            }
        }
        window.setContentPane(panel); // adding panel to windown frame
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // set exit on close
        window.setVisible(true); // set window frame visible
    }

 @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (((AbstractButton) e.getSource()).getIcon() == greenFrog)
            {
                System.out.println(""+((Component) e.getSource()).getBounds());
                System.out.println(""+((AbstractButton) e.getSource()).getIcon());
                for (int x = 0; x < 5; x++){
                    for (int y = 0; y <5; y++){
                        if (a.getSquare(x, y).getIcon() == greenFrog2){
                            a.getSquare(x, y).setIcon(greenFrog);
                        }
                        else if (a.getSquare(x, y).getIcon() == redFrog2){
                            a.getSquare(x, y).setIcon(redFrog);
                        }
                    }
                }
                ((AbstractButton) e.getSource()).setIcon(greenFrog2);
            }
        else if (((AbstractButton) e.getSource()).getIcon() == greenFrog2)
            {
                ((AbstractButton) e.getSource()).setIcon(greenFrog);
                System.out.println(""+((Component) e.getSource()).getBounds());
                System.out.println(""+((AbstractButton) e.getSource()).getIcon());
            }
        else if (((AbstractButton) e.getSource()).getIcon() == redFrog)
            {
                for (int x = 0; x < 5; x++){
                    for (int y = 0; y <5; y++){
                        if (a.getSquare(x, y).getIcon() == greenFrog2){
                            a.getSquare(x, y).setIcon(greenFrog);
                        }
                    }
                }
                ((AbstractButton) e.getSource()).setIcon(redFrog2);
                System.out.println(""+((Component) e.getSource()).getBounds());
                System.out.println(""+((AbstractButton) e.getSource()).getIcon());
            }
        else if (((AbstractButton) e.getSource()).getIcon() == redFrog2)
            {
                ((AbstractButton) e.getSource()).setIcon(redFrog);
                System.out.println(""+((Component) e.getSource()).getBounds());
                System.out.println(""+((AbstractButton) e.getSource()).getIcon());
            }
        
        else if (((AbstractButton) e.getSource()).getIcon() == lilypad)
            {
            a.moveTo((JButton) e.getSource());
            }
    }

    public static void main(String[] args) 
    {
        Board c = new Board(750, 750, "Hopper!");
    }
}