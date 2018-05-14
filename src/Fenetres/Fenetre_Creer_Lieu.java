package Fenetres;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ClassesJava.Lieu;
import ClassesJava.Personne;
import DAO.LieuxDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Fenetre_Creer_Lieu extends JFrame {

	private JPanel contentPane;
	protected JTextField emplacement;
	protected JTextField nbrEntree;
	private JLabel lblH;
	private JLabel lblMin;
	private JLabel lblSec;
	private Lieu lieu; 
	private LieuxDAO lieuDAO = new LieuxDAO();
	protected Time Hopen;
	protected Time Hclose;
	private int heure, min, sec; 
	protected JComboBox<Integer> comboBox;
	protected JComboBox<Integer> comboBox_1;
	protected JComboBox<Integer> comboBox_2;
	private JLabel label;
	protected JComboBox<Integer> comboBox_3;
	private JLabel label_1;
	protected JComboBox<Integer> comboBox_4;
	private JLabel label_2;
	protected JComboBox<Integer> comboBox_5;
	protected JButton btnModifier;
	protected JButton btnNewButton;
	private Fenetre_Gerer_Lieux fenetre2;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fenetre_Creer_Lieu  frame = new Fenetre_Creer_Lieu();
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
	
	public Fenetre_Creer_Lieu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500,100,557,605);
		contentPane = new JPanel_Background();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("  Emplacements :");
		lblNewLabel.setForeground(Color.WHITE);
		Image icon1 = new ImageIcon(this.getClass().getResource("/placeholder-on-map-paper-in-perspective.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(icon1));
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblNewLabel.setBounds(49, 116, 171, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("  Nbr Entrees :");
		lblNewLabel_1.setForeground(Color.WHITE);
		Image icon2 = new ImageIcon(this.getClass().getResource("/open-exit-door.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(icon2));
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(48, 188, 219, 29);
		contentPane.add(lblNewLabel_1);
		Image icon3 = new ImageIcon(this.getClass().getResource("/clock-circular-outline.png")).getImage();
		
		JLabel lblNewLabel_3 = new JLabel("  Heure Fermeture :");
		lblNewLabel_3.setForeground(Color.WHITE);
		Image icon4 = new ImageIcon(this.getClass().getResource("/clock-padlock.png")).getImage();
		
		JLabel lblNewLabel_2 = new JLabel("  Heure Ouverture :");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setIcon(new ImageIcon(icon3));
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(49, 254, 188, 43);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_3.setIcon(new ImageIcon(icon4));
		lblNewLabel_3.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(49, 332, 188, 43);
		contentPane.add(lblNewLabel_3);
		Image icon6 = new ImageIcon(this.getClass().getResource("/left-arrow.png")).getImage();
		
		lblH = new JLabel("  Hour");
		lblH.setForeground(Color.WHITE);
		lblH.setBounds(282, 304, 45, 29);
		contentPane.add(lblH);
		
		lblMin = new JLabel("Min");
		lblMin.setForeground(Color.WHITE);
		lblMin.setBounds(356, 311, 46, 14);
		contentPane.add(lblMin);
		
		lblSec = new JLabel("    Sec");
		lblSec.setForeground(Color.WHITE);
		lblSec.setBounds(412, 311, 46, 14);
		contentPane.add(lblSec);
		
		label = new JLabel("  Hour");
		label.setForeground(Color.WHITE);
		label.setBounds(282, 376, 45, 29);
		contentPane.add(label);
		
		label_1 = new JLabel("Min");
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(356, 383, 46, 14);
		contentPane.add(label_1);
		
		label_2 = new JLabel("    Sec");
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(412, 383, 46, 14);
		contentPane.add(label_2);
		
		emplacement = new JTextField();
		emplacement.setBounds(272, 116, 182, 35);
		contentPane.add(emplacement);
		emplacement.setColumns(10);
		
		nbrEntree = new JTextField();
		nbrEntree.setColumns(10);
		nbrEntree.setBounds(272, 188, 182, 35);
		contentPane.add(nbrEntree);
		
		comboBox = new JComboBox<Integer>();
		comboBox.setBounds(272, 268, 55, 29);
		for(heure = 0; heure<= 24; heure++) {
					
					comboBox.addItem(heure);
				}
		contentPane.add(comboBox);
		
		comboBox_1 = new JComboBox<Integer>();
		comboBox_1.setBounds(337, 268, 55, 29);
		for(min = 0; min<= 60; min++) {
			
			comboBox_1.addItem(min);
		}
		contentPane.add(comboBox_1);
		
		comboBox_2 = new JComboBox<Integer>();
		comboBox_2.setBounds(402, 268, 51, 29);
		for(sec = 00; sec<= 60; sec++) {
			
			comboBox_2.addItem(sec);
		}
		contentPane.add(comboBox_2);
		
		comboBox_3 = new JComboBox<Integer>();
		comboBox_3.setBounds(272, 340, 55, 29);
		for(heure = 0; heure<= 24; heure++) {
			
			comboBox_3.addItem(heure);
		}
		contentPane.add(comboBox_3);
		
		comboBox_4 = new JComboBox<Integer>();
		comboBox_4.setBounds(337, 340, 55, 29);
		for(min = 0; min<= 60; min++) {
					
					comboBox_4.addItem(min);
				}
		contentPane.add(comboBox_4);
		
		comboBox_5 = new JComboBox<Integer>();
		comboBox_5.setBounds(402, 340, 51, 29);
		for(sec = 00; sec<= 60; sec++) {
					
					comboBox_5.addItem(sec);
				}
		contentPane.add(comboBox_5);	
		
		
		
		btnNewButton = new JButton("Creer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int resultat;	
				int nbr = Integer.parseInt(nbrEntree.getText());
				
				Hopen = new Time(comboBox.getSelectedIndex(),comboBox_1.getSelectedIndex(),comboBox_2.getSelectedIndex());
				Hclose = new Time(comboBox_3.getSelectedIndex(),comboBox_4.getSelectedIndex(),comboBox_5.getSelectedIndex());
				 
				lieu = new Lieu(emplacement.getText(), nbr, Hopen, Hclose);
				
				resultat = lieuDAO.creer_lieu(lieu);
					
				JOptionPane.showMessageDialog(null, resultat + " Lieu crée", "Resultat", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnNewButton.setBounds(205, 459, 139, 43);
		contentPane.add(btnNewButton);
		
		JButton btnRetour = new JButton("    Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(fenetre2 == null) {
					fenetre2 = new Fenetre_Gerer_Lieux(); 
					fenetre2.setVisible(true);
					
				}
				else {
					fenetre2.setVisible(true);
					
				}	
			}
		});
		btnRetour.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnRetour.setIcon(new ImageIcon(icon6));
		btnRetour.setBounds(36, 459, 139, 43);
		contentPane.add(btnRetour);
		
		btnModifier = new JButton("  Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int res = 0;
				int nbr = Integer.parseInt(nbrEntree.getText());
				
				Hopen = new Time(comboBox.getSelectedIndex(),comboBox_1.getSelectedIndex(),comboBox_2.getSelectedIndex());
				Hclose = new Time(comboBox_3.getSelectedIndex(),comboBox_4.getSelectedIndex(),comboBox_5.getSelectedIndex());
				
				Lieu NewLieu = new Lieu(emplacement.getText(), nbr, Hopen, Hclose);
				res = lieuDAO.modifier_lieu(NewLieu, emplacement.getText());	
				
				JOptionPane.showMessageDialog(null, " Lieu modifié", "Resultat", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		Image icon21 = new ImageIcon(this.getClass().getResource("/database.png")).getImage();
		btnModifier.setIcon(new ImageIcon(icon21));
		btnModifier.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnModifier.setBounds(372, 459, 139, 43);
		contentPane.add(btnModifier);
		
	
	}
}
