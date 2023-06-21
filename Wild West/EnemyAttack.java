import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyAttack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyAttack extends Actor
{
    int deltaX;
    int damage = 10;
    public EnemyAttack(){
        deltaX = -3;
    }

    /**
     * Act - do whatever the EnemyAttack wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Move
        setLocation(getX() + deltaX, getY());
        
        //checks if it has hit the end 
        if(isTouching(Barrier.class)){
            AttackTest world = getWorldOfType(AttackTest.class);
            if(world.level == 2){
                damage = 25;
            }
            AttackTest.hero.health -= damage;
            // Display damage
            getWorld().addObject(new Damage(damage), 250, 200);
            // Start Enemy animation
            ((AttackTest)getWorld()).enemyAttack = true;
            if(AttackSlider.deltaX > 0){
                AttackSlider.deltaX = 4;
            }
            else{
                AttackSlider.deltaX = -4;
            }
            getWorld().removeObject(this);
        }

    }
    
    public void addedToWorld(World AttackTest) {
        // Change image for each level
        setImage("EnemyAttack" + ((AttackTest)getWorld()).level + ".png");
    }

}
