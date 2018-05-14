package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import ClassesJava.*;
import java.sql.*;

public class PersonneDAO {
	
	/**
	 * Parametres de connexion � la base de donn�es oracle URL, LOGIN et PASSWORD
	 * sont des constantes
	 */
	final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	final static String LOGIN = "Amiel"; 
	final static String PASSWORD = "Amiel0749";
	
	public PersonneDAO() {
	
	//Chargement du pilote de bases de donn�es
	
	try {
		Class.forName("oracle.jdbc.OracleDriver");
			
	}catch (ClassNotFoundException e) {
			
		System.err.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
		}
	}

	/**
	 * Permet d'ajouter une personne dans la table personne Le mode est auto-commit
	 * donc par d�faut chaque insertion est valid�e
	 * 
	 * @param personne
	 *            la personne�� ajouter
	 * @return 
	 * @return retourne un message de confirmation d'ajout
	 */
	public int  inserer_personne(Personne personne) {
		Connection connexion = null;
		PreparedStatement ps = null;
		
		//Variable permettant de confirmer la fin du processus
		int retour = 0;

		// Connexion � la Base de donn�es

		try {
			// Tentative de connexion
			connexion = DriverManager.getConnection(URL, LOGIN, PASSWORD);
			// Pr�paration de l'instruction SQL: chaque "?" repr�sente une valeur
			// � communiquer dans l'insertion
			// Les getters permettent de r�cuperer les valeurs des attributs
			// souhait�s
				ps = connexion.prepareStatement("INSERT INTO PERSONNES (IDPERSONNE, NOM, PRENOM, DATE_DE_NAISSANCE, FONCTION) VALUES (PERSONNES_SEQUENCE.NEXTVAL, ?, ?, ?, ?)");
				ps.setString(1, personne.getNom());
				ps.setString(2, personne.getPrenom());
				ps.setDate(3, personne.getDateDeNaissance());
				ps.setString(4, personne.getFonction());

				// Ex�cution de la requete
				retour = ps.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// fermeture du preparedStatement et de la connexion
				try {
					if (ps != null)
						ps.close();
				} catch (Exception ignore) {
				}
				try {
					if (connexion != null)
						connexion.close();
				} catch (Exception ignore) {
				}
			}
			return retour;
	}
	
	public int supprimer_personne(Personne personne) {
		Connection connexion = null;
		PreparedStatement ps = null;
		
		//Variable permettant de confirmer la fin du processus
		int retour = 0;

		// Connexion � la Base de donn�es

		try {
			// Tentative de connexion
			connexion = DriverManager.getConnection(URL, LOGIN, PASSWORD);
			// 
			// 
			// 
			// 
				ps = connexion.prepareStatement("DELETE FROM PERSONNES WHERE NOM = ? AND PRENOM = ?" );		
				
				ps.setString(1, personne.getNom());
				ps.setString(2, personne.getPrenom());

				// Ex�cution de la requete
				retour = ps.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// fermeture du preparedStatement et de la connexion
				try {
					if (ps != null)
						ps.close();
				} catch (Exception ignore) {
				}
				try {
					if (connexion != null)
						connexion.close();
				} catch (Exception ignore) {
				}
			}
			return retour;
	}
	
	public Personne getPersonne(String nom, String prenom) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Personne retour = null;

		// connexion à la base de données
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
			ps = con.prepareStatement("SELECT * FROM PERSONNES WHERE NOM = ? AND PRENOM = ?");
			ps.setString(1, nom);
			ps.setString(2, prenom);

			// on exécute la requête
			// rs contient un pointeur situé juste avant la première ligne
			// retournée
			rs = ps.executeQuery();
			// passe à la première (et unique) ligne retournée
			if (rs.next())
				retour = new Personne(rs.getString("NOM"),
						rs.getString("PRENOM"),
						rs.getDate("DATE_DE_NAISSANCE"), rs.getString("FONCTION"));

		} catch (Exception ee) {
			
			ee.printStackTrace();

		} finally {
			// fermeture du ResultSet, du PreparedStatement et de la Connexion
			try {
				if (rs != null)
					rs.close();
			} catch (Exception ignore) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ignore) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ignore) {
			}
		}
		return retour;

	}
	
	public int get_Id_Personne(String nom, String prenom) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int retour = 0;

		// connexion à la base de données
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
			ps = con.prepareStatement("SELECT IDPERSONNE FROM PERSONNES WHERE NOM = ? AND PRENOM = ?");
			ps.setString(1, nom);
			ps.setString(2, prenom);

			// on exécute la requête
			// rs contient un pointeur situé juste avant la première ligne
			// retournée
			rs = ps.executeQuery();
			// passe à la première (et unique) ligne retournée
			if (rs.next())
				retour = rs.getInt("IDPERSONNE");

		} catch (Exception ee) {
			
			ee.printStackTrace();
			
		} finally {
			// fermeture du ResultSet, du PreparedStatement et de la Connexion
			try {
				if (rs != null)
					rs.close();
			} catch (Exception ignore) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ignore) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ignore) {
			}
		}
		return retour;

	}

	public int modifier_personne(Personne personne1, String nom, String prenom) {
		
		Connection connexion = null;
		PreparedStatement ps = null;
		
		//Variable permettant de confirmer la fin du processus
		int retour = 0;

		// Connexion � la Base de donn�es

		try {
			// Tentative de connexion
			connexion = DriverManager.getConnection(URL, LOGIN, PASSWORD);
			// Pr�paration de l'instruction SQL: chaque "?" repr�sente une valeur
			// � communiquer dans l'insertion
			// Les getters permettent de r�cuperer les valeurs des attributs
			// souhait�s
				ps = connexion.prepareStatement("UPDATE PERSONNES SET NOM = ?, PRENOM = ?, DATE_DE_NAISSANCE = ?, FONCTION = ? WHERE NOM = ? AND PRENOM = ?");
				ps.setString(1, nom);
				ps.setString(2, prenom);
				ps.setDate(3, personne1.getDateDeNaissance());
				ps.setString(4, personne1.getFonction());
				ps.setString(5,  personne1.getNom());
				ps.setString(6, personne1.getPrenom());
				// Ex�cution de la requete
				retour = ps.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// fermeture du preparedStatement et de la connexion
				try {
					if (ps != null)
						ps.close();
				} catch (Exception ignore) {
				}
				try {
					if (connexion != null)
						connexion.close();
				} catch (Exception ignore) {
				}
			}
			return retour;
	}

	
	/**
	 * Permet de r�cuperer tous les articles stock�s de la table personne
	 * 
	 * @return une ArrayList d'Articles
	 * 
	 * 
	 */
	
	public List<Personne> getListePersonne(){
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Personne> retour = new ArrayList<Personne>();

		// connexion � la base de donn�es
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
			ps = con.prepareStatement("SELECT * FROM PERSONNES");

			// on ex�cute la requete
			rs = ps.executeQuery();
			
			// on parcourt les lignes du r�sultat
			while (rs.next())
				retour.add(new Personne(rs.getString("NOM"), rs
						.getString("PRENOM"), rs
						.getDate("DATE_DE_NAISSANCE"), rs.getString("FONCTION")));

		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			// fermeture du rs, du preparedStatement et de la connexion
			try {
				if (rs != null)
					rs.close();
			} catch (Exception ignore) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ignore) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ignore) {
			}
		}
		return retour;
		
	}
  
	// main permettant de tester la classe
	public static void main(String[] args) throws SQLException {

		PersonneDAO personneDAO = new PersonneDAO();
		// test de la méthode ajouter
		
		Date date = new Date(0,11,15);
	
		Personne a1 = new Personne("Tom", "Cruise", date, "Prof");
		
		int ins = personneDAO.inserer_personne(a1);
		
		Personne a2 = personneDAO.getPersonne(a1.getNom(), a1.getPrenom());
		
		System.out.println(a2.afficher());
		
		//int test = personneDAO.supprimer_personne(a2);
		//System.out.println(test + " personne supprim�e");
	}
	
}

