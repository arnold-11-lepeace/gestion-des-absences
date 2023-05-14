/**
 * 
 */
package DAO;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;

import Model.Eleve;
import Model.ElevePeriodeAbsenceDeclare;
import Model.PeriodeAbsence;
import oracle.net.aso.c;


/**
 * Classe d'acces aux donnees contenues dans la table PERIODE ABSENCE
 * 
 * @author Arnold ONANA
 * @version 1.0
 */
public class PeriodeAbsenceDAO extends ConnectionDAO {

	/**
	 *constructor
	 */
	public PeriodeAbsenceDAO() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	/*
	 * Permet d'ajouter une matière dans la base de données
	 * 
	 */

	public int add(PeriodeAbsence periode) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;
		// connexion a la base de donnees
		try {
			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// preparation de l'instruction SQL, chaque ? represente une valeur
			// a communiquer dans l'insertion.
			// les getters permettent de recuperer les valeurs des attributs
			ps = con.prepareStatement("INSERT INTO PERIODEABSENCE (DATEDEBUT,DATEFIN,TYPE,ETAT,FICHIERJUSTIFICATIF,idetudiantp) VALUES ( ?, ?, ?, ?, ?,?)");
			ps.setString(1,  periode.getDateDebutPeriodeAbsence());
			ps.setString(2,   periode.getDateFinPeriodeAbsence());
			ps.setString(3, "physique");
			ps.setInt(4, 0);
			FileReader reader = new FileReader(periode.getFichierJustificatif());
			ps.setCharacterStream(5,reader );
			ps.setInt(6,10 );
			//ps.setInt(7, 10);
			System.out.println("C'est arrivé");

			// Execution de la requete
			returnValue = ps.executeUpdate();
			System.out.println("ajout éffectué");
		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				System.out.println("Cet identifiant de matière existe déjà !Ajout impossible !");
			else
				e.printStackTrace();
		} finally {
			// fermeture du preparedStatement et de la connexion
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception ignore) {
			}
			
		}
		return returnValue;
	}
	
	
	/*
	 * Permet de modifier l'état de la période absence déclarée dans la base de données
	 * 
	 */
	public int update(int etat, int idDeclarationabs) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {

			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// preparation de l'instruction SQL, chaque ? represente une valeur
			// a communiquer dans la modification.
			// les getters permettent de recuperer les valeurs des attributs souhaites
			ps = con.prepareStatement("UPDATE periodeabsence SET periodeabsence.etat=? WHERE IDABSENCEPERIODE = ?");
			ps.setInt(1, etat);
			ps.setInt(2, idDeclarationabs);
			

			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// fermeture du preparedStatement et de la connexion
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception ignore) {
			}
		}
		return returnValue;
	}

	
	
	
	public ArrayList<PeriodeAbsence> getList() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<PeriodeAbsence> returnValue = new ArrayList<PeriodeAbsence>();
		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL,LOGIN , PASS);
			ps = con.prepareStatement("SELECT * FROM PERIODEABSENCE");
			// on execute la requete
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			while (rs.next()) {
				returnValue.add(new PeriodeAbsence(rs.getInt(1),""+rs.getString(2), ""+rs.getDate(3), rs.getString(4),
					null, rs.getInt(5)));
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			// fermeture du rs, du preparedStatement et de la connexion
			try {
				if (rs != null)
					rs.close();
			} catch (Exception ignore) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ignore) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ignore) {
			}

			// fermeture du rs, du preparedStatement et de la connexion

		}
		return returnValue;
	}
	
	
	public static void main(String[] args) throws SQLException {
		int returnValue;
		float t1[]= {2, 25, 23};
		//DateFormat 
		 //Date aujourdhui = new Date(1, 1, 2);
		 Date aujourdhui = new Date(23, 1, 01);
		 Date Demain = new Date(23, 1, 02);
		 File file = new File("C:\\Users\\ONANA Arnold\\eclipse-workspace\\Gestion absences\\images\\flèche déposer.png");
		 PeriodeAbsenceDAO periodeDAO = new PeriodeAbsenceDAO();
		 
		// PeriodeAbsence P1 = new PeriodeAbsence(aujourdhui, Demain, "physique", file, 1);
		 //returnValue = periodeDAO.add(P1);
			//System.out.println("Ajout éffectué");
			//System.out.println(returnValue + " eleve ajoute");
	    DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
	        DateFormat.SHORT,
	        DateFormat.SHORT);
	    ArrayList<PeriodeAbsence> listEleve = new PeriodeAbsenceDAO().getList();
		// listEleve
		for (int i = 0; i < listEleve.size(); i++) {
			System.out.println(listEleve.get(i).getDateDebutPeriodeAbsence());
		}
	    
	    //System.out.println(formater.format(aujourdhui));
		//System.out.println(returnValue + " matiére ajoutée");
	    //System.out.println(shortDateFormat.format(aujourdhui));
		
	}

}
