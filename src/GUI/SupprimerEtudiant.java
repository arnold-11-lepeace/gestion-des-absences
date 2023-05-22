package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import DAO.EleveDao;
import Model.Eleve;
import javax.swing.table.DefaultTableModel;
import javax.swing.JEditorPane;
import javax.swing.DropMode;
import javax.swing.JSlider;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.Scrollbar;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.SpringLayout;
import java.awt.Insets;

public class SupprimerEtudiant {

	private JFrame SupprimerEtudiant;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupprimerEtudiant window = new SupprimerEtudiant();
					window.SupprimerEtudiant.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SupprimerEtudiant() {
		initialize();
		SupprimerEtudiant.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		initialiserJFrame();

		initialiserEntete();

		JPanel panelCorps = new JPanel();
		panelCorps.setBounds(10, 65, 414, 400);
		SupprimerEtudiant.getContentPane().add(panelCorps);

		ArrayList<Eleve> listEleve = new EleveDao().getList();
		ArrayList<JCheckBox> CasesaCochees = new ArrayList<>();
		int pat = 0;
		int y = 0;

		JTextPane txtpnId = new JTextPane();
		txtpnId.setText("Id");
		txtpnId.setEditable(false);
		panelCorps.add(txtpnId, "cell 0 0,alignx left,aligny top");

		JTextPane txtpnFilire = new JTextPane();
		txtpnFilire.setText("Filière");
		txtpnFilire.setEditable(false);
		panelCorps.add(txtpnFilire, "cell 1 0,alignx left,aligny top");

		JTextPane txtpnNom = new JTextPane();
		txtpnNom.setText("Nom");
		txtpnNom.setEditable(false);
		panelCorps.add(txtpnNom, "cell 2 0,alignx left,aligny top");

		JTextPane txtpnPrnom = new JTextPane();
		txtpnPrnom.setText("Prénom");
		txtpnPrnom.setEditable(false);
		panelCorps.add(txtpnPrnom, "cell 3 0,alignx left,aligny top");

		for (int i = 0; i < listEleve.size(); i++) {

			/*
			 * JTextPane txtpnvaleurId = new JTextPane();
			 * txtpnvaleurId.setText(listEleve.get(i).getIdEleve() +"");
			 * txtpnvaleurId.setEditable(false); panelCorps.add(txtpnvaleurId);
			 * 
			 * 
			 * JTextPane txtpnValeurNom = new JTextPane();
			 * txtpnValeurNom.setText(listEleve.get(i).getNomEleve());
			 * txtpnValeurNom.setEditable(false); panelCorps.add(txtpnValeurNom);
			 */

		}

		for (int i = 0; i < 13; i++) {

			y = 21 + pat;

			JTextPane txtpnvaleurId = new JTextPane();
			txtpnvaleurId.setText(listEleve.get(i).getIdEleve() + "");
			txtpnvaleurId.setEditable(false);
			txtpnvaleurId.setBounds(10, y, 60, 20);
			panelCorps.add(txtpnvaleurId);

			JTextPane txtpnValeurNom = new JTextPane();
			txtpnValeurNom.setText(listEleve.get(i).getNomEleve());
			txtpnValeurNom.setEditable(false);
			txtpnValeurNom.setBounds(72, y, 96, 20);
			panelCorps.add(txtpnValeurNom);

			JTextPane txtpnValeurPrnom = new JTextPane();
			txtpnValeurPrnom.setText(listEleve.get(i).getPrenomEleve());
			txtpnValeurPrnom.setEditable(false);
			txtpnValeurPrnom.setBounds(170, y, 96, 20);
			panelCorps.add(txtpnValeurPrnom);

			JTextPane txtpnValeurFilire = new JTextPane();
			txtpnValeurFilire.setText(listEleve.get(i).getFiliereEleve());
			txtpnValeurFilire.setEditable(false);
			txtpnValeurFilire.setBounds(267, y, 76, 20);
			panelCorps.add(txtpnValeurFilire);

			JCheckBox chckbxEtudiant = new JCheckBox("");
			chckbxEtudiant.setBounds(345, y, 97, 23);
			// panelCorps.add(chckbxEtudiant);
			// CasesaCochees.add(chckbxEtudiant);
			pat = pat + 22;
		}

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
		btnSupprimer.setBounds(253, 255, 89, 23);
		SupprimerEtudiant.getContentPane().add(btnSupprimer);
		btnSupprimer.setVisible(true);

		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcceuilGestionnaire window = new AcceuilGestionnaire();
				SupprimerEtudiant.setVisible(false);
			}
		});
		btnRetour.setBackground(new Color(128, 128, 255));
		btnRetour.setBounds(94, 255, 89, 23);
		SupprimerEtudiant.getContentPane().add(btnRetour);

		panelCorps.setLayout(new GridLayout(13, 4, 10, 0));

		JScrollPane scrollpane = new JScrollPane(panelCorps);
		// panelCorps.setLayout(new MigLayout("", "[17px][35px][28px][43px]",
		// "[20px]"));

		// JPanel paneltest = new JPanel();
		// paneltest.setBackground(new Color(11, 0, 0));
		// SupprimerEtudiant.getContentPane().add(paneltest);
		// paneltest.add(panelCorps);

		// scrollpane.setBounds(10, 65, 414, 188);
		// SupprimerEtudiant.getContentPane().add(scrollpane);
		SupprimerEtudiant.setContentPane(scrollpane);
		// scrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

	}

	private void initialiserEntete() {
		JPanel panelEntete = new JPanel();
		panelEntete.setBackground(new Color(128, 128, 255));
		panelEntete.setBounds(10, 11, 414, 53);
		SupprimerEtudiant.getContentPane().add(panelEntete);
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

	private void initialiserJFrame() {
		SupprimerEtudiant = new JFrame();
		SupprimerEtudiant.setBounds(100, 100, 450, 300);
		SupprimerEtudiant.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SupprimerEtudiant.getContentPane().setLayout(null);
	}
}
