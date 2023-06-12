import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyHealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyHealthBar extends Actor
{
    GreenfootImage img1 = new GreenfootImage ("pixil-frame-0 (14).png");
    GreenfootImage img2 = new GreenfootImage ("pixil-frame-0 (15).png");
    GreenfootImage img3 = new GreenfootImage ("pixil-frame-0 (16).png");
    GreenfootImage img4 = new GreenfootImage ("pixil-frame-0 (17).png");
    /**
     * Act - do whatever the EnemyHealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        if (AttackTest.hero.health > 75){
            setImage(img1);
        }
        if (AttackTest.hero.health > 50 && AttackTest.hero.health < 75){
            setImage(img2);
        }
        if (AttackTest.hero.health > 25 && (AttackTest.hero.health < 50)){
            setImage(img3);
        }
        if (AttackTest.hero.health < 25){
            setImage(img4);
        }
    }
}
