package observer;

import scene.Scene;

/**
* SceneObserver interface.
*
* @author  Joseph Hicks
* @version 1.0
* @since   1/31/2023 
*/
public interface SceneObserver
{
  /**
  * Remove all elements from the collection.
  *
  */
  public void reset();
  
  /**
  * Handler for scene. 
  *
  * @param s - the scene to handle. 
  */
  public void handleScene(final Scene s);
}
