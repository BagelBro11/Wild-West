import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AttackSlider here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AttackSlider extends Actor
{
    //speed X variable
    public static double deltaX;
    boolean moveRight = true;

    public AttackSlider(){
        //setting speed
        deltaX = 4;
    }

    /**
     * Act - do whatever the AttackSlider wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        bouncing();
        isHit();
        if (moveRight) {
            setLocation(getX() + (int)deltaX, getY());
        } else {
            setLocation(getX() - (int)deltaX, getY());
        }
    }

    private void bouncing(){
        //if touching left side of attack bar go other way
        if(getX() < 200){
            moveRight = true;
        }
        //if touching right side of attack bar go other way
        if(getX() > 700){
            moveRight = false;
        }
    }

    /**
     * method which reads if the attack bar is touching any objects which would cause reprocussions
     */
    private void isHit(){
        if(isTouching(EnemyAttack.class) && Greenfoot.mousePressed(AttackTest.click)){
            deltaX += 1;

            removeTouching(EnemyAttack.class);
        }
        else if(isTouching(HeroAttack.class) && Greenfoot.mousePressed(AttackTest.click)){
            deltaX += 1;
            
            AttackTest.enemy.health -= 10;
            ((AttackTest)getWorld()).attack = true;
            removeTouching(HeroAttack.class);
        }
        else if(isTouching(AttackBar.class) && Greenfoot.mousePressed(AttackTest.click)){
            deltaX = 4;
            
            AttackTest.hero.health -= 5;
        }

    }
}
