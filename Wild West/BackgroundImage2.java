import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BackgroundImage2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackgroundImage2 extends Actor
{
    /**
     * Act - do whatever the BackgroundImage2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        AttackTest world = (AttackTest)getWorld();
        if(!world.inBattle){
            setLocation(getX() -1, getY());
        }
    }
}