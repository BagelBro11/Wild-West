import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AttackTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AttackTest extends World
{
    int enemyTimer = 0;
    public void act(){
        enemyTimer++;
        if(enemyTimer > Greenfoot.getRandomNumber(4000)){
            enemyTimer = 0;
            addObject(new EnemyAttack(), 700, 300);
        }
    }
    /**
     * Constructor for objects of class AttackTest.
     * 
     */
    public AttackTest()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 400, 1); 
        addObject(new AttackBar(), 450, 300);
        addObject(new AttackSlider(), 450, 300);
        addObject(new Barrier(), 200, 300);
    }
    
}
