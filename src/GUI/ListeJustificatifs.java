package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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

import DAO.EleveDao;
import DAO.ElevePeriodeAbsenceDeclareDAO;
import DAO.PeriodeAbsenceDAO;
import Model.Eleve;
import Model.ElevePeriodeAbsenceDeclare;
import Model.PeriodeAbsence;

public class ListeJustificatifs {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListeJustificatifs window = new ListeJustificatifs();
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
	public ListeJustificatifs() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//initialiserEntete();
				JPanel panelEntete = new JPanel();
				panelEntete.setBackground(new Color(128, 128, 255));
				panelEntete.setBounds(10, 11, 414, 53);
				//frame.getContentPane().add(panelEntete);
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
				
				    String counts[] = { "Id","fichier", "Date de début", "Date de fin", "Action" };

				    
					ArrayList<PeriodeAbsence> listJustificaifEleve= new PeriodeAbsenceDAO().getList();
					ArrayList<JCheckBox> CasesaCochees= new ArrayList<>();
					ArrayList<JButton> listBtnNomFichier = new ArrayList<>();
					
					  
					  
					  
					  

				    
					  JPanel panelCorps = new JPanel();
				    panelCorps.setSize(600, 400);
				    //p.setBounds(10, 65, 414, 400);
				    panelCorps.setLayout(new GridLayout(listJustificaifEleve.size(), 5, 10, 0));
				    
				    
				   for (int row = 0; row < listJustificaifEleve.size(); row++) {
				      
				      for (int col = 0; col < 5; col++) {
				        if (row == 0) {
				          panelCorps.add(new JLabel(counts[col]));
				        } else {
				        	switch (col) {
				        	case 0:
				        		 panelCorps.add(new JLabel(""+listJustificaifEleve.get(row).getId()));
				        		 break;
				        	case 1:
				        		JButton btnNomFichier=new JButton (""+listJustificaifEleve.get(row).getNomFichierJustificatif());
				        		panelCorps.add(btnNomFichier);
				        		listBtnNomFichier.add(btnNomFichier);
				        		
				        		break;
				        	case 2:
				        		panelCorps.add(new JLabel(listJustificaifEleve.get(row).getDateDebutPeriodeAbsence()));
				        		break;
				        	case 3:
				        		panelCorps.add(new JLabel(listJustificaifEleve.get(row).getDateFinPeriodeAbsence()));
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
				    
				   
				   for(int i=0;i<listBtnNomFichier.size();i++) {
					   String text = listBtnNomFichier.get(i).getText();
					   listBtnNomFichier.get(i).addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							/*
							// TODO Auto-generated method stub
							   try 
							    {
							        //Créer une instance PdfReader.
							        PdfReader pdf = new PdfReader("C:\\my.pdf");  
							   
							        //Récupérer le nombre de pages en pdf.
							        int nbrPages = pdf.getNumberOfPages(); 
							   
							        //Itérer le pdf à travers les pages.
							        for(int i=1; i <= nbrPages; i++) 
							        { 
							            //Extraire le contenu de la page à l'aide de PdfTextExtractor.
							            String content = PdfTextExtractor.getTextFromPage(pdf, i);
							   
							            //Afficher le contenu de la page sur la console.
							            System.out.println("Contenu du page : " + content);
							        }
							   
							        //Fermez le PdfReader.
							        pdf.close();
							    
							    } catch (Exception ex) {
							        ex.printStackTrace();
							    }
							*/
						}
					});
						   
					   
				   }
				   
				   
					
					
					
					JPanel panelPieds = new JPanel();
					panelPieds.setBounds(10, 11, 414, 53);
					panelPieds.setLayout(null);
					
					PeriodeAbsenceDAO declaration= new PeriodeAbsenceDAO();
					
					JButton btnRefuser = new JButton("Refuser");
					btnRefuser.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for(int i=0; i<CasesaCochees.size();i++) {
								if(CasesaCochees.get(i).isSelected()) {
									int a = declaration.update(2,listJustificaifEleve.get(i).getId() );
								}
							
							}
						}
					});
					btnRefuser.setBackground(new Color(255, 0, 0));
					btnRefuser.setBounds(88, 25, 89, 23);
					btnRefuser.setVisible(true);
					panelPieds.add(btnRefuser);
					
					JButton btnValider = new JButton("Valider");
					btnValider.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							for(int i=0; i<CasesaCochees.size();i++) {
								if(CasesaCochees.get(i).isSelected()) {
									int a = declaration.update(1,listJustificaifEleve.get(i).getId() );
									System.out.println(a);
								}
							
							}
						}
					});
					btnValider.setBackground(new Color(0, 255, 128));
					btnValider.setBounds(246,  25, 89, 23);
					panelPieds.add(btnValider);
					
					
					JPanel panelBase = new JPanel();
					panelBase.setLayout(new GridLayout(3, 1));
					
					
				    
				    JScrollPane scrollpane = new JScrollPane(panelCorps);
				    
				    
				   panelBase.add(panelEntete);
					panelBase.add(scrollpane, BorderLayout.CENTER);
					panelBase.add(panelPieds);
					
					
					frame.setContentPane(panelBase);
	}

}
