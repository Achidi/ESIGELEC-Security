package Handwritted_not_used;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
 
public class JPanel_Application extends JPanel implements ActionListener{
	public JPanel_Application() {
	} 
	
	private JButton Bouton1 = new JButton("Gestion des Personnes");
	private JButton Bouton2 = new JButton("Gestion des Badges");
	private JButton Bouton3 = new JButton("Gestion des Lieux");
	private JButton Bouton4 = new JButton("Reporting");
	private JButton Bouton5 = new JButton("Retour");
	private Fenetre_Gerer_Personne GererPersonne = null;
	private Fenetre_Gerer_Badge Badge = null;
	private Fenetre_Gerer_Lieux Lieux = null;
	private Fenetre_Authentification Authentification = null;
	
	 // Recuperation de l'image de fond de la Fenetre
    File fichier = new File("C:/Users/Amiel Dylan/Desktop/Developpement/Projet Devellopement Logiciel/Image3.png"); 
    
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
       
    // introduire une espace constant entre les differents champs
       
       Bouton1.setBounds(250,70,400,50);
	   this.add(Bouton1);
	   Bouton2.setBounds(250,170,400,50);
	   this.add(Bouton2);
	   Bouton3.setBounds(250,270,400,50);
	   this.add(Bouton3);
	   Bouton4.setBounds(250,370,400,50);
	   this.add(Bouton4);
	   Bouton5.setBounds(250,520,100,30);
	   this.add(Bouton5);
	   
	   Bouton1.addActionListener(this);
	   Bouton2.addActionListener(this);
	   Bouton3.addActionListener(this);
	   Bouton4.addActionListener(this);
	   Bouton5.addActionListener(this);
	   
	  } 
    	
    public void actionPerformed(ActionEvent ea) {
		
		try {
			if (ea.getSource() == Bouton1) {
				if(GererPersonne == null) {
					GererPersonne = new Fenetre_Gerer_Personne();
				}
				else {
					GererPersonne.setVisible(true);
				}
			   }
			
			if (ea.getSource() == Bouton2) {
				if(Badge == null) {
					Badge = new Fenetre_Gerer_Badge();
				}
				else {
					Badge.setVisible(true);
				}
			   }
			
			if (ea.getSource() == Bouton3) {
				if(Lieux == null) {
					Lieux = new Fenetre_Gerer_Lieux();
				}
				else {
					Lieux.setVisible(true);
				}
			   }
			
			if (ea.getSource() == Bouton4) {}
			
			if (ea.getSource() == Bouton5) {
				if(Authentification == null) {
					Authentification = new Fenetre_Authentification();
				}
				else {
					Authentification.setVisible(true);
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