import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitlePage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitlePage extends Actor
{
    /**
     * Act - do whatever the TitlePage wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.isKeyDown("enter"))
        {
            setImage("blank.png");
        }
        else if(Greenfoot.isKeyDown("escape"))
        {
            setImage("title.jpg");
        }
    }    
}
