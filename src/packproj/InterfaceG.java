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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceG extends JFrame implements ActionListener {
	JPanel pan1, pan2;
	JLabel pseudo, mot_de_passe;
	JTextField textpseudo, textmdp ;
	JButton connecter;
	JTextArea aire;
	
	public InterfaceG (String titre) {
		super();
		this.setTitle(titre);
		this.setSize(500,200);			
		
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing (WindowEvent e){
				System.exit (0);
			}
		});
		
		/*recuperation du ContentPane*/
		Container contenu = this.getContentPane();
		
		/*creation des JPanel avec leur Layout Manager*/
		pan1 =new JPanel(new GridLayout (2,2));
		pan2 =new JPanel(new GridLayout (1,1));
		
		
		//création de JLabel
		pseudo = new JLabel ("Pseudo");
		mot_de_passe = new JLabel ("Mot_de_passe");
		
		//création de JTextField
		textpseudo = new JTextField("");
		textmdp = new JTextField("");
				
		//création de JButton
		connecter= new JButton("Connecter");
						
		/*ajout des pannneaux au ContentPane,l'un au nord, l'autre au sud*/
		contenu.add (pan1, BorderLayout.NORTH);
		contenu.add(pan2, BorderLayout.SOUTH);
		
		/*ajout d une bordure avec intiutlé a 1*/
		pan1.setBorder (new TitledBorder("Se connecter"));
		
		/*ajout de  label et de trois zones de texte a pan1*/
		pan1.add(pseudo); pan1.add(textpseudo);
		pan1.add(mot_de_passe); pan1.add(textmdp);
		
		/*ajout de  boutons a pan1*/
		pan2.add(connecter);
		
		/* on cree un objet ecouteur de la fenetre*/
		EcoutWindows ecout = new EcoutWindows();
		this.addMouseListener(ecout);
		
		//Appeler le bouton lorsqu'on clickera sur lui
		//connecter.addActionListener(this);
		
		 
	     connecter.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {	 
	        	 Fonctions fct2 = new Fonctions();	        	 
	        	 String ps = fct2.pseudo();
	        	 String pass= fct2.mdp();
	        	 String ps1=textpseudo.getText();
	        	 String pass2=textmdp.getText();
	        	 if ((ps1!=ps) || (pass2!=pass)) {	        			        	 	        	 	        	
	        		 dispose();	        	
	        		 InterfaceGBis fen2 = new InterfaceGBis("test");
	        		 fen2.setVisible(true); 	
	     		} 
	        	 
	        	else {
	        		 JButton ouvre= new JButton("OK");
	        		 ouvre.addActionListener(this);
	        		 contenu.add(ouvre);
	        		 JOptionPane.showMessageDialog(contenu, "Pseudo ou mot de passe incorrecte", "Info", JOptionPane.INFORMATION_MESSAGE, null);	        	 
	        		 
	        	 }
	        	 
		     }
	     });
				        	
	}

	
	public void actionPerformed(ActionEvent e) {
		if( e.getSource() == connecter){
			
		}
	}
	
}
