import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerBattleCharacter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerBattleCharacter extends Actor
{
    boolean attack = true;
    boolean inBattle = true;
    boolean draw = true;
    int runAnimation = 0;
    int drawAndShoot = 0;
    int holster = 14;
    int imageDelay = 8;
    /**
     * Act - do whatever the PlayerBattleCharacter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Run animation
        if (inBattle == false) {
            imageDelay--;
            if (imageDelay == 0) {
                imageDelay = 8;
                runAnimation++;
                // Change image
                setImage("PlayerWalk" + runAnimation + ".png");
                if (runAnimation == 4) {
                    runAnimation = 0;
                }
            }
        } else {            
            imageDelay--;
            if (imageDelay == 0) {
                imageDelay = 8;
                // Attack animation
                if (attack == true) {
                    // Draw weapon and shoot
                    if (draw == true) {
                        drawAndShoot++;
                        if (drawAndShoot <= 22) {
                            setImage("PlayerAttack" + drawAndShoot + ".png");
                            if (drawAndShoot == 22) {
                                drawAndShoot = 0;
                                draw = false;
                            }
                        }
                    } else {
                        if (holster > 0) {
                            setImage("PlayerAttack" + holster + ".png");
                        }
                        holster--;
                    }
                }
            }
        }
    }
}
