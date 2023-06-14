import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    boolean attack = false;
    boolean drawGun = true;
    int drawAndShoot = 0;
    int holster = 14;
    int idle = 0;
    int shootDelayNum = 3;
    int idleDelayNum = 15;
    int imageDelay = 1;
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Attack animation
        if (attack == true) {
            imageDelay--;
            if (imageDelay == 0) {
                imageDelay = shootDelayNum;
                // Draw weapon and shoot
                if (drawGun == true) {
                    drawAndShoot++;
                    if (drawAndShoot <= 22) {
                        setImage("EnemyAttack" + drawAndShoot + ".png");
                        if (drawAndShoot == 22) {
                            drawAndShoot = 0;
                            drawGun = false;
                        }
                    }
                } else {
                    if (holster > 0) {
                        setImage("EnemyAttack" + holster + ".png");
                    }
                    else {
                        setImage("EnemyIdle2.png");
                    }
                    holster--;
                }
            }
        } else {
            imageDelay--;
            if (imageDelay == 0) {
                imageDelay = idleDelayNum;
                idle++;
                setImage("EnemyIdle" + idle + ".png");
                if (idle == 2){
                    idle = 0;
                }
            }
        }
    }
}
