import java.awt.*;
import javax.swing.*;
/** 
* Model is a class that will use Square.java to build a Graphical User Interface(GUI)
*/

public class Board
{
    //delared all the variables to be used
    private JFrame window;
    private JPanel panel;

    public Board()
        {
            window = new JFrame();
            window.setTitle("Hoppers");
            window.setSize(700, 700);

            panel = new JPanel();
            panel.setLayout(new GridLayout(5,5));
            
            JButton[] jb = new JButton[25];

            for (int i=0; i<25; i++)
            {
                ImageIcon a = new ImageIcon("Water.png");
                jb[i] = new JButton(a);
                jb[i].setIcon(a);
                panel.add(jb[i]);
            }

            window.setContentPane(panel);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setVisible(true);
        }
    //this method will open a window frame as the games GUI
}