import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WinScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WinScreen extends World
{

    /**
     * Constructor for objects of class WinScreen.
     * 
     */
    public WinScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(590, 320, 1); 

        prepare();
        //Sent to win world after all enemys are killed
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        RedoButton redoButton = new RedoButton();
        addObject(redoButton,295,286);
        redoButton.setLocation(295,286);
        setBackground("WinScreen.jpg");
        //Redo if they wanna play again
    }
}
