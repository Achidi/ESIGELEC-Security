	package Fenetres;


	import java.awt.Graphics;
	import java.awt.Image;
	import java.io.File;
	import java.io.IOException;
	import javax.imageio.ImageIO;
	import javax.swing.JPanel;
	 
	public class JPanel_Background_Authentification extends JPanel{ 

		
		 // Recuperation de l'image de fond de la Fenetre
	    File fichier = new File("C:/Users/Amiel Dylan/Desktop/Developpement/Projet Devellopement Logiciel/Image1 - Copie.png"); 
	    
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
		  } 
	    }

