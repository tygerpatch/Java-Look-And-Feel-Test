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

 private JFrame frm;

 public LookNFeel()
 {
  create_layoutManager();
  create_JPanel();
  create_JFrame();
 }

 private void create_layoutManager()
 {
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

 private void create_JPanel()
 {
  create_JRadioButtons();
  set_ActionCommand_JRadioButtons();
  add_ActionListeners_JRadioButtons();
  set_constraints_JRadioButtons();
  add_JRadioButtons();
 }

 private void create_JFrame()
 {
  frm = new JFrame("Look - 'N' - Feel");
  
  frm.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  frm.setContentPane( this );
  frm.setSize(100, 150);
  frm.setResizable(false);
  frm.setVisible(true);
 }

 private void create_JRadioButtons()
 {
  optMetal = new JRadioButton("Metal");
  optMotif = new JRadioButton("Motif");
  optWindows = new JRadioButton("Windows");
 }

 private void set_ActionCommand_JRadioButtons()
 {
  optMetal.setActionCommand("Metal");
  optMotif.setActionCommand("Motif");
  optWindows.setActionCommand("Windows");
 }

 private void add_ActionListeners_JRadioButtons()
 {
  optMetal.addActionListener( this );
  optMotif.addActionListener( this );
  optWindows.addActionListener( this );
 }

 private void set_constraints_JRadioButtons()
 {
  gridBag.setConstraints( optMetal, gridConst );
  gridBag.setConstraints( optMotif, gridConst );
  gridBag.setConstraints( optWindows, gridConst );
 }

 private void add_JRadioButtons()
 {
  add( optMetal );
  add( optMotif );
  add( optWindows );
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

   create_JFrame();
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

 public static void main(String[] args)
 {
  LookNFeel lnf = new LookNFeel();
 }
}