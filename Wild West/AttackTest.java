import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AttackTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AttackTest extends World
{
    //timers for each attack spawning on attack bar
    int enemyTimer = 0;
    int heroTimer = 0;
    int backgroundTimer = 899;
    boolean inBattle = false;
    
    //static variable for click button
    static ClickButton click = new ClickButton();
    
    //hero timer variable between two random numbers 
    int heroTimerTarget = getRandomNumber(100, 400);
    
    //test
    static PlayerBattleCharacter hero = new PlayerBattleCharacter();
    static EnemyExample enemy = new EnemyExample();
    
    // Battle variables
    static boolean inBattle = false;
    static boolean attack = false;
    public void act(){
        enemyAttack();
        heroAttack();
        //Infinity Background
        backgroundTimer++;
        if (backgroundTimer == 900 && inBattle == false){
            backgroundTimer = 0;
            addObject(new BackgroundImage(), 1350, 200);
        }
    }
    
    /**
     * Constructor for objects of class AttackTest.
     * 
     */
    public AttackTest()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 400, 1, false); 
        //makes attack slider be above other objects 
        setPaintOrder(AttackSlider.class, AttackBar.class, Barrier.class, HeroHealthBar.class, EnemyHealthBar.class, heroexample.class, ClickButton.class, EnemyExample.class);
        
        addObject(new AttackBar(), 450, 325);
        addObject(new AttackSlider(), 450, 325);
        addObject(new Barrier(), 200, 325);
        addObject(click, 810, 332);
        addObject(new HeroHealthBar(), 125, 25);
        addObject(new EnemyHealthBar(), 775, 25);
        hero = new PlayerBattleCharacter();
        enemy = new EnemyExample();
        addObject(new BackgroundImage(), 450, 200);
    }
    
    /**
     * method which randomly controls the NPC attack 
     */
    private void enemyAttack(){
        enemyTimer++;
        if(enemyTimer > Greenfoot.getRandomNumber(4000)){
            enemyTimer = 0;
            addObject(new EnemyAttack(), 700, 325);
        }
    }
    
    /**
     * method which randomly spawns hero attack
     */
    private void heroAttack(){
        heroTimer++;
        if(heroTimer == heroTimerTarget){
            heroTimer = 0;
            heroTimerTarget = getRandomNumber(100, 400);
            int randX = getRandomNumber(200, 700);
            addObject(new HeroAttack(), randX, 325);
        }
    }
   
    /**
     * clearer random number method to specify parameters 
     */
    public int getRandomNumber(int start, int end){
        int normal = Greenfoot.getRandomNumber(end - start +1);
        return normal + start;
    }
}
