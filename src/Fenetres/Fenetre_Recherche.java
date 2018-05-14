package Fenetres;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ClassesJava.Badge;
import ClassesJava.Personne;
import DAO.BadgeDAO;
import DAO.PersonneDAO;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Fenetre_Recherche extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private PersonneDAO personneDAO = new PersonneDAO();
	private BadgeDAO badgeDAO = new BadgeDAO();
	private Fenetre_Resultats fenetre1;
	private Personne UnePersonne;
	private Badge badge;
	protected JButton btnSupprimer;
	protected JButton btnNewButton;
	protected JButton btnSupprimerBadge;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fenetre_Recherche frame = new Fenetre_Recherche();
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
	public Fenetre_Recherche() {
		this.setTitle("ESIGELEC Security - Recherche");
		
		// on instancie la classe Article DAO
				this.personneDAO = new PersonneDAO();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 100, 678, 204);
		contentPane = new JPanel_Background();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(94, 28, 211, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(411, 28, 211, 32);
		contentPane.add(textField_1);
		Image icon2 = new ImageIcon(this.getClass().getResource("/left-arrow.png")).getImage();
		
		btnNewButton = new JButton("Rechercher");
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		String nom = textField.getText();
		String prenom = textField_1.getText();
		UnePersonne = personneDAO.getPersonne(nom, prenom);
					
				if(fenetre1 == null) {
						fenetre1 = new Fenetre_Resultats(); 
						fenetre1.listePersonne.addElement(UnePersonne);
						fenetre1.listePersonnes.addElement(UnePersonne.afficher());
						fenetre1.setVisible(true);	
					}	
			}		
		});
		
		btnNewButton.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnNewButton.setBounds(69, 115, 134, 39);
		contentPane.add(btnNewButton);
		
		btnSupprimer = new JButton("Supprimer Personne");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				int resultat = 0;
				String nom = textField.getText();
				String prenom = textField_1.getText();
				UnePersonne = personneDAO.getPersonne(nom, prenom);
				int id = personneDAO.get_Id_Personne(UnePersonne.getNom(), UnePersonne.getPrenom());
				
				if(badgeDAO.getBadge(id) != null) {
					int delete = badgeDAO.supprimer_badge(badgeDAO.getBadge(id));
				}
				
				resultat = personneDAO.supprimer_personne(UnePersonne);	
				
				JOptionPane.showMessageDialog(null, resultat + " Personne supprimée", "Resultat", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		btnSupprimer.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnSupprimer.setBounds(232, 115, 195, 39);
		contentPane.add(btnSupprimer);
		
		btnSupprimerBadge = new JButton("Supprimer Badge");
		btnSupprimerBadge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int resultat = 0;
				String nom = textField.getText();
				String prenom = textField_1.getText();
				UnePersonne = personneDAO.getPersonne(nom, prenom);
				int id = personneDAO.get_Id_Personne(UnePersonne.getNom(), UnePersonne.getPrenom());
				
				resultat = badgeDAO.supprimer_badge(badgeDAO.getBadge(id));
				
				JOptionPane.showMessageDialog(null, " Baddge supprimé", "Resultat", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		btnSupprimerBadge.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnSupprimerBadge.setBounds(457, 115, 195, 39);
		contentPane.add(btnSupprimerBadge);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setForeground(Color.WHITE);
		lblNom.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblNom.setBounds(32, 28, 122, 32);
		contentPane.add(lblNom);

		
		JLabel lblPrenom = new JLabel("Prenom :");
		lblPrenom.setForeground(Color.WHITE);
		lblPrenom.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblPrenom.setBounds(338, 26, 122, 32);
		contentPane.add(lblPrenom);
	}
}
