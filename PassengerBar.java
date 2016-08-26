import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class PassengerBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PassengerBar extends Actor
{
    /**
     * Act - do whatever the PassengerBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int passenger = 0;
    int barWidth = 200;
    int barHeight = 50;
    public PassengerBar()
    {
        update();
    }
    public void act() 
    {
        update();
    }    
    public void update()
    {
        GreenfootImage img = new GreenfootImage(barWidth, barHeight);
        img.setColor(Color.WHITE);
        img.setFont(new Font("TimesRoman", Font.PLAIN, 18));
        img.setColor(Color.WHITE);
        img.drawString("Passenger: "+passenger, 80, 30);
        setImage(img);
    }
}
