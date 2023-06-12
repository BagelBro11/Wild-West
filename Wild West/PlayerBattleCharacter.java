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
    boolean inBattle = false;
    int runAnimation = 0;
    /**
     * Act - do whatever the PlayerBattleCharacter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Run animation
        if (inBattle == false) {
            runAnimation++;
            // Change Image
            
            if (runAnimation == 4) {
                runAnimation = 0;
            }
        } else {
            // Attack animation
            if (attack == true) {
                // Draw weapon and shoot
                for (int i = 1; i <= 22; i++) {

                }
                // Holster weapon
                for (int i = 14; i > 0; i--) {

                }
            }
        }
    }
}
