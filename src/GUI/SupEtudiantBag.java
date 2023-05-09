package GUI;
 
/*
 * GridBagLayoutDemo.java requires no other files.
 */
 
import java.awt.*;
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
import Model.Eleve;
 
public class SupEtudiantBag {
    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
 
    public static void addComponentsToPane(Container pane) {
        if (RIGHT_TO_LEFT) {
            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
 
        JButton button;
    pane.setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    if (shouldFill) {
    //natural height, maximum width
    c.fill = GridBagConstraints.HORIZONTAL;
    }
 
    button = new JButton("Button 1");
    if (shouldWeightX) {
    c.weightx = 0.5;
    }
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 0;
    c.gridy = 0;
    pane.add(button, c);
 
    button = new JButton("Button 2");
    c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0.5;
    c.gridx = 1;
    c.gridy = 0;
    pane.add(button, c);
 
    button = new JButton("Button 3");
    c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0.5;
    c.gridx = 2;
    c.gridy = 0;
    pane.add(button, c);
 
    button = new JButton("Long-Named Button 4");
    c.fill = GridBagConstraints.HORIZONTAL;
    c.ipady = 40;      //make this component tall
    c.weightx = 0.0;
    c.gridwidth = 3;
    c.gridx = 0;
    c.gridy = 1;
    pane.add(button, c);
 
    button = new JButton("5");
    c.fill = GridBagConstraints.HORIZONTAL;
    c.ipady = 0;       //reset to default
    c.weighty = 1.0;   //request any extra vertical space
    c.anchor = GridBagConstraints.PAGE_END; //bottom of space
    c.insets = new Insets(10,0,0,0);  //top padding
    c.gridx = 1;       //aligned with button 2
    c.gridwidth = 2;   //2 columns wide
    c.gridy = 2;       //third row
    pane.add(button, c);
    }
 
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("GridBagLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Set up the content pane.
        //addComponentsToPane(frame.getContentPane());
 
        
        JButton button;
        Container contentPane = frame.getContentPane();
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        contentPane.setLayout(gridbag);
        c.fill = GridBagConstraints.HORIZONTAL; 
           
    	JPanel panelEntete = new JPanel();
		panelEntete.setBackground(new Color(128, 128, 255));
		panelEntete.setSize(600, 400);

		//panelEntete.setBounds(10, 11, 414, 53);
		//frame.getContentPane().add(panelEntete);
		panelEntete.setLayout(new GridBagLayout());
		
		JLabel labelESIGELEC = new JLabel("ESIGELEC");
		labelESIGELEC.setForeground(Color.RED);
		labelESIGELEC.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelESIGELEC.setBounds(10, 11, 91, 36);
		//c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        gridbag.setConstraints(labelESIGELEC, c);
        //c.gridwidth = 3;
		panelEntete.add(labelESIGELEC);
		
		JButton btnDeconnexion = new JButton("Déconnexion");
		btnDeconnexion.setBackground(new Color(255, 0, 0));
		btnDeconnexion.setBounds(283, 11, 108, 23);
		panelEntete.add(btnDeconnexion);
		
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        gridbag.setConstraints(panelEntete, c);
        c.gridwidth = 3;
        contentPane.add(panelEntete);

        
        
	    String counts[] = { "Id", "Nom", "Prénom", "Filière", "Action" };

	    
		ArrayList<Eleve> listEleve= new EleveDao().getList();
		ArrayList<JCheckBox> CasesaCochees= new ArrayList<>();
		
		  JRadioButton form[][] = new JRadioButton[listEleve.size()][5];
		  
		  


	    
		  JPanel panelCorps = new JPanel();
	    panelCorps.setSize(600, 400);
	    //p.setBounds(10, 65, 414, 400);
	    panelCorps.setLayout(new GridLayout(listEleve.size(), 5, 10, 0));
	   for (int row = 0; row < listEleve.size(); row++) {
	      ButtonGroup bg = new ButtonGroup();
	      for (int col = 0; col < 5; col++) {
	        if (row == 0) {
	          panelCorps.add(new JLabel(counts[col]));
	        } else {
	        	switch (col) {
	        	case 0:
	        		 panelCorps.add(new JLabel(""+listEleve.get(row).getIdEleve()));
	        		 break;
	        	case 1:
	        		panelCorps.add(new JLabel(listEleve.get(row).getNomEleve()));
	        		break;
	        	case 2:
	        		panelCorps.add(new JLabel(listEleve.get(row).getPrenomEleve()));
	        		break;
	        	case 3:
	        		panelCorps.add(new JLabel(listEleve.get(row).getFiliereEleve()));
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
	    JScrollPane scrollpane = new JScrollPane(panelCorps);
	    //scrollpane.setBounds(10, 65, 414, 400);
	    scrollpane.setSize(20, 20);
	    
        c.gridx = 0;
        c.gridy = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight=2;
        c.gridwidth=2;
        gridbag.setConstraints(scrollpane, c);
        contentPane.add(scrollpane);

        button = new JButton("Button 3");
        c.gridx = 4;
        c.gridy = 1;
        //gridbag.setConstraints(button, c);
        //contentPane.add(button);

        button = new JButton("Long-Named Button 4");
        c.ipady = 40;      //make this component tall
        c.weightx = 0.0;
        c.gridwidth = 3;
        c.insets = new Insets(10,10,10,10);  //top padding
        

        c.gridx = 0;
        c.gridy = 1;
        //gridbag.setConstraints(button, c);
        //contentPane.add(button);

        button = new JButton("Button 5");
        c.ipady = 0;       //reset to default
        c.weighty = 1.0;   //request any extra vertical space
        c.anchor = GridBagConstraints.SOUTH; //bottom of space
        c.insets = new Insets(10,0,0,0);  //top padding
        c.gridx = 1;       //aligned with button 2
        c.gridwidth = 2;   //2 columns wide
        c.gridy = 2;       //third row
        gridbag.setConstraints(button, c);
        contentPane.add(button);
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}