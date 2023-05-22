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
import Model.ElevePeriodeAbsenceDeclare;

/**
 * @author ONANA Arnold
 *
 */
public class ElevePeriodeAbsenceDeclareDAO extends ConnectionDAO {

	public ArrayList<ElevePeriodeAbsenceDeclare> getList() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<ElevePeriodeAbsenceDeclare> returnValue = new ArrayList<ElevePeriodeAbsenceDeclare>();
		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT IDETUDIANTP,NOMETUDIANT,DATEDEBUT,DATEFIN,FICHIERJUSTIFICATIF \r\n"
					+ " FROM PERIODEABSENCE INNER JOIN ETUDIANT ON(IDETUDIANTP= IDETUDIANT)\r\n" + " WHERE ETAT=0");
			// on execute la requete
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			while (rs.next()) {
				returnValue.add(new ElevePeriodeAbsenceDeclare(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), "azer" + rs.getString(5)));
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
		ArrayList<ElevePeriodeAbsenceDeclare> listEleve = new ElevePeriodeAbsenceDeclareDAO().getList();
		// listEleve
		for (int i = 0; i < listEleve.size(); i++) {
			System.out.println(listEleve.get(i).getNomFichier());
		}
	}

}
