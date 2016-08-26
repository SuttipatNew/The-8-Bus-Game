import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class line here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class line extends Actor
{
    /**
     * Act - do whatever the line wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public boolean Stop()
    {
        World world = getWorld();
        Bus bus = world.getObjects(Bus.class).get(0);
        return (bus.isOnBlock() || bus.isDead());
    }
    public void act() 
    {
        boolean stop = Stop();
        if(!stop)
        {
            move(-5);
        }
        /*if(Greenfoot.isKeyDown("up") && !stop)
        {
           move(-6);
        }*/
        warp();
    }    
    public void warp()
    {
        World world = getWorld();
        if(getY() == world.getHeight() - 1)
        {
            setLocation(getX(), 0);
        }
    }
}
