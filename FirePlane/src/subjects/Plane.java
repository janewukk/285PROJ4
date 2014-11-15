package subjects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import util.Location;
import util.Speed;
import interfaces.Movable;

public class Plane implements Movable
{
  private Location planeLocation;
  private Speed planeSpeed;
  private boolean isAlive;
  BufferedImage planeImage;
  
  public Plane(Location startLocation, Speed _speed, BufferedImage _planeImage)
  {
    planeSpeed = _speed;
    planeLocation = startLocation;
    isAlive = true;
    planeImage = _planeImage;
  }
  
  //this is very important, we have to have a function to paint them
  
  public void paintPlane(Graphics g)
  {
    // TODO draw the plane
    g.drawImage(planeImage, (int)planeLocation.getX(), (int)planeLocation.getY(), null);
  }
  
  @Override
  public void move()
  {
    planeLocation.setX(planeLocation.getX() + planeSpeed.getXSpeed());
    planeLocation.setY(planeLocation.getY() + planeSpeed.getYSpeed());
  }

  @Override
  public void moveLeft()
  {
    // TODO Auto-generated method stub
    //planeLocation.setX(planeLocation.getX() - speed);
  }

  @Override
  public void moveRight()
  {
    // TODO Auto-generated method stub
    //planeLocation.setX(planeLocation.getX() + speed);
  }

  @Override
  public void moveUp()
  {
    // TODO Auto-generated method stub
    //planeLocation.setY(planeLocation.getY() - speed);
  }

  @Override
  public void moveDown()
  {
    // TODO Auto-generated method stub
    //planeLocation.setY(planeLocation.getY() + speed);
  }

  
  public void setSpeed(Speed _speed)
  {
    planeSpeed = _speed;
  }
  
  public Speed getSpeed()
  {
    return planeSpeed;
  }
  
  public Speed isAlive()
  {
    return planeSpeed;
  }
  
  
  
}
