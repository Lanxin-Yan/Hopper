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
    public ImageIcon water = new ImageIcon("Water.png");
    public ImageIcon lilypad = new ImageIcon("Lilypad.png");
    public ImageIcon greenFrog = new ImageIcon("GreenFrog.png");
    public ImageIcon redFrog = new ImageIcon("RedFrog.png");
    public ImageIcon greenFrog2 = new ImageIcon("GreenFrog2.png");
    public ImageIcon redFrog2 = new ImageIcon("RedFrog2.png");

    private JButton[][] square = new JButton[5][5];
    private String[][] Loc = new String[5][5];

    private Rectangle lily;
    private Rectangle highlightedFrog;
    //private Rectangle middleFrog;
    //private Rectangle abstractRectagle;

    private int redOrGreen;

    private int highlightXLoc;
    private int highlightYLoc;
    private int xLoc;
    private int yLoc;
    private int middlexLoc;
    private int middleyLoc;

    public Square() {
        for (int i = 0; i < square.length; i++)// use a for loop to add the button 25 times
        {
            for (int j = 0; j < square[i].length; j++) {
                square[i][j] = new JButton();
            }
        }
    }

    public JButton getSquare(int x, int y) {
        return square[x][y];
    }

    
    public String levelSelector(){
        String[] choices = { 
        "level1.txt", "level2.txt", "level3.txt", "level4.txt", "level5.txt", "level6.txt", "level7.txt","level8.txt","level9.txt","level20.txt","level21.txt",
        "level22.txt","level23.txt","level24.txt", "level25.txt","level26.txt","level27.txt","level28.txt","level29.txt","level30.txt","level31.txt","level32.txt","level33.txt",
        "level34.txt","level35.txt","level36.txt","level37.txt","level38.txt","level39.txt","level40.txt"
    };
        String input = (String) JOptionPane.showInputDialog(null, "Choose now...",
            "The Choice of a Lifetime", JOptionPane.QUESTION_MESSAGE, null, // Use
                                                                            // default
                                                                            // icon
            choices, // Array of choices
            choices[1]); // Initial choice
        System.out.println(input);
        return input;
    }

    public void changeButton() {
        try {
            Scanner sc = new Scanner(new BufferedReader((new FileReader(levelSelector()))));
            String[][] myArray = new String[5][5];
            while (sc.hasNextLine()) {
                for (int x = 0; x < myArray.length; x++) {
                    String[] line = sc.nextLine().trim().split(" ");
                    for (int y = 0; y < line.length; y++) {
                        myArray[x][y] = line[y];

                        switch (myArray[x][y]) {

                            case "g":
                                Loc[x][y] = "greenFrog";
                                square[x][y].setIcon(greenFrog);
                                break;

                            case "r":
                                Loc[x][y] = "redFrog";
                                square[x][y].setIcon(redFrog);
                                break;

                            case "l":
                                Loc[x][y] = "lilypad";
                                square[x][y].setIcon(lilypad);
                                break;

                            case "w":
                                Loc[x][y] = "water";
                                square[x][y].setIcon(water);
                                break;

                            default:
                                Loc[x][y] = "water";
                                square[x][y].setIcon(water);
                        }
                    }
                }
            }
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void moveTo(JButton XY) 
    {
        System.out.println("" + XY.getIcon());
        System.out.println("" + XY.getBounds());

        lily = XY.getBounds();
        xLoc = lily.x;
        yLoc = lily.y;

        for (int i = 0; i < 5; i++){
            for (int y = 0; y < 5; y++)
            {
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

        middlexLoc = (xLoc + highlightXLoc) / 2;
        middleyLoc = (yLoc + highlightYLoc) / 2;

        for (int x = 0; x < 5; x++){
            for (int j = 0; j < 5; j++){
                    if (square[x][j].getIcon() == greenFrog){
                        if (square[x][j].getBounds().x == middlexLoc && square[x][j].getBounds().y == middleyLoc){
                            square[x][j].setIcon(lilypad);
                            if (redOrGreen == 0){
                                XY.setIcon(greenFrog);
                                System.out.println("" + redOrGreen);
                            }
                            else if (redOrGreen == 1){
                                XY.setIcon(redFrog);
                                System.out.println("" + redOrGreen);
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
                            System.out.println("FAKE");
                        }
                    }
                    else{
                        System.out.println("OH no");                    
                    }
            }
        }
        System.out.println("" + highlightXLoc);
        System.out.println("" + highlightYLoc);
        System.out.println("" + xLoc);
        System.out.println("" + yLoc);
	}
}
