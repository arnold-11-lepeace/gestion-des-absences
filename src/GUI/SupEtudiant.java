package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
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

	private JFrame frame;
	  JScrollPane scrollpane;
	  private void initialiserEntete() {
			JPanel panelEntete = new JPanel();
			panelEntete.setBackground(new Color(128, 128, 255));
			panelEntete.setBounds(10, 11, 414, 53);
			frame.getContentPane().add(panelEntete);
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
					window.frame.setVisible(true);
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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initialiserEntete();
		
		    String counts[] = { "Id", "Nom", "Prénom", "Filière", "Action" };

		    
			ArrayList<Eleve> listEleve= new EleveDao().getList();
			ArrayList<JCheckBox> CasesaCochees= new ArrayList<>();
			
			  JRadioButton form[][] = new JRadioButton[listEleve.size()][5];
			  
			  


		    
			  JPanel p = new JPanel();
		    p.setSize(600, 400);
		    //p.setBounds(10, 65, 414, 400);
		    p.setLayout(new GridLayout(listEleve.size(), 5, 10, 0));
		   for (int row = 0; row < listEleve.size(); row++) {
		      ButtonGroup bg = new ButtonGroup();
		      for (int col = 0; col < 5; col++) {
		        if (row == 0) {
		          p.add(new JLabel(counts[col]));
		        } else {
		        	switch (col) {
		        	case 0:
		        		 p.add(new JLabel(""+listEleve.get(row).getIdEleve()));
		        		 break;
		        	case 1:
		        		p.add(new JLabel(listEleve.get(row).getNomEleve()));
		        		break;
		        	case 2:
		        		p.add(new JLabel(listEleve.get(row).getPrenomEleve()));
		        		break;
		        	case 3:
		        		p.add(new JLabel(listEleve.get(row).getFiliereEleve()));
		        		break;
		        	case 4:
		        		JCheckBox chckbxEtudiant = new JCheckBox("");
						p.add(chckbxEtudiant);
						CasesaCochees.add(chckbxEtudiant);
						break;
		        		
		        	default:
		        			
		        		break;
		        	
		        	}
		        }
		      }
		    }
		    
		   JPanel p1 = new JPanel();
			//p1.setBackground(new Color(128, 128, 255));
			p1.setBounds(10, 11, 414, 53);
			frame.setContentPane(p1);
			p1.setLayout(null);
			
		    
		    scrollpane = new JScrollPane(p);
		    //scrollpane.setBounds(10, 65, 414, 400);
		    p1.add(scrollpane);
		   // frame.getContentPane().add(scrollpane, BorderLayout.CENTER);
	}

}
