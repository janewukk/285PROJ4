package subjects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import util.Location;
import util.Speed;

public class PlayerPlane extends Plane
{
  String username;
  public PlayerPlane(double x, double y, Speed _speed, BufferedImage _planeImage, String _username)
  {
    super(x, y, _planeImage);
    this.username = _username;
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
    super.paint(g);
    g.drawString(username, (int)getLocation().getX(), (int)getLocation().getY());
  }
}
