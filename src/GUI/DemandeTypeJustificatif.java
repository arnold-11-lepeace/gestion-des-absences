package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DemandeTypeJustificatif {

	private JFrame ChoixTypeJustificatif;
	private JTextField txtQuelTypeDe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DemandeTypeJustificatif window = new DemandeTypeJustificatif();
					window.ChoixTypeJustificatif.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DemandeTypeJustificatif() {
		initialize();
		ChoixTypeJustificatif.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ChoixTypeJustificatif = new JFrame();
		ChoixTypeJustificatif.setBounds(100, 100, 450, 300);
		ChoixTypeJustificatif.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ChoixTypeJustificatif.getContentPane().setLayout(null);
		
		
		JPanel panelEntete = new JPanel();
		panelEntete.setBackground(new Color(128, 128, 255));
		panelEntete.setBounds(10, 11, 414, 53);
		ChoixTypeJustificatif.getContentPane().add(panelEntete);
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
		panelCorps.setBounds(10, 63, 414, 187);
		ChoixTypeJustificatif.getContentPane().add(panelCorps);
		panelCorps.setLayout(null);
		
		txtQuelTypeDe = new JTextField();
		txtQuelTypeDe.setBackground(new Color(255, 255, 255));
		txtQuelTypeDe.setEditable(false);
		txtQuelTypeDe.setText("Quel type de justificatifs d'absence voulez vous déposer?");
		txtQuelTypeDe.setBounds(51, 11, 329, 48);
		panelCorps.add(txtQuelTypeDe);
		txtQuelTypeDe.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Justificatif d'absence pour une période");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChoixTypeJustificatif.setVisible(false);
				PageDepotJustificatif window = new PageDepotJustificatif();
			}
		});
		btnNewButton_1.setBounds(84, 81, 255, 23);
		panelCorps.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Justificatif d'absence pour un cours");
		btnNewButton_1_1.setBounds(84, 115, 258, 23);
		panelCorps.add(btnNewButton_1_1);
	}
}
