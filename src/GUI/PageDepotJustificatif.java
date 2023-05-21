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

import DAO.PeriodeAbsenceDAO;
import Model.PeriodeAbsence;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

import java.text.SimpleDateFormat;
import com.toedter.calendar.JDateChooser;

public class PageDepotJustificatif extends Identification {

	private JFrame DepotJustificatif;
	private JTextField txtJeSeraiAbsent;
	private JTextField txtAu;
	private JTextField txtVeuillezDposerVotre;
	static  String selectedFileName;
	static  String selectedFileAccessPath;
	private JTextField txtAjoutEffectu;

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
		
		txtAu = new JTextField();
		txtAu.setBackground(new Color(255, 255, 255));
		txtAu.setEditable(false);
		txtAu.setText("au");
		txtAu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtAu.setColumns(10);
		txtAu.setBounds(260, 11, 21, 20);
		panelCorps.add(txtAu);
		
		txtVeuillezDposerVotre = new JTextField();
		txtVeuillezDposerVotre.setText("Veuillez déposer votre justificatif ici");
		txtVeuillezDposerVotre.setFont(new Font("Times New Roman", Font.BOLD, 12));
		txtVeuillezDposerVotre.setEditable(false);
		txtVeuillezDposerVotre.setColumns(10);
		txtVeuillezDposerVotre.setBounds(115, 42, 205, 20);
		panelCorps.add(txtVeuillezDposerVotre);
		
		JDateChooser dateFinPeriode = new JDateChooser();
		dateFinPeriode.setBounds(303, 11, 101, 20);
		panelCorps.add(dateFinPeriode);
		
		JDateChooser dateDebutPeriode = new JDateChooser();
		dateDebutPeriode.setBounds(149, 11, 101, 20);
		panelCorps.add(dateDebutPeriode);
		
		
		JPanel panelDedepot = new JPanel();
		panelDedepot.setBackground(new Color(255, 255, 255));
		panelDedepot.setBounds(115, 68, 205, 78);
		panelCorps.add(panelDedepot);
		panelDedepot.setLayout(null);
		
		
		txtAjoutEffectu = new JTextField();
		txtAjoutEffectu.setEditable(false);
		txtAjoutEffectu.setBounds(10, 58, 185, 20);
		panelDedepot.add(txtAjoutEffectu);
		txtAjoutEffectu.setText("Ajout effectué");
		txtAjoutEffectu.setColumns(10);
		txtAjoutEffectu.setVisible(false);
		
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
				      selectedFileName= choose.getName(file);
				      System.out.println(selectedFileName);
				      
				      
				      txtAjoutEffectu.setVisible(true);
				      txtAjoutEffectu.setForeground(new Color(0, 255, 128));
				      //txtAjoutEffectu
				      selectedFileAccessPath=file.getAbsolutePath();
				      System.out.println(file.getAbsolutePath());
				    }
				  
			}
		});
		btnDepotJustificatif.setIcon(new ImageIcon("C:\\Users\\ONANA Arnold\\eclipse-workspace\\Gestion absences\\images\\flèche déposer.png"));
		btnDepotJustificatif.setBounds(48, 11, 91, 40);
		panelDedepot.add(btnDepotJustificatif);
		
		
		
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtAjoutEffectu.setForeground(new Color(255, 0, 0));
				txtAjoutEffectu.setVisible(true);
				txtAjoutEffectu.setText("Votre sélection a été annulée");
				selectedFileName=null;
				
			}
		});
		btnAnnuler.setBackground(new Color(255, 0, 0));
		btnAnnuler.setBounds(73, 157, 89, 23);
		panelCorps.add(btnAnnuler);
		
		
		
		
		
		PeriodeAbsenceDAO periodeAbsenceDao= new PeriodeAbsenceDAO();
		
		
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dateDeDebut = (((JTextField) dateDebutPeriode.getDateEditor().getUiComponent()).getText());
				String datedeFin = (((JTextField) dateFinPeriode.getDateEditor().getUiComponent()).getText());
				
				PeriodeAbsence p1= new PeriodeAbsence(-1,dateDeDebut, datedeFin, "physique", selectedFileName, connectedEleveId);
				periodeAbsenceDao.add(p1,connectedEleveId);

			    File src = new File(selectedFileAccessPath); 
			    File dest = new File("C:\\Users\\ONANA Arnold\\eclipse-workspace\\Gestion absences\\justificatif d'absences\\"+selectedFileName); 
			    InputStream is = null;
			    OutputStream os = null;
			  
			   try {
			        is = new FileInputStream(src);
			        os = new FileOutputStream(dest);
			        byte[] buffer = new byte[1024];
			        int len;
			        while ((len = is.read(buffer)) > 0) {
			            os.write(buffer, 0, len);
			        }
			        is.close();
			        os.close();
			    }
			    catch(IOException a){
			        a.printStackTrace();
			    }
			   /* Path sourceFile = Path.of("selectedFileAccessPath");
		        Path destinationFile = Path.of("C:\\\\Users\\\\ONANA Arnold\\\\eclipse-workspace\\\\Gestion absences\\\\justificatif d'absences");

		        try {
		            Files.copy(sourceFile, destinationFile, StandardCopyOption.REPLACE_EXISTING);
		            System.out.println("Fichier copié avec succès !");
		        } catch (IOException e1) {
		            System.err.println("Erreur lors de la copie du fichier : " + e1.getMessage());
		        }*/
		        
		        
		        
			}
			
		});
		btnValider.setBackground(new Color(0, 255, 128));
		btnValider.setBounds(245, 157, 89, 23);
		panelCorps.add(btnValider);
		
		
	}
}
