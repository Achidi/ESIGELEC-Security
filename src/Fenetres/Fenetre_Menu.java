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

public class Fenetre_Menu extends JFrame {

	private JPanel contentPane;
	private Fenetre_Gerer_Personne fenetre1 = null;
	private Fenetre_Gerer_Badge fenetre3 = null;
	private Fenetre_Gerer_Lieux fenetre4 = null;
	private Fenetre_Authentification fenetre2 = null;

  //private Fenetre_Reporting fenetre5 = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fenetre_Menu frame = new Fenetre_Menu();
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
	public Fenetre_Menu() {
		this.setTitle("ESIGELEC Security - Menu");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 100, 620, 605);
		contentPane = new JPanel_Background();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("  Gerer Personne");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(fenetre1 == null) {
					fenetre1 = new Fenetre_Gerer_Personne(); 
					
					fenetre1.setVisible(true);
					
				}
				else {
					
					fenetre1.setVisible(true);
				}		
				
			}
		});
		Image icon1 = new ImageIcon(this.getClass().getResource("/office-worker-outline.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(icon1));
		btnNewButton.setBounds(188, 70, 237, 49);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_4 = new JButton("  Retour");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(fenetre2 == null) {
					fenetre2 = new Fenetre_Authentification(); 
					
					fenetre2.setVisible(true);
				}
				else {
					
					fenetre2.setVisible(true);
				}		
				
			}
		});
		Image icon2 = new ImageIcon(this.getClass().getResource("/left-arrow.png")).getImage();
		btnNewButton_4.setIcon(new ImageIcon(icon2));
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_4.setBounds(44, 502, 107, 38);
		contentPane.add(btnNewButton_4);
		
		JButton btnGererBadge = new JButton("  Gerer Badge");
		btnGererBadge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(fenetre3 == null) {
					
					fenetre3 = new Fenetre_Gerer_Badge(); 
				}
				else {
					
					fenetre3.setVisible(true);
				}		
				
			}
		});
		btnGererBadge.setIconTextGap(2);
		Image icon3 = new ImageIcon(this.getClass().getResource("/id-card.png")).getImage();
		btnGererBadge.setIcon(new ImageIcon(icon3));
		btnGererBadge.setBounds(188, 181, 237, 49);
		contentPane.add(btnGererBadge);
		
		JButton btnGererLieux = new JButton("  Gerer Lieux");
		btnGererLieux.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if(fenetre4 == null) {
					fenetre4 = new Fenetre_Gerer_Lieux(); 
					
					fenetre4.setVisible(true);
				}
				else {
					
					fenetre4.setVisible(true);
				}		
				
			}
		});
		Image icon4 = new ImageIcon(this.getClass().getResource("/plans.png")).getImage();
		btnGererLieux.setIcon(new ImageIcon(icon4));
		btnGererLieux.setBounds(188, 295, 237, 49);
		contentPane.add(btnGererLieux);
		
		JButton btnReporting = new JButton("Reporting");
		/*btnReporting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(fenetre5 == null) {
					
					fenetre5 = new Fenetre_Gerer_Reporting(); 
				}
				else {
					
					fenetre5.setVisible(true);
				}		
				
			}
		});*/
		Image icon5 = new ImageIcon(this.getClass().getResource("/report.png")).getImage();
		btnReporting.setIcon(new ImageIcon(icon5));
		btnReporting.setBounds(188, 407, 237, 49);
		contentPane.add(btnReporting);
	}
}
