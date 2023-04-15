package gui;

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
  * Add the given WeatherDatum to the collection if it is non-null.
  *
  * @param datum the datum to add to the collection.
  */
  public void handleScene(final Scene s);
}
