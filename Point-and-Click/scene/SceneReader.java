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
  private static final String A = "A";
  private static final String B = "B";
  private static final String C = "C";
  private static final String D = "D";
  private Map<String, Scene> scenes;
  private Map<Scene, String[]> nextScenes;
  private BufferedReader reader;
  private ResourceFinder finder;

  /**
   * Read in a Scene file from the resources folder and populate a map.
   */
  public SceneReader()
  {
    scenes = new HashMap<String, Scene>();
    nextScenes = new HashMap<Scene, String[]>();

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
          String[] futureScenes = new String[4];

          curr.setSceneName(line);
          curr.setPrompt(reader.readLine());

          // A
          curr.setOptionA(reader.readLine());
          futureScenes[0] = reader.readLine();

          // B
          curr.setOptionB(reader.readLine());
          futureScenes[1] = reader.readLine();

          // C
          curr.setOptionC(reader.readLine());
          futureScenes[2] = reader.readLine();

          // D
          curr.setOptionD(reader.readLine());
          futureScenes[3] = reader.readLine();
          
          String isEnd = reader.readLine();
          if (isEnd.equals("False")) {
            curr.setEnd(false);
          } else {
            curr.setEnd(true);
          }
          
          curr.setImage(parseSceneImage(reader.readLine()));
          putScene(curr);
          nextScenes.put(curr, futureScenes);

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

  /**
   * Get the next scene based off of the user selection on the current scene.
   * 
   * @param curr
   *          - current scene.
   * @param choice
   *          - the letter of the option selected.
   * @return the next scene based off the selected option.
   */
  public Scene getNextScene(final Scene curr, final String choice)
  {
    Scene result = null;
    switch (choice)
    {
      case A:
        result = scenes.get(nextScenes.get(curr)[0]);
        break;
      case B:
        result = scenes.get(nextScenes.get(curr)[1]);
        break;
      case C:
        result = scenes.get(nextScenes.get(curr)[2]);
        break;
      case D:
        result = scenes.get(nextScenes.get(curr)[3]);
        break;
      default:
        result = null;
        break;
    }
    return result;
  }

}
