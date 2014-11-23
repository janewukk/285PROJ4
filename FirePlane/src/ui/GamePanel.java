package ui;


import resource.StaticImageResource;
import subjects.*;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import net.Client;
import net.Packet00Login;
import net.Packet10Shoot;
import net.Packet99Move;
import net.Server;
import net.Settings;
import resource.StaticImageResource;
import subjects.PlayerPlane;
import subjects.PlayerPlaneMP;
import subjects.Stuff;
import util.Location;
import util.Speed;

public class GamePanel extends JPanel implements KeyListener, Runnable
{ 
  private static PlayerPlane myPlayer;
  //myPlayer is whom on the 
  private Speed initialSpeed = new Speed(0.0, 0.0);
  private static Server gameServer;
  private static Client gameClient;
  
  
  BufferedImage currentBackGroundBufferedImage;
  public GamePanel(BufferedImage bg)
  {
    //players = new ArrayList<PlayerPlane>();
    try
    {
      if (JOptionPane.showConfirmDialog(this, "Do you want to run the server") == 0) {
        gameServer = new Server();
        gameServer.start();
        gameServer.setPriority(4);
      }
      gameClient = new Client("localhost");
      gameClient.start();
      gameClient.setPriority(4);
      myPlayer 
      = new PlayerPlaneMP(new Location(100.0, 100.0), new Speed(0, 0),
          JOptionPane.showInputDialog(this, "Please enter"), null, -1);
      Stuff.getAllStuffs().add(myPlayer);
      Packet00Login loginPacket = new Packet00Login(myPlayer.getUserName());
      if(gameServer != null)
      {
        gameServer.addConnection((PlayerPlaneMP)myPlayer, loginPacket);
      }
      loginPacket.writeData(gameClient);
    }
    catch( IOException e )
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
      System.exit(7);
    }
    currentBackGroundBufferedImage = bg;
    new Thread(this).start();
    //add listener to panel
    this.addListener();
    
    
    // TODO Auto-generated constructor stub
  }
  
  public void update()
  {
    //TODO this function is to update every single elements in the game. 
    //Everything will be on this game Panel 
    /*for(PlayerPlane p : players)
    {
      p.move();;
    }*/
    
    for (int i = 0; i < Stuff.getAllStuffs().size(); i++)
    {
      Stuff.getAllStuffs().get(i).move();;
    }
    //`System.out.println("##########");
  }
  
  @Override
  public void paint(Graphics g)
  {
    super.paint(g);
    g.drawImage(currentBackGroundBufferedImage, 0, 0, null);
    /*for(PlayerPlane p : players)
    {
      p.paintPlane(g);
    }*/
    for (int i = 0; i < Stuff.getAllStuffs().size(); i++)
    {
      Stuff.getAllStuffs().get(i).paint(g);
    }
    
  }
  
  @Override
  public void keyTyped(KeyEvent e)
  {
    // TODO Auto-generated method stub
    
    
  }

  @Override
  public void keyPressed(KeyEvent e)
  {
    // TODO Auto-generated method stub
    if(myPlayer != null)
    {
      switch(e.getKeyCode())
      {
        case KeyEvent.VK_UP:
          //Sound sound = new Sound("Startup1.wav");
          myPlayer.setSpeed(0.0, -10.0);
          break;
        case KeyEvent.VK_DOWN:
          myPlayer.setSpeed(0.0, 10.0);
          break;
        case KeyEvent.VK_LEFT:
          myPlayer.setSpeed(-10.0, 0.0);
          break;
        case KeyEvent.VK_RIGHT:
          myPlayer.setSpeed(10.0, 0.0);
          break;
        case KeyEvent.VK_SPACE:
          Bullet bullet = myPlayer.shoot();
          if(bullet != null)
          {
            Packet10Shoot packet = new Packet10Shoot(myPlayer.getUserName());
            packet.writeData(gameClient);
          } 
          break;
        case KeyEvent.VK_E:
          myPlayer.explode();
          break;
          
      }
      Packet99Move packet = new Packet99Move(
          myPlayer.getUserName(),
          (int)myPlayer.getLocation().getX(),
          (int)myPlayer.getLocation().getY(), 
          (int)myPlayer.getSpeed().getXSpeed(), 
          (int)myPlayer.getSpeed().getYSpeed());
      
      System.out.println((int)myPlayer.getLocation().getX() 
          + "," + (int)myPlayer.getLocation().getY());
      packet.writeData(gameClient);
    }
    
  }

  @Override
  public void keyReleased(KeyEvent e)
  {
    // TODO Auto-generated method stub
      if(myPlayer != null)
      {
        myPlayer.setSpeed(0.0, 0.0);
        Packet99Move packet = new Packet99Move(
            myPlayer.getUserName(),
            (int)myPlayer.getLocation().getX(),
            (int)myPlayer.getLocation().getY(), 
            (int)myPlayer.getSpeed().getXSpeed(), 
            (int)myPlayer.getSpeed().getYSpeed());
        packet.writeData(gameClient);
        
      }
        
    
  }
  
  @Override
  public void run()
  {
    
    while(true)
    {
      this.update();
      this.repaint();
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }

  }

  protected void addListener()
  {
    this.addKeyListener(this);
  }
  
  /*public static void addPlane(PlayerPlane addedPlane)
  {
    players.add(addedPlane);
  }*/
  
  public static void setMyPlayer(PlayerPlaneMP _myPlayer)
  {
    myPlayer = _myPlayer;
  }
  
  
  
}
