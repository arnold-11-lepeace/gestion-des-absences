package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Window;
import com.toedter.calendar.JDateChooser;

public class AcceuilEtudiant {

	private JFrame pageAcceuilEtudiant;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AcceuilEtudiant window = new AcceuilEtudiant();
					window.pageAcceuilEtudiant.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AcceuilEtudiant() {
		initialize();
		pageAcceuilEtudiant.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		pageAcceuilEtudiant = new JFrame();
		pageAcceuilEtudiant.setBounds(100, 100, 450, 300);
		pageAcceuilEtudiant.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pageAcceuilEtudiant.getContentPane().setLayout(null);

		JPanel panelEntete = new JPanel();
		panelEntete.setBackground(new Color(128, 128, 255));
		panelEntete.setBounds(10, 11, 414, 53);
		pageAcceuilEtudiant.getContentPane().add(panelEntete);
		panelEntete.setLayout(null);

		JLabel lblNewLabel = new JLabel("ESIGELEC");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 11, 91, 36);
		panelEntete.add(lblNewLabel);

		JButton btnDeconnexion = new JButton("Déconnexion");
		btnDeconnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pageAcceuilEtudiant.setVisible(false);
				Conexion window = new Conexion();
			}
		});
		btnDeconnexion.setBackground(new Color(255, 0, 0));
		btnDeconnexion.setBounds(283, 11, 108, 23);
		panelEntete.add(btnDeconnexion);

		JPanel panelCorps = new JPanel();
		panelCorps.setBounds(10, 75, 414, 175);
		pageAcceuilEtudiant.getContentPane().add(panelCorps);
		panelCorps.setLayout(null);

		JPanel panelFonctionnaliteEtudiant = new JPanel();
		panelFonctionnaliteEtudiant.setForeground(new Color(255, 0, 0));
		panelFonctionnaliteEtudiant.setBackground(new Color(220, 220, 220));
		panelFonctionnaliteEtudiant.setBounds(0, 33, 140, 97);
		panelCorps.add(panelFonctionnaliteEtudiant);
		panelFonctionnaliteEtudiant.setVisible(false);

		JButton btnConsulterListeAbsences = new JButton("Mes absences");
		btnConsulterListeAbsences.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// CreerEtudiant window = new CreerEtudiant();
				pageAcceuilEtudiant.setVisible(false);
			}
		});
		btnConsulterListeAbsences.setForeground(new Color(0, 0, 0));
		btnConsulterListeAbsences.setBackground(new Color(255, 255, 255));
		panelFonctionnaliteEtudiant.add(btnConsulterListeAbsences);

		JButton btnAnticiperAbsence = new JButton("Anticiper absence");
		btnAnticiperAbsence.setBackground(new Color(255, 255, 255));
		btnAnticiperAbsence.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panelFonctionnaliteEtudiant.add(btnAnticiperAbsence);

		JButton btnDeposerjustif = new JButton("Déposer \r\njustificatif");
		btnDeposerjustif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelFonctionnaliteEtudiant.setVisible(false);
				DemandeTypeJustificatif window = new DemandeTypeJustificatif();
				pageAcceuilEtudiant.setVisible(false);
			}
		});
		btnDeposerjustif.setBackground(new Color(255, 255, 255));
		panelFonctionnaliteEtudiant.add(btnDeposerjustif);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 414, 22);
		panelCorps.add(menuBar);

		JButton btnAbsences = new JButton("Absences");
		btnAbsences.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelFonctionnaliteEtudiant.setVisible(true);
			}
		});
		menuBar.add(btnAbsences);

		JButton btnPlanning = new JButton("Planning");
		btnPlanning.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlanningEtudiant window = new PlanningEtudiant();
			}
		});
		menuBar.add(btnPlanning);

		JButton btnNotes = new JButton("Notes");
		menuBar.add(btnNotes);

		JButton btnMessages = new JButton("Messages");
		menuBar.add(btnMessages);

	}
}
