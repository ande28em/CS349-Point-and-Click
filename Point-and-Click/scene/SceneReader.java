package scene;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import io.ResourceFinder;
import resources.Marker;

/**
 * SceneReader.java - Reads in the required scene information from a .txt file and populate scene
 * objects. These scenes can be accessed through the Map by using the "SceneName" key.
 * 
 * This work complies with the JMU Honor Code.
 * 
 * @author Eric Anderson
 * @version Apr 12, 2023
 */
public class SceneReader
{
  private static final String FILENAME = "scene_content.txt";
  private static final String FAILREAD = "Failed to read ";
  private static final String PERIOD = ".";
  private Map<String, Scene> scenes;
  private BufferedReader reader;
  private ResourceFinder finder;

  /**
   * Read in a Scene file from the resources folder and populate a map.
   */
  public SceneReader()
  {
    scenes = new HashMap<String, Scene>();

    // Read in FILENAME
    finder = ResourceFinder.createInstance(new Marker());
    InputStream is = finder.findInputStream(FILENAME);
    reader = new BufferedReader(new InputStreamReader(is));

    String line;
    try
    {
      while ((line = reader.readLine()) != null)
      {
        Scene curr = new Scene();
        if (!line.isBlank()) // Another scene to be read
        {
          curr.setSceneName(line);
          curr.setPrompt(reader.readLine());
          curr.setOptionA(reader.readLine());
          curr.setOptionB(reader.readLine());
          curr.setOptionC(reader.readLine());
          curr.setOptionD(reader.readLine());
          curr.setImage(parseSceneImage(reader.readLine()));
          putScene(curr);
        }
      }

    }
    catch (IOException e)
    {
      JOptionPane.showMessageDialog(null, FAILREAD + FILENAME + PERIOD, FAILREAD + " File",
          JOptionPane.ERROR_MESSAGE);
    }

  }

  /**
   * Parse an image name from the scene file and return the BufferedImage.
   * 
   * @param imageName
   *          - name of the scene image file.
   * @return the corresponding BufferedImage.
   */
  private BufferedImage parseSceneImage(final String imageName)
  {
    BufferedImage bufferedImage = null;
    if (imageName != null)
    {
      InputStream is = finder.findInputStream(imageName);
      try
      {
        bufferedImage = ImageIO.read(is);
      }
      catch (IOException e)
      {
        JOptionPane.showMessageDialog(null, FAILREAD + imageName + PERIOD, FAILREAD + "Image",
            JOptionPane.ERROR_MESSAGE);
      }
    }
    return bufferedImage;
  }

  /**
   * Get all scenes.
   * 
   * @return the scene map.
   */
  public Map<String, Scene> getAllScenes()
  {
    return scenes;
  }

  /**
   * Get the scene corresponding to a given scene name.
   * 
   * @param sceneName
   *          - the name of the scene to fetch.
   * @return the scene or null.
   */
  public Scene getScene(final String sceneName)
  {
    return scenes.get(sceneName);
  }

  /**
   * Add a given scene to the scenes map.
   * 
   * @param scene
   *          - the scene to add.
   */
  public void putScene(final Scene scene)
  {
    if (scene != null)
    {
      scenes.put(scene.getSceneName(), scene);
    }
  }

}
