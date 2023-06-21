import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Damage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Damage extends Actor
{
    int count = 100;
    public Damage(int damage) {
        setImage("Damage(-" + damage + ").png");
    }
    
    /**
     * Act - do whatever the Damage wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move();
        countDown();
        delete();
    }

    private void move() {
        setLocation(getX(), getY() - 1);
    }

    private void countDown() {
        count--;
    }

    private void delete() {
        if (count <= 0) {
            getWorld().removeObject(this);
        }
    }
}
