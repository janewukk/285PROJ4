package view;


import resource.Sound;
import resource.StaticImageResource;
import model.*;
import net.ClientSocket;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.Simulator;
import resource.StaticImageResource;
import util.Location;
import util.Speed;

public class GamePanel extends JPanel implements KeyListener
{
  private boolean keyActivated = true;
  private int gameOverActivated = -1;
  BufferedImage currentBackGroundBufferedImage;
  Sound gameSound = new Sound();

  public GamePanel(BufferedImage bg)
  {
    currentBackGroundBufferedImage = bg;
    this.addListener();
    UserInfo.UserName = JOptionPane.showInputDialog(this,
        "Please enter Username");

    String loginPacket = null;
    try
    {
      loginPacket = "#0@00#1@" + UserInfo.UserName + "#2@"
          + InetAddress.getLocalHost().getHostAddress() + "#3@"
          + UserInfo.UserPoint + "#4@";
    }
    catch( UnknownHostException e )
    {
      e.printStackTrace();
    }

    ClientSocket.sendPacket(loginPacket);
  }

  @Override
  public void paint(Graphics g)
  {
    super.paint(g);
    g.drawImage(currentBackGroundBufferedImage, 0, 0, null);
    for( int i = 0; i < Simulator.getAllStuffs().size(); i++ )
    {
      Stuff buff = Simulator.getAllStuffs().get(i);
      if( buff.isValid() )
      {
        Simulator.getAllStuffs().get(i).paint(g);
      }
    }
    if( !UserInfo.isExist() )
    {
      g.drawImage(StaticImageResource.gameover, 80, 200, null);
      if( gameOverActivated == -1 )
        gameOverActivated = 1;
    }
    if( gameOverActivated == 1 )
    {
      gameSound.gameOverSound();
      gameOverActivated = 2;
    }


  }

  @Override
  public void keyTyped(KeyEvent e)
  {

  }

  @Override
  public void keyPressed(KeyEvent e)
  {
    if( getControlString(e.getKeyCode()) != null && keyActivated )
    {
      keyActivated = false;
      ClientSocket.sendPacket(getControlString(e.getKeyCode()));
    }
  }

  public String getControlString(int keyCode)
  {
    if( keyCode == KeyEvent.VK_UP )
    {
      UserInfo.UserPlane.setSpeed(new Speed(0, -10));
      return "#0@11#1@" + UserInfo.UserName + "#2@0#3@-10#4@";

    }
    if( keyCode == KeyEvent.VK_DOWN )
    {
      UserInfo.UserPlane.setSpeed(new Speed(0, 10));
      return "#0@11#1@" + UserInfo.UserName + "#2@0#3@10#4@";
    }
    if( keyCode == KeyEvent.VK_LEFT )
    {
      UserInfo.UserPlane.setSpeed(new Speed(-10, 0));
      return "#0@11#1@" + UserInfo.UserName + "#2@-10#3@0#4@";
    }
    if( keyCode == KeyEvent.VK_RIGHT )
    {
      UserInfo.UserPlane.setSpeed(new Speed(10, 0));
      return "#0@11#1@" + UserInfo.UserName + "#2@10#3@0#4@";
    }
    if( keyCode == KeyEvent.VK_SPACE )
    {
      gameSound.shootSound();
      return "#0@10#1@" + UserInfo.UserName + "#2@";
    }

    return null;
  }

  @Override
  public void keyReleased(KeyEvent e)
  {
    keyActivated = true;
    if( e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN
        || e.getKeyCode() == KeyEvent.VK_LEFT
        || e.getKeyCode() == KeyEvent.VK_RIGHT )
    {
      ClientSocket.sendPacket("#0@11#1@" + UserInfo.UserName + "#2@0#3@0#4@");
      UserInfo.UserPlane.setSpeed(new Speed(0, 0));
    }
  }

  protected void addListener()
  {
    this.addKeyListener(this);
  }

}
