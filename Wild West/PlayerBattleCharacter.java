import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerBattleCharacter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerBattleCharacter extends Actor
{
    boolean inBattle = false;
    boolean drawGun = true;
    int runAnimation = 0;
    int drawAndShoot = 0;
    int holster = 14;
    int idle = 0;
    int runDelayNum = 7;
    int shootDelayNum = 3;
    int idleDelayNum = 15;
    int imageDelay = 1;

    int health = 500;
    /**
     * Act - do whatever the PlayerBattleCharacter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        //Losing condition
        checkHealth();
        // Run animations
        animations();
    }
    
    public void addedToWorld() {
        setImage("PlayerBattleIdle2.png");
    }
    
    private void checkHealth() {
        if(health <= 0){
            Greenfoot.setWorld(new LoseScreen());
        }
    }

    private void animations() {
        if (((AttackTest)getWorld()).inBattle == false) {
            // Run animation
            run();
        } else {
            if (((AttackTest)getWorld()).attack == true) {
                // Attack animation
                attack();
            } else {
                // Idle animation
                idle();
            }
        }
    }

    private void run () {
        // Count down until next image can be displayed
        imageDelay--;
        if (imageDelay == 0) {
            // Reset imageDelay
            imageDelay = runDelayNum;
            // Add one to run animation to change the image that will be set
            runAnimation++;
            // Change image
            setImage("PlayerWalk" + runAnimation + ".png");
            // Reset runAnimation if it has reached its max
            if (runAnimation == 4) {
                runAnimation = 0;
            }
        }
    }

    private void attack() {
        // Count down until next image can be displayed
        imageDelay--;
        if (imageDelay == 0) {
            // Reset imageDelay
            imageDelay = shootDelayNum;
            // Draw weapon and shoot
            if (drawGun == true) {
                // Add one to drawAndShoot to change the image that will be set
                drawAndShoot++;
                if (drawAndShoot <= 22) {
                    setImage("PlayerAttack" + drawAndShoot + ".png");
                    if (drawAndShoot == 22) {
                        // Reset drawAndShoot for the next time this animation is run
                        drawAndShoot = 0;
                        // set DrawGun to false to run the holster animation
                        drawGun = false;
                    }
                }
            } else {
                if (holster > 0) {
                    setImage("PlayerAttack" + holster + ".png");
                }
                else {
                    // Reset attack animation values and start the idle animation
                    setImage("PlayerBattleIdle2.png");
                    ((AttackTest)getWorld()).attack = false;
                    drawGun = true;
                    holster = 15;
                }
                // holster counts down to change the image that is being set
                holster--;
            }
        }
    }

    private void idle() {
        // Count down until next image can be displayed
        imageDelay--;
        if (imageDelay == 0) {
            // Reset imageDelay
            imageDelay = idleDelayNum;
            // Add one to idle to change what image will be set
            idle++;
            // Set the image
            setImage("PlayerBattleIdle" + idle + ".png");
            // Reset idle to 0 if it has reached its max
            if (idle == 2){
                idle = 0;
            }
        }
    }
}
