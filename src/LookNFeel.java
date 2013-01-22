import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

import javax.swing.UIManager;
import javax.swing.SwingUtilities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Insets;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class LookNFeel extends JPanel implements ActionListener
{
 private JRadioButton optMetal;
 private JRadioButton optMotif;
 private JRadioButton optWindows;

 private GridBagLayout gridBag;

 private GridBagConstraints gridConst;

 public LookNFeel() {
  // create_layoutManager();
  // create_JPanel();
  // create_JFrame();
   gridBag = new GridBagLayout();
   gridConst = new GridBagConstraints();

   /*
    "This field specifies the external padding of
      the component, the minimum amount of space
      between the component and the edges of its
      display area." (java.awt.GridBagConstraints, Documenation)
   */
   gridConst.insets = new Insets(10, 10, 10, 10);
 }

  private void create_JPanel() {
    optMetal = new JRadioButton("Metal");
    optMetal.setActionCommand("Metal");
    optMetal.addActionListener(this);
    gridBag.setConstraints(optMetal, gridConst);
    add(optMetal);

    optMotif = new JRadioButton("Motif");
    optMotif.setActionCommand("Motif");
    optMotif.addActionListener(this);
    gridBag.setConstraints(optMotif, gridConst);
    add(optMotif);

    optWindows = new JRadioButton("Windows");
    optWindows.setActionCommand("Windows");
    optWindows.addActionListener(this);
    gridBag.setConstraints(optWindows, gridConst);
    add(optWindows);
  }

 public void actionPerformed(ActionEvent evt)
 {
  String cmd = evt.getActionCommand();
  String lnf;
   
  if( cmd == "Metal" )
   lnf = new String("javax.swing.plaf.metal.MetalLookAndFeel");
  else
  {
   if( cmd == "Motif" )
    lnf = new String("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
   else
    lnf = new String("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
  }

  /*
   "How to Set the Look and Feel", The Java Tutorial, Sun Microsystems
   http://java.sun.com/docs/books/tutorial/uiswing/misc/plaf.html

   UIManager records which Look and Feel to use
   SwingUtitilites changes components to the current Look and Feel 
  */
  try
  {
   /*
    "Sets the current default look and feel using a class name"
    (javax.swing.UIManager, Documenation)
   */
   UIManager.setLookAndFeel( lnf );

   /*
    "A simple minded look and feel change: ask each node in the tree to
    updateUI() -- that is, to initialize its UI property with the current
    look and feel."
      
    (javax.swing.SwingUtilities, Documenation)
   */
   SwingUtilities.updateComponentTreeUI(this);

//   create_JFrame();
  }
  catch(Exception e)
  {
   /*
    All four exceptions that UIManager.setLookAndFeel throws
    are subclasses of Exception. Exception type exceptions are checked.
     
    "ClassNotFoundException - if the LookAndFeel class could not be found 
    InstantiationException - if a new instance of the class couldn't be created 
    IllegalAccessException - if the class or initializer isn't accessible 
    UnsupportedLookAndFeelException - if lnf.isSupportedLookAndFeel() is false"
   */
   e.printStackTrace();
  }
 }

  public static void main(String[] args) {
    LookNFeel lnf = new LookNFeel();

    JFrame frame = new JFrame("Look - 'N' - Feel");

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // frame.setContentPane(this);
    frame.setSize(100, 150);
    frame.setResizable(false);
    //frame.setVisible(true);
  }
}
