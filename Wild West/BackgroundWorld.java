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
    boolean inBattle = false;

    /**
     * Constructor for objects of class BackgroundWorld.
     * 
     */
    public BackgroundWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 400, 1, false); 
        setPaintOrder(BackgroundImage.class);
        addObject(new BackgroundImage(), 450, 200);
    }
    
    public void act(){
        //Infinity Background
        backgroundTimer++;
        if (backgroundTimer == 900 && inBattle == false){
            backgroundTimer = 0;
            addObject(new BackgroundImage(), 1350, 200);
        }
    }
}
