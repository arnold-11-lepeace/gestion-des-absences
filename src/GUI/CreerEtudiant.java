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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.SwingConstants;

public class CreerEtudiant {

	private JFrame CreerEtudiant;
	private JTextField txtNom;
	private JTextField txtPrnom;
	private JTextField txtAdressemail;
	private JTextField txtFilire;
	private JTextField txtAjoutReussi;
	private JTextField txtMessageErreur;

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
		
		
		JPanel panelEntete = new JPanel();
		panelEntete.setBackground(new Color(128, 128, 255));
		panelEntete.setBounds(10, 11, 414, 53);
		CreerEtudiant.getContentPane().add(panelEntete);
		panelEntete.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ESIGELEC");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 11, 91, 36);
		panelEntete.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Déconnexion");
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setBounds(283, 11, 108, 23);
		panelEntete.add(btnNewButton);
		
		JPanel panelformulaire = new JPanel();
		panelformulaire.setBounds(10, 62, 414, 188);
		CreerEtudiant.getContentPane().add(panelformulaire);
		panelformulaire.setLayout(null);
		
		txtNom = new JTextField();
		txtNom.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtNom.getText().equals("Nom")) {
					txtNom.setText("");
				}
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtNom.getText().equals("")) {
					txtNom.setText("Nom");
				}
			}
		});
		txtNom.setFont(new Font("Tahoma", Font.ITALIC, 14));
		txtNom.setText("Nom");
		txtNom.setBounds(132, 42, 201, 20);
		panelformulaire.add(txtNom);
		txtNom.setColumns(20);
		
		txtPrnom = new JTextField();
		txtPrnom.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtPrnom.getText().equals("Prénom")) {
					txtPrnom.setText("");
				}
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPrnom.getText().equals("")) {
					txtPrnom.setText("Prénom");
				}
			}
		});
		txtPrnom.setText("Prénom");
		txtPrnom.setFont(new Font("Tahoma", Font.ITALIC, 14));
		txtPrnom.setColumns(20);
		txtPrnom.setBounds(132, 73, 201, 20);
		panelformulaire.add(txtPrnom);
		
		txtAdressemail = new JTextField();
		txtAdressemail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtAdressemail.getText().equals("Adressemail")) {
					txtAdressemail.setText("");
				}
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtAdressemail.getText().equals("")) {
					txtAdressemail.setText("Adressemail");
				}
			}
		});
		txtAdressemail.setText("Adressemail");
		txtAdressemail.setFont(new Font("Tahoma", Font.ITALIC, 14));
		txtAdressemail.setColumns(20);
		txtAdressemail.setBounds(132, 104, 201, 20);
		panelformulaire.add(txtAdressemail);
		
		txtFilire = new JTextField();
		txtFilire.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtFilire.getText().equals("Filière")) {
					txtFilire.setText("");
				}
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtFilire.getText().equals("")) {
					txtFilire.setText("Filière");
				}
			}
		});
		txtFilire.setText("Filière");
		txtFilire.setFont(new Font("Tahoma", Font.ITALIC, 14));
		txtFilire.setColumns(20);
		txtFilire.setBounds(132, 135, 201, 20);
		panelformulaire.add(txtFilire);
		
		txtMessageErreur = new JTextField();
		txtMessageErreur.setForeground(new Color(255, 0, 0));
		txtMessageErreur.setEditable(false);
		txtMessageErreur.setText("Ajout impossible. Veuillez remplir tous les champs");
		txtMessageErreur.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMessageErreur.setColumns(20);
		txtMessageErreur.setBounds(72, 11, 315, 20);
		txtMessageErreur.setVisible(false);
		panelformulaire.add(txtMessageErreur);
		
		txtAjoutReussi = new JTextField();
		txtAjoutReussi.setEditable(false);
		txtAjoutReussi.setForeground(new Color(0, 255, 64));
		txtAjoutReussi.setText("Ajout réussi");
		txtAjoutReussi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAjoutReussi.setColumns(20);
		txtAjoutReussi.setBounds(132, 11, 201, 20);
		txtAjoutReussi.setVisible(false);
		panelformulaire.add(txtAjoutReussi);
		
		 
		
		
		EleveDao EleveDAO = new EleveDao();
		//int returnvalue=0;
		
		
		
		JButton btnNewButton_1 = new JButton("Creer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Eleve E1 = new Eleve( -1,"azertyu",txtNom.getText(),txtPrnom.getText(), 
						txtAdressemail.getText(),txtFilire.getText());
				
				int i=EleveDAO.add(E1);
				
				
				if(i==0) {
					txtMessageErreur.setVisible(true);
					txtAjoutReussi.setVisible(false);
				}
				else {
					txtMessageErreur.setVisible(false);
					txtAjoutReussi.setVisible(true);
					txtNom.setText("nom");
					txtPrnom.setText("prénom");
					txtAdressemail.setText("Adresseemail");
					txtFilire.setText("filière");
					Timer timer = new Timer();
					
					TimerTask tache = new TimerTask() {
						public void run() {
							txtAjoutReussi.setVisible(false);	
						}
					};
					timer.schedule(tache, 1000);
					
				}
				
				
				
				
				
			}
		});
		btnNewButton_1.setBackground(new Color(128, 255, 128));
		btnNewButton_1.setBounds(315, 166, 89, 23);
		panelformulaire.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Retour");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Acceuil window = new Acceuil();
				CreerEtudiant.setVisible(false);
				
			}
		});
		btnNewButton_2.setBackground(new Color(128, 128, 255));
		btnNewButton_2.setBounds(104, 166, 89, 23);
		panelformulaire.add(btnNewButton_2);
		
		
		
		
		
		
	}
}
