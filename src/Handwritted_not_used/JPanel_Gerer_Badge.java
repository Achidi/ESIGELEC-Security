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
 
public class JPanel_Gerer_Badge extends JPanel implements ActionListener{ 
	
	private JButton Bouton1 = new JButton("Créer");
	private JButton Bouton2 = new JButton("Bloquer");
	private JButton Bouton3 = new JButton("Supprimer");
	private JButton Bouton4 = new JButton("Retour");
	private Fenetre_Application Application = null;
	
	 // Recuperation de l'image de fond de la Fenetre
    File fichier = new File("C:/Users/Amiel Dylan/Desktop/Developpement/Projet Devellopement Logiciel/Image3.png"); 
    
    public void paintComponent(Graphics image){
	
       
    // introduire une espace constant entre les differents champs
       
       Bouton1.setBounds(250,70,400,50);
	   this.add(Bouton1);
	   Bouton2.setBounds(250,170,400,50);
	   this.add(Bouton2);
	   Bouton3.setBounds(250,270,400,50);
	   this.add(Bouton3);
	   Bouton4.setBounds(250,520,100,30);
	   this.add(Bouton4);
	   
    
	   try {
		   // Creation d'un objet de type Image a partir du fichier
		   Image Background = ImageIO.read(fichier);
		   
		   //Insertion et dessin de l'image en tant que image de fond d'ecran
		   image.drawImage(Background, 0, 0,this.getWidth(), this.getHeight(), this);
	  	   }
	   catch(IOException e) {
		   System.out.println("Fichier image non trouvé!");
	   } 
	   
	   Bouton1.addActionListener(this);
	   Bouton2.addActionListener(this);
	   Bouton3.addActionListener(this);
	   Bouton4.addActionListener(this);
	  } 
    
public void actionPerformed(ActionEvent ea) {
		
		try {
			//if (ea.getSource() == Bouton1) {}

			if (ea.getSource() == Bouton2) {
				if(Bouton2.getText() == "Bloquer") {
					Bouton2.setText("Debloquer");
				}
				else if(Bouton2.getText() == "Debloquer") {
					Bouton2.setText("Bloquer");
				}
				Bouton2.repaint();
			   }
			
			//if (ea.getSource() == Bouton3) {}
			
			if (ea.getSource() == Bouton4) {
				if(Application == null) {
					Application = new Fenetre_Application();
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
