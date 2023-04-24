package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DAO.EleveDao;
import Model.Eleve;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreerEtudiant {

	private JFrame CreerEtudiant;
	private JTextField txtNom;
	private JTextField txtPrnom;
	private JTextField txtAdressemail;
	private JTextField txtFilire;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreerEtudiant window = new CreerEtudiant();
					window.CreerEtudiant.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CreerEtudiant() {
		initialize();
		CreerEtudiant.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		CreerEtudiant = new JFrame();
		CreerEtudiant.setBounds(100, 100, 450, 300);
		CreerEtudiant.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CreerEtudiant.getContentPane().setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		panel.setBounds(10, 11, 414, 53);
		CreerEtudiant.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ESIGELEC");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 11, 91, 36);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Déconnexion");
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setBounds(283, 11, 108, 23);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 62, 414, 188);
		CreerEtudiant.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		txtNom = new JTextField();
		txtNom.setFont(new Font("Tahoma", Font.ITALIC, 14));
		txtNom.setText("Nom");
		txtNom.setBounds(132, 28, 201, 20);
		panel_1.add(txtNom);
		txtNom.setColumns(20);
		
		txtPrnom = new JTextField();
		txtPrnom.setText("Prénom");
		txtPrnom.setFont(new Font("Tahoma", Font.ITALIC, 14));
		txtPrnom.setColumns(20);
		txtPrnom.setBounds(132, 59, 201, 20);
		panel_1.add(txtPrnom);
		
		txtAdressemail = new JTextField();
		txtAdressemail.setText("Adressemail");
		txtAdressemail.setFont(new Font("Tahoma", Font.ITALIC, 14));
		txtAdressemail.setColumns(20);
		txtAdressemail.setBounds(132, 90, 201, 20);
		panel_1.add(txtAdressemail);
		
		txtFilire = new JTextField();
		txtFilire.setText("Filière");
		txtFilire.setFont(new Font("Tahoma", Font.ITALIC, 14));
		txtFilire.setColumns(20);
		txtFilire.setBounds(132, 121, 201, 20);
		panel_1.add(txtFilire);
		
		
		EleveDao EleveDAO = new EleveDao();
		//int returnvalue=0;
		
		
		JButton btnNewButton_1 = new JButton("Creer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Eleve E1 = new Eleve( 10013345,"azertyu",txtNom.getText(),txtPrnom.getText(), 
						txtAdressemail.getText(),txtFilire.getText());
				EleveDAO.add(E1);
				
				
				
			}
		});
		btnNewButton_1.setBackground(new Color(128, 255, 128));
		btnNewButton_1.setBounds(315, 152, 89, 23);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Retour");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Acceuil window = new Acceuil();
				CreerEtudiant.setVisible(false);
			}
		});
		btnNewButton_2.setBackground(new Color(128, 128, 255));
		btnNewButton_2.setBounds(104, 152, 89, 23);
		panel_1.add(btnNewButton_2);
		
		
	}
}
