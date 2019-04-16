package packproj;

import java.sql.*;
import com.mysql.jdbc.Statement;

import java.awt.Component;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

public class Fonctions {
	Testmysql ts = new Testmysql();
	ResultSet rslt ;
	String nbre;
	String pseudo;
	String mdp;
	String matricule;
	String nom;
	String num_ss;
	
	
	
	public void ajouter_medecin(int matricule, String nom_med) {
		try {  
			String nm = "INSERT INTO medecin VALUES (?,?)";
            PreparedStatement p;
            p = ts.sqlconnect().prepareStatement(nm);
            p.setInt(1, matricule);
            p.setString(2, nom_med);
            p.executeUpdate();
            p.close();
            ts.sqlconnect().close();
        } 
		
		catch (SQLException e) {
        }		
	}
	
	public void ajouter_cslt(int numero, String date, String motifs, int mat, int num_pat) {
		try {  
			String nm = "INSERT INTO consultation VALUES(?,?,?,?,?)";
            PreparedStatement p;
            p = ts.sqlconnect().prepareStatement(nm);
            p.setInt(1, numero);
            p.setString(2, date);
            p.setString(3, motifs);
            p.setInt(4, mat);
            p.setInt(5, num_pat);
            p.executeUpdate();
            p.close();
            ts.sqlconnect().close();
        } 
		
		catch (SQLException e) {
        }		
	}
	
	
	public void ajouter_medoc(String code, String libelle, String indications, String posologie) {
		try {  
			String nm = "INSERT INTO medicament VALUES (?,?,?,?)";
            PreparedStatement p;
            p = ts.sqlconnect().prepareStatement(nm);
            p.setString(1, code);
            p.setString(2, libelle);
            p.setString(3, indications);
            p.setString(4, posologie);
            p.executeUpdate();
            p.close();
            ts.sqlconnect().close();
        } 
		
		catch (SQLException e) {
        }		
	}
	
	public void ajouter_patient(int num_ss, String nom_pat) {
		try {  
			String nm = "INSERT INTO patient VALUES (?,?)";
            PreparedStatement p;
            p = ts.sqlconnect().prepareStatement(nm);
            p.setInt(1, num_ss);
            p.setString(2, nom_pat);
            p.executeUpdate();
            p.close();
            ts.sqlconnect().close();
        } 
		
		catch (SQLException e) {
        }		
	}
	
	public String afficherNbreMed() {
		try {
			Statement stmt = (Statement) ts.sqlconnect().createStatement();
			rslt = stmt.executeQuery("SELECT count(*)from medecin");						
			while (rslt.next()) {
                 nbre = rslt.getString(1);
            }		
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return nbre;
	}
	
	public String afficherNbreMedoc() {
		try {
			java.sql.Statement stmt = ts.sqlconnect().createStatement();
			rslt = stmt.executeQuery("SELECT count(*)from medicament");						
			while (rslt.next()) {
                nbre = rslt.getString(1);
            }
			ts.sqlconnect().close();
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return nbre;
	}
	
	public String afficherNbreCslt() {
		try {
			java.sql.Statement stmt = ts.sqlconnect().createStatement();
			rslt = stmt.executeQuery("SELECT count(*)from consultation");						
			while (rslt.next()) {
                nbre = rslt.getString(1);
            }
			ts.sqlconnect().close();
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return nbre;
	}
	
	public String afficherNbrePat() {
		try {
			java.sql.Statement stmt = ts.sqlconnect().createStatement();
			rslt = stmt.executeQuery("SELECT count(*)from patient");						
			while (rslt.next()) {
                nbre = rslt.getString(1);
            }
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return nbre;
	}
	
	public String pseudo() {
		try {
			java.sql.Statement stmt = ts.sqlconnect().createStatement();
			rslt = stmt.executeQuery("SELECT pseudo_admin from administrateur");						
			while (rslt.next()) {
                pseudo = rslt.getString(1);                
            }			
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pseudo;
	}
	
	public String mdp() {
		try {
			java.sql.Statement stmt = ts.sqlconnect().createStatement();
			rslt = stmt.executeQuery("SELECT mdp_admin from administrateur");						
			while (rslt.next()) {
                mdp = rslt.getString(1);                
            }			
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return mdp;
	}
	
	public String[][] afficherPatient() {
		int i=0; 
		String table[][]= new String[10][2];
		try {						
			java.sql.Statement stmt = ts.sqlconnect().createStatement();
			rslt = stmt.executeQuery("SELECT * from patient");					

			while (rslt.next()) {
				matricule= rslt.getString("num_ss");	
				nom= rslt.getString("nom_p");				
				
				table[i][0]=matricule;
				table[i][1]=nom;
				i++;	
			} 
							
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return table;
	}
	
	public String[] retourNumMed() {
		int i=0; 
		String table[]=new String[2];
		try {						
			java.sql.Statement stmt = ts.sqlconnect().createStatement();
			rslt = stmt.executeQuery("SELECT matricule from medecin");					

			while (rslt.next()) {
				matricule= rslt.getString("matricule");	
												
				table[i]=matricule;				
				i++;	
			} 							
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return table;
	}
	
	public String[] retourNumPat() {
		int i=0; 
		String table[]=new String[1];
		try {						
			java.sql.Statement stmt = ts.sqlconnect().createStatement();
			rslt = stmt.executeQuery("SELECT num_ss from patient");					

			while (rslt.next()) {
				num_ss= rslt.getString("num_ss");	
												
				table[i]=num_ss;				
				i++;	
			} 							
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return table;
	}
	
	
	
}
