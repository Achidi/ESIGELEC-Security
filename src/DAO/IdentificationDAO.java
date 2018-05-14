package DAO;

import java.util.ArrayList;
import ClassesJava.*;

public class IdentificationDAO {
	
	/**
	 * Parametres de connexion à la base de données oracle URL, LOGIN et PASSWORD
	 * sont des constantes
	 */
	final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	final static String LOGIN = "Amiel"; 
	final static String PASSWORD = "Amiel0749"; 
	
	public IdentificationDAO() {
	//Chargement du pilote de bases de données
	try {
		Class.forName("oracle.jdbc.OracleDriver");
				
	}catch (ClassNotFoundException e) {
						
		System.err.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
			}	
	}

	public ArrayList<Identification> recuperer_id (ArrayList<Identification> Liste_id){
		return Liste_id;
		
	}
}
