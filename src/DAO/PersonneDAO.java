package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import ClassesJava.*;
import java.sql.*;

public class PersonneDAO {
	
	/**
	 * Parametres de connexion à la base de données oracle URL, LOGIN et PASSWORD
	 * sont des constantes
	 */
	final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	final static String LOGIN = "Amiel"; 
	final static String PASSWORD = "Amiel0749";
	
	public PersonneDAO() {
	
	//Chargement du pilote de bases de données
	
	try {
		Class.forName("oracle.jdbc.OracleDriver");
			
	}catch (ClassNotFoundException e) {
			
		System.err.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
		}
	}

	/**
	 * Permet d'ajouter une personne dans la table personne Le mode est auto-commit
	 * donc par défaut chaque insertion est validée
	 * 
	 * @param personne
	 *            la personne à ajouter
	 * @return 
	 * @return retourne un message de confirmation d'ajout
	 */
	public int  inserer_personne(Personne personne) {
		Connection connexion = null;
		PreparedStatement ps = null;
		
		//Variable permettant de confirmer la fin du processus
		int retour = 0;

		// Connexion à la Base de données

		try {
			// Tentative de connexion
			connexion = DriverManager.getConnection(URL, LOGIN, PASSWORD);
			// Préparation de l'instruction SQL: chaque "?" représente une valeur
			// à communiquer dans l'insertion
			// Les getters permettent de récuperer les valeurs des attributs
			// souhaités
				ps = connexion.prepareStatement("INSERT INTO PERSONNES (IDPERSONNE, NOM, PRENOM, DATE_DE_NAISSANCE, FONCTION) VALUES (PERSONNES_SEQUENCE.NEXTVAL, ?, ?, ?, ?)");
				ps.setString(1, personne.getNom());
				ps.setString(2, personne.getPrenom());
				ps.setDate(3, personne.getDateDeNaissance());
				ps.setString(4, personne.getFonction());

				// Exécution de la requete
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

		// Connexion à la Base de données

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

				// Exécution de la requete
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

		// connexion Ã  la base de donnÃ©es
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
			ps = con.prepareStatement("SELECT * FROM PERSONNES WHERE NOM = ? AND PRENOM = ?");
			ps.setString(1, nom);
			ps.setString(2, prenom);

			// on exÃ©cute la requÃªte
			// rs contient un pointeur situÃ© juste avant la premiÃ¨re ligne
			// retournÃ©e
			rs = ps.executeQuery();
			// passe Ã  la premiÃ¨re (et unique) ligne retournÃ©e
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

		// connexion Ã  la base de donnÃ©es
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
			ps = con.prepareStatement("SELECT IDPERSONNE FROM PERSONNES WHERE NOM = ? AND PRENOM = ?");
			ps.setString(1, nom);
			ps.setString(2, prenom);

			// on exÃ©cute la requÃªte
			// rs contient un pointeur situÃ© juste avant la premiÃ¨re ligne
			// retournÃ©e
			rs = ps.executeQuery();
			// passe Ã  la premiÃ¨re (et unique) ligne retournÃ©e
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

		// Connexion à la Base de données

		try {
			// Tentative de connexion
			connexion = DriverManager.getConnection(URL, LOGIN, PASSWORD);
			// Préparation de l'instruction SQL: chaque "?" représente une valeur
			// à communiquer dans l'insertion
			// Les getters permettent de récuperer les valeurs des attributs
			// souhaités
				ps = connexion.prepareStatement("UPDATE PERSONNES SET NOM = ?, PRENOM = ?, DATE_DE_NAISSANCE = ?, FONCTION = ? WHERE NOM = ? AND PRENOM = ?");
				ps.setString(1, nom);
				ps.setString(2, prenom);
				ps.setDate(3, personne1.getDateDeNaissance());
				ps.setString(4, personne1.getFonction());
				ps.setString(5,  personne1.getNom());
				ps.setString(6, personne1.getPrenom());
				// Exécution de la requete
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
	 * Permet de récuperer tous les articles stockés de la table personne
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

		// connexion à la base de données
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
			ps = con.prepareStatement("SELECT * FROM PERSONNES");

			// on exécute la requete
			rs = ps.executeQuery();
			
			// on parcourt les lignes du résultat
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
		// test de la mÃ©thode ajouter
		
		Date date = new Date(0,11,15);
	
		Personne a1 = new Personne("Tom", "Cruise", date, "Prof");
		
		int ins = personneDAO.inserer_personne(a1);
		
		Personne a2 = personneDAO.getPersonne(a1.getNom(), a1.getPrenom());
		
		System.out.println(a2.afficher());
		
		//int test = personneDAO.supprimer_personne(a2);
		//System.out.println(test + " personne supprimée");
	}
	
}

