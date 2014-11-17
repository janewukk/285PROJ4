package net;

public class Packet99Move extends Packet
{
  private String username;
  public Packet99Move(byte[] data)
  {
    super(99);
    this.username = readData(data);
    // TODO Auto-generated constructor stub
  }
  
  public Packet99Move(String username)
  {
    super(99);
    this.username = username;
    // TODO Auto-generated constructor stub
  }

  @Override
  public void writeData(Client client)
  {
    // TODO Auto-generated method stub
    client.sendData(getData());
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
    return ("00" + this.username).getBytes();
  }

  public String getUserName()
  {
    // TODO Auto-generated method stub
    return username;
  }
  
}
