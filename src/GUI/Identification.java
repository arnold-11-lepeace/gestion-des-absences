package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import DAO.EleveDao;
import DAO.GestionnaireDao;
import Model.Eleve;
import Model.Gestionnaire;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JFormattedTextField;

public class Identification extends Conexion {

	private JFrame identificationFrame;
	private JTextField idField;
	private JPasswordField mdpField;

	private Eleve connectedEleve;
	private Gestionnaire connectedGestionnaire;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Identification window = new Identification();
					//window.identificationFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Identification() {
		initialize();
		identificationFrame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		identificationFrame = new JFrame();
		identificationFrame.getContentPane().setBackground(new Color(255, 255, 255));
		identificationFrame.getContentPane().setForeground(new Color(255, 255, 255));
		identificationFrame.setBounds(100, 100, 450, 300);
		identificationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		identificationFrame.getContentPane().setLayout(null);
		
		JPanel panelFeuille = new JPanel();
		panelFeuille.setBackground(new Color(128, 128, 255));
		panelFeuille.setBounds(10, 11, 414, 239);
		identificationFrame.getContentPane().add(panelFeuille);
		panelFeuille.setLayout(null);
		
		idField = new JTextField();
		idField.setBounds(123, 85, 201, 20);
		panelFeuille.add(idField);
		idField.setColumns(10);
		
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Page d'identification");
		lblNewJgoodiesTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewJgoodiesTitle.setBounds(149, 16, 130, 20);
		lblNewJgoodiesTitle.setForeground(new Color(255, 255, 255));
		panelFeuille.add(lblNewJgoodiesTitle);
		
		mdpField = new JPasswordField();
		mdpField.setColumns(8);
		mdpField.setBounds(123, 131, 201, 20);
		panelFeuille.add(mdpField);
		
		JLabel Ibidentifiant = new JLabel("Identifiant");
		Ibidentifiant.setBackground(new Color(128, 128, 192));
		Ibidentifiant.setBounds(32, 88, 63, 14);
		panelFeuille.add(Ibidentifiant);
		
		JLabel lblMotDePasse = new JLabel("mot de passe");
		lblMotDePasse.setBounds(19, 134, 89, 14);
		panelFeuille.add(lblMotDePasse);
		
		JLabel lblNewLabel_1 = new JLabel("ESIGELEC");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(19, 11, 76, 29);
		panelFeuille.add(lblNewLabel_1);
		
		
		
		
		
		
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(role.length()==8) {
					System.out.println(role);
					EleveDao elevDAO = new EleveDao();
					int identifiant = Integer.parseInt(idField.getText());
					 connectedEleve = elevDAO.login(identifiant, mdpField.getText());

						if(  connectedEleve!=null )  {
							Acceuil window = new Acceuil();
							identificationFrame.setVisible(false);
							System.out.println("identification reussie");
							System.out.println(mdpField.getText());
					}
						else {
							System.out.println("identification échouée");
							System.out.println(mdpField.getText());
							
						}
					
						
					
					
				}else if (role.length()==12) {
					System.out.println(role);
					GestionnaireDao GestionnaireDAO = new GestionnaireDao();
					int identifiant = Integer.parseInt(idField.getText());
					 connectedGestionnaire= GestionnaireDAO.loginGestionnaire(identifiant, mdpField.getText());
					 if(  connectedGestionnaire!=null )  {
							Acceuil window = new Acceuil();
							identificationFrame.setVisible(false);
							System.out.println("identification reussie");
							System.out.println(mdpField.getText());
					}
						else {
							System.out.println("identification échouée");
							System.out.println(mdpField.getText());
							
						}
					 
					
					
					
					
				}
				
				
				
				
				
			}
		});
		btnValider.setForeground(new Color(0, 0, 0));
		btnValider.setBackground(new Color(128, 255, 128));
		btnValider.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnValider.setBounds(278, 188, 89, 23);
		panelFeuille.add(btnValider);
		
		
	}
}
