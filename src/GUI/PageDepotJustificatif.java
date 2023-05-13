package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileSystemView;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import java.awt.event.ActionEvent;

public class PageDepotJustificatif {

	private JFrame DepotJustificatif;
	private JTextField txtJeSeraiAbsent;
	private JTextField txtDateDebutAbs;
	private JTextField txtAu;
	private JTextField txtDateFinAbs;
	private JTextField txtVeuillezDposerVotre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PageDepotJustificatif window = new PageDepotJustificatif();
					window.DepotJustificatif.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PageDepotJustificatif() {
		initialize();
		DepotJustificatif.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		DepotJustificatif = new JFrame();
		DepotJustificatif.setBounds(100, 100, 450, 300);
		DepotJustificatif.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DepotJustificatif.getContentPane().setLayout(null);
		
		JPanel panelEntete = new JPanel();
		panelEntete.setBackground(new Color(128, 128, 255));
		panelEntete.setBounds(10, 11, 414, 53);
		DepotJustificatif.getContentPane().add(panelEntete);
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
		panelCorps.setBounds(10, 66, 414, 184);
		DepotJustificatif.getContentPane().add(panelCorps);
		panelCorps.setLayout(null);
		
		txtJeSeraiAbsent = new JTextField();
		txtJeSeraiAbsent.setBackground(new Color(255, 255, 255));
		txtJeSeraiAbsent.setEditable(false);
		txtJeSeraiAbsent.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtJeSeraiAbsent.setText("Je serai absent(e) du");
		txtJeSeraiAbsent.setBounds(10, 11, 129, 20);
		panelCorps.add(txtJeSeraiAbsent);
		txtJeSeraiAbsent.setColumns(10);
		
		txtDateDebutAbs = new JTextField();
		txtDateDebutAbs.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtDateDebutAbs.getText().equals("DD/MM/YEAR")) {
					txtDateDebutAbs.setText("");
				}
				
				/*else {
					if(txtDateDebutAbs.getText().length()==2) {
						txtDateDebutAbs.setText(txtDateDebutAbs.getText()+"/");
					}
					else if(txtDateDebutAbs.getText().length()==2) {
						txtDateDebutAbs.setText(txtDateDebutAbs.getText()+"/");
					}
		        	}*/
					
					
				
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtDateDebutAbs.getText().equals("")) {
					txtDateDebutAbs.setText("DD/MM/YEAR");
					
				}
			}
		});
		txtDateDebutAbs.setText("DD/MM/YEAR");
		txtDateDebutAbs.setFont(new Font("Tahoma", Font.ITALIC, 12));
		txtDateDebutAbs.setColumns(10);
		txtDateDebutAbs.setBounds(159, 11, 85, 20);
		panelCorps.add(txtDateDebutAbs);
		
		txtAu = new JTextField();
		txtAu.setBackground(new Color(255, 255, 255));
		txtAu.setEditable(false);
		txtAu.setText("au");
		txtAu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtAu.setColumns(10);
		txtAu.setBounds(256, 11, 21, 20);
		panelCorps.add(txtAu);
		
		txtDateFinAbs = new JTextField();
		txtDateFinAbs.setText("DD/MM/YEAR");
		txtDateFinAbs.setFont(new Font("Tahoma", Font.ITALIC, 12));
		txtDateFinAbs.setColumns(10);
		txtDateFinAbs.setBounds(289, 11, 85, 20);
		panelCorps.add(txtDateFinAbs);
		
		txtVeuillezDposerVotre = new JTextField();
		txtVeuillezDposerVotre.setText("Veuillez déposer votre justificatif ici");
		txtVeuillezDposerVotre.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txtVeuillezDposerVotre.setEditable(false);
		txtVeuillezDposerVotre.setColumns(10);
		txtVeuillezDposerVotre.setBounds(115, 42, 205, 20);
		panelCorps.add(txtVeuillezDposerVotre);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBackground(new Color(255, 0, 0));
		btnAnnuler.setBounds(73, 141, 89, 23);
		panelCorps.add(btnAnnuler);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBackground(new Color(0, 255, 128));
		btnValider.setBounds(245, 141, 89, 23);
		panelCorps.add(btnValider);
		
		JPanel panelDedepot = new JPanel();
		panelDedepot.setBackground(new Color(255, 255, 255));
		panelDedepot.setBounds(115, 68, 205, 62);
		panelCorps.add(panelDedepot);
		panelDedepot.setLayout(null);
		
		JButton btnDepotJustificatif = new JButton("");
		btnDepotJustificatif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser choose = new JFileChooser(
				        FileSystemView
				        .getFileSystemView()
				        .getHomeDirectory()
				    );
				    // Ouvrez le fichier
				    int res = choose.showOpenDialog(null);
				    // Enregistrez le fichier
				    // int res = choose.showSaveDialog(null);
				    if (res == JFileChooser.APPROVE_OPTION) {
				      File file = choose.getSelectedFile();
				      System.out.println(file.getAbsolutePath());
				    }
				  
			}
		});
		btnDepotJustificatif.setIcon(new ImageIcon("C:\\Users\\ONANA Arnold\\eclipse-workspace\\Gestion absences\\images\\flèche déposer.png"));
		btnDepotJustificatif.setBounds(48, 11, 91, 40);
		panelDedepot.add(btnDepotJustificatif);
	}
}
