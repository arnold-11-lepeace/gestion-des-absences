package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Conexion {

	private JFrame connectionFrame;
	private JTextField txtVousEtesQui;
	 static String role; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Conexion window = new Conexion();
					window.connectionFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Conexion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		connectionFrame = new JFrame();
		connectionFrame.setBounds(100, 100, 450, 300);
		connectionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		connectionFrame.getContentPane().setLayout(null);
		
		JPanel panelFeuille = new JPanel();
		panelFeuille.setBackground(new Color(128, 128, 255));
		panelFeuille.setBounds(10, 11, 414, 239);
		connectionFrame.getContentPane().add(panelFeuille);
		panelFeuille.setLayout(null);
		
		txtVousEtesQui = new JTextField();
		txtVousEtesQui.setHorizontalAlignment(SwingConstants.CENTER);
		txtVousEtesQui.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtVousEtesQui.setText("Vous etes qui?");
		txtVousEtesQui.setBounds(162, 62, 120, 20);
		panelFeuille.add(txtVousEtesQui);
		txtVousEtesQui.setColumns(10);
		
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Page de connexion");
		lblNewJgoodiesTitle.setBounds(168, 11, 91, 14);
		lblNewJgoodiesTitle.setBackground(new Color(255, 255, 255));
		lblNewJgoodiesTitle.setForeground(new Color(255, 255, 255));
		panelFeuille.add(lblNewJgoodiesTitle);
		
		JButton studentJbutton = new JButton("Etudiant");
		studentJbutton.setBackground(new Color(255, 255, 255));
		studentJbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				role="Etudiant";
				System.out.println("clique");
				Identification window = new Identification();
				connectionFrame.setVisible(false);
			}
		});
		studentJbutton.setBounds(10, 115, 73, 23);
		panelFeuille.add(studentJbutton);
		
		JButton gestionJbutton = new JButton("Gestionnaire");
		gestionJbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				role="Gestionnaire";
				Identification window = new Identification();
				connectionFrame.setVisible(false);
			}
		});
		gestionJbutton.setBounds(194, 115, 100, 23);
		panelFeuille.add(gestionJbutton);
		
		JLabel lblNewLabel = new JLabel("ESIGELEC");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 11, 91, 36);
		panelFeuille.add(lblNewLabel);
		
		JButton teacherJbutton = new JButton("Professeur");
		teacherJbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				role="Professeur";
			}
		});
		teacherJbutton.setBackground(Color.WHITE);
		teacherJbutton.setBounds(93, 115, 91, 23);
		panelFeuille.add(teacherJbutton);
		
		JButton AdministratorJbutton = new JButton("Admin");
		AdministratorJbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				role="Admin";
			}
		});
		AdministratorJbutton.setBackground(Color.WHITE);
		AdministratorJbutton.setBounds(304, 115, 100, 23);
		panelFeuille.add(AdministratorJbutton);
	}
}
