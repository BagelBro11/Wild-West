import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyHealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyHealthBar extends Actor
{
    String images[] = {"pixil-frame-0 (14).png","pixil-frame-0 (15).png","pixil-frame-0 (16).png","pixil-frame-0 (17).png"};
    /**
     * Act - do whatever the EnemyHealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        //Health bar lowers hearts as damge is delt
        Enemy enemy = ((AttackTest)getWorld()).enemies[((AttackTest)getWorld()).lastEnemyInWorld];
        if (enemy.health > 75){
            setImage(images[0]);
        }
        else if (enemy.health > 50 && enemy.health < 75){
            setImage(images[1]);
        }
        else if (enemy.health > 25 && (enemy.health < 50)){
            setImage(images[2]);
        }
        else if (enemy.health < 25){
            setImage(images[3]);
        }
    }
}
