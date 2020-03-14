import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.awt.event.*;
/**
 * Model is a clickable square that will be used later on in my GUI This class
 * represents a Square objects, when combined with the Board.java class,
 * Instances of the Square class can be displayed on the screen.
 */

public class Square extends JButton implements ActionListener{

        private static final long serialVersionUID = 1L;
        private ImageIcon water = new ImageIcon("Water.png");
        private ImageIcon lilypad = new ImageIcon("Lilypad.png");
        private ImageIcon greenFrog = new ImageIcon("GreenFrog.png");
        private ImageIcon redFrog = new ImageIcon("RedFrog.png");
        private ImageIcon greenFrog2 = new ImageIcon("GreenFrog2.png");
        private ImageIcon redFrog2 = new ImageIcon("RedFrog2.png");

        private JButton[][] square = new JButton[5][5];

        public Square() 
        {
            for (int i=0; i<square.length; i++)//use a for loop to add the button 25 times
            {
                for (int j=0; j<square[i].length; j++)
                {
                    square[i][j] = new JButton();
                }
            }
        }

        public JButton getSquare(int x, int y)
        {
            return square[x][y];
        }

        public void changeButton() 
        {
            try 
                {
                    Scanner sc = new Scanner(new BufferedReader((new FileReader("level1.txt"))));
                    String [][] myArray = new String [5][5];
                    while(sc.hasNextLine())
                    {
                        for (int x=0; x<myArray.length; x++)
                        {
                            String[] line = sc.nextLine().trim().split(" ");
                            for (int y=0; y<line.length; y++)
                            {
                                myArray[x][y] = line[y];
                        
                                switch (myArray[x][y]){

                                    case "g":
                                    square[x][y].setIcon(greenFrog);
                                    square[x][y].addActionListener(this);
                                    break;
                                    
                                    case "r":
                                    square[x][y].setIcon(redFrog);
                                    break;

                                    case "l":
                                    square[x][y].setIcon(lilypad);
                                    break;

                                    case "w":
                                    square[x][y].setIcon(water);
                                    break;

                                    default:
                                    square[x][y].setIcon(water);
                                }
                            }
                        }
                    }
                } 
            catch (FileNotFoundException e) 
                {
                    e.printStackTrace();
                }
            }

            public void actionPerformed(ActionEvent c) 
            {   
                ((AbstractButton) c.getSource()).setIcon(greenFrog2);
            }
    }