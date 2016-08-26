import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class HealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBar extends Actor
{
    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int health = 40;
    int healthBarWidth = 120;
    int healthBarHeight = 15;
    int pixelsPerHealthPoint = (int)healthBarWidth/health;
    long lastTime = System.currentTimeMillis();
    public HealthBar()
    {
        update();
    }
    public void act() 
    {
        update();
        if(System.currentTimeMillis() - lastTime >= 1500)
        {
            health -= 1;
            lastTime = System.currentTimeMillis();
        }
    }    
    public void update()
    {
        setImage(new GreenfootImage(healthBarWidth + 2, healthBarHeight + 2));
        GreenfootImage myImage = getImage();
        myImage.setColor(Color.WHITE);
        myImage.drawRect(0, 0, healthBarWidth + 1, healthBarHeight + 1);
        myImage.setColor(Color.RED);
        myImage.fillRect(1, 1, health*pixelsPerHealthPoint, healthBarHeight);
    }
}
