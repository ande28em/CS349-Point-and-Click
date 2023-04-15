package pointandclick;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import gui.SceneVisual;
import io.ResourceFinder;



/**
 * PointAndClick.java - Main class to start the CS349 point and click game.
 * 
 * This work complies with the JMU Honor Code.
 * 
 * @author Eric Anderson
 * @version Apr 5, 2023
 */
public class PointAndClickV2 extends app.JApplication implements ActionListener
{
  SceneVisual vis;
  protected static final String ABOUT = "About";
  static final String EXIT = "Exit";

  private static final int HEIGHT = 780;
  private static final int WIDTH = 720;
  private static String HELP = "Help";
  private static String START = "Start";
  private static String BUTTONA = "buttonA";
  private static String BUTTONB = "buttonB";
  private static String BUTTONC = "buttonC";
  private static String BUTTOND = "buttonD";
  private JButton startButton;
  private JButton buttonA;
  private JButton buttonB;
  private JButton buttonC;
  private JButton buttonD;
  private JLabel backGround = null;

  //JFrame frame;
  JRootPane contentPane;

  /**
   * @param args
   *          - command line arguments.
   */
  public PointAndClickV2(final String[] args)

  {
    super(args, WIDTH, HEIGHT);
    this.vis = new SceneVisual();
  }

  /**
   * Must construct the GUI components and lay them out.
   */
  public void init()
  {
    //this.frame = new JFrame("The Final Adventure");
    //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    contentPane = getRootPane();
    contentPane.setLayout(null);
    
    // Add the menu
    JMenuBar menuBar = new JMenuBar();
    //frame.setJMenuBar(menuBar);

    JMenu menu;
    // JMenuItem item;

    menu = new JMenu("File");
    menuBar.add(menu);

    JMenuItem exit = new JMenuItem(EXIT);
    exit.addActionListener(this);
    menu.add(exit);

    KeyStroke quitKey = KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_DOWN_MASK); // works
                                                                                        // without
                                                                                        // opening
                                                                                        // // the
                                                                                        // menu
                                                                                        // first
    exit.setAccelerator(quitKey);

    exit.setMnemonic(KeyEvent.VK_Q); // menu must first be open

    JMenu help = new JMenu(HELP);
    menuBar.add(help);
    JMenuItem about = new JMenuItem(ABOUT);
    about.addActionListener(this);
    help.add(about);

    // ImageIcon icon = new ImageIcon("pointandclick/resources/Nature_Distraction.jpg");

    ResourceFinder rf = ResourceFinder.createInstance(new resources.Marker());

    BufferedImage bg;
    Image bg2;
    
    
    
    try
    {
      InputStream is = rf.findInputStream("ISAT_Entering.jpg");
      bg = ImageIO.read(is);
      bg2 = bg.getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH);
      backGround = new JLabel(new ImageIcon(bg2));
      backGround.setBounds(0, 0, WIDTH, HEIGHT);
      contentPane.add(backGround);
    }
    catch (IOException e)
    {

    }
    
    startButton = new JButton("Start");
    startButton.setBounds(275, 600, 150, 50);
    startButton.addActionListener(this);
    contentPane.add(startButton);
    vis.setBounds(1, HEIGHT * 3/4, WIDTH * 2/ 3, HEIGHT / 4);
    contentPane.add(vis);
    vis.setVisible(false);

    
    buttonA = new JButton("First Option A");
    buttonA.setActionCommand("A");
    buttonA.setBounds(WIDTH * 2 / 3, HEIGHT * 3/4, 125, 75);
    buttonA.addActionListener(this);
    contentPane.add(buttonA);
    buttonA.setVisible(false);

    buttonB = new JButton("First Option B");
    buttonB.setActionCommand("B");
    buttonB.setBounds((WIDTH * 2 / 3) + 125, HEIGHT * 3/4, 125, 75);
    buttonB.addActionListener(this);
    contentPane.add(buttonB);
    buttonB.setVisible(false);

    buttonC = new JButton("First Option C");
    buttonC.setActionCommand("C");
    buttonC.setBounds(WIDTH * 2 / 3, (HEIGHT * 3/4)+ 75, 125, 75);
    buttonC.addActionListener(this);
    contentPane.add(buttonC);
    buttonC.setVisible(false);
    buttonD = new JButton("First Option D");
    buttonD.setActionCommand("D");
    buttonD.setBounds((WIDTH * 2 / 3) + 125, (HEIGHT * 3/4) + 75, 125, 75);
    buttonD.addActionListener(this);
    contentPane.add(buttonD);
    buttonD.setVisible(false);

    //frame.setSize(720, 780);


    contentPane.setBackground(Color.GRAY);
    //frame.setBackground(Color.GRAY);

    //frame.setVisible(true);

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

    if (actionCommand.equals(EXIT))
    {

      System.exit(0);

      return;
    }

    if (actionCommand.equals(ABOUT))
    {
      String about = "Point & click adventure game revolving around " + ""
          + "the user attempting to pass the CS349 final exam.\n"
          + "User choices will influence the overall \"story\" leading to a particular ending.";

      JOptionPane.showMessageDialog(null, about, ABOUT, 1);

      return;
    }


    // can only be pressed once per iteration
    if (actionCommand.equals(START))
    {
      startButton.setVisible(false);

      ResourceFinder rf = ResourceFinder.createInstance(new resources.Marker());

      BufferedImage bg;
      Image bg2;
      
      
      
      try
      {
        contentPane.remove(backGround);
        InputStream is = rf.findInputStream("ClassroomScene.jpg");
        bg = ImageIO.read(is);
        bg2 = bg.getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH);
        backGround = new JLabel(new ImageIcon(bg2));
        backGround.setBounds(0, 0, WIDTH, HEIGHT * 3 / 4);     
        contentPane.add(backGround);
        contentPane.repaint();
      }
      catch (IOException e)
      {

      }
      buttonA.setVisible(true);
      buttonB.setVisible(true);
      buttonC.setVisible(true);
      buttonD.setVisible(true);
      vis.setVisible(true);

    }

    if (actionCommand.equals(BUTTONA))
    {

      buttonA.setText("next option A");
      buttonB.setText("next option B");
      buttonC.setText("next option C");
      buttonD.setText("next option D");
    }

    if (actionCommand.equals(BUTTONB))
    {

      buttonA.setText("next option A");
      buttonB.setText("next option B");
      buttonC.setText("next option C");
      buttonD.setText("next option D");
    }

    if (actionCommand.equals(BUTTONC))
    {

      buttonA.setText("next option A");
      buttonB.setText("next option B");
      buttonC.setText("next option C");
      buttonD.setText("next option D");
    }

    if (actionCommand.equals(BUTTOND))
    {

      buttonA.setText("next option A");
      buttonB.setText("next option B");
      buttonC.setText("next option C");
      buttonD.setText("next option D");
    }
    

  }

//  @Override
//  public void run()
//  {
//    // TODO Auto-generated method stub
//    try
//    {
//      String style = UIManager.getSystemLookAndFeelClassName();
//      UIManager.setLookAndFeel(style);
//    }
//    catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException
//        | IllegalAccessException e)
//    {
//      System.out.print("error, style");
//    }
//
//    this.init();
//
//  }

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
  {
    app.JApplication app = new PointAndClickV2(args);
    invokeInEventDispatchThread(app);
  }

}
