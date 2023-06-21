import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    boolean drawGun = true;
    int drawAndShoot = 0;
    int holster = 14;
    int idle = 0;
    int shootDelayNum = 3;
    int idleDelayNum = 15;
    int imageDelay = 1;

    int health = 100;
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        startBattle();
        move();
        endBattle();
    }

    /**
     * Set image
     */
    public void addedToWorld(World AttackTest) {
        setImage("Enemy" + ((AttackTest)getWorld()).level + "Idle2.png");
    }

    /**
     * Start battle if enemy has reached battle location
     */
    private void startBattle() {
        if (getX() <= 750) {
            ((AttackTest)getWorld()).inBattle = true;
        }
    }

    /**
     * Move when not in battle
     * Start animations if in battle
     */
    private void move() {
        if (!((AttackTest)getWorld()).inBattle) {
            move(-1);
        } else {
            // Attack animation
            animations();
        }
    }

    /**
     * Select the animation used
     */
    private void animations() {
        if (((AttackTest)getWorld()).enemyAttack == true) {
            // Attack
            attack();
        } else {
            // Idle
            idle();
        }
    }

    /**
     * When enemy used each animation
     */
    private void attack() {
        // imageDelay counts down to zero to change the image
        imageDelay--;
        if (imageDelay == 0) {
            // Reset imageDelay
            imageDelay = shootDelayNum;
            if (drawGun == true) { // Draw the gun and shoot
                // Add one to drawAndShoot to change the image every time
                drawAndShoot++;
                if (drawAndShoot <= 22) {
                    setImage("Enemy" + ((AttackTest)getWorld()).level + "Attack" + drawAndShoot + ".png");
                    if (drawAndShoot == 22) {
                        // Reset value for the next time the animation is run
                        drawAndShoot = 0;
                        // Set drawGun to false to run the holster animation
                        drawGun = false;
                    }
                }
            } else { // Holster the gun
                if (holster > 0) {
                    setImage("Enemy" + ((AttackTest)getWorld()).level + "Attack" + holster + ".png");
                }
                else {
                    // Reset values and start the idle animation
                    setImage("Enemy" + ((AttackTest)getWorld()).level + "Idle2.png");
                    ((AttackTest)getWorld()).enemyAttack = false;
                    drawGun = true;
                    holster = 15;
                }
                // Change the value of holster to change what the image will be set to
                holster--;
            }
        }
    }

    /**
     * Idle code for enemy
     */
    private void idle() {
        // imageDelay counts down to zero to change the image
        imageDelay--;
        if (imageDelay == 0) {
            // Reset imageDelay
            imageDelay = idleDelayNum;
            // Add one to idle to change the image that will be set
            idle++;
            // Set the image
            setImage("Enemy" + ((AttackTest)getWorld()).level + "Idle" + idle + ".png");
            // Reset idle if it has reached its max
            if (idle == 2){
                idle = 0;
            }
        }
    }

    /**
     * Method to check if battle is completed
     */
    private void endBattle() {
        // Check if the enemy has any health left
        // If not, remove all classes associated with the battle and add one to the enemy count
        if (health <= 0) {
            ((AttackTest)getWorld()).inBattle = false;
            ((AttackTest)getWorld()).attackClassesLoaded = false;
            ((AttackTest)getWorld()).addNewEnemy = true;
            ((AttackTest)getWorld()).lastEnemyInWorld++;
            removeAttackClasses();
        }
    }

    /**
     * Removed objects once battle completed
     */
    private void removeAttackClasses() {
        // Store all classes that need to be removed in an array
        Class names[] = {AttackBar.class, AttackSlider.class, Barrier.class, ClickButton.class, EnemyAttack.class, HeroAttack.class, EnemyHealthBar.class, Enemy.class};
        // Remove all classes by going through the array
        for (int i = 0; i < names.length; i++) {
            getWorld().removeObjects(getWorld().getObjects(names[i]));
        }
    }
}
