package ClassesJava;

import DAO.PersonneDAO;

public class Badge {

		private int idpersonne;
		
		
		public Badge() {}
		
		public Badge(int idpersonne) {
	
			this.idpersonne = idpersonne;
		}


		public int getIdpersonne() {
			return idpersonne;
		}

		
		/*public void afficher () {
			System.out.print("id_Badge : " + idBadge + "\nProprietaire : " + personne.afficher());
		}*/
}
