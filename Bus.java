import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bus extends Actor
{
    /**
     * Act - do whatever the Bus wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootSound bombSound = new GreenfootSound("bomb.mp3");
    public void act() 
    {
        if(!isOnBlock() && !isDead())
        {
            drive();
            hit();
        }
        else if(isDead())
        {
            setImage("explosion.png");
            bombSound.setVolume(40);
            bombSound.play();
        }
    }  
    public void drive()
    {
        if(Greenfoot.isKeyDown("left"))
            move(-2);
        if(Greenfoot.isKeyDown("right"))
            move(2);
    }
    public void hit()
    {
        tree myTree = (tree) getOneObjectAtOffset(0,0,tree.class);
        GreenfootSound hitTree = new GreenfootSound("hit_tree.mp3");
        if(myTree != null && myTree.image == "tree.png")
        {
            hitTree.setVolume(30);
            hitTree.play();
            myTree.setImage("blank.png");
            World world = getWorld();
            HealthBar bar = world.getObjects(HealthBar.class).get(0);
            bar.health -= 5;
        }
    }
    public boolean isOnBlock()
    {
        World world = getWorld();
        Block block = (Block) getOneObjectAtOffset(0, 70, Block.class);
        return ((block != null) && block.display);
    }
    public boolean isDead()
    {
        World world = getWorld();
        HealthBar bar = world.getObjects(HealthBar.class).get(0);
        return (bar.health < 1);
    }
}
