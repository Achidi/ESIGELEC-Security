package Fenetres;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ClassesJava.Badge;
import ClassesJava.Personne;
import DAO.BadgeDAO;
import DAO.PersonneDAO;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;

import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class Fenetre_Resultats extends JFrame {

	private JPanel contentPane;
	private Fenetre_Creer_Personne fenetre1;
	protected JList <String> list;
	protected DefaultListModel <Personne> listePersonne = new DefaultListModel<Personne>();
	protected  DefaultListModel<String> listePersonnes = new DefaultListModel<String>();
	private JButton btnAssocierBadge;
	private Badge badge;
	private BadgeDAO badgeDAO;
	private PersonneDAO personneDAO = new PersonneDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 Fenetre_Resultats frame = new Fenetre_Resultats();
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
	public Fenetre_Resultats() {
		this.setTitle("ESIGELEC Security - Resultats");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 100, 620, 553);
		contentPane = new JPanel_Background();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Image icon2 = new ImageIcon(this.getClass().getResource("/left-arrow.png")).getImage();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(79, 41, 425, 403);
		contentPane.add(scrollPane);
		
		list = new JList<String>(listePersonnes);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);
		
		JButton btnRetour = new JButton("  Modifier");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(fenetre1 == null) {
					fenetre1 = new Fenetre_Creer_Personne(); 
					fenetre1.nom.setText(listePersonne.getElementAt(0).getNom());
					fenetre1.prenom.setText(listePersonne.getElementAt(0).getPrenom());
					fenetre1.Jours.setSelectedIndex(listePersonne.getElementAt(0).getDateDeNaissance().getDay());
					fenetre1.Mois.setSelectedIndex(listePersonne.getElementAt(0).getDateDeNaissance().getMonth());
					fenetre1.Annees.setSelectedIndex(listePersonne.getElementAt(0).getDateDeNaissance().getYear());
					fenetre1.fonctions.setSelectedItem(listePersonne.getElementAt(0).getFonction());
					fenetre1.setVisible(true);
					
				}
				else {
					fenetre1.setVisible(true);
				}		
				
			}
		});
		btnRetour.setIcon(new ImageIcon(icon2));
		btnRetour.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnRetour.setBounds(109, 467, 178, 36);
		contentPane.add(btnRetour);
		
		btnAssocierBadge = new JButton("  Associer Badge");
		btnAssocierBadge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				badge = new Badge(personneDAO.get_Id_Personne(listePersonne.getElementAt(0).getNom(), listePersonne.getElementAt(0).getPrenom()));
				badgeDAO = new BadgeDAO();
				int resultat = badgeDAO.inserer_badge(badge);
				JOptionPane.showMessageDialog(null, resultat + " Badge crée", "Resultat", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		btnAssocierBadge.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnAssocierBadge.setBounds(297, 467, 178, 36);
		contentPane.add(btnAssocierBadge);

	}
	
}
