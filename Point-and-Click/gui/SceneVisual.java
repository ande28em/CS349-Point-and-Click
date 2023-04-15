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
    setText("");
  }

  @Override
  public void handleScene(Scene s)
  {
    reset();
    append(s.getPrompt() + "\n\n");
    append("A:" + s.getOptionA() + "\n");
    append("B:" + s.getOptionB() + "\n");
    append("C:" + s.getOptionC() + "\n");
    append("D:" + s.getOptionD() + "\n");
  }
  
}
