package Fenetres;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

public class Fenetre_Gerer_Lieux extends JFrame {

	private JPanel contentPane;
	private Fenetre_Creer_Lieu fenetre1 = null; 
	private Fenetre_Recherche_Lieux fenetre2 = null;
	private Fenetre_Menu fenetre3 = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fenetre_Gerer_Lieux frame = new Fenetre_Gerer_Lieux();
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
	public Fenetre_Gerer_Lieux() {
		this.setTitle("ESIGELEC Security - Gerer Lieux");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 100, 620, 605);
		contentPane = new JPanel_Background();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCreerLieu = new JButton(" Creer ");
		btnCreerLieu.setFont(new Font("Century Gothic", Font.BOLD, 20));
		btnCreerLieu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(fenetre1 == null) {
					fenetre1 = new Fenetre_Creer_Lieu();
					fenetre1.btnNewButton.setEnabled(true);
					fenetre1.btnModifier.setEnabled(false);
					
					fenetre1.setVisible(true);
				}
				else {
					
					fenetre1.setVisible(true);
				}		
				
			}
		});
		Image icon1 = new ImageIcon(this.getClass().getResource("/sketch.png")).getImage();
		btnCreerLieu.setIcon(new ImageIcon(icon1));
		btnCreerLieu.setBounds(188, 152, 237, 57);
		contentPane.add(btnCreerLieu);
		
		JButton btnModifier = new JButton(" Modifier");
		btnModifier.setFont(new Font("Century Gothic", Font.BOLD, 18));
		Image icon2 = new ImageIcon(this.getClass().getResource("/drawing-house-plan.png")).getImage();
		btnModifier.setIcon(new ImageIcon(icon2));
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(fenetre2 == null) {
					fenetre2 = new Fenetre_Recherche_Lieux(); 
					
					fenetre2.setVisible(true);
				}
				else {
					
					fenetre2.setVisible(true);
				}			
				
			}
		});
		btnModifier.setBounds(188, 300, 237, 57);
		contentPane.add(btnModifier);
		
		JButton btnRetour = new JButton(" Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(fenetre3 == null) {
					fenetre3 = new Fenetre_Menu(); 
					
					fenetre3.setVisible(true);
				}
				else {
					
					fenetre3.setVisible(true);
				}	
				
			}
		});
		btnRetour.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		Image icon21 = new ImageIcon(this.getClass().getResource("/left-arrow.png")).getImage();
		btnRetour.setIcon(new ImageIcon(icon21));
		btnRetour.setBounds(44, 492, 129, 47);
		contentPane.add(btnRetour);
	}

}
