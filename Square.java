import javax.swing.*;
import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 * Model is a clickable square that will be used later on in my GUI This class
 * represents a Square objects, when combined with the Board.java class,
 * Instances of the Square class can be displayed on the screen.
 */

public class Square extends JButton {
    private static final long serialVersionUID = 1L;
    //inherited all the functions from JButton library 

    public ImageIcon water = new ImageIcon("Water.png");
    public ImageIcon lilypad = new ImageIcon("Lilypad.png");
    public ImageIcon greenFrog = new ImageIcon("GreenFrog.png");
    public ImageIcon redFrog = new ImageIcon("RedFrog.png");
    public ImageIcon greenFrog2 = new ImageIcon("GreenFrog2.png");
    public ImageIcon redFrog2 = new ImageIcon("RedFrog2.png");
    //innitiated ImageIcons, which searches file names through the directory by a String of txt

    private JButton[][] square = new JButton[5][5];
    //created a 2D array of JButtons

    private Rectangle lily;
    private Rectangle highlightedFrog;
    //I have then created 2 rectangle object, which will allow me to get my x and y coord of my JButtons using getbounds function

    private int redOrGreen;
    //This int variable will determine if a redfrog or yellow frog was selected

    private int highlightXLoc;
    private int highlightYLoc;
    private int xLoc;
    private int yLoc;
    private int middlexLoc;
    private int middleyLoc;
    //integer variables which stores the x and y of the lilypad that has been clicked, the selected highlighted greenfrogs/redfrogs, and the button between.

    /**
     * Constructor of the square class, which creates 25 JButtons, using 2 for loops
     */
    public Square(){

        for (int i = 0; i < square.length; i++){

            for (int j = 0; j < square[i].length; j++){
                
                square[i][j] = new JButton();
            }
        }
    }

    /**
     * Get function that returns the JButton, which will be called in the Board class.
     * @param x will be called in Board class using a for loop
     * @param y will be called in Board class using a for loop
     * @return returns the JButton in the desired x and y
     */
    public JButton getSquare(int x, int y){

        return square[x][y];
    }

    /**
     * Added a levelSelector which will be called in the changeButton() method, it will return the desired level as a String value. 
     * @return A string value that describes the choosen level 
     */
    public String levelSelector(){

        String[] choices = { 

        "level1.txt", "level2.txt", "level3.txt", "level4.txt", "level5.txt", "level6.txt", "level7.txt","level8.txt","level9.txt","level20.txt","level21.txt",
        "level22.txt","level23.txt","level24.txt", "level25.txt","level26.txt","level27.txt","level28.txt","level29.txt","level30.txt","level31.txt","level32.txt","level33.txt",
        "level34.txt","level35.txt","level36.txt","level37.txt","level38.txt","level39.txt","level40.txt"
    };
    //added an array of strings, each element describes a level 

        String input = (String) JOptionPane.showInputDialog(null, "Choose now...",
            "The Choice of a Lifetime", JOptionPane.QUESTION_MESSAGE, null, // Use
                                                                            // default
                                                                            // icon
            choices, // Array of choices
            choices[1]); // Initial choice
        return input;
        //return the string input which describe the level
    }

    /**
     * A method which uses a switch case to innitiate what appropriate icon goes on each JButtons, using a 
     * switch case.
     * A 2D array is innitiated here to store the content read from the txt file. This 2D array will be used
     * as the switch target.
     * Error handling is also added, with a try catch method, which will output an error message when file isn't
     * found.
     */
    public void changeButton(){

        try{

            Scanner sc = new Scanner(new BufferedReader((new FileReader(levelSelector()))));
            String[][] myArray = new String[5][5];
            while (sc.hasNextLine()){

                for (int x = 0; x < myArray.length; x++){

                    String[] line = sc.nextLine().trim().split(" ");
                    for (int y = 0; y < line.length; y++){

                        myArray[x][y] = line[y];

                        switch (myArray[x][y]){

                            case "g":
                                square[x][y].setIcon(greenFrog);
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

        catch (FileNotFoundException e){

            e.printStackTrace();
        }
    }

    /**
     * MoveTo function, which will only allow legal moves on board.
     * @param XY the JButton thats passed in from actionlistener, which is the lilypad that has been clicked.
     */
    public void moveTo(JButton XY){

        lily = XY.getBounds();
        xLoc = lily.x;
        yLoc = lily.y;
        //In order to get the x and y coords of the lilypad, I have passed it into a rectangle object.
        //This allows me to do calculations with the X and Y.

        for (int i = 0; i < 5; i++){

            for (int y = 0; y < 5; y++){

                if (square[i][y].getIcon() == redFrog2){

                    highlightedFrog = square[i][y].getBounds();
                    highlightXLoc = highlightedFrog.x;
                    highlightYLoc = highlightedFrog.y;
                    redOrGreen = 1;
                }
                else if (square[i][y].getIcon() == greenFrog2){

                    highlightedFrog = square[i][y].getBounds();
                    highlightXLoc = highlightedFrog.x;
                    highlightYLoc = highlightedFrog.y;
                    redOrGreen = 0;
                }
            }
        }
        //Search through the board, to check if there was a redfrog clicked or a greenfrog, using an interger 
        //to determine this status. 
        //Then also pass the x and y coords to another rectangle object, which I can then use to do calculations with

        middlexLoc = (xLoc + highlightXLoc) / 2;
        middleyLoc = (yLoc + highlightYLoc) / 2;
        //to work out the middle coords, we add up the x of the highlighted button and clicked lilypad, divid it by 2
        //to work out the middle coords, we add up the y of the highlighted button and clicked lilypad, divid it by 2

        for (int x = 0; x < 5; x++){

            for (int j = 0; j < 5; j++){

                    if (square[x][j].getIcon() == greenFrog){

                        if (square[x][j].getBounds().x == middlexLoc && square[x][j].getBounds().y == middleyLoc){

                            square[x][j].setIcon(lilypad);
                            if (redOrGreen == 0){

                                XY.setIcon(greenFrog);
                            }
                            else if (redOrGreen == 1){

                                XY.setIcon(redFrog);                            
                            }
                                for (int i = 0; i < 5; i++){

                                    for (int y = 0; y < 5; y++){

                                        if (square[i][y].getIcon() == redFrog2 || square[i][y].getIcon() == greenFrog2){
                                            square[i][y].setIcon(lilypad);
                                        }
                                    }
                                }
                            }
                        else{
                        }
                    }
                    else{                   
                    }
                }
            }
            //Scan throught the board, to find the square inbetween the lilybutton and highlighted frog button.
            //Check if this is a greenfrog, because frogs can only jump over greenfrogs
            //If there is a greenfrog inbetween, swap the highlighted frog and lilypad, and remove the frog inbetween. 
	}
}
