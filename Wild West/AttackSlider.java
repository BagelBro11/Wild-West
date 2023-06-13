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
    int deltaX;

    public AttackSlider(){
        //setting speed
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
        isHit();
        setLocation(getX() + deltaX, getY());
    }

    private void bouncing(){
        //if touching left side of attack bar go other way
        if(getX() < 200){
            deltaX = 5;

        }
        //if touching right side of attack bar go other way
        if(getX() > 700){
            deltaX = -5;

        }
    }

    /**
     * method which reads if the attack bar is touching any objects which would cause reprocussions
     */
    private void isHit(){

        if(isTouching(EnemyAttack.class) && Greenfoot.mousePressed(AttackTest.click)){
            removeTouching(EnemyAttack.class);
        }
        else if(isTouching(HeroAttack.class) && Greenfoot.mousePressed(AttackTest.click)){
            AttackTest.enemy.health -= 10;

            removeTouching(HeroAttack.class);
        }
        else if(isTouching(AttackBar.class) && Greenfoot.mousePressed(AttackTest.click)){

            AttackTest.hero.health -= 5;
        }

    }
}
