import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AttackSlider here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AttackSlider extends Actor
{
    //speed X variable
    public static double deltaX;
    boolean moveRight = true;

    public AttackSlider(){
        //setting speed
        deltaX = 4;
    }

    /**
     * Act - do whatever the AttackSlider wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        //Code to move it from side to side
        bouncing();
        isHit();
        if (moveRight) {
            setLocation(getX() + (int)deltaX, getY());
        } else {
            setLocation(getX() - (int)deltaX, getY());
        }
    }
    
    public void addedToWorld(World AttackTest) {
        setImage("AttackSlider.png");
    }

    private void bouncing(){
        //if touching left side of attack bar go other way
        if(getX() < 200){
            moveRight = true;
        }
        //if touching right side of attack bar go other way
        if(getX() > 700){
            moveRight = false;
        }
    }

    /**
     * method which reads if the attack bar is touching any objects which would cause reprocussions
     */
    private void isHit(){
        if(isTouching(EnemyAttack.class) && Greenfoot.mousePressed(AttackTest.click)){
            deltaX += 1;

            removeTouching(EnemyAttack.class);
            //speed boost if clicked and removal
        }
        else if(isTouching(HeroAttack.class) && Greenfoot.mousePressed(AttackTest.click)){
            // Set attack to true to start animation            
            ((AttackTest)getWorld()).attack = true;
            // Find what enemy is in the battle
            Enemy enemy = ((AttackTest)getWorld()).enemies[((AttackTest)getWorld()).lastEnemyInWorld];
            // Hero damage
            enemy.health -= 10;
            // Display damage
            getWorld().addObject(new Damage(10), 650, 200);
            // Speed boost if clicked and removal
            deltaX += 1;
            removeTouching(HeroAttack.class);
        }
        else if(isTouching(AttackBar.class) && Greenfoot.mousePressed(AttackTest.click)){
            // Missed objects, therefore speed is reset
            deltaX = 4;
            // Damage penalty for hitting the bar
            AttackTest.hero.health -= 5;
            // Display damage
            getWorld().addObject(new Damage(5), 250, 200);
        }

    }
}
