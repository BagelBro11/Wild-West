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
    /**
     * Setting speed
     */
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
        //Code to move it from side to side
        bouncing();
        isHit();
        if (moveRight) {
            setLocation(getX() + (int)deltaX, getY());
        } else {
            setLocation(getX() - (int)deltaX, getY());
        }
    }

    /**
     * Set image
     */
    public void addedToWorld(World AttackTest) {
        setImage("AttackSlider.png");
    }

    /**
     * Change direction when at edge of the attack bar
     */
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
            //speed boost if clicked and removal
        }
        else if(isTouching(HeroAttack.class) && Greenfoot.mousePressed(AttackTest.click)){
            deltaX += 1;
            Enemy enemy = ((AttackTest)getWorld()).enemies[((AttackTest)getWorld()).lastEnemyInWorld];
            enemy.health -= 10;
            //Hero damage
            ((AttackTest)getWorld()).attack = true;
            removeTouching(HeroAttack.class);
            //speed boost if clicked and removal
        }
        else if(isTouching(AttackBar.class) && Greenfoot.mousePressed(AttackTest.click)){
            deltaX = 4;

            AttackTest.hero.health -= 5;
            //Enemy damage
        }

    }
}
