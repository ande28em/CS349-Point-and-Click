package gui;

import java.awt.Color;

import javax.swing.JTextArea;

import observer.SceneObserver;
import scene.Scene;

/**
 * SceneVisual.java - Creates the visualization for scene options.
 * 
 * This work complies with the JMU Honor Code.
 * 
 * @author Joseph Hicks
 * @version Apr 16, 2023
 */
public class SceneVisual extends JTextArea implements SceneObserver
{
  public static final String NEWLINE = "\n";

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
    setBackground(new Color(0, 0, 0, 200));
    setForeground(Color.white);
    setEditable(false);
    setLineWrap(true);
    setWrapStyleWord(true);
    
  }

  @Override
  public void reset()
  {
    setText("");
  }

  @Override
  public void handleScene(final Scene s)
  {
    reset();
    append(s.getPrompt() + "\n\n");
    if (!s.isEnd()) {
      append("A. " + s.getOptionA() + NEWLINE);
      append("B. " + s.getOptionB() + NEWLINE);
      append("C. " + s.getOptionC() + NEWLINE);
      append("D. " + s.getOptionD() + NEWLINE);
    }
  }
  
}
