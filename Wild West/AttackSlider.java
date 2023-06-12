import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AttackSlider here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AttackSlider extends Actor
{
    int deltaX;
    int health = 0;
    public AttackSlider(){
        deltaX = 5;
    }
    /**
     * Act - do whatever the AttackSlider wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        bouncing();
        setLocation(getX() + deltaX, getY());
    }
    private void bouncing(){
        //if touching left side of attack bar go other way
        if(getX() < 200){
            //setLocation(getWorld().getWidth() /2,getWorld().getHeight() /2 );
            deltaX = 5;
            
            
        }
        //if touching right side of attack bar go other way
        if(getX() > 700){
            //setLocation(getWorld().getWidth() /2,getWorld().getHeight() /2 );
            deltaX = -5;
            
            
        }
    }
    private void isHit(){

        World w = getWorld();
        if(isTouching(EnemyAttack.class) && Greenfoot.mousePressed(w)){
            getWorld().removeObject(EnemyAttack);
        }
        else if(isTouching(HeroAttack.class) && Greenfoot.mousePressed(w)){
            getWorld().removeObject(HeroAttack);
        }
        else if(isTouching(HeroAttack.class) && Greenfoot.mousePressed(w)){
            health = 0;
        }
        
    }
}
