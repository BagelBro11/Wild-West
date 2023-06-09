import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LoseScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LoseScreen extends World
{

    /**
     * Constructor for objects of class LoseScreen.
     * 
     */
    public LoseScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(530, 300, 1); 
        prepare();
        //Sent to this world from attack test after no health left
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        //Redo button for after they lose if they wanna redo
        RedoButton redoButton = new RedoButton();
        addObject(redoButton,279,132);
        // Set image for background
        setBackground("LoseScreenNew.png");
    }
}
