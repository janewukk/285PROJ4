package subjects;

import interfaces.Movable;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import util.Location;
import util.Speed;

public abstract class Stuff implements Movable
{
  private Location location;
  private Speed speed;
  BufferedImage stuffImage;
  private static ArrayList<Stuff> allStuffs = new ArrayList<Stuff>();
  public Stuff()
  {
    
  }
  public Stuff(Location l, Speed s, BufferedImage img)
  {
    location = l;
    speed = s;
    stuffImage = img;
  }
  
  public void addStuff(Stuff s)
  {
    getAllStuffs().add(s);
  }
  
  public abstract void paint(Graphics g);
  
  public Location getLocation()
  {
    return location;
  }
  
  public void setLocation(Location l)
  {
    location = l;
  }
  
  public Speed getSpeed()
  {
    return speed;
  }
  
  public void setSpeed(Speed s)
  {
    speed = s;
  }
  
  public static ArrayList<Stuff> getAllStuffs()
  {
    return allStuffs;
  }
  public static void setAllStuffs(ArrayList<Stuff> allStuffs)
  {
    Stuff.allStuffs = allStuffs;
  }
  @Override
  public void move()
  {
    // TODO Auto-generated method stub
    
  }
  @Override
  public void moveLeft()
  {
    // TODO Auto-generated method stub
    
  }
  @Override
  public void moveRight()
  {
    // TODO Auto-generated method stub
    
  }
  @Override
  public void moveUp()
  {
    // TODO Auto-generated method stub
    
  }
  @Override
  public void moveDown()
  {
    // TODO Auto-generated method stub
    
  }
  
  public BufferedImage getImage()
  {
    return stuffImage;
  }

  
}
