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
    int heroTimer = 0;
    static ClickButton click = new ClickButton();
    int heroTimerTarget = getRandomNumber(100, 400);
    public void act(){
        enemyTimer++;
        if(enemyTimer > Greenfoot.getRandomNumber(4000)){
            enemyTimer = 0;
            addObject(new EnemyAttack(), 700, 300);
        }
        heroTimer++;
        if(heroTimer == heroTimerTarget){
            heroTimer = 0;
            heroTimerTarget = getRandomNumber(100, 400);
            int randX = getRandomNumber(200, 700);
            addObject(new HeroAttack(), randX, 300);
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
        setPaintOrder(AttackSlider.class);
        addObject(new AttackBar(), 450, 300);
        addObject(new AttackSlider(), 450, 300);
        addObject(new Barrier(), 200, 300);
        addObject(click, 810, 307);
    }
    
    public int getRandomNumber(int start, int end){
        int normal = Greenfoot.getRandomNumber(end - start +1);
        return normal + start;
    }
}
