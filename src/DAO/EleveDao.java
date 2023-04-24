package DAO;

import java.sql.*;
import java.util.ArrayList;
import Model.Eleve;

/**
 * Classe d'acces aux donnees contenues dans la table etudiant
 * 
 * @author Arnold ONANA
 * @version 1.0
 */
public class EleveDao extends ConnectionDAO {
	/**
	 * Constructor
	 * 
	 */
	public EleveDao() {
		super();
	}
	/*
	 * Permet d'ajouter un étudiant dans la base de données
	 * 
	 */

	public int add(Eleve eleve) {
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
			ps = con.prepareStatement("INSERT INTO ETUDIANT (MOTDEPASSEETUDIANT,nometudiant,prenometudiant,adressemail,filiereetudiant) VALUES (?, ?, ?,?,?)");
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
	}
	/*
	 * Permet de supprimer un étudiant dans la liste des étudiants
	 * 
	 * @param idEleve
	 * 
	 * @return returnvalue
	 */

	public static int delete(int idEleve) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;
		// connexion a la base de donnees
		try {
			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// preparation de l'instruction SQL, le ? represente la valeur de l'id
			// a communiquer dans la suppression.
			// le getter permet de recuperer la valeur de l'ID du fournisseur
			ps = con.prepareStatement("DELETE FROM ETUDIANT WHERE IDETUDIANT = ?");
			// ps.setInt(1);
			ps.setInt(1, idEleve);
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
			
		}
		return returnValue;
	}

	/*
	 * permet de comparer les identifiants entrées par l'utilisateur à ceux présents
	 * dans la base de données
	 * 
	 * @param id, password
	 */
	public Eleve login(int identifiant, String motDePasse) {
		Connection con = null;
		PreparedStatement ps = null;
		Eleve returnValue = null;
		// connexion a la base de donnees
		try {
			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// preparation de l'instruction SQL, chaque ? represente une valeur
			// a communiquer dans l'insertion.
			// les getters permettent de recuperer les valeurs des attributs
			ps = con.prepareStatement("SELECT * FROM ETUDIANT WHERE IDETUDIANT=? AND MOTDEPASSEETUDIANT= ?");
			ps.setInt(1, identifiant);
			ps.setString(2, motDePasse);

			// Execution de la requete
			ResultSet rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			if (rs.next()) {
				returnValue = new Eleve(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6));
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
		}
		return returnValue;

	}

	/*
	 * Permet de modifier les caractéristiques d'un étudiant
	 * 
	 * @param idEleve
	 * 
	 * @return Eleve
	 */

	/*
	 * public int update(Eleve eleve) { Connection con = null; PreparedStatement ps
	 * = null; int returnValue = 0;
	 * 
	 * // connexion a la base de donnees try { // tentative de connexion con =
	 * DriverManager.getConnection("jdbc:oracle:thin:@oracle.esigelec.fr:1521:orcl",
	 * "C##BDD4_26", "BDD426"); // preparation de l'instruction SQL, chaque ?
	 * represente une valeur // a communiquer dans la modification. // les getters
	 * permettent de recuperer les valeurs des attributs ps =
	 * con.prepareStatement("UPDATE ETUDIANT SET NOMETUDIANT = ? WHERE IDETUDIANT=?"
	 * ); //ps.setInt(1, eleve.getIdEleve()); //ps.setString(2,
	 * eleve.getmotDePasseEleve()); //ps.setString(3, LOGIN); ps.setString(3,
	 * "eleve.getNomEleve()"); //ps.setString(4, eleve.getPrenomEleve());
	 * //ps.setString(5, eleve.getAdresseMailEleve()); //ps.setString(6,
	 * eleve.getFiliereEleve()); // Execution de la requete returnValue =
	 * ps.executeUpdate(); } catch (Exception e) { e.printStackTrace(); } finally {
	 * // fermeture du preparedStatement et de la connexion try { if (ps != null) {
	 * ps.close(); } } catch (Exception ignore) { } try { if (con != null) {
	 * con.close(); } } catch (Exception ignore) { } } return returnValue; }
	 */

	/*
	 * Permet de retourner la liste des étudiants présents dans la base de données
	 * 
	 * @param listEleve
	 * 
	 * @return ArratList Eleve
	 */

	public ArrayList<Eleve> getList() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Eleve> returnValue = new ArrayList<Eleve>();
		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@oracle.esigelec.fr:1521:orcl", "C##BDD4_26", "BDD426");
			ps = con.prepareStatement("SELECT * FROM ETUDIANT");
			// on execute la requete
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			while (rs.next()) {
				returnValue.add(new Eleve(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6)));
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
		EleveDao EleveDAO = new EleveDao();
		// Ce test va utiliser directement votre BDD, on essaie d'éviter les collisions
		// avec vos données en prenant de grands ID
		int[] ids = { 424242, 111111, 222222, 000000 };
		// test du constructeur
		Eleve E1 = new Eleve(ids[0], "azerty", "ONANA", "Arnold", "peace@gmail.com", "apprentie");
		Eleve E2 = new Eleve(ids[1], "StringEleve", "NYA", "Serena", "NYA@gmail.com", "apprentie");
		Eleve E3 = new Eleve(ids[2], "StringEleve", "OTA", "Simon", "OTA@gmail.com", "apprentie");
		Eleve E4 = new Eleve(ids[3], "StringEleve", "OTAMA", "Simon", "OTAMA@gmail.com", "apprentie");
		// test de la methode add
		// returnValue=EleveDAO.add(E1);
		// returnValue=EleveDAO.add(E2);
		// returnValue=EleveDAO.add(E3);
		returnValue = EleveDAO.add(E4);
		System.out.println("Ajout éffectué");
		System.out.println(returnValue + " eleve ajoute");
		// test de la methode get
		// Eleve E = EleveDAO.get(E1);
		// appel implicite de la methode toString de la classe Object (a eviter)
		// System.out.println(E1);
		// System.out.println();

		// test de la methode getList
		ArrayList<Eleve> listEleve = new EleveDao().getList();
		// listEleve
		for (int i = 0; i < listEleve.size(); i++) {
			System.out.println(listEleve.get(i).getNomEleve());
		}
		for (Eleve e : listEleve) {
			// appel explicite de la methode toString de la classe Object (a privilegier)
			System.out.println(e.toString());
		}
		// test de la methode delete
		// On supprime les 3 articles qu'on a créé
		returnValue = 0;
		// for (int id : ids) {
		returnValue = EleveDao.delete(000000);
		// System.out.println(returnValue + " fournisseur supprime");
		// }
		System.out.println();

	}

}