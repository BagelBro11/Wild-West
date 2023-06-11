import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyAttack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyAttack extends Actor
{
     int deltaX;
    public EnemyAttack(){
        deltaX = -4;
    }
     /**
     * Act - do whatever the EnemyAttack wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        setLocation(getX() + deltaX, getY());
        //checks if it has hit the end
        if(isTouching(Barrier.class)){
            getWorld().removeObject(this);
        }
        //checks if enemy attack was hit
        isHit();
    }
    
    private void isHit(){
        if(isTouching(AttackSlider.class) && Greenfoot.isKeyDown("space")){
            getWorld().removeObject(this);
        }
    }
}
