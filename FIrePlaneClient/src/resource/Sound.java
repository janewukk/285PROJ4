package resource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound
{
  File shootAudioFile;
  File gameOverSoundFile;
  public Sound()
  {
    shootAudioFile = new File("sound/shipfire.wav");
    gameOverSoundFile = new File("sound/YOU DIE.wav");
    
  }
  
  public void shootSound()
  {
    try
    {
      AudioInputStream shootAudioInputStream = AudioSystem.getAudioInputStream(shootAudioFile);
      
      AudioFormat shootFormat = shootAudioInputStream.getFormat();
      
      DataLine.Info shootInfo = new DataLine.Info(Clip.class, shootFormat);
      
      Clip shootClip = (Clip) AudioSystem.getLine(shootInfo);
      shootClip.open(shootAudioInputStream);
      shootClip.start();
      //shootClip.close();
      //shootAudioInputStream.close();
    }
    catch( LineUnavailableException e )
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    catch( IOException e )
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    catch( UnsupportedAudioFileException e )
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
  }
  
  public void gameOverSound()
  {
    try
    {
      AudioInputStream youDieStream = AudioSystem.getAudioInputStream(gameOverSoundFile);
      
      AudioFormat youdieFormat = youDieStream.getFormat();
      
      DataLine.Info youDieInfo = new DataLine.Info(Clip.class, youdieFormat);
      
      Clip youDieClip = (Clip) AudioSystem.getLine(youDieInfo);
      youDieClip.open(youDieStream);
      youDieClip.start();
      //shootClip.close();
      //shootAudioInputStream.close();
    }
    catch( LineUnavailableException e )
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    catch( IOException e )
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    catch( UnsupportedAudioFileException e )
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
