package audio;

import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

import io.ResourceFinder;
import resources.Marker;

/**
 * Soundtrack.java - Class to play background audio.
 * 
 * This work complies with the JMU Honor Code.
 * 
 * @author Eric Anderson
 * @version Apr 30, 2023
 */
public class Soundtrack
{
  private ResourceFinder rf;
  private InputStream is;

  private Clip clip;

  /**
   * Default constructor.
   * 
   * @param filename
   *          - file to read in.
   */
  public Soundtrack(final String filename)
  {
    rf = ResourceFinder.createInstance(new Marker());
    is = rf.findInputStream(filename);
  }

  /**
   * Initialize and start clip on repeat.
   */
  public void init()
  {
    AudioInputStream stream;
    try
    {
      stream = AudioSystem.getAudioInputStream(is);

      AudioFormat format = stream.getFormat();

      DataLine.Info info = new DataLine.Info(Clip.class, format);
      clip = (Clip) AudioSystem.getLine(info);
      clip.open(stream);
    }
    catch (IOException e)
    {
      JOptionPane.showMessageDialog(null, "Exception when loading audio.", "Audio IOException",
          JOptionPane.ERROR_MESSAGE);
    }
    catch (LineUnavailableException e)
    {
      JOptionPane.showMessageDialog(null, "Line unavailable when loading audio.", "LineUnavailable",
          JOptionPane.ERROR_MESSAGE);
    }
    catch (UnsupportedAudioFileException e1)
    {
      JOptionPane.showMessageDialog(null, "The given audio file is not supported.",
          "Unsupported File Format", JOptionPane.ERROR_MESSAGE);
    }
    clip.start();
    this.clip.loop(Clip.LOOP_CONTINUOUSLY);
  }

}
