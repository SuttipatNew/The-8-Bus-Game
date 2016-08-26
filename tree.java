import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class tree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class tree extends Actor
{
    /**
     * Act - do whatever the tree wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int nWarp = 0;
    String image = "tree.png";
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
            move(-5);
        if(Greenfoot.isKeyDown("up") && !stop)
        {
           move(-6);
        }
        warp();
    }    
    public void warp()
    {
        World world = getWorld();
        if(getY() == world.getHeight() - 1)
        {
            setLocation(getX(), 0);
            //setImage("tree.png");
            transform();
        }
    }
    public void transform()
    {
        if(this.nWarp < Road.distance)
        {
            setImage("tree.png");
            this.nWarp++;
        }
        else
        {
            setImage("blank.png");
            this.nWarp = 0;
        }
    }
}
