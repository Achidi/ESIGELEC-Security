package Handwritted_not_used;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Fenetres.Fenetre_Menu;
 
public class JPanel_Authentification extends JPanel implements ActionListener{ 
	
	/*****************************
	 * DECLARATION DES ATTRIBUTS *
	 *                           *
	 ****************************/
	private JLabel identifiant = new JLabel ("Identifiant:");
	private JLabel mot_de_passe = new JLabel ("Mot de passe:");
	private JTextField blocIdentifiant = new JTextField();
	private JPasswordField blocMot_de_passe = new JPasswordField();
	private JButton Bouton = new JButton("Se Connecter");
	private Fenetre_Menu Application = null;
	

	/**
	 * Police attribuée aux JLabel
	 */
	Font police = new Font("ARIAL", Font.BOLD, 16);
	
	 /**
	  * Recuperation de l'image de fond de la Fenetre
	  */ 
    File fichier = new File("C:/Users/Amiel Dylan/Desktop/Developpement/Projet Devellopement Logiciel/Image5.png"); 
    
    
    /********************************
     * METHODE DE GESTION DU JPanel *
     *                              *
     ********************************/
    public void paintComponent(Graphics image){
    	
		 try {
		   // Creation d'un objet de type Image a partir du fichier
		   Image Background = ImageIO.read(fichier);
		   
		   //Insertion et dessin de l'image en tant que image de fond d'ecran
		   image.drawImage(Background, 0, 0,this.getWidth(), this.getHeight(), this);
	  	   }
	   catch(IOException e) {
		   System.out.println("Fichier image non trouvé!");
	   } 
		 
		 
	    //Attribution des polices aux JLabel
	    identifiant.setFont(police);
	    
	    mot_de_passe.setFont(police);
	    
	    //Positionnement des éléments sur le JPanel
	    identifiant.setBounds(280,200,200,100);
	    
		mot_de_passe.setBounds(280,280,200,100);
		
		Bouton.setBounds(387,420,130,30);
		
		blocIdentifiant.setBounds(400, 237, 240, 25);
		
		blocMot_de_passe.setBounds(400, 317, 240, 25);
	   
		//Ajout des compoants sut le JPanel
	    this.add(identifiant);
	    this.add(blocIdentifiant);
	    this.add(mot_de_passe);
	    this.add(blocMot_de_passe);
	    this.add(Bouton);
	    
	   // ajout des écouteurs sur le boutons pour gérer les évènements
	  Bouton.addActionListener(this);
    
	  }
    
	public void actionPerformed(ActionEvent e) {
		
		try {
			if (e.getSource() == Bouton) {
				if(Application == null) {
					Application = new Fenetre_Menu();
				}
				else {
					Application.setVisible(true);
				}
			   }
			}
			catch (Exception ae) {
				JOptionPane.showMessageDialog(this,
						"Veuillez reprendre l'opération", "Erreur",
						JOptionPane.ERROR_MESSAGE);
				System.err.println("Veuillez reprendre l'opération");
			}
	} 
    
}