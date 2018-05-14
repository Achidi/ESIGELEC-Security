package Fenetres;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import ClassesJava.Badge;
import ClassesJava.Lieu;
import DAO.BadgeDAO;

public class Fenetre_Resultats_Lieux extends JFrame {

	private JPanel contentPane;
	private Fenetre_Creer_Lieu fenetre1;
	protected JList <String> list;
	protected DefaultListModel <Lieu> listeLieu = new DefaultListModel<Lieu>();
	protected  DefaultListModel<String> listeLieux = new DefaultListModel<String>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fenetre_Resultats_Lieux frame = new Fenetre_Resultats_Lieux();
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
	public Fenetre_Resultats_Lieux() {
this.setTitle("ESIGELEC Security - Resultats");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 100, 543, 553);
		contentPane = new JPanel_Background();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Image icon2 = new ImageIcon(this.getClass().getResource("/left-arrow.png")).getImage();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 42, 425, 403);
		contentPane.add(scrollPane);
		

		list = new JList<String>(listeLieux);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);
		
		JButton btnRetour = new JButton("  Modifier Lieu");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(fenetre1 == null) {
					fenetre1 = new Fenetre_Creer_Lieu(); 
					
					fenetre1.emplacement.setText(listeLieu.getElementAt(0).getEmplacement());
					fenetre1.nbrEntree.setText( String.valueOf(listeLieu.getElementAt(0).getNombreAcces()));
					fenetre1.comboBox.setSelectedIndex(listeLieu.getElementAt(0).getHoraireOuverture().getHours());
					fenetre1.comboBox_1.setSelectedIndex(listeLieu.getElementAt(0).getHoraireOuverture().getMinutes());
					fenetre1.comboBox_2.setSelectedIndex(listeLieu.getElementAt(0).getHoraireOuverture().getSeconds());
					fenetre1.comboBox_3.setSelectedIndex(listeLieu.getElementAt(0).getHoraireOuverture().getHours());
					fenetre1.comboBox_4.setSelectedIndex(listeLieu.getElementAt(0).getHoraireOuverture().getMinutes());
					fenetre1.comboBox_5.setSelectedIndex(listeLieu.getElementAt(0).getHoraireOuverture().getSeconds());
					fenetre1.btnNewButton.setEnabled(false);
					fenetre1.btnModifier.setEnabled(true);
					
					fenetre1.setVisible(true);
				}
				else {
					fenetre1.setVisible(true);
				}		
				
			}
		});
		btnRetour.setIcon(new ImageIcon(icon2));
		btnRetour.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnRetour.setBounds(166, 467, 191, 36);
		contentPane.add(btnRetour);
	}

}
