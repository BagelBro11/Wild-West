import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RedoButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RedoButton extends Actor
{
    /**
     * Act - do whatever the RedoButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Send to attack test
        if(Greenfoot.mousePressed(this)){
            Greenfoot.setWorld(new AttackTest());
        }    
    }

    public void addedToWorld(World World) {
        setImage("RedoButton.png");
    }
}
