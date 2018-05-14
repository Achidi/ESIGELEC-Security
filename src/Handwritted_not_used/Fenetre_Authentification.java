package Handwritted_not_used;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


public class Fenetre_Authentification extends JFrame{

	private JPanel_Authentification Panneau = new JPanel_Authentification();
	

	public Fenetre_Authentification() {
			
			//Definit un titre pour la fenetre
			this.setTitle("ESIGELEC Security");
			
			//La fenetre ne dispose d'aucun Layout Manager
			this.setLayout(null);
			
			//Definit une taille pour la fenetre
			this.setSize(900, 600);
			
			//Definit la position de la fenetre par rapport a l'ecran
			this.setLocationRelativeTo(null);
			
			//Permet le redimensionnement de la fenetre
			this.setResizable(false);
			
			this.setContentPane(Panneau);
			
			//Arrete le programme a la sortie
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			//Affiche la fenetre
			this.setVisible(true);
		}
	
	public static void main(String[] args) {
		new Fenetre_Authentification();
	}
		
}

