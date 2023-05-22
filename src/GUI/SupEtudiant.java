package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import DAO.EleveDao;
import Model.Eleve;

public class SupEtudiant {

	private JFrame listeEtudiants;
	JScrollPane scrollpane;

	private void initialiserEntete() {
		JPanel panelEntete = new JPanel();
		panelEntete.setBackground(new Color(128, 128, 255));
		panelEntete.setBounds(10, 11, 414, 53);
		listeEtudiants.getContentPane().add(panelEntete);
		panelEntete.setLayout(null);

		JLabel labelESIGELEC = new JLabel("ESIGELEC");
		labelESIGELEC.setForeground(Color.RED);
		labelESIGELEC.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelESIGELEC.setBounds(10, 11, 91, 36);
		panelEntete.add(labelESIGELEC);

		JButton btnDeconnexion = new JButton("Déconnexion");
		btnDeconnexion.setBackground(new Color(255, 0, 0));
		btnDeconnexion.setBounds(283, 11, 108, 23);
		panelEntete.add(btnDeconnexion);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupEtudiant window = new SupEtudiant();
					window.listeEtudiants.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SupEtudiant() {
		initialize();
		listeEtudiants.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		listeEtudiants = new JFrame();
		listeEtudiants.setBounds(100, 100, 450, 300);
		listeEtudiants.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// initialiserEntete();
		JPanel panelEntete = new JPanel();
		panelEntete.setBackground(new Color(128, 128, 255));
		panelEntete.setBounds(10, 11, 414, 53);
		// frame.getContentPane().add(panelEntete);
		panelEntete.setLayout(null);

		JLabel labelESIGELEC = new JLabel("ESIGELEC");
		labelESIGELEC.setForeground(Color.RED);
		labelESIGELEC.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelESIGELEC.setBounds(10, 11, 91, 36);
		panelEntete.add(labelESIGELEC);

		JButton btnDeconnexion = new JButton("Déconnexion");
		btnDeconnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listeEtudiants.setVisible(false);
				Conexion window = new Conexion();
			}
		});
		btnDeconnexion.setBackground(new Color(255, 0, 0));
		btnDeconnexion.setBounds(283, 11, 108, 23);
		panelEntete.add(btnDeconnexion);

		String counts[] = { "Id", "Nom", "Prénom", "Filière", "Action" };

		ArrayList<Eleve> listEleve = new EleveDao().getList();
		ArrayList<JCheckBox> CasesaCochees = new ArrayList<>();

		JRadioButton form[][] = new JRadioButton[listEleve.size()][5];

		JPanel panelCorps = new JPanel();
		panelCorps.setSize(600, 400);
		// p.setBounds(10, 65, 414, 400);
		panelCorps.setLayout(new GridLayout(listEleve.size(), 5, 10, 0));
		for (int row = 0; row < listEleve.size(); row++) {
			ButtonGroup bg = new ButtonGroup();
			for (int col = 0; col < 5; col++) {
				if (row == 0) {
					panelCorps.add(new JLabel(counts[col]));
				} else {
					switch (col) {
					case 0:
						panelCorps.add(new JLabel("" + listEleve.get(row).getIdEleve()));
						break;
					case 1:
						panelCorps.add(new JLabel(listEleve.get(row).getNomEleve()));
						break;
					case 2:
						panelCorps.add(new JLabel(listEleve.get(row).getPrenomEleve()));
						break;
					case 3:
						panelCorps.add(new JLabel(listEleve.get(row).getFiliereEleve()));
						break;
					case 4:
						JCheckBox chckbxEtudiant = new JCheckBox("");
						panelCorps.add(chckbxEtudiant);
						CasesaCochees.add(chckbxEtudiant);
						break;

					default:

						break;

					}
				}
			}
		}

		JPanel panelPieds = new JPanel();
		panelPieds.setBounds(10, 11, 414, 53);
		panelPieds.setLayout(null);

		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < CasesaCochees.size(); i++) {
					if (CasesaCochees.get(i).isSelected()) {
						EleveDao.delete(listEleve.get(i).getIdEleve());

					}

				}
			}
		});
		btnSupprimer.setBackground(new Color(255, 0, 0));
		btnSupprimer.setBounds(253, 25, 89, 23);
		btnSupprimer.setVisible(true);
		panelPieds.add(btnSupprimer);

		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcceuilGestionnaire window = new AcceuilGestionnaire();
				listeEtudiants.setVisible(false);
			}
		});
		btnRetour.setBackground(new Color(128, 128, 255));
		btnRetour.setBounds(94, 25, 89, 23);
		panelPieds.add(btnRetour);

		JPanel panelBase = new JPanel();
		panelBase.setLayout(new GridLayout(3, 1));

		scrollpane = new JScrollPane(panelCorps);

		panelBase.add(panelEntete);
		panelBase.add(scrollpane, BorderLayout.CENTER);
		panelBase.add(panelPieds);

		listeEtudiants.setContentPane(panelBase);

	}

}
