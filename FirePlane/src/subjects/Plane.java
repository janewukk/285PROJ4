package subjects;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import util.Location;
import util.Speed;
import interfaces.Movable;

public abstract class Plane
{
  private boolean isAlive;
  private Speed speed;
  private Location location;
  
  public Plane(Location loc)
  {
    location = loc;
    speed = new Speed(0, 0);
    isAlive = true;
  }

  
  
  //this is very important, we have to have a function to paint them
  
  public abstract void paint(Graphics g);
  
  synchronized public void move()
  {
    getLocation().setX(getLocation().getX() + getSpeed().getXSpeed());
    getLocation().setY(getLocation().getY() + getSpeed().getYSpeed());
  }

  
  synchronized public void setLocation(double x, double y)
  {
    getLocation().setX(x);
    getLocation().setY(y);
  }
  
  
  public Location getLocation()
  {
    return location;
  }
  
  
  public Speed getSpeed()
  {
    return speed;
  }
  
  
  synchronized public void setSpeed(double speedX, double speedY)
  {
    speed.setXSpeed(speedX);
    speed.setYSpeed(speedY);
  }


  public BufferedImage getImage()
  {
    // TODO Auto-generated method stub
    return null;
  }
  
  public boolean isAlive()
  {
    return isAlive;
  }
  
  public void setAlive(boolean stillAlive)
  {
    isAlive = stillAlive;
  }
  
  public void explode()
  {
    setAlive(false);
  }
  
}
