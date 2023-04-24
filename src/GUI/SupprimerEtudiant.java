package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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
		SupprimerEtudiant = new JFrame();
		SupprimerEtudiant.setBounds(100, 100, 450, 300);
		SupprimerEtudiant.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SupprimerEtudiant.getContentPane().setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		panel.setBounds(10, 11, 414, 53);
		SupprimerEtudiant.getContentPane().add(panel);
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
		SupprimerEtudiant.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		
		
		JTextPane txtpnId = new JTextPane();
		txtpnId.setText("Id");
		txtpnId.setEditable(false);
		txtpnId.setBounds(10, 21, 60, 20);
		panel_1.add(txtpnId);
		
		JTextPane txtpnNom = new JTextPane();
		txtpnNom.setText("Nom");
		txtpnNom.setEditable(false);
		txtpnNom.setBounds(72, 21, 96, 20);
		panel_1.add(txtpnNom);
		
		JTextPane txtpnPrnom = new JTextPane();
		txtpnPrnom.setText("Prénom");
		txtpnPrnom.setEditable(false);
		txtpnPrnom.setBounds(170, 21, 96, 20);
		panel_1.add(txtpnPrnom);
		
		JTextPane txtpnFilire = new JTextPane();
		txtpnFilire.setText("Filière");
		txtpnFilire.setEditable(false);
		txtpnFilire.setBounds(267, 21, 76, 20);
		panel_1.add(txtpnFilire);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int returnValue=0;
				returnValue = EleveDao.delete(000000);
			}
		});
		btnSupprimer.setBackground(new Color(255, 0, 0));
		btnSupprimer.setBounds(283, 154, 89, 23);
		panel_1.add(btnSupprimer);
		
		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Acceuil window = new Acceuil();
				SupprimerEtudiant.setVisible(false);
			}
		});
		btnNewButton_1.setBackground(new Color(128, 128, 255));
		btnNewButton_1.setBounds(94, 154, 89, 23);
		panel_1.add(btnNewButton_1);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBackground(new Color(255, 255, 255));
		scrollBar.setMaximum(200);
		scrollBar.setBounds(387, 11, 17, 166);
		panel_1.add(scrollBar);
		btnSupprimer.setVisible(true);
		
		
		
		
		ArrayList<Eleve> listEleve= new EleveDao().getList();
		int j=0;
		
		for(int i=0;i<listEleve.size(); i++) {
			
			//System.out.println(listEleve.get(i).getNomEleve());
			JTextPane txtpnValeurNom = new JTextPane();
			txtpnValeurNom.setText(listEleve.get(i).getNomEleve());
			txtpnValeurNom.setEditable(false);
			txtpnValeurNom.setBounds(72, 21+j, 96, 20);
			panel_1.add(txtpnValeurNom);
			
			
			
			JTextPane txtpnValeurPrnom = new JTextPane();
			txtpnValeurPrnom.setText(listEleve.get(i).getPrenomEleve());
			txtpnValeurPrnom.setEditable(false);
			txtpnValeurPrnom.setBounds(170, 21+j, 96, 20);
			panel_1.add(txtpnValeurPrnom);
			
			JTextPane txtpnValeurFilire = new JTextPane();
			txtpnValeurFilire.setText("Filière");
			txtpnValeurFilire.setEditable(false);
			txtpnValeurFilire.setBounds(267, 21+j, 76, 20);
			panel_1.add(txtpnValeurFilire);
			
			
			JCheckBox chckbxEtudiant = new JCheckBox("");
			chckbxEtudiant.setBounds(345, 21+j, 97, 23);
			panel_1.add(chckbxEtudiant);
			
			
			j=j+22;
		}
		
		
		
		
		
		
		
	}
}
