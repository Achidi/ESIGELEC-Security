package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import ClassesJava.*;

public class LieuxDAO {
	
	/**
	 * Parametres de connexion à la base de données oracle URL, LOGIN et PASSWORD
	 * sont des constantes
	 */
	final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	final static String LOGIN = "Amiel"; 
	final static String PASSWORD = "Amiel0749"; 
	
	public LieuxDAO() {
	
	//Chargement du pilote de bases de données
	try {
		Class.forName("oracle.jdbc.OracleDriver");
		
	}catch (ClassNotFoundException e) {
				
		System.err.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
		}
	}

	public int creer_lieu( Lieu lieu ) {
		
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
				ps = connexion.prepareStatement("INSERT INTO LIEUX (IDLIEUX, EMPLACEMENT, HORAIRE_OUVERTURE, HORAIRE_FERMETURE, NBR_ACCES) VALUES (LIEUX_SEQUENCE.NEXTVAL, ?, ?, ?, ?)");
				ps.setString(1, lieu.getEmplacement());
				ps.setTime(2, lieu.getHoraireOuverture());
				ps.setTime(3, lieu.getHoraireFermerture());
				ps.setInt(4, lieu.getNombreAcces());

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
		
	public int modifier_lieu(Lieu lieu, String emplacement) {
		
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
				ps = connexion.prepareStatement("UPDATE LIEUX SET EMPLACEMENT = ?, HORAIRE_OUVERTURE = ?, HORAIRE_FERMETURE = ?, NBR_ACCES = ? WHERE EMPLACEMENT = ?");
				ps.setString(1, emplacement);
				ps.setTime(2, lieu.getHoraireOuverture());
				ps.setTime(3, lieu.getHoraireFermerture());
				ps.setInt(4, lieu.getNombreAcces());
				ps.setString(5, lieu.getEmplacement());
				
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
	
	public Lieu getLieu(String emplacement) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Lieu retour = null;

		// connexion Ã  la base de donnÃ©es
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASSWORD);
			ps = con.prepareStatement("SELECT * FROM LIEUX WHERE EMPLACEMENT = ?");
			ps.setString(1, emplacement);

			// on exÃ©cute la requÃªte
			// rs contient un pointeur situÃ© juste avant la premiÃ¨re ligne
			// retournÃ©e
			rs = ps.executeQuery();
			// passe Ã  la premiÃ¨re (et unique) ligne retournÃ©e
			if (rs.next())
				retour = new Lieu(rs.getString("EMPLACEMENT"),
						rs.getInt("NBR_ACCES"),
						rs.getTime("HORAIRE_FERMETURE"), rs.getTime("HORAIRE_OUVERTURE"));

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
	
	/*public ArrayList<Lieu> recuperer_liste_lieu(ArrayList<Lieu> Liste_lieu){
		return Liste_lieu;
		
	}*/
	
	
	// main permettant de tester la classe
		public static void main(String[] args) throws SQLException {

			LieuxDAO lieuxDAO = new LieuxDAO();
			Time open = new Time(9,0,0);
			Time close = new Time(10,0,0);
			// test de la mÃ©thode ajouter

			Lieu a1 = new Lieu("Armani", 2, open, close);
			
			int retour = lieuxDAO.creer_lieu(a1);

			System.out.println(retour + " Lieu créé");
			
			int modif = lieuxDAO.modifier_lieu(a1, "Charpak");
			
			System.out.println(modif + " Lieu modifié");

		}
}
