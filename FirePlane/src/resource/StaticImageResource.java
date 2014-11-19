package resource;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class StaticImageResource
{
  //here we save different images into public static BufferedImage
  final static int myPlaneTypeNum = 2, backGroundTypeNum = 1;
  public static BufferedImage[] backgroudImages = new BufferedImage[backGroundTypeNum];
  public static BufferedImage[] playerPlanes = new BufferedImage[myPlaneTypeNum];
  
  public static void initializeImages()
  {
    for(int i = 0; i < backgroudImages.length; i++)
    {
      try
      {
        backgroudImages[i] = ImageIO.read(new FileInputStream("imgs/bg" + i + ".jpg"));
      }
      catch( IOException e )
      {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    
    for(int i = 0; i < playerPlanes.length; i++)
    {
      try
      {
        playerPlanes[i] = ImageIO.read(new FileInputStream("imgs/plane/plane" + i + ".gif"));
      }
      catch( IOException e )
      {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }
}