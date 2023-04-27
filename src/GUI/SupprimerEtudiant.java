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
		panel_1.setBounds(10, 2, 414, 188);
		SupprimerEtudiant.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		/*JPanel panel_11 = new JPanel();
		panel_11.setBounds(10, 62, 414, 553);
		SupprimerEtudiant.getContentPane().add(panel_11);
		panel_11.setLayout(null);
		panel_11.add(panel_1);*/
		
		
				
		
		
		
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
		
		
		ArrayList<Eleve> listEleve= new EleveDao().getList();
		ArrayList<JCheckBox> CasesaCochees= new ArrayList<>();
		int pat=0;
		int y=0;
		
		for(int i=0;i<listEleve.size(); i++) {
			
			y=21+pat;
			
			//System.out.println(listEleve.get(i).getNomEleve());
			JTextPane txtpnValeurNom = new JTextPane();
			txtpnValeurNom.setText(listEleve.get(i).getNomEleve());
			txtpnValeurNom.setEditable(false);
			txtpnValeurNom.setBounds(72, y, 96, 20);
			panel_1.add(txtpnValeurNom);
			
			
			
			JTextPane txtpnValeurPrnom = new JTextPane();
			txtpnValeurPrnom.setText(listEleve.get(i).getPrenomEleve());
			txtpnValeurPrnom.setEditable(false);
			txtpnValeurPrnom.setBounds(170, y, 96, 20);
			panel_1.add(txtpnValeurPrnom);
			
			JTextPane txtpnValeurFilire = new JTextPane();
			txtpnValeurFilire.setText(listEleve.get(i).getFiliereEleve());
			txtpnValeurFilire.setEditable(false);
			txtpnValeurFilire.setBounds(267, y, 76, 20);
			panel_1.add(txtpnValeurFilire);
			
			
			JCheckBox chckbxEtudiant = new JCheckBox("");
			chckbxEtudiant.setBounds(345, y, 97, 23);
			panel_1.add(chckbxEtudiant);
			CasesaCochees.add(chckbxEtudiant);
			pat=pat+22;
		}
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i<CasesaCochees.size();i++) {
					if(CasesaCochees.get(i).isSelected()) {
						EleveDao.delete(listEleve.get(i).getIdEleve());
					}
				
				}
			}
		});
		btnSupprimer.setBackground(new Color(255, 0, 0));
		btnSupprimer.setBounds(253, y+30, 89, 23);
		panel_1.add(btnSupprimer);
		btnSupprimer.setVisible(true);
		
		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Acceuil window = new Acceuil();
				SupprimerEtudiant.setVisible(false);
			}
		});
		btnNewButton_1.setBackground(new Color(128, 128, 255));
		btnNewButton_1.setBounds(94,  y+30, 89, 23);
		panel_1.add(btnNewButton_1);
		
		JScrollPane scrollpane= new JScrollPane(panel_1);
		//panel_11.add(scrollpane);
		//scrollpane.setBackground(new Color(255, 255, 0));
		//scrollpane.setWheelScrollingEnabled(true);
		//scrollpane.add(panel);
		//scrollpane.add(panel_1);
		//scrollpane.addMouseWheelListener(new MouseWheelListener() {
			/*public void mouseWheelMoved(MouseWheelEvent e) {
				//SupprimerEtudiant.setBounds(100, 100, 450, 350);
				//panel_11.setBounds(10, 62, 414, 200);
				//panel_1.setBounds(10, 62, 414, 200);
				//scrollpane.setColumnHeaderView(panel);
				
				System.out.println("la page a bougé");
				
			}
		});*/
		scrollpane.setBounds(10, 70, 414, 188);
		//scrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		SupprimerEtudiant.setContentPane(scrollpane);
		
	
		
		
		
		
		
		
		
		
		
	}
}
