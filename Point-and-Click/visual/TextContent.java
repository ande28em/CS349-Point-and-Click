package visual;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import visual.statik.AbstractTransformableContent;

/**
* TextContent.
*
* @author  Joseph Hicks
* @version 1.0
* @since   2/12/2023 
*/

public class TextContent extends AbstractTransformableContent
{
  private String text;
  private Rectangle2D original;
  private int x;
  private int y;
  
  /**
   * Value constructor for textContent.
   *
   *@param text of content.
   *@param original size of content.
   *@param x value.
   *@param y value.
   */
  public TextContent(final String text, final Rectangle2D original, final int x, final int y)
  {
    super();
    this.text = text;
    this.original = original;
    this.x = x;
    this.y = y;
  }
  
  
  @Override
  public void render(final Graphics arg0)
  {
    // TODO Auto-generated method stub
    Font font = new Font(Font.SANS_SERIF, Font.PLAIN,20);
    Graphics2D g2;
    // Cast the rendering engine appropriately
    g2 = (Graphics2D)arg0;
    g2.setFont(font);
    
    g2.setColor(new Color(0, 0, 0, 190));
    g2.fill(this.original);
    g2.draw(this.original);
    g2.setColor(Color.WHITE);
    g2.drawString(this.text, x, y);
  }


  @Override
  public Rectangle2D getBounds2D(final boolean arg0)
  {
    // TODO Auto-generated method stub
    if (arg0)
    {
      return super.getBounds2D();
    }
    return this.original;
  }

}
