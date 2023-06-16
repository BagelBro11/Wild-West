import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HeroHealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HeroHealthBar extends Actor
{
    String images[] = {"pixil-frame-0 (10).png", "pixil-frame-0 (11).png", "pixil-frame-0 (12).png", "pixil-frame-0 (13).png"};
    /**
     * Act - do whatever the HeroHealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        if (AttackTest.hero.health > 75){
            setImage(images[0]);
        }
        else if (AttackTest.hero.health > 50 && AttackTest.hero.health < 75){
            setImage(images[1]);
        }
        else if (AttackTest.hero.health > 25 && (AttackTest.hero.health < 50)){
            setImage(images[2]);
        }
        else if (AttackTest.hero.health < 25){
            setImage(images[3]);
        }
    }
}
