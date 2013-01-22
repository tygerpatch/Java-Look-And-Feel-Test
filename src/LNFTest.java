import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 This class is for testing the Look and Feel property of Swing

 Menu allows you to switch to different look and feels: Metal, Motif, and Windows

 @author Todd Gerspacher
*/
public class LNFTest extends JFrame implements ActionListener {

 public void actionPerformed(ActionEvent evt)
 {
  String action = evt.getActionCommand();
  String lnfName = new String(); // look and feel name

  if( action.equalsIgnoreCase("Metal") )
   lnfName = new String("javax.swing.plaf.metal.MetalLookAndFeel");

  if( action.equalsIgnoreCase("Motif") )
   lnfName = new String("com.sun.java.swing.plaf.motif.MotifLookAndFeel");

  if( action.equalsIgnoreCase("Windows") )
   lnfName = new String("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

  /*
   "How to Set the Look and Feel", The Java Tutorial, Sun Microsystems
   http://java.sun.com/docs/books/tutorial/uiswing/misc/plaf.html

   UIManager records which Look and Feel to use
   SwingUtitilites changes components to the current Look and Feel 
  */
  try
  {
   UIManager.setLookAndFeel( lnfName );
   SwingUtilities.updateComponentTreeUI(this);
  }
  catch(Exception e)
  {
   e.printStackTrace();
  }
 }

 public static void main(String[] args) {
   JMenu menu = new JMenu("Look and Feel");

   JMenuItem menuItem = new JMenuItem("Metal");

//   menuItem.setActionCommand(label);
//   menuItem.addActionListener(this);

   menu.add( menuItem );

   menuItem = new JMenuItem("Motif");

// menuItem.setActionCommand(label);
// menuItem.addActionListener(this);

 menu.add( menuItem );

 menuItem = new JMenuItem("Windows");

  //menuItem.setActionCommand(label);
  //menuItem.addActionListener(this);

  menu.add( menuItem );

   JMenuBar menuBar = new JMenuBar();

   menuBar.add( menu );

   JFrame frame = new JFrame("Testing Java's Look & Feel");
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   frame.setJMenuBar(menuBar);
   frame.setVisible(true);
 }
}