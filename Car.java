import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Car here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Car extends Actor
{
    /**
     * Act - do whatever the Car wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    boolean display = true;
    GreenfootSound hitSound = new GreenfootSound("crash.mp3");
    public void act() 
    {
        move(-2);
        if(Greenfoot.isKeyDown("up") && !isBusStop())
        {
            move(-3);
        }
        else if(isBusStop())
        {
            move(3);
        }
        remove();
    }    
    public void remove()
    {
        World world = getWorld();
        Bus bus = world.getObjects(Bus.class).get(0);
        HealthBar hb = world.getObjects(HealthBar.class).get(0);
        if(getY() == world.getHeight() - 1 || getY() == 0)
        {
            world.removeObject(this);
        }
        else if(isTouching(Bus.class) && display)
        {
            hitSound.play();
            setImage("blank.png");
            display = false;
            hb.health -= 6;
        }
    }
    public boolean isBusStop()
    {
        World world = getWorld();
        Bus bus = world.getObjects(Bus.class).get(0);
        return (bus.isOnBlock() || bus.isDead());
    }
}
