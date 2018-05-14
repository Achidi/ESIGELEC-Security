package ClassesJava;

import java.sql.Date;

public class Personne {
	
	private String nom = new String();
	private String prenom = new String();
	private Date dateDeNaissance;
	private String fonction = new String();
	
	public Personne() {}
	
	public Personne(String nom, String prenom, Date dateDeNaissance, String fonction) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.fonction = fonction;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}


	public String afficher() {
		
	String s = ("NOM : "+ nom + "  PRENOM : " + prenom + "  Date de Naissance : " + dateDeNaissance + " , " + fonction);
	
		return s;
		
	}
}
