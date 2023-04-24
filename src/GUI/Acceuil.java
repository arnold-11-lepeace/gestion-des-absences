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

public class Acceuil {

	private JFrame Acceuil;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acceuil window = new Acceuil();
					window.Acceuil.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Acceuil() {
		initialize();
		Acceuil.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Acceuil = new JFrame();
		Acceuil.setBounds(100, 100, 450, 300);
		Acceuil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Acceuil.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		panel.setBounds(10, 11, 414, 53);
		Acceuil.getContentPane().add(panel);
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
		panel_1.setBounds(10, 75, 414, 175);
		Acceuil.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(10, 37, 144, 127);
		panel_1.add(panel_2);
		panel_2.setVisible(false);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Creer etudiant");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreerEtudiant window = new CreerEtudiant();
				Acceuil.setVisible(false);
			}
		});
		btnNewButton_1_1_1_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1_1_1_1.setBackground(new Color(255, 255, 255));
		panel_2.add(btnNewButton_1_1_1_1);
		
		JButton btnNewButton_1_1_1_4 = new JButton("Creer un groupe");
		btnNewButton_1_1_1_4.setBackground(new Color(255, 255, 255));
		btnNewButton_1_1_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_2.add(btnNewButton_1_1_1_4);
		
		JButton btnNewButton_1_1_1_3 = new JButton("Modifier Etudiant");
		btnNewButton_1_1_1_3.setBackground(new Color(255, 255, 255));
		panel_2.add(btnNewButton_1_1_1_3);
		
		JButton btnNewButton_1_1_1_2 = new JButton("Supprimer etudiant");
		btnNewButton_1_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SupprimerEtudiant window = new SupprimerEtudiant();
				Acceuil.setVisible(false);
			}
		});
		btnNewButton_1_1_1_2.setBackground(new Color(255, 255, 255));
		panel_2.add(btnNewButton_1_1_1_2);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 414, 22);
		panel_1.add(menuBar);
		
		JButton btnNewButton_1_1_1 = new JButton("Etudiant");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				panel_2.setVisible(true);
			}
		});
		menuBar.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1 = new JButton("Enseignant");
		menuBar.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Planning");
		menuBar.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_3 = new JButton("Absence");
		menuBar.add(btnNewButton_1_3);
		
		JButton btnNewButton_1_5 = new JButton("Messages");
		menuBar.add(btnNewButton_1_5);
		
		
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
