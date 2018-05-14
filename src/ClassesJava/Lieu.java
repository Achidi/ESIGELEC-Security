package ClassesJava;

public class Lieu {
	
	private String emplacement;
	private int nombreAcces;
	private java.sql.Time horaireOuverture;
	private java.sql.Time horaireFermerture;
	
	public Lieu() {}
	
	public Lieu(String emplacement, int nombreAcces, java.sql.Time horaireOuverture, java.sql.Time horaireFermerture) {
		this.emplacement = emplacement;
		this.nombreAcces = nombreAcces;
		this.horaireOuverture = horaireOuverture;
		this.horaireFermerture = horaireFermerture;
	}
	
	
	public int getNombreAcces() {
		return nombreAcces;
	}
	
	
	public void setNombreAcces(int nombreAcces) {
		this.nombreAcces = nombreAcces;
	}
	
	
	public java.sql.Time getHoraireOuverture() {
		return horaireOuverture;
	}
	
	
	public void setHoraireOuverture(java.sql.Time horaireOuverture) {
		this.horaireOuverture = horaireOuverture;
	}
	
	
	public java.sql.Time getHoraireFermerture() {
		return horaireFermerture;
	}
	
	
	public void setHoraireFermerture(java.sql.Time horaireFermerture) {
		this.horaireFermerture = horaireFermerture;
	}

	
	public String getEmplacement() {
		return emplacement;
	}
	
	
	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}

	
	public String afficher () {
		String afficher = ("Emplacement : " + emplacement + " Nombre d'acces : " + nombreAcces +" Horaire d'ouverture " + horaireOuverture + " Horaire de fermerture : " + horaireFermerture);
		return afficher;
	}
}
