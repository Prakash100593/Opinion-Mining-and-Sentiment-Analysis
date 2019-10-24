/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package src.featureextraction;
import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.UIManager;
/**
 *
 * @author seabird
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame.setDefaultLookAndFeelDecorated(true);
                JDialog.setDefaultLookAndFeelDecorated(true);
        try
  	{
            UIManager.setLookAndFeel("ch.randelshofer.quaqua.QuaquaLookAndFeel");
  	}
  	catch (Exception ex)
  	{
   		
  	}
       /* MainFrame mf=new MainFrame();
        mf.setTitle("Feature Extraction");
        mf.setVisible(true);
        mf.setResizable(false);*/
        
        FirstFrame ff=new FirstFrame();
        ff.setVisible(true);
     //   ff.setResizable(false);
        ff.setTitle("Opinion Mining ");
    }

}
