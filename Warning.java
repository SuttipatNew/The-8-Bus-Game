import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Warning here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Warning extends Actor
{
    /**
     * Act - do whatever the Warning wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //public long blinkTime = 0;
    public long blinkTime = System.currentTimeMillis();
    public boolean display = false;
    public void act() 
    {
        World world = getWorld();
        BusStop bs = world.getObjects(BusStop.class).get(0);
        if(bs.nWarp >= Road.distance - 3)
        {
            blink();
        }
        else
        {
            setImage("blank.png");
            this.display = false;
        }
    }    
    public void blink()
    {
        if(System.currentTimeMillis() - blinkTime > 500)
        {
            if(this.display)
            {
                setImage("blank.png");
            }
            else
            {
                setImage("warning.png");
            }
            this.display = !this.display;
            blinkTime = System.currentTimeMillis();
        }
    }
}
