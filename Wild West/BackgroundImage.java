import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BackgroundImage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackgroundImage extends Actor
{
    /**
     * Act - do whatever the BackgroundImage wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Move left if the player is not in a battle
        AttackTest world = (AttackTest)getWorld();
        if(!world.inBattle){
            setLocation(getX() -1, getY());
        }
    }

    /**
     * Set image
     */
    public void addedToWorld(World AttackTest) {
        setImage("Background" + ((AttackTest)getWorld()).level + ".jpg");
    }
}
