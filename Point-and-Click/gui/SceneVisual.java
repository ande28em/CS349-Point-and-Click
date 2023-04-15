package gui;

import java.awt.Color;

import javax.swing.JTextArea;

import scene.Scene;

public class SceneVisual extends JTextArea implements SceneObserver
{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  /**
   * Default constructor for WeatherBoard object.
   *
   */
  public SceneVisual()
  {
    super();
    setBackground(new Color(0, 0, 0, 210));
    setEditable(false);
  }

  @Override
  public void reset()
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void handleScene(Scene s)
  {
    // TODO Auto-generated method stub
    
  }
  
}
