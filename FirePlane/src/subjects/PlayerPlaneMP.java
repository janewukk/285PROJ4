package subjects;

import java.awt.image.BufferedImage;
import java.net.InetAddress;

import resource.StaticImageResource;
import net.Client;
import net.Packet;
import net.Packet99Move;
import ui.GamePanel;
import util.Location;
import util.Speed;

public class PlayerPlaneMP extends PlayerPlane
{
  public InetAddress ipAddress;
  public int port;
  private BufferedImage image;
  private int counter = 0;
  
  public PlayerPlaneMP(Location _loc,  Speed _speed, String _username, InetAddress _ipAddress, int _port)
  {
    super(_loc, _speed, _username);
    this.ipAddress = _ipAddress;
    this.port = _port;
    this.image = StaticImageResource.playerPlanes[0];
    // TODO Auto-generated constructor stub
  }
  
  public void move()
  {
    if (isAlive())
    {
      super.move();
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
        Stuff.deleteStuff(this);
      }
    }
  }
  
  @Override
  public BufferedImage getImage()
  {
    // TODO Auto-generated method stub
    return image;
  }
  
  public void explode()
  {
    setAlive(false);
  }
 
}
