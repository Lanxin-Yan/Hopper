import javax.swing.*;
import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
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

    private Boolean redOrGreen;

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

    public void changeButton() {
        try {
            Scanner sc = new Scanner(new BufferedReader((new FileReader("level1.txt"))));
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
                    redOrGreen = false;
                }
                else if (square[i][y].getIcon() == greenFrog2){
                    highlightedFrog = square[i][y].getBounds();
                    highlightXLoc = highlightedFrog.x;
                    highlightYLoc = highlightedFrog.y;
                    redOrGreen = true;
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
                        if (redOrGreen = true){
                            XY.setIcon(greenFrog);
                            System.out.println("" + redOrGreen);
                        }
                        else if (redOrGreen = false){
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
