import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Passenger here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Passenger extends Actor
{
    /**
     * Act - do whatever the Passenger wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int nWarp = 0;
    boolean onTheBus = false;
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
            setRotation(-90);
            move(-5);
            this.onTheBus = false;
        }
        if(Greenfoot.isKeyDown("up") && !stop)
        {
           setRotation(-90);
           move(-6);
           this.onTheBus = false;
        }
        if(stop)
        {
            getOn();
        }
        warp();
    }
    public void warp()
    {
        World world = getWorld();
        if(getY() == world.getHeight() - 1)
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
        }
        else
        {
            setImage("poby2.png");
            this.nWarp = 0;
            //setLocation(Greenfoot.getRandomNumber(90), 0);
        }
    }
    public void getOn()
    {
        World world = getWorld();
        Bus bus = world.getObjects(Bus.class).get(0);
        PassengerBar pb = world.getObjects(PassengerBar.class).get(0);
        BusStop bs = world.getObjects(BusStop.class).get(0);
        HealthBar hb = world.getObjects(HealthBar.class).get(0);
        GreenfootSound getPoint = new GreenfootSound("point.mp3");
        if(bus != null)
        {
            if(bus.isOnBlock() && !this.onTheBus && !bus.isDead())
            {
                turnTowards(bus.getX(), bus.getY());
                move(2);
                if(isTouching(Bus.class))
                {
                    getPoint.play();
                    setImage("blank.png");
                    pb.passenger++;
                    hb.health += 2;
                    if(hb.health > 40)
                        hb.health = 40;
                    int[] yRange = {bs.getY()-280, bs.getY()};
                    int y = 0;
                    do
                    {
                        y = Greenfoot.getRandomNumber(world.getHeight());
                    }
                    while(y < yRange[0] || y > yRange[1]);
                    setLocation(Greenfoot.getRandomNumber(90), y);
                    setRotation(-90);
                    this.onTheBus = true;
                }
            }
        }
    }
}
