import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerBattleCharacter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerBattleCharacter extends Actor
{
    boolean attack = false;
    /**
     * Act - do whatever the PlayerBattleCharacter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Idle animation
        if (attack == false) {

        }
        // Attack animation
        else if (attack == true) {
            // Draw weapon and shoot
            for (int i = 1; i <= 22; i++) {
                    
            }
            // Holster weapon
            for (int i = 14; i > 0; i--) {
                    
            }
        }
    }
}
