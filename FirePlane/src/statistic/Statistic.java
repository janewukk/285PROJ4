package statistic;

import java.awt.Graphics;

import ui.GameFrame;

public class Statistic
{
  private static int score = 0;
  
  
  public static void paint(Graphics g)
  {
    g.drawString("Score: " + Integer.toString(score), GameFrame.WINDOWS_WIDTH - 100, 20);
  }
  
  public static void setScore(int _newScore)
  {
    score = _newScore;
  }
  
  public static int getScore()
  {
    return score;
  }
}
