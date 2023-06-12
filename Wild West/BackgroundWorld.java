import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BackgroundWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackgroundWorld extends World
{
    int backgroundTimer = 899;

    /**
     * Constructor for objects of class BackgroundWorld.
     * 
     */
    public BackgroundWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 400, 1, false); 
        setPaintOrder(BackgroundImage.class);
        addObject(new BackgroundImage(), 900, 200);
    }
    
    public void act(){
        //Infinity Background
        backgroundTimer++;
        if (backgroundTimer == 900){
            backgroundTimer = 0;
            addObject(new BackgroundImage(), 900, 200);
        }
    }
}
