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
    int throwawayTimer = 0;

    //static variable for click button
    static ClickButton click = new ClickButton();

    //hero timer variable between two random numbers 
    int heroTimerTarget = getRandomNumber(100, 400);

    //test
    static PlayerBattleCharacter hero;
    static Enemy[] enemies = new Enemy[6];
    Level2Image level2 = new Level2Image();
    // Battle variables
    boolean inBattle = false;
    boolean attack = false;
    boolean enemyAttack = false;
    boolean attackClassesLoaded = false;
    boolean addNewEnemy = true;

    int lastEnemyInWorld = 0;
    int level = 1;
    public void act(){
        enemyAttack();
        heroAttack();

        // Check to see if a new enemy needs to be added
        if (addNewEnemy == true && lastEnemyInWorld < 6) {
            addObject(enemies[lastEnemyInWorld], 1200, 200);
            addNewEnemy = false;
        }

        if(!inBattle){
            // Increase background timer when not in a battle
            backgroundTimer++;
        } else if (inBattle && !attackClassesLoaded){
            // Load battle classes once the battle has started
            addObject(new AttackBar(), 450, 325);
            addObject(new AttackSlider(), 450, 325);
            addObject(new Barrier(), 200, 325);
            addObject(click, 810, 332);
            addObject(new EnemyHealthBar(), 775, 25);

            attackClassesLoaded = true;
        }

        //Infinity Background
        if (backgroundTimer == 900 && !inBattle){
            backgroundTimer = 0;
            // Choose what background image to display based on the level
            addObject(new BackgroundImage(), 1350, 200);
        }

        // Check if 3 enemies have been defeated
        // If fewer than 3 enemies have been defeated, it is still level 1
        // If more than 3 or 3 enemies have been defeated, it is level 2
        if (lastEnemyInWorld == 3) {
            level = 2;
        }
        
        defeatedAllEnemies();
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
        setPaintOrder( Level2Image.class, AttackSlider.class, EnemyAttack.class, HeroAttack.class, AttackBar.class, Barrier.class, HeroHealthBar.class, EnemyHealthBar.class, PlayerBattleCharacter.class, ClickButton.class, Enemy.class);


        addObject(new HeroHealthBar(), 125, 25);
        hero = new PlayerBattleCharacter();
        addObject(hero, 150, 200);
        addObject(new BackgroundImage(), 450, 200);

        for (int i = 0; i < enemies.length; i++) {
            enemies[i] = new Enemy();
        }
    }

    /**
     * method which randomly controls the NPC attack 
     */
    private void enemyAttack(){
        // Checks to see if battle is true for scroll to occur
        if(inBattle == true){
            enemyTimer++;
            if(enemyTimer > Greenfoot.getRandomNumber(4000)){
                enemyTimer = 0;
                addObject(new EnemyAttack(), 700, 325);
            }
        }
    }

    /**
     * method which randomly spawns hero attack
     */
    private void heroAttack(){
        if(inBattle == true){
            heroTimer++;
            if(heroTimer == heroTimerTarget){
                heroTimer = 0;
                heroTimerTarget = getRandomNumber(100, 400);
                int randX = getRandomNumber(200, 700);
                addObject(new HeroAttack(), randX, 325);
                //Hero attack button
            }
        }
    }

    /**
     * clearer random number method to specify parameters 
     */
    public int getRandomNumber(int start, int end){
        int normal = Greenfoot.getRandomNumber(end - start +1);
        return normal + start;
        
    }
    
    /**
     * Checks if all enemies have been defeated
     * Changes the world to the win screen if they have
     */
    private void defeatedAllEnemies() {
        if (lastEnemyInWorld == 6) {
            Greenfoot.setWorld(new WinScreen());
        }
    }
}
