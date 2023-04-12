package pointandclick;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.lang.reflect.InvocationTargetException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * PointAndClick.java - Main class to start the CS349 point and click game.
 * 
 * This work complies with the JMU Honor Code.
 * 
 * @author Eric Anderson
 * @version Apr 5, 2023
 */
public class PointAndClick implements Runnable, ActionListener
{

  protected static final String ABOUT = "About";
  JFrame frame;

  public PointAndClick(String[] args)
  {
    // TODO
  }

  /**
   * Must construct the GUI components and lay them out.
   */
  public void init()
  {
    this.frame = new JFrame("The Final Adventure");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel contentPane = (JPanel) frame.getContentPane();

    contentPane.setLayout(null);

    // Add the menu
    JMenuBar menuBar = new JMenuBar();
    frame.setJMenuBar(menuBar);

    JMenu menu;
    // JMenuItem item;

    menu = new JMenu("File");
    menuBar.add(menu);

    JMenuItem exit = new JMenuItem("Exit");
    exit.addActionListener(this);
    menu.add(exit);

    KeyStroke quitKey = KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_DOWN_MASK); // works
                                                                                        // without
                                                                                        // opening
                                                                                        // the menu
                                                                                        // first
    exit.setAccelerator(quitKey);

    exit.setMnemonic(KeyEvent.VK_Q); // menu must first be open
    
    Icon icon = new ImageIcon("InfoIcon.png");
    
    JButton button1 = new JButton(icon);
    button1.setBounds(70, 5, 100, 100);
    button1.setActionCommand(ABOUT);
    button1.addActionListener(this);
    contentPane.add(button1);

    frame.setSize(400, 250);
    contentPane.setBackground(Color.GRAY);
    // menuBar.setBackground(Color.GRAY);
    frame.setBackground(Color.GRAY);

    frame.setVisible(true);

    contentPane.setVisible(true);
  }

  /**
   * Must handle the events generated by the user clicking on the buttons.
   * 
   * @param evt
   *          the action clicked on
   */
  public void actionPerformed(final ActionEvent evt)
  {

    String actionCommand;
    actionCommand = evt.getActionCommand();

    // code I wrote for another of my projects; to be edited to fit this one later

    if (actionCommand.equals("Exit"))
    {

      System.exit(0);

      return;
    }

    if (actionCommand.equals(ABOUT))
    {
      String about = "Point & click adventure game revolving around the user attempting to pass the CS349 final exam.\n"
          + "User choices will influence the overall �story� leading to a particular ending.";

      JOptionPane.showMessageDialog(null, about, ABOUT, 1);

      return;
    }

    // if (actionCommand.equals(CALCULATOR))
    // {
    //
    // CalorieCalculatorWindow.main(null);
    //
    // return;
    // }
    //
    // if (actionCommand.equals(CONVERTER))
    // {
    //
    // UnitConverterWindow.main(null);
    //
    // return;
    // }

  }

  @Override
  public void run()
  {
    // TODO Auto-generated method stub
    try
    {
      String style = UIManager.getSystemLookAndFeelClassName();
      UIManager.setLookAndFeel(style);
    }
    catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException
        | IllegalAccessException e)
    {
      System.out.print("error, style");
    }

    this.init();

  }

  /**
   * The entry point of the application.
   * 
   * @param args
   *          The command-line arguments (which are ignored)
   * @throws InterruptedException
   *           If the system is interrupted
   * @throws InvocationTargetException
   *           If there is a problem starting the system
   */
  public static void main(final String[] args)
      throws InterruptedException, InvocationTargetException
  {
    // Perform all of the setup activities in the event dispatch thread
    SwingUtilities.invokeAndWait(new PointAndClick(args));
  }

}
