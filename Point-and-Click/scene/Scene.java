package scene;

import java.awt.image.BufferedImage;

/**
 * Scene.java - scene object to encapsulate information needed for each story scene/slide.
 * 
 * This work complies with the JMU Honor Code.
 * 
 * @author Eric Anderson
 * @version Apr 12, 2023
 */
public class Scene
{
  private String sceneName;
  private String prompt;
  private String optionA;
  private String optionB;
  private String optionC;
  private String optionD;
  private BufferedImage image;

  /**
   * Default constructor.
   */
  public Scene()
  {
    this.sceneName = null;
    this.prompt = null;
    this.optionA = null;
    this.optionB = null;
    this.optionC = null;
    this.optionD = null;
    this.image = null;
  }

  /**
   * Explicit constructor.
   * 
   * @param sceneName
   *          - name of the scene to be used for future recall. (1-2 word description)
   * @param prompt
   *          - prompt for the user to make a choice.
   * @param optionA
   *          - First option for the user to select.
   * @param optionB
   *          - Second option for the user to select.
   * @param optionC
   *          - Third option for the user to select.
   * @param optionD
   *          - Fourth option for the user to select.
   * @param image
   *          - the image to display for the scene.
   */
  public Scene(final String sceneName, final String prompt, final String optionA,
      final String optionB, final String optionC, final String optionD, final BufferedImage image)
  {
    this.sceneName = sceneName;
    this.prompt = prompt;
    this.optionA = optionA;
    this.optionB = optionB;
    this.optionC = optionC;
    this.optionD = optionD;
    this.image = image;
  }

  /**
   * @return the sceneName
   */
  public String getSceneName()
  {
    return sceneName;
  }

  /**
   * @return the prompt
   */
  public String getPrompt()
  {
    return prompt;
  }

  /**
   * @return the optionA
   */
  public String getOptionA()
  {
    return optionA;
  }

  /**
   * @return the optionB
   */
  public String getOptionB()
  {
    return optionB;
  }

  /**
   * @return the optionC
   */
  public String getOptionC()
  {
    return optionC;
  }

  /**
   * @return the optionD
   */
  public String getOptionD()
  {
    return optionD;
  }

  /**
   * @return the image
   */
  public BufferedImage getImage()
  {
    return image;
  }

  /**
   * @param sceneName
   *          the sceneName to set
   */
  public void setSceneName(final String sceneName)
  {
    this.sceneName = sceneName;
  }

  /**
   * @param prompt
   *          the prompt to set
   */
  public void setPrompt(final String prompt)
  {
    this.prompt = prompt;
  }

  /**
   * @param optionA
   *          the optionA to set
   */
  public void setOptionA(final String optionA)
  {
    this.optionA = optionA;
  }

  /**
   * @param optionB
   *          the optionB to set
   */
  public void setOptionB(final String optionB)
  {
    this.optionB = optionB;
  }

  /**
   * @param optionC
   *          the optionC to set
   */
  public void setOptionC(final String optionC)
  {
    this.optionC = optionC;
  }

  /**
   * @param optionD
   *          the optionD to set
   */
  public void setOptionD(final String optionD)
  {
    this.optionD = optionD;
  }

  /**
   * @param image
   *          the image to set
   */
  public void setImage(final BufferedImage image)
  {
    this.image = image;
  }

}
