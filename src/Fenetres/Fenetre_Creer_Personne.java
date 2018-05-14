 package Fenetres;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import ClassesJava.Personne;
import DAO.PersonneDAO;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Fenetre_Creer_Personne extends JFrame {

	private JPanel contentPane;
	protected JTextField nom;
	protected JTextField prenom;
	private JButton button;
	private Fenetre_Gerer_Personne fenetre = null;
	private PersonneDAO personneDAO ;
	private Date date;
	protected JComboBox<String> fonctions;
	protected JComboBox<Integer> Jours;
	protected JComboBox<Integer> Mois;
	protected JComboBox<Integer> Annees;
	protected JButton btnModifier;
	protected JButton btnEnregistrer;
	


	/**
	 * Create the frame.
	 */
	public Fenetre_Creer_Personne() {
		
		personneDAO = new PersonneDAO();
		
		//Definit un titre pour la fenetre
		this.setTitle("ESIGELEC Security - Créer Personne");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500,100,620, 605);
		contentPane = new JPanel_Background();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom :");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		
		lblNewLabel.setBounds(147, 145, 69, 17);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Prenom :");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(128, 216, 79, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Date de Naissance :");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(42, 293, 160, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Profil :");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(155, 367, 61, 14);
		contentPane.add(lblNewLabel_3);
		
		btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				int resultat = 0;
			Personne personne = new Personne(nom.getText(), prenom.getText() ,date ,fonctions.getSelectedItem().toString());
			resultat = personneDAO.inserer_personne(personne);	
				
				JOptionPane.showMessageDialog(null, resultat + " Personne crée", "Resultat", JOptionPane.INFORMATION_MESSAGE);

			}
		});
		btnEnregistrer.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		btnEnregistrer.setBounds(244, 477, 125, 34);
		contentPane.add(btnEnregistrer);
		
		btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int res = 0;
				Personne NewPersonne = new Personne(nom.getText(), prenom.getText() ,date ,fonctions.getSelectedItem().toString());
				res = personneDAO.modifier_personne(NewPersonne,nom.getText(), prenom.getText());	
				
				JOptionPane.showMessageDialog(null, " Personne modifiée", "Resultat", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnModifier.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		Image icon21 = new ImageIcon(this.getClass().getResource("/database.png")).getImage();
		btnModifier.setIcon(new ImageIcon(icon21));
		btnModifier.setBounds(393, 477, 125, 34);
		contentPane.add(btnModifier);
		
		button = new JButton("Retour");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				if(fenetre == null) {
					fenetre = new Fenetre_Gerer_Personne(); 
					fenetre.setVisible(true);
					
				}
				else {
					fenetre.setVisible(true);
					
				}		
			}
		});
		
		button.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		Image icon2 = new ImageIcon(this.getClass().getResource("/left-arrow.png")).getImage();
		button.setIcon(new ImageIcon(icon2));
		button.setFont(new Font("Tahoma", Font.PLAIN, 13));
		button.setBounds(81, 477, 135, 34);
		contentPane.add(button);
		
		nom = new JTextField();
		nom.setBackground(Color.LIGHT_GRAY);
		nom.setBounds(226, 142, 221, 27);
		contentPane.add(nom);
		nom.setColumns(10);
		
		prenom = new JTextField();
		prenom.setBackground(Color.LIGHT_GRAY);
		prenom.setBounds(226, 212, 221, 27);
		contentPane.add(prenom);
		prenom.setColumns(10);
		
		String [] profil = {"", "Etudiant F.I", "Apprenti", "Technicien", "Professeur","Directeur"};
		fonctions = new JComboBox<String>(profil);
		fonctions.setBounds(226, 364, 222, 27);
		contentPane.add(fonctions);
		
		int jours,mois,annees;
		
		Jours = new JComboBox<Integer>();
		Jours.setToolTipText("Jours");
		Jours.setBackground(Color.WHITE);
		Jours.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		Jours.setBounds(226, 286, 44, 34);
		for(jours = 1; jours<= 31; jours++) {
			
			Jours.addItem(jours);
		}
		contentPane.add(Jours);
		
		
		Mois = new JComboBox<Integer>();
		Mois.setToolTipText("Mois");
		Mois.setBackground(Color.WHITE);
		Mois.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		Mois.setBounds(292, 286, 44, 34);
		for(mois = 1; mois<= 12; mois++) {
					
					Mois.addItem(mois);
				}
		contentPane.add(Mois);
		
	
	    Annees = new JComboBox<Integer>();
		Annees.setToolTipText("Ann\u00E9es");
		Annees.setBackground(Color.WHITE);
		Annees.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		Annees.setBounds(373, 286, 74, 34);
		for(annees = 1990; annees<= 2019; annees++) {
					
					Annees.addItem(annees);
				}
		contentPane.add(Annees);
		
		date = new Date( Annees.getSelectedIndex(), Mois.getSelectedIndex(), Jours.getSelectedIndex());
		
	}
	
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Fenetre_Creer_Personne frame = new Fenetre_Creer_Personne();
						frame.setVisible(true);
						
						//Permet le redimensionnement de la fenetre
						frame.setResizable(false);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
}
