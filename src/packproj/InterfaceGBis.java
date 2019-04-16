package packproj;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.JScrollPane.*;


public class InterfaceGBis extends JFrame implements ActionListener {
	JPanel pan, accueil;
	JLabel lab;
	JMenuBar menu;
	JMenu accueil0, ajout, consultation, visuel ;
	JMenuItem accueil1, ajouter_patient, ajouter_medecin, ajouter_medicament, patients, historique, ajouter_cslt;
	CardLayout cardl = new CardLayout();
	
	
	public InterfaceGBis (String titre) {
		super();
		this.setTitle(titre);
		this.setSize(500,400);			
		
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing (WindowEvent e){
				System.exit (0);
			}
		});
		
		/*recuperation du ContentPane*/
		Container contenu = this.getContentPane();
		
		// Créer le JPanel
		pan=new JPanel();
		accueil= new JPanel();	
		
		lab = new JLabel("BIENVENUE");
		
		//On prend le premier panel (pan) qu'on intègre au CardLayout
		pan.setLayout(cardl); 
				
		//ajout de nos menus et sous menu		
		menu = new JMenuBar();
		accueil0 = new JMenu("Accueil");
		ajout = new JMenu("Ajouter");
		consultation = new JMenu("Consultation");
		visuel = new JMenu("Visualiser");
		accueil1 = new JMenuItem("Fenêtre principale");
		ajouter_medecin = new JMenuItem("Ajouter un médecin");
		ajouter_patient = new JMenuItem("Ajouter un patient");
		ajouter_cslt = new JMenuItem("Nouvelle consultation");
		ajouter_medicament = new JMenuItem("Ajouter un médicament");
		historique = new JMenuItem("Historique des consultations");
		patients = new JMenuItem("Liste des patients");
		
		//On superpose les panels secondaires sur le panelcontenant le CardLayout
		InterfaceGTer fen1 = new InterfaceGTer();
		pan.add(lab);
		pan.add(accueil, "0");
		pan.add(fen1.menup(), "7");
		pan.add(fen1.aj_med(), "1");
		pan.add(fen1.aj_pat(), "2");
		pan.add(fen1.aj_medoc(), "3");
		pan.add(fen1.nv_csltation(), "4");
		//pan.add(fen1.aj_prescrit(), "5");
		pan.add(fen1.liste_patient(), "6");
		
		//ajouter menu dans la fenetre
		contenu.add(menu);
								
		//ajouter menu dans la fenetre		
		menu.add(accueil0);
		menu.add(ajout);
		menu.add(consultation);
		menu.add(visuel);
		
		//ajouter sous-menu dans la fenetre
		accueil0.add(accueil1);
		ajout.add(ajouter_medecin);
		ajout.add(ajouter_patient);
		ajout.add(ajouter_medicament);
		consultation.add(ajouter_cslt);
		visuel.add(historique);
		visuel.add(patients);
		
		//intégrer la barre de menu
		setJMenuBar(menu);
		
		contenu.add(pan);	

		accueil1.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {	        	 
	        	 cardl.show(pan, "7");
		     }
	     });
		
		ajouter_medecin.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {	        	 
	        	 cardl.show(pan, "1");
		     }
	     });
		
		ajouter_patient.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {	        	 
	        	 cardl.show(pan, "2");
		     }
	     });
		
		ajouter_medicament.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {	        	 
	        	 cardl.show(pan, "3");
		     }
	     });
		
		ajouter_cslt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardl.show(pan, "4");				
			}
		});
		
		patients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardl.show(pan, "6");				
			}
		});

}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
	}}
