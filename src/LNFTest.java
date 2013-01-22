import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.UIManager;
import javax.swing.SwingUtilities;

import java.lang.Exception;

/**
 This class is for testing the Look and Feel property of Swing

 Menu allows you to switch to different look and feels: Metal, Motif, and Windows

 @author Todd Gerspacher
*/
public class LNFTest extends JFrame implements ActionListener {


 public JMenuBar menuBar()
 {
  JMenu menu = new JMenu("Look and Feel");

  menu.add( menuItem("Metal") );
  menu.add( menuItem("Motif") );
  menu.add( menuItem("Windows") );

  JMenuBar menuBar = new JMenuBar();

  menuBar.add( menu );

  return menuBar;
 }

 public JMenuItem menuItem(String label)
 {
  JMenuItem menuItem = new JMenuItem(label);

  menuItem.setActionCommand(label);
  menuItem.addActionListener(this);

  return menuItem;
 }

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
   JMenuBar menubar = new JMenuBar();

   JFrame frame = new JFrame("Testing Java's Look & Feel");
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   frame.setJMenuBar(menubar);
   frame.setVisible(true);
 }
}