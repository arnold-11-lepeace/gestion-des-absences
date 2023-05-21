package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBoxMenuItem;
import java.awt.Choice;
import javax.swing.JScrollBar;
import java.awt.List;
import java.awt.ScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AcceuilGestionnaire {

	private JFrame PageAcceuilGestionnaire;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AcceuilGestionnaire window = new AcceuilGestionnaire();
					window.PageAcceuilGestionnaire.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AcceuilGestionnaire() {
		initialize();
		PageAcceuilGestionnaire.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		PageAcceuilGestionnaire = new JFrame();
		PageAcceuilGestionnaire.setBounds(100, 100, 450, 300);
		PageAcceuilGestionnaire.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PageAcceuilGestionnaire.getContentPane().setLayout(null);
		
		JPanel panelEntete = new JPanel();
		panelEntete.setBackground(new Color(128, 128, 255));
		panelEntete.setBounds(10, 11, 414, 53);
		PageAcceuilGestionnaire.getContentPane().add(panelEntete);
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
		
		JPanel panelCorps = new JPanel();
		panelCorps.setBounds(10, 75, 414, 175);
		PageAcceuilGestionnaire.getContentPane().add(panelCorps);
		panelCorps.setLayout(null);
		
		
		JPanel panelFonctionnaliteEtudiant = new JPanel();
		panelFonctionnaliteEtudiant.setBackground(new Color(192, 192, 192));
		panelFonctionnaliteEtudiant.setBounds(10, 37, 144, 127);
		panelCorps.add(panelFonctionnaliteEtudiant);
		panelFonctionnaliteEtudiant.setVisible(false);
		
		JButton btnCreerEtudiant = new JButton("Creer etudiant");
		btnCreerEtudiant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreerEtudiant window = new CreerEtudiant();
				PageAcceuilGestionnaire.setVisible(false);
			}
		});
		btnCreerEtudiant.setForeground(new Color(0, 0, 0));
		btnCreerEtudiant.setBackground(new Color(255, 255, 255));
		
		
		JButton btnCreerGroupe = new JButton("Creer un groupe");
		btnCreerGroupe.setBackground(new Color(255, 255, 255));
		btnCreerGroupe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		JButton btnModifierEtudiant = new JButton("Modifier Etudiant");
		btnModifierEtudiant.setBackground(new Color(255, 255, 255));
		
		
		JButton btnSupprimerEtudiant = new JButton("Supprimer etudiant");
		btnSupprimerEtudiant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SupEtudiant window = new SupEtudiant();
				PageAcceuilGestionnaire.setVisible(false);
			}
		});
		btnSupprimerEtudiant.setBackground(new Color(255, 255, 255));
		
		
		
		JButton btnTraiterjustificatif = new JButton("Traiter Justifcatifs");
		btnTraiterjustificatif.setBackground(new Color(255, 255, 255));
		btnTraiterjustificatif.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ListeJustificatifs window= new ListeJustificatifs();
				
			}
		});
		
		
		JButton btnListeAbsences = new JButton("Liste absences");
		btnListeAbsences.setBackground(new Color(255, 255, 255));
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 414, 22);
		panelCorps.add(menuBar);
		
		JButton btnEtudiant = new JButton("Etudiant");
		btnEtudiant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				panelFonctionnaliteEtudiant.add(btnCreerEtudiant);
				panelFonctionnaliteEtudiant.add(btnCreerGroupe);
				panelFonctionnaliteEtudiant.add(btnModifierEtudiant);
				panelFonctionnaliteEtudiant.add(btnSupprimerEtudiant);
				panelFonctionnaliteEtudiant.setVisible(true);
			}
		});
		menuBar.add(btnEtudiant);
		
		JButton btnEnseignant = new JButton("Enseignant");
		menuBar.add(btnEnseignant);
		
		JButton btnPlanning = new JButton("Planning");
		menuBar.add(btnPlanning);
		
		JButton btnAbsence = new JButton("Absence");
		btnAbsence.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelFonctionnaliteEtudiant.add(btnListeAbsences);
				panelFonctionnaliteEtudiant.add(btnTraiterjustificatif);
				panelFonctionnaliteEtudiant.setVisible(true);
				
			}
		});
		menuBar.add(btnAbsence);
		
		JButton btnMessages = new JButton("Messages");
		menuBar.add(btnMessages);
		
		JPanel panel = new JPanel();
		panel.setBounds(246, 37,144, 127);
		panelCorps.add(panel);
		
		
		//panel.add(btnListeAbsences);
		
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
