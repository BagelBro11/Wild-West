import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HeroAttack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HeroAttack extends Actor
{
    /**
     * Act - do whatever the HeroAttack wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        isHit();
    
    
    }
    private void isHit(){

        World w = getWorld();
        if(isTouching(AttackSlider.class) && Greenfoot.mousePressed(w)){
            getWorld().removeObject(this);
        }

    }
}
