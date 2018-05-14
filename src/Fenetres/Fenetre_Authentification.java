package Fenetres;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class Fenetre_Authentification extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserId;
	private JPasswordField pwdPassword;
	private Fenetre_Menu fenetre1 = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fenetre_Authentification frame = new Fenetre_Authentification();
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
	public Fenetre_Authentification() {
		this.setTitle("ESIGELEC Security - Authentification");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 620, 605);
		contentPane = new JPanel_Background();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("     Identifiant :");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		Image icon1 = new ImageIcon(this.getClass().getResource("/avatar.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(icon1));
		lblNewLabel.setBounds(74, 187, 171, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblMotDePasse = new JLabel("    Mot de passe :");
		lblMotDePasse.setForeground(Color.WHITE);
		lblMotDePasse.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		Image icon2 = new ImageIcon(this.getClass().getResource("/password.png")).getImage();
		lblMotDePasse.setIcon(new ImageIcon(icon2));
		lblMotDePasse.setBounds(63, 281, 171, 40);
		contentPane.add(lblMotDePasse);
		
		txtUserId = new JTextField();
		txtUserId.setText("Admin");
		txtUserId.setForeground(Color.GRAY);
		txtUserId.setBounds(244, 187, 237, 37);
		contentPane.add(txtUserId);
		txtUserId.setColumns(10);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setText("password");
		pwdPassword.setBounds(244, 286, 237, 37);
		contentPane.add(pwdPassword);
		
		JButton btnNewButton = new JButton("Log in");
		btnNewButton.addActionListener(new ActionListener() {
			
		public void actionPerformed(ActionEvent e) {
				
		if(txtUserId.getText().compareTo("Admin") == 0 && pwdPassword.getText().compareTo("Admin") == 0) {
						
			if(fenetre1 == null) {
			
			   fenetre1 = new Fenetre_Menu(); 
			   JOptionPane.showMessageDialog(null, "Administrateur Connecté!", "Answer", JOptionPane.NO_OPTION);
			  
			   fenetre1.setVisible(true);
			}
			
			else {
			
				fenetre1.setVisible(true);
			}	
		 }
					
		 else {
				JOptionPane.showMessageDialog(null, "Accès Refusé!", "Answer", JOptionPane.WARNING_MESSAGE);
		 }

		}});
		btnNewButton.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnNewButton.setBounds(231, 413, 145, 40);
		contentPane.add(btnNewButton);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Enregistrer ses identifiants");
		chckbxNewCheckBox.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		chckbxNewCheckBox.setBounds(38, 506, 187, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JLabel lblLogo = new JLabel("");
		Image icon3 = new ImageIcon(this.getClass().getResource("/worker.png")).getImage();
		lblLogo.setIcon(new ImageIcon(icon3));
		lblLogo.setBounds(260, 22, 155, 128);
		contentPane.add(lblLogo);
	}
}
