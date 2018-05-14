package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ClassesJava.*;

public class BadgeDAO {
	
	/**
	 * Parametres de connexion � la base de donn�es oracle URL, LOGIN et PASSWORD
	 * sont des constantes
	 */
	final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	final static String LOGIN = "Amiel"; 
	final static String PASSWORD = "Amiel0749"; 
	
	public BadgeDAO() {
	//Chargement du pilote de bases de donn�es
	try {
		Class.forName("oracle.jdbc.OracleDriver");
			
	}catch (ClassNotFoundException e) {
					
		System.err.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
			}
	}

	public int inserer_badge(Badge badge) {
			
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
				ps = connexion.prepareStatement("INSERT INTO BADGE (IDBADGE, IDPERSONNE_BADGE) VALUES (BADGES_SEQUENCE.NEXTVAL, ?)");
				ps.setInt(1, badge.getIdpersonne());
				

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
	
	public int supprimer_badge(Badge badge) {
		
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
				ps = connexion.prepareStatement("DELETE FROM BADGE WHERE IDPERSONNE_BADGE = ?" );		
				
				ps.setInt(1, badge.getIdpersonne());

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
	
	public Badge getBadge(int idpersonne) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Badge retour = null;

		// connexion à la base de données
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
			ps = con.prepareStatement("SELECT * FROM BADGE WHERE IDPERSONNE_BADGE = ?");
			ps.setInt(1, idpersonne);

			// on exécute la requête
			// rs contient un pointeur situé juste avant la première ligne
			// retournée
			rs = ps.executeQuery();
			// passe à la première (et unique) ligne retournée
			if (rs.next())
				retour = new Badge(rs.getInt("IDPERSONNE_BADGE"));

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
	
	/*public List<Badge> recuperer_liste_badge(){
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Badge> Liste_badge = new ArrayList<Badge>();

		
		return Liste_badge;
		
	}*/
	
	// main permettant de tester la classe
		public static void main(String[] args) throws SQLException {

			PersonneDAO personneDAO = new PersonneDAO();
			BadgeDAO badgeDAO = new BadgeDAO();
			Badge badge;
			// test de la méthode ajouter
			Date date = new Date(1997,11,15);
			
			Personne a1 = new Personne("Paul", "AMELI", date, "Ecoliere");
			
			int ins = personneDAO.inserer_personne(a1);
			
		//	System.out.println(ins + " Personne cr��e et ");
			
			Personne a2 = personneDAO.getPersonne(a1.getNom(), a1.getPrenom());
			
			//a2.afficher();
			/*int ins = personneDAO.inserer_personne(a1);
			
			int id = personneDAO.get_Id_Personne(a1.getNom(), a1.getPrenom());
			
			badge = new Badge(id);
			
			int retour = badgeDAO.inserer_badge(badge);
			
			System.out.println(ins + " Personne cr��e et " + retour + " Badge cr��");
			
			System.out.println(ins + " Personne cr��e" + " id : " + personneDAO.get_Id_Personne(a1.getNom(), a1.getPrenom()));*/
			
			

		}
	
	
}
