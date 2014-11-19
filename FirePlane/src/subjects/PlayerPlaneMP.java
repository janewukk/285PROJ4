package subjects;

import java.awt.image.BufferedImage;
import java.net.InetAddress;

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
  
  public PlayerPlaneMP(double x, double y,  Speed _speed,
      BufferedImage _planeImage, String _username, InetAddress _ipAddress, int _port)
  {
    super(x, y, _speed, _planeImage, _username);
    this.ipAddress = _ipAddress;
    this.port = _port;
    // TODO Auto-generated constructor stub
  }
  
  public void move()
  {
    super.move();
  }

}
