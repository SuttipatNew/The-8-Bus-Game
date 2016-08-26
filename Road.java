import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Road here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Road extends World
{

    /**
     * Constructor for objects of class Road.
     * 
     */
    static int distance = 15;
    boolean isPlaying = false;
    long lastTime = -1;
    int bgmVolume = 50;
    GreenfootSound bgm = new GreenfootSound("bgm.mp3");
    public Road()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        setBackground("title.jpg");
        setPaintOrder(HealthBar.class, ContinueText.class, PassengerBar.class, Warning.class, Box.class, Car.class);
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("enter") && !isPlaying)
        {
            prepare();
            this.isPlaying = true;
            lastTime = -1;
            bgm.setVolume(bgmVolume);
            bgm.play();
            repaint();
        }
        if(isPlaying)
        {
            setBackground("background-free.jpg");
            genCar();
            gameOver();
        }
    }
    

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        int pos = 30;
        line line1 = new line();
        line1.setRotation(-90);
        addObject(line1,232,pos);
        line line2 = new line();
        line2.setRotation(-90);
        addObject(line2, 369, pos);
        pos+=66;
        line line3 = new line();
        line3.setRotation(-90);
        addObject(line3, 232, pos);
        line line4 = new line();
        line4.setRotation(-90);
        addObject(line4, 369, pos);
        pos+=66;
        line line5 = new line();
        line5.setRotation(-90);
        addObject(line5, 232, pos);
        line line6 = new line();
        line6.setRotation(-90);
        addObject(line6, 369, pos);
        pos+=66;
        line line7 = new line();
        line7.setRotation(-90);
        addObject(line7, 232, pos);
        line line8 = new line();
        line8.setRotation(-90);
        addObject(line8, 369, pos);
        pos+=66;
        line line9 = new line();
        line9.setRotation(-90);
        addObject(line9, 232, pos);
        line line10 = new line();
        line10.setRotation(-90);
        addObject(line10, 369, pos);
        pos+=66;
        line line11 = new line();
        line11.setRotation(-90);
        addObject(line11, 232, pos);
        line line12 = new line();
        line12.setRotation(-90);
        addObject(line12, 369, pos);
        
        tree tree = new tree();
        tree.setRotation(-90);
        addObject(tree,553,108);
        tree tree2 = new tree();
        tree2.setRotation(-90);
        addObject(tree2,553,299);
        tree tree3 = new tree();
        tree3.setRotation(-90);
        addObject(tree3,48,108);
        tree tree4 = new tree();
        tree4.setRotation(-90);
        addObject(tree4,48,299);
        BusStop bs = new BusStop();
        bs.setRotation(-90);
        addObject(bs, 46, 295);
        Block block = new Block();
        block.setRotation(-90);
        addObject(block, 160, 200);
        Bus bus = new Bus();
        addObject(bus,300,280);
        HealthBar healthbar = new HealthBar();
        addObject(healthbar,520,25);
        Passenger passenger = new Passenger();
        passenger.setRotation(-90);
        addObject(passenger,Greenfoot.getRandomNumber(90),Greenfoot.getRandomNumber(235));
        Passenger passenger2 = new Passenger();
        passenger2.setRotation(-90);
        addObject(passenger2,Greenfoot.getRandomNumber(90),Greenfoot.getRandomNumber(235));
        Passenger passenger3 = new Passenger();
        passenger3.setRotation(-90);
        addObject(passenger3,Greenfoot.getRandomNumber(90),Greenfoot.getRandomNumber(235));
        Passenger passenger4 = new Passenger();
        passenger4.setRotation(-90);
        addObject(passenger4,Greenfoot.getRandomNumber(90),Greenfoot.getRandomNumber(235));
        Box box = new Box();
        addObject(box,90,26);
        PassengerBar pb = new PassengerBar();
        addObject(pb, 50, 27);
        Warning wn = new Warning();
        addObject(wn, 300, 70);
    }
    public void genCar()
    {
        long time = System.currentTimeMillis();
        Block block = getObjects(Block.class).get(0);
        Bus bus = getObjects(Bus.class).get(0);
        if(time % 2 == 0 && getObjects(Car.class).isEmpty() && !block.display && !bus.isDead())
        {
            Car car = new Car();
            car.setRotation(-90);
            int lane = 0;
            int color = 0;
            do
            {
                lane = Greenfoot.getRandomNumber(3);
                color = Greenfoot.getRandomNumber(4);
            }while(lane == 0 || color == 0);
            car.setImage("car"+color+".png");
            if(lane == 1 && block.nWarp < 8)
            {
                addObject(car, 160, 0);
            }
            else if(lane == 2)
            {
                addObject(car, 300, 0);
            }
            else
            {
                addObject(car, 440, 0);
            }
        }
    }
    public void gameOver()
    {
        Bus bus = getObjects(Bus.class).get(0);
        if(bus.isDead())
        {
            bgm.stop();
            if(lastTime < 0)
                lastTime = System.currentTimeMillis();
            List objects = getObjects(null);
            if(objects != null && System.currentTimeMillis() - lastTime > 1000)
            {
                removeObjects(objects);
                setBackground("title.jpg");
                isPlaying = false;
            }
        }
    }
}
