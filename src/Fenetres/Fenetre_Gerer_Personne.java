package Fenetres;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Fenetre_Gerer_Personne extends JFrame {

	private JPanel contentPane;
	private Fenetre_Creer_Personne fenetre1 = null;
	private Fenetre_Recherche fenetre3 = null;
	private Fenetre_Menu fenetre2 = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fenetre_Gerer_Personne frame = new Fenetre_Gerer_Personne();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Fenetre_Gerer_Personne() {
		this.setTitle("ESIGELEC Security - Gerer Personne");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 100, 620, 605);
		contentPane = new JPanel_Background();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnCreation = new JButton("       Creation");
		btnCreation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(fenetre1 == null) {
					fenetre1 = new Fenetre_Creer_Personne(); 
					fenetre1.btnEnregistrer.setEnabled(true);
					fenetre1.btnModifier.setEnabled(false);
					
					fenetre1.setVisible(true);
				}
				else {
					
					fenetre1.setVisible(true);
				}	
				
			}
		});
		btnCreation.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		Image icon1 = new ImageIcon(this.getClass().getResource("/user-create.png")).getImage();
		btnCreation.setIcon(new ImageIcon(icon1));
		btnCreation.setBounds(176, 108, 247, 70);
		contentPane.add(btnCreation);
		
		
		JButton btnRetour = new JButton("  Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(fenetre2 == null) {
					fenetre2 = new Fenetre_Menu(); 
					
					fenetre2.setVisible(true);
				}
				else {
					
					fenetre2.setVisible(true);
				}		
				
			}
		});
		Image icon2 = new ImageIcon(this.getClass().getResource("/left-arrow.png")).getImage();
		btnRetour.setIcon(new ImageIcon(icon2));
		btnRetour.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnRetour.setBounds(44, 502, 107, 38);
		contentPane.add(btnRetour);
		
		
		JButton btnModification = new JButton("   Modification");
		btnModification.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		Image icon3 = new ImageIcon(this.getClass().getResource("/user-update.png")).getImage();
		btnModification.setIcon(new ImageIcon(icon3));
		btnModification.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(fenetre3 == null) {
					fenetre3 = new Fenetre_Recherche();
					fenetre3.btnSupprimer.setEnabled(false);
					fenetre3.btnNewButton.setEnabled(true);
					fenetre3.btnSupprimerBadge.setEnabled(false);
					
					fenetre3.setVisible(true);
				}
				else {
					
					fenetre3.setVisible(true);
				}
				
			}
		});
		btnModification.setBounds(176, 225, 247, 70);
		contentPane.add(btnModification);
		
		
		JButton btnSupression = new JButton("      Suppression");
		btnSupression.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(fenetre3 == null) {
					fenetre3 = new Fenetre_Recherche();
					fenetre3.btnSupprimer.setEnabled(true);
					fenetre3.btnNewButton.setEnabled(false); 
					fenetre3.btnSupprimerBadge.setEnabled(true);
					
					fenetre3.setVisible(true);
					
				}
				else {
					
					fenetre3.setVisible(true);
				}	
			}
		});
		btnSupression.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		Image icon4 = new ImageIcon(this.getClass().getResource("/user-delete.png")).getImage();
		btnSupression.setIcon(new ImageIcon(icon4));
		btnSupression.setBounds(176, 349, 247, 70);
		contentPane.add(btnSupression);
	}
}
