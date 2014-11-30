package subjects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import resource.StaticImageResource;
import util.Location;
import util.Speed;

public class PlayerPlane extends Plane
{
  String username;
  private BufferedImage image;
  private int counter = 0;
  public PlayerPlane(Location _loc, Speed _speed, String _username)
  {
    super(_loc);
    this.username = _username;
    this.image = StaticImageResource.playerPlanes[0];
    // TODO Auto-generated constructor stub
  }
  
  public String getUserName()
  {
    return this.username;
  }
  
  @Override
  public void paint(Graphics g)
  {
    // TODO Auto-generated method stub
    g.drawImage(getImage(), (int)getLocation().getX(), (int)getLocation().getY(), null);
    g.drawString(username, (int)getLocation().getX(), (int)getLocation().getY());
  }

  @Override
  public BufferedImage getImage()
  {
    // TODO Auto-generated method stub
    return image;
  }
  
  public Bullet shoot()
  {
    if(isAlive())
    {
      BlueSmallBullet bullet = new BlueSmallBullet(this);
      Stuff.addBullet(bullet);
      bullet.move();
      return bullet;
    }
    else
      return null;
  }
  
  public void move()
  {
    if (isAlive())
    {
      double nextX = getLocation().getX() + getSpeed().getXSpeed();
      double nextY = getLocation().getY() + getSpeed().getYSpeed();
      if (nextX > 0 && nextX < 500 && nextY > 0 && nextY < 650)
      {
        getLocation().setX(getLocation().getX() + getSpeed().getXSpeed());
        getLocation().setY(getLocation().getY() + getSpeed().getYSpeed());
      }
    }
    else
    {
      if (counter < 16)
      {
        image = StaticImageResource.explosionImages[counter];
        counter++;
      }
      else
      {
        image = null;
        //Stuff.deleteStuff(this);
      }
    }
  }
  
  public void explode()
  {
    setAlive(false);
  }
}
