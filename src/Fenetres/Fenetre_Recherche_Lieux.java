package Fenetres;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ClassesJava.Lieu;

import DAO.LieuxDAO;


public class Fenetre_Recherche_Lieux extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private LieuxDAO lieuxDAO ;
	private Fenetre_Resultats_Lieux fenetre1;
	private Lieu UnLieu;
	protected JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fenetre_Recherche_Lieux frame = new Fenetre_Recherche_Lieux();
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
	public Fenetre_Recherche_Lieux() {
		// on instancie la classe Article DAO
		this.lieuxDAO = new LieuxDAO();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 100, 678, 204);
		contentPane = new JPanel_Background();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(321, 40, 211, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		Image icon2 = new ImageIcon(this.getClass().getResource("/left-arrow.png")).getImage();
		
		btnNewButton = new JButton("Rechercher");
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		String emplacement = textField.getText();
		UnLieu = lieuxDAO.getLieu(emplacement);
					
				if(fenetre1 == null) {
						fenetre1 = new Fenetre_Resultats_Lieux(); 
						fenetre1.listeLieu.addElement(UnLieu);
						fenetre1.listeLieux.addElement(UnLieu.afficher());	
						fenetre1.setVisible(true);	
					}	
			}		
		});
		
		btnNewButton.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnNewButton.setBounds(270, 115, 134, 39);
		contentPane.add(btnNewButton);
		
		JLabel lblNom = new JLabel("Nom de l'Emplacement : ");
		lblNom.setForeground(Color.WHITE);
		lblNom.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		lblNom.setBounds(101, 42, 254, 32);
		contentPane.add(lblNom);
			}
		
		}
