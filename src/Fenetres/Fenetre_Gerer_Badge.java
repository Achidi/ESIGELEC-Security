package Fenetres;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Fenetre_Gerer_Badge extends JFrame {

	private JPanel contentPane;
	private Fenetre_Menu fenetre2 = null;
	private Fenetre_Recherche fenetre3 = null;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fenetre_Gerer_Badge frame = new Fenetre_Gerer_Badge();
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
	public Fenetre_Gerer_Badge() {
		this.setTitle("ESIGELEC Security - Gerer Badge");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 620, 605);
		contentPane = new JPanel_Background();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCreerBadge = new JButton("   Creer Badge");
		btnCreerBadge.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		Image icon1 = new ImageIcon(this.getClass().getResource("/add-business-card-symbol.png")).getImage();
		btnCreerBadge.setIcon(new ImageIcon(icon1));
		btnCreerBadge.addActionListener(new ActionListener() {
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
		btnCreerBadge.setBounds(172, 133, 279, 83);
		contentPane.add(btnCreerBadge);
		
		
		JButton btnSupprimerBadge = new JButton("  Supprimer Badge");
		btnSupprimerBadge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(fenetre3 == null) {
					fenetre3 = new Fenetre_Recherche();
					fenetre3.btnSupprimer.setEnabled(false);
					fenetre3.btnNewButton.setEnabled(false); 
					fenetre3.btnSupprimerBadge.setEnabled(true);
					
					fenetre3.setVisible(true);
				}
				else {
					
					fenetre3.setVisible(true);
				}
			}
		});
		btnSupprimerBadge.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		Image icon2 = new ImageIcon(this.getClass().getResource("/minus-sign-on-business-card.png")).getImage();
		btnSupprimerBadge.setIcon(new ImageIcon(icon2));
		btnSupprimerBadge.setBounds(172, 299, 279, 83);
		contentPane.add(btnSupprimerBadge);
		
		JButton btnRetour = new JButton("   Retour");
		Image icon3 = new ImageIcon(this.getClass().getResource("/left-arrow.png")).getImage();
		btnRetour.setIcon(new ImageIcon(icon3));
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
		btnRetour.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnRetour.setBounds(44, 502, 107, 38);
		contentPane.add(btnRetour);
	}

}
