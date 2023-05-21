/**
 * 
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Eleve;
import Model.Matiere;
import Model.PeriodeAbsence;
import Model.Seance;

/**
 * @author ONANA Arnold
 *
 */
public class SeanceDAO extends ConnectionDAO {

	/**
	 * constructor
	 */
	public SeanceDAO() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	
	/*
	 * Permet d'ajouter une séance de cours dans la base de données
	 * 
	 */

	/*public int add(Seance seance) {
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
			ps = con.prepareStatement("INSERT INTO SEANCE (NOMSEANCE,TYPESEANCE,DATESEANCE,DUREESEANCE) VALUES (?, ?, ?,?,?)");
			// ps.setInt(1, eleve.getIdEleve());
			ps.setString(1, eleve.getmotDePasseEleve());
			ps.setString(2, eleve.getNomEleve());
			ps.setString(3, eleve.getPrenomEleve());
			ps.setString(4, eleve.getAdresseMailEleve());
			ps.setString(5, eleve.getFiliereEleve());

			// Execution de la requete
			returnValue = ps.executeUpdate();
			System.out.println("ajout éffectué");
		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				System.out.println("Cet identifiant de fournisseur existe déjà !Ajout impossible !");
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
	}*/
	/*
	 * Permet de récupérer la liste des séances de cours dans la base de données
	 * 
	 */
	
	public ArrayList<Seance> getList() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Seance> returnValue = new ArrayList<Seance>();
		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL,LOGIN , PASS);
			ps = con.prepareStatement("SELECT * FROM SEANCE");
			// on execute la requete
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			while (rs.next()) {
				//returnValue.
				returnValue.add(new Seance(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getInt(9) ,rs.getString(4),
						rs.getFloat(5)));
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
		ArrayList<Seance> listEleve = new SeanceDAO().getList();
		// listEleve
		for (int i = 0; i < listEleve.size(); i++) {
			System.out.println(listEleve.get(i).getIdSeance());
		}
		
	}


}
