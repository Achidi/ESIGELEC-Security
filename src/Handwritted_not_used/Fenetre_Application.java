package Handwritted_not_used;
import javax.swing.JFrame;


public class Fenetre_Application extends JFrame {

	private JPanel_Application Panneau = new JPanel_Application();

	public Fenetre_Application() {
			
			//Definit un titre pour la fenetre
			this.setTitle("Application");
			
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
		new Fenetre_Application();
	}

}

