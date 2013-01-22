import javax.swing.JRadioButton;
import javax.swing.JOptionPane;
import javax.swing.JDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Insets;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class SelectionTest extends JDialog implements ActionListener
{
 public SelectionTest()
 {
  /*
   "When a modal dialog is visible, 
    it blocks user input to all other windows in the program."

   ( "How to Make Dialogs", 
      <http://java.sun.com/docs/books/tutorial/uiswing/components/dialog.html> )
  */
  setModal(true);

  // Close Dialog Box when user clicks on close button
  setDefaultCloseOperation( javax.swing.JDialog.EXIT_ON_CLOSE );

  // Create layout manager
  GridBagLayout gridBag = new GridBagLayout();

  // Create constraint
  GridBagConstraints gridConst = new GridBagConstraints();

  // Create inset
  // Insets(int top, int left, int bottom, int right)
  Insets ins = new Insets(10, 10, 10, 10);

  // Set fields for constraint
  /*
   "This field specifies the external padding of
     the component, the minimum amount of space 
     between the component and the edges of its
     display area." (java.awt.GridBagConstraints, Documenation)
  */
  gridConst.insets = ins;

  // Create JRadioButtons
  JRadioButton optMetal = new JRadioButton("Metal");
  JRadioButton optMotif = new JRadioButton("Motif");
  JRadioButton optWindows = new JRadioButton("Windows");

  // Set constraints
  gridBag.setConstraints( optMetal, gridConst );
  gridBag.setConstraints( optMotif, gridConst );
  gridBag.setConstraints( optWindows, gridConst );

  // set layout manager for JPanel
  setLayout( gridBag );

  // Set Action Command for JRadioButtons
  optMetal.setActionCommand("Metal");
  optMotif.setActionCommand("Motif");
  optWindows.setActionCommand("Windows");

  // Add ActionListeners to JRadioButtons
  optMetal.addActionListener( this );
  optMotif.addActionListener( this );
  optWindows.addActionListener( this );

  // Add Component
  add( optMetal );
  add( optMotif );
  add( optWindows );
 }

 public void actionPerformed(ActionEvent evt)
 {
  String cmd = evt.getActionCommand();

  JOptionPane.showMessageDialog( null, cmd + " button was clicked.");
 }

 public static void main(String[] args)
 {
  SelectionTest ST = new SelectionTest();
  ST.setVisible(true);
 }
}

