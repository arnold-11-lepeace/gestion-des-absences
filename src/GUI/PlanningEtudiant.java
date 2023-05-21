package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DAO.PeriodeAbsenceDAO;
import DAO.SeanceDAO;
import Model.PeriodeAbsence;
import Model.Seance;
import com.toedter.calendar.JCalendar;
import javax.swing.JTextPane;

public class PlanningEtudiant {

	private JFrame planningEtudiant;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlanningEtudiant window = new PlanningEtudiant();
					window.planningEtudiant.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PlanningEtudiant() {
		initialize();
		planningEtudiant.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		planningEtudiant = new JFrame();
		planningEtudiant.setBounds(100, 100, 450, 300);
		planningEtudiant.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		planningEtudiant.getContentPane().setLayout(null);
		
		
		JPanel panelEntete = new JPanel();
		panelEntete.setBackground(new Color(128, 128, 255));
		panelEntete.setBounds(10, 11, 414, 53);
		planningEtudiant.getContentPane().add(panelEntete);
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
		panelCorps.setBounds(10, 74, 414, 176);
		planningEtudiant.getContentPane().add(panelCorps);
		panelCorps.setLayout(null);
		
		JPanel panelCours = new JPanel();
		panelCours.setBackground(new Color(255, 255, 255));
		panelCours.setBounds(115, 68, 205, 96);
		panelCorps.add(panelCours);
		panelCours.setLayout(null);
		panelCours.setVisible(false);
		
		JTextPane txtTypeSeance = new JTextPane();
		txtTypeSeance.setText("type séance");
		txtTypeSeance.setBackground(new Color(128, 0, 255));
		txtTypeSeance.setEditable(false);
		txtTypeSeance.setBounds(66, 11, 57, 20);
		panelCours.add(txtTypeSeance);
		
		JLabel lblNomSeance = new JLabel("Nom séance");
		lblNomSeance.setBounds(10, 33, 103, 14);
		panelCours.add(lblNomSeance);
		
		JLabel lblDureeSeance = new JLabel("durée");
		lblDureeSeance.setBounds(10, 64, 90, 14);
		panelCours.add(lblDureeSeance);
		
		
		
		JButton btnLienDistanciel = new JButton("");
		btnLienDistanciel.setBackground(new Color(128, 128, 255));
		btnLienDistanciel.setBounds(10, 47, 90, 14);
		panelCours.add(btnLienDistanciel);
		
		
		
		
		
		ArrayList<Seance> listSeancecours= new SeanceDAO().getList();
		ArrayList<PeriodeAbsence>listDeclarationsAbsences = new PeriodeAbsenceDAO().getList();
		
		
		
		
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(10, 11, 394, 153);
		panelCorps.add(calendar);
		
		calendar.addPropertyChangeListener("calendar", (PropertyChangeListener) new PropertyChangeListener() {
		    @Override
		    public void propertyChange(PropertyChangeEvent evt) {
		        if (evt.getPropertyName().equals("calendar")) {
		            
		        	SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		            
					
		        	
		        	for(int i=0; i< listSeancecours.size();i++) {
		        		String A=listSeancecours.get(i).getDate();
		        				Date B= calendar.getDate();
		        				String c= formater.format(B).toString();
		        				
		        				
		        		if(A.equals(c)) {
		        			
		        			txtTypeSeance.setText(listSeancecours.get(i).getTypeSeance());
		        			lblNomSeance.setText("-"+listSeancecours.get(i).getNomSeance());
		        			lblDureeSeance.setText("- Durée:"+listSeancecours.get(i).getDurree());
		        			Seance a=listSeancecours.get(i);
		        			/*for(int j=0; j<listDeclarationsAbsences.size();i++) {
		        				String dD =listDeclarationsAbsences.get(j).getDateDebutPeriodeAbsence();
		        				String dF =listDeclarationsAbsences.get(j).getDateFinPeriodeAbsence();
		        				
		        				Date dateDebut = new SimpleDateFormat("dd/MM/yyyy").parse(dD);
		        				Date dateFin = new SimpleDateFormat("dd/MM/yyyy").parse(dF);
		        			}*/
		        				//if(dateDebut<B) {
		        			//}
		        			btnLienDistanciel.setText("lien fictif");
		        			panelCours.setVisible(true);
        					calendar.setVisible(false);
		        			Timer timer = new Timer();
		        			
		        			TimerTask tache = new TimerTask() {
		        				public void run() {
		        					panelCours.setVisible(false);
		        					calendar.setVisible(true);
		        				}
		        			};
		        			timer.schedule(tache, 1500);
		        			
		        			
		        			System.out.println("c'est bon");
		        		}
		        		
		        	}
		        	
		        }
		    }
		});
		
		
	}
}
