import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Block here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Block extends Actor
{
    /**
     * Act - do whatever the Block wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int nWarp = 0;
    boolean display = false;
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
        toggle();
    }
    public void warp()
    {
        World world = getWorld();
        
        //to fix bugs that pobys' location aren't right ----------------------------
        BusStop bs = world.getObjects(BusStop.class).get(0);
        if(bs.display && this.nWarp != 0)
        {
            if(bs.getY() > 80 && !display)
            {
                setLocation(getX(), 0);
                setImage("block.png");
                this.nWarp = 0;
                display = true;
            }
        }
        //----------------------------------------------------------------------------
        else if(getY() == world.getHeight() - 1)
        {
            setLocation(getX(), 0);
            transform();
        }
    }
    public void transform()
    {
        if(this.nWarp < Road.distance)
        {
            setImage("blank.png");
            this.nWarp++;
            display = false;
        }
        else
        {
            setImage("block.png");
            this.nWarp = 0;
            display = true;
        }
    }
    public void toggle()
    {
        World world = getWorld();
        Bus bus = world.getObjects(Bus.class).get(0);
        Passenger[] passengers = new Passenger[4];
        for(int i = 0; i < 4; i++)
        {
            passengers[i] = world.getObjects(Passenger.class).get(i);
        }
        if(bus.isOnBlock() && !bus.isDead() && display)
        {
            boolean canContinue = false;
            for(int i = 0; i < 4; i++)
            {
                if(!passengers[i].onTheBus)
                {
                    canContinue = false;
                    break;
                }
                canContinue = true;
            }
            if(canContinue)
            {
                setImage("blank.png");
                display = false;
            }
        }
        
    }
}
