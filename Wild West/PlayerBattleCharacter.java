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
        if(health <= 0){
            Greenfoot.setWorld(new LoseScreen());
        }
       
        // Run animation
        if (((AttackTest)getWorld()).inBattle == false) {
            imageDelay--;
            if (imageDelay == 0) {
                imageDelay = runDelayNum;
                runAnimation++;
                // Change image
                setImage("PlayerWalk" + runAnimation + ".png");
                if (runAnimation == 4) {
                    runAnimation = 0;
                }
            }
        } else {  
            // Attack animation
            if (((AttackTest)getWorld()).attack == true) {
                imageDelay--;
                if (imageDelay == 0) {
                    imageDelay = shootDelayNum;
                    // Draw weapon and shoot
                    if (drawGun == true) {
                        drawAndShoot++;
                        if (drawAndShoot <= 22) {
                            setImage("PlayerAttack" + drawAndShoot + ".png");
                            if (drawAndShoot == 22) {
                                drawAndShoot = 0;
                                drawGun = false;
                            }
                        }
                    } else {
                        if (holster > 0) {
                            setImage("PlayerAttack" + holster + ".png");
                        }
                        else {
                            setImage("PlayerBattleIdle2.png");
                            ((AttackTest)getWorld()).attack = false;
                            drawGun = true;
                            holster = 15;
                        }
                        holster--;
                    }
                }
            } else {
                imageDelay--;
                if (imageDelay == 0) {
                    imageDelay = idleDelayNum;
                    idle++;
                    setImage("PlayerBattleIdle" + idle + ".png");
                    if (idle == 2){
                        idle = 0;
                    }
                }
            }
        }
    }
}
