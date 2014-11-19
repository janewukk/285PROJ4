package net;

public class Packet99Move extends Packet
{
  private String username;
  private int x, y;
  private int speedX, speedY;
  public Packet99Move(byte[] data)
  {
    super(99);
    String[] dataArray = readData(data).split("#");
    this.username = dataArray[0];
    this.x = Integer.parseInt(dataArray[1]);
    this.y = Integer.parseInt(dataArray[2]);
    this.speedX = Integer.parseInt(dataArray[3]);
    this.speedY = Integer.parseInt(dataArray[4]);
    // TODO Auto-generated constructor stub
  }
  
  public Packet99Move(String username, int _x, int _y, int _speedX, int _speedY)
  {
    super(99);
    this.x = _x;
    this.y = _y;
    this.speedX = _speedX;
    this.speedY = _speedY;
    this.username = username;
    // TODO Auto-generated constructor stub
  }

  @Override
  public void writeData(Client client)
  {
    // TODO Auto-generated method stub
    System.out.println(this.x + "," + this.y);
    client.sendData(getData());
    System.out.println("send from client");
  }

  @Override
  public void writeData(Server server)
  {
    // TODO Auto-generated method stub
    server.sendDataToAllClients(getData());
  }

  @Override
  public byte[] getData()
  {
    // TODO Auto-generated method stub
    return ("99"+ this.username + "#" + this.x + "#" + this.y + "#" 
    + this.speedX + "#" + this.speedY).getBytes();
  }

  public String getUserName()
  {
    // TODO Auto-generated method stub
    return username;
  }
  
  public int getX()
  {
    return this.x;
  }
  
  public int getY()
  {
    return this.y;
  }
  
  public int getSpeedX()
  {
    return this.speedX;
  }
  
  public int getSpeedY()
  {
    return this.speedY;
  }
}
