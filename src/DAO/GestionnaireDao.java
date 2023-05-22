package DAO;

import java.sql.*;
import java.util.ArrayList;

import Model.Eleve;
import Model.Gestionnaire;

/**
 * Classe d'acces aux donnees contenues dans la table etudian
 * 
 * @author Arnold ONANA
 * @version 1.0
 */

public class GestionnaireDao extends ConnectionDAO {

	/**
	 * Constructor
	 * 
	 */
	public GestionnaireDao() {
		// TODO Auto-generated constructor stub
		super();
	}

	/*
	 * permet de comparer les identifiants entrées par l'utilisateur à ceux présents
	 * dans la base de données
	 * 
	 * @param id, password
	 */
	public Gestionnaire loginGestionnaire(int identifiant, String motDePasse) {
		Connection con = null;
		PreparedStatement ps = null;
		Gestionnaire returnValue = null;
		// connexion a la base de donnees
		try {
			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// preparation de l'instruction SQL, chaque ? represente une valeur
			// a communiquer dans l'insertion.
			// les getters permettent de recuperer les valeurs des attributs
			ps = con.prepareStatement(
					"SELECT * FROM GESTIONNAIRE WHERE IDGESTIONNAIRE=? AND MOTDEPASSEGESTIONNAIRE= ?");
			ps.setInt(1, identifiant);
			ps.setString(2, motDePasse);

			// Execution de la requete
			ResultSet rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			if (rs.next()) {
				returnValue = new Gestionnaire(rs.getInt(1), rs.getString(2));
			}
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
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception ignore) {
			}
		}
		return returnValue;

	}

}
