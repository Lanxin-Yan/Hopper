import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Model is a class that will use Square.java to build a Graphical User
 * Interface(GUI)
 */
public class Board implements ActionListener{ // inherits all methods from Square class 

    // declared all the variables to be used
    private JFrame window;
    public JPanel panel;

    private Square a = new Square();
    //innitiating a new instance of the class Square

    private ImageIcon greenFrog = a.greenFrog;
    private ImageIcon greenFrog2 = a.greenFrog2;
    private ImageIcon redFrog = a.redFrog;
    private ImageIcon redFrog2 = a.redFrog2;
    private ImageIcon lilypad = a.lilypad;
    //pull the ImageIcon variables over from Square.class

    /**
     * Constructor, a JFrame window will be build with the parameter: int, int, String
     * a JPanel is created and placed inside the JFrame
     * JPanel contains the actual game with 25 buttons
     */

    public Board(int width, int height, String title){

        this.window = new JFrame();
        this.window.setTitle(title);
        this.window.setSize(width, height);
        // added JFrame window

        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 5));
        // added panel with the layout of 5 x 5

        a.changeButton();
        //calls the function in Square, which will read the selected level in the text file

        for (int x = 0; x < 5; x++){
            for (int y = 0; y < 5; y++){
                a.getSquare(x, y).addActionListener(this);
                panel.add(a.getSquare(x, y));
                //for every JButtons added, we have implemented an actionListener to it. 
            }
        }
        //I have used my getSquare method to return my JButtons onto the 5x5 JPanel

        window.setContentPane(panel);
         // assigning panel to windown frame
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         // set exit on close action
        window.setVisible(true);
         // set window frame visible
    }

    /**
     * What action is performed when a buttom is clicked
     */
 @Override
    public void actionPerformed(ActionEvent e){
        if (((AbstractButton) e.getSource()).getIcon() == greenFrog){
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
            //when a green frog is clicked, set the according icon to highlighted greenfrog, which is greenfrog2, however, if there is any other highlighted green frog on board, set 
            //it back to greenfrog, so there isn't more than 2 highlighted frog on board

        else if (((AbstractButton) e.getSource()).getIcon() == greenFrog2){
                ((AbstractButton) e.getSource()).setIcon(greenFrog);
            }
            //when a highlighted greenfrog is clicked, remove its highlight status, for which I have just set its icon back to greenfrog

        else if (((AbstractButton) e.getSource()).getIcon() == redFrog){
                for (int x = 0; x < 5; x++){
                    for (int y = 0; y <5; y++){
                        if (a.getSquare(x, y).getIcon() == greenFrog2){
                            a.getSquare(x, y).setIcon(greenFrog);
                        }
                    }
                }
                ((AbstractButton) e.getSource()).setIcon(redFrog2);
            }
            //when a red frog is clicked, set the according icon to highlighted redfrog, which is redfrog2, however, if there is any greenfrog highlighted on board, set it to greenfrog
            //so the situation of highlighted red frog and greenfrog can not happen

        else if (((AbstractButton) e.getSource()).getIcon() == redFrog2){
                ((AbstractButton) e.getSource()).setIcon(redFrog);
            }
            //when a highlighted red frog is clicked, set it to redfrog
        
        else if (((AbstractButton) e.getSource()).getIcon() == lilypad){
            a.moveTo((JButton) e.getSource());
            }
            //when a lilypad is clicked, jump to the moveTo method in Square class, which contains the logic to allow legal moves. 
    }

    /**
     * Main function, which passes values into the Board.class' constructor, allow it to use
     * those elements to build the GUI.
     */
    public static void main(String[] args){
        Board c = new Board(750, 750, "Hopper!");   
        //the JFrame window would be 750x750, with the title Hopper!
    }
}