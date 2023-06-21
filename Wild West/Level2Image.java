import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2Image here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2Image extends Actor
{
    int deleteCount = 300;
    /**
     * Act - do whatever the Level2Image wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Count down to actor deletion
        deleteCount--;
        if (deleteCount == 0) {
            getWorld().removeObject(this);
        }
    }

    /**
     * Set image
     */
    public void addedToWorld(World AttackTest) {
        setImage("Level2.png");
    }
}
