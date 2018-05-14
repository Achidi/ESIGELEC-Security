package Fenetres;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Fenetre_Reporting extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fenetre_Reporting frame = new Fenetre_Reporting();
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
	public Fenetre_Reporting() {
		this.setTitle("ESIGELEC Security - Reporting");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 620, 605);
		contentPane = new JPanel_Background();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setDropMode(DropMode.ON);
		textArea.setBounds(10, 26, 584, 474);
		contentPane.add(textArea);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Image icon2 = new ImageIcon(this.getClass().getResource("/left-arrow.png")).getImage();
		btnRetour.setIcon(new ImageIcon(icon2));
		btnRetour.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnRetour.setBounds(10, 524, 107, 31);
		contentPane.add(btnRetour);
	}

}
