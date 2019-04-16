package packproj;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.JScrollPane.*;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class InterfaceGFin extends JFrame implements ActionListener{
	JPanel pan1, pan2;
	JLabel message;
	JButton retour;
	
	
	public InterfaceGFin (String title) {
		super();
		this.setTitle(title);
		this.setSize(350, 100);			
		
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing (WindowEvent e){
				System.exit (0);
			}
		});
		
		/*recuperation du ContentPane*/
		Container contenu = this.getContentPane();
		
		message= new JLabel("Enregistrement effectué");
		
		/*creation des JPanel avec leur Layout Manager*/		
		pan1 = new JPanel(new GridLayout (2,1));
		pan2 = new JPanel(new GridLayout (1,1));
		
		retour= new JButton("Oui");
		
		 
		pan1.add(message);
		pan2.add(retour);
		
		contenu.add(pan1, BorderLayout.NORTH);
		contenu.add(pan2);
		
		retour.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {	        	 	        	 	        	 
	        	 dispose();	  
	        	 
	        	 InterfaceGTer f= new InterfaceGTer();
	        	 f.aj_med();
		     }
	     });
				
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
