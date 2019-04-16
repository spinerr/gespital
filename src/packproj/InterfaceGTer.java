package packproj;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;
import javax.swing.JScrollPane.*;

public class InterfaceGTer extends JFrame implements ActionListener{
	Fonctions fct = new Fonctions();	
	
	public Component menup() {
		JPanel accueil;
		JLabel label;
		
		Container contenu = this.getContentPane();
		
		accueil = new JPanel(new GridLayout(1,1));
		label = new JLabel("BIENVENUE");
		
		accueil.add(label);
		
		return contenu.add(accueil);
	}
	
	public Component aj_med() {
		JPanel pan, pan1, pan2;
		JLabel nbreMed, matricule, nom;
		JTextField textmatricule, textnom;
		JButton ajouter, annuler;
		
		Container contenu = this.getContentPane();
		
		pan =new JPanel(new GridLayout (2,1));
		pan1 =new JPanel(new GridLayout (1,1));
		pan2 =new JPanel(new GridLayout (3,2));		
		
		nbreMed = new JLabel("Le nombre de medecin dans cette structure est de: "+fct.afficherNbreMed());
		matricule = new JLabel("Matricule");
		nom = new JLabel("Nom");
		
		textmatricule= new JTextField("");
		textnom = new JTextField("");
		
		ajouter = new JButton("Ajouter");
		annuler = new JButton("Annuler");
		
		pan1.add(nbreMed);
		pan2.add(matricule); pan2.add(textmatricule);
		pan2.add(nom); pan2.add(textnom);
		pan2.add(ajouter);pan2.add(annuler);
		pan.add(pan1);
		pan.add(pan2);
		
		ajouter.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 int mat = Integer.parseInt(textmatricule.getText());
	        	 fct.ajouter_medecin(mat, textnom.getText());
	        	textmatricule.setText(" ");
	        	textnom.setText(" ");
	        	 //pan.revalidate();
	        	 //pan.repaint();
	        	
	        	InterfaceGFin fen3 = new InterfaceGFin("test");
	        	fen3.setVisible(true);	        		        
	        	
	        
	         }
	     });
		
		return contenu.add(pan);
	}
	

	
	public Component aj_pat() {
		JPanel pan, pan1, pan2;
		JLabel num_pat, nom_pat, nbrePat;
		JTextField textnum_pat, textnom_pat;	
		JButton jb1, jb2;
		
		Container contenu = this.getContentPane();
		
		pan1 =new JPanel(new GridLayout (1,1));
		pan2 =new JPanel(new GridLayout (3,2));
		pan =new JPanel(new GridLayout (2,1));
		
		num_pat = new JLabel("Numèro du patient");
		nom_pat = new JLabel("Nom du patient");
		nbrePat = new JLabel("Le nombre de patients dans cette structure est de: "+fct.afficherNbrePat());
		
		textnum_pat= new JTextField("");
		textnom_pat = new JTextField("");	
		
		jb1 = new JButton("Ajouter");
		jb2 = new JButton("Annuler");
		
		pan1.add(nbrePat);
		pan2.add(num_pat); pan2.add(textnum_pat);
		pan2.add(nom_pat); pan2.add(textnom_pat);
		pan2.add(jb1);pan2.add(jb2);
		pan.add(pan1); pan.add(pan2);
		
		jb1.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {	
	        	 int mat = Integer.parseInt(textnum_pat.getText());
	        	 fct.ajouter_patient(mat, textnom_pat.getText());
	        	 textnum_pat.setText(" ");
	        	 textnom_pat.setText(" ");
	        	 //pan.revalidate();
	        	 //pan.repaint();
	        	
	        	InterfaceGFin fen3 = new InterfaceGFin("test");
	        	fen3.setVisible(true);	      
	         }
	     });
				
		return contenu.add(pan);
	}
	
	public Component aj_medoc() {
		JPanel pan, pan1, pan2;
		JLabel code, libelle, indication, posologie, nbreMedoc;
		JTextField textcode, textlibelle, textindication, textposologie;		
		JButton jb1, jb2;
		
		Container contenu = this.getContentPane();
		
		pan =new JPanel(new GridLayout (2,1));
		pan1 =new JPanel(new GridLayout (1,1));
		pan2 =new JPanel(new GridLayout (5,2));
		
		code = new JLabel("Code");
		libelle = new JLabel("Libelle");
		indication = new JLabel("Indication");
		posologie = new JLabel("Posologie");
		nbreMedoc = new JLabel("Le nombre de medicaments dans cette structure est de: "+fct.afficherNbreMedoc());
		
		textcode= new JTextField("");
		textlibelle = new JTextField("");
		textindication= new JTextField("");
		textposologie = new JTextField("");		
		
		jb1 = new JButton("Ajouter");
		jb2 = new JButton("Annuler");
		
		pan2.add(code); pan2.add(textcode);
		pan2.add(libelle); pan2.add(textlibelle);
		pan2.add(indication); pan2.add(textindication);
		pan2.add(posologie); pan2.add(textposologie);
		pan2.add(jb1);pan2.add(jb2);
		pan1.add(nbreMedoc);
		pan.add(pan1); pan.add(pan2);
		
		jb1.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {	
	        	 
	        	 fct.ajouter_medoc(textcode.getText(), textlibelle.getText(), textindication.getText(), textposologie.getText());
	        	 textcode.setText(" ");
	        	 textlibelle.setText(" ");
	        	 textindication.setText(" ");
	        	 textposologie.setText(" ");
	        	 //pan.revalidate();
	        	 //pan.repaint();
	        	
	        	InterfaceGFin fen3 = new InterfaceGFin("test");
	        	fen3.setVisible(true);	      
	         }
	     });
		
		return contenu.add(pan);
	}
	
	public Component nv_csltation() {
		JPanel pan,pan1,pan2,pan3;
		JLabel numero, nbrcslt, date, motifs, num_med, num_pat;
		JTextField textnumero, textdate;
		JTextArea textmotifs;
		JComboBox cb_num_med, cb_num_pat;
		JButton suivant, annuler;
		
		Container contenu = this.getContentPane();
		
		pan =new JPanel(new GridLayout (6,2));
		pan1 =new JPanel(new GridLayout (1,1));
		pan2 =new JPanel(new GridLayout (1,2));
		pan3 =new JPanel(new GridLayout (3,1));
		
		numero = new JLabel("Numèro de la consultation");
		nbrcslt = new JLabel("Le nombre de consultation est de: "+fct.afficherNbreCslt());
		date = new JLabel("Date de la consultation");
		motifs = new JLabel("Motifs de la consultation");
		num_med = new JLabel("Numero médecin");
		num_pat = new JLabel("Numero patient");		
		
		textnumero = new JTextField("");
		textdate = new JTextField("");
		
		textmotifs = new JTextArea();
		
		cb_num_med = new JComboBox(fct.retourNumMed());
		cb_num_pat = new JComboBox(fct.retourNumPat());
		
		suivant = new JButton("Ajouter");
		annuler = new JButton("Annuler");
		
		pan.add(numero); pan.add(textnumero);
		pan.add(date); pan.add(textdate);
		pan.add(motifs); pan.add(textmotifs);
		pan.add(num_med);pan.add(cb_num_med);
		pan.add(num_pat);pan.add(cb_num_pat);
		pan1.add(nbrcslt);
		pan2.add(suivant);pan2.add(annuler);
		pan3.add(pan1);
		pan3.add(pan);
		pan3.add(pan2);
		
		suivant.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {	
	        	 int mat = Integer.parseInt(textnumero.getText());
	        	 int num_med = Integer.parseInt(cb_num_med.getSelectedItem().toString());
	        	 int num_pat = Integer.parseInt(cb_num_pat.getSelectedItem().toString());
	        	 fct.ajouter_cslt(mat, textdate.getText(), textmotifs.getText(), num_med, num_pat);
	        	 textnumero.setText(" ");
	        	 textdate.setText(" ");
	        	 textmotifs.setText(" ");
	        	 //cb_num_med.setText(" ");
	        	 //cb_num_pat.setText(" ");
	        	 //pan.revalidate();
	        	 //pan.repaint();
	        	
	        	InterfaceGFin fen3 = new InterfaceGFin("test");
	        	fen3.setVisible(true);	      
	         }
	     });
		return contenu.add(pan3);
	}
	
	public Component liste_patient() {	
		String col[] = { "numèro", "Nom"};
		JPanel pan1;		
		//JTextArea tab;
		DefaultTableModel model = new DefaultTableModel(fct.afficherPatient(), col);
	    JTable table = new JTable(model);
	    table.setShowGrid(true);
	    table.setShowVerticalLines(true);
		
		Container contenu = this.getContentPane();
		
		pan1 = new JPanel(new GridLayout (1,1));	
		//tab = new JTextArea(""+fct.afficherMedecin());				
							
		pan1.add(table);
		
		return contenu.add(pan1);
	}
	
	/*public void aj_medoc_prescrit() {
		System.out.println( textFieldAA1("nbre").getText());
		/*int i =Integer.parseInt(textFieldAA1("nbre").getText());					
		
		JPanel pan = new JPanel(new GridLayout (i,3));
		JPanel pan1 = new JPanel(new GridLayout (1,1));
		JPanel pan2 = new JPanel(new GridLayout (1,1));
		
		Container contenu = this.getContentPane();
		
		for(int j=0; j<i; j++) {
			pan.add(textFieldAA("Medicament"+j));
			pan.add(textFieldAA("Consultation"+j));
			pan.add(textFieldAA("Nombre de jours"+j));
		}	
		
		pan1.add(btn_aj_prescrit("Enregistrer"));
		pan2.add(pan);
		pan2.add(pan1);
		
		return contenu.add(pan2);
	}*/
	

	public void actionPerformed(ActionEvent e) {				
			
	}	

}
