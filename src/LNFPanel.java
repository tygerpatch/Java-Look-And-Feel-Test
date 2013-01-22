import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 This class is for testing the Look and Feel property of Swing

 Menu allows you to switch to different look and feels: Metal, Motif, and Windows

 @author Todd Gerspacher
*/
public class LNFPanel extends JPanel implements ActionListener {

  private ButtonGroup buttonGroup = new ButtonGroup();

  public LNFPanel() {
    setLayout(new GridLayout(1, 3));

    add(radioButton("Metal"));
    add(radioButton("Motif"));
    add(radioButton("Windows"));
  }

  public JRadioButton radioButton(String text) {
    JRadioButton radioButton = new JRadioButton(text);
    radioButton.setActionCommand(text);
    radioButton.addActionListener(this);

    buttonGroup.add(radioButton);

    return radioButton;
  }

  public void actionPerformed(ActionEvent actionEvent) {
    String actionCommand = actionEvent.getActionCommand();
    String className = "";

    if("Metal".equals(actionCommand))
      className = "javax.swing.plaf.metal.MetalLookAndFeel";

    if("Motif".equals(actionCommand))
      className = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";

    if("Windows".equals(actionCommand))
      className = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";

    /*
    "How to Set the Look and Feel", The Java Tutorial, Sun Microsystems
    http://java.sun.com/docs/books/tutorial/uiswing/misc/plaf.html

    UIManager records which Look and Feel to use
    SwingUtitilites changes components to the current Look and Feel
   */
   try {
     UIManager.setLookAndFeel(className);
    SwingUtilities.updateComponentTreeUI(this);
   }
   catch(ClassNotFoundException classNotFound) {
     System.out.println(classNotFound);
   }
   catch(InstantiationException instantiation) {
     System.out.println(instantiation);
   }
   catch(IllegalAccessException illegalAccess) {
     System.out.println(illegalAccess);
   }
   catch(UnsupportedLookAndFeelException unsupportedLookAndFeel) {
     System.out.println(unsupportedLookAndFeel);
   }
  }

  public static void main(String[] args) {
   JFrame frame = new JFrame("Testing Java's Look & Feel");
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   frame.setContentPane(new LNFPanel());
   frame.setVisible(true);
   frame.pack();
  }
}