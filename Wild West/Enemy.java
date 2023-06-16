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
        //Winning condition
        if(health == 0){
            Greenfoot.setWorld(new WinScreen());
        }
        
        if (getX() <= 750) {
            ((AttackTest)getWorld()).inBattle = true;
        }
        if (!((AttackTest)getWorld()).inBattle) {
            move(-1);
        } else {
            // Attack animation
            if (((AttackTest)getWorld()).enemyAttack == true) {
                imageDelay--;
                if (imageDelay == 0) {
                    imageDelay = shootDelayNum;
                    // Draw weapon and shoot
                    if (drawGun == true) {
                        drawAndShoot++;
                        if (drawAndShoot <= 22) {
                            setImage("EnemyAttack" + drawAndShoot + ".png");
                            if (drawAndShoot == 22) {
                                drawAndShoot = 0;
                                drawGun = false;
                            }
                        }
                    } else {
                        if (holster > 0) {
                            setImage("EnemyAttack" + holster + ".png");
                        }
                        else {
                            setImage("EnemyIdle2.png");
                            ((AttackTest)getWorld()).enemyAttack = false;
                            drawGun = true;
                            holster = 15;
                        }
                        holster--;
                    }
                }
            } else {
                imageDelay--;
                if (imageDelay == 0) {
                    imageDelay = idleDelayNum;
                    idle++;
                    setImage("EnemyIdle" + idle + ".png");
                    if (idle == 2){
                        idle = 0;
                    }
                }
            }
        }

        endBattle();
    }

    private void endBattle() {
        if (AttackTest.enemy.health <= 0) {
            ((AttackTest)getWorld()).inBattle = false;
            removeAttackClasses();
        }
    }

    private void removeAttackClasses() {
        Class names[] = {AttackBar.class, AttackSlider.class, Barrier.class, ClickButton.class, EnemyAttack.class, HeroAttack.class, EnemyHealthBar.class, Enemy.class};
        for (int i = 0; i < names.length; i++) {
            getWorld().removeObjects(getWorld().getObjects(names[i]));
        }
    }
}
