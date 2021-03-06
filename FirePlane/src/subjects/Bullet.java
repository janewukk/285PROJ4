package subjects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import util.Location;
import util.Speed;

public abstract class Bullet extends Stuff
{
  private int power = 1;
  public Bullet(Location _loc, Speed _speed)
  {
    super(_loc, _speed);
    ID = nextID;
    ++nextID;
  }
  
  
  public abstract void paint(Graphics g);
  public abstract BufferedImage getImage();
  
  public void move(){
    int nextX = (int)(this.getLocation().getX() + this.getSpeed().getXSpeed());
    int nextY = (int)(this.getLocation().getY() + this.getSpeed().getYSpeed());
    if (nextX > 0 && nextX < 550 && nextY >0 && nextY < 700)
    {
      this.setLocation(nextX, nextY);
    }
    else
    {
      Stuff.delelteBullet(this);
    }
  }
  
  public Rectangle getBounds()
  {
    return new Rectangle((int)getLocation().getX(), (int)getLocation().getY(), getImage().getWidth(), getImage().getHeight());
  }
  
  public void setPower(int _power)
  {
    power = _power;
  }


  public int getPower()
  {
    // TODO Auto-generated method stub
    return power;
  }
  
}
