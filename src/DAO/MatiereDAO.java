package DAO;
import java.sql.*;
import java.util.ArrayList;
import Model.Matiere;

/**
 * Classe d'acces aux donnees contenues dans la table etudiant
 * 
 * @author Arnold ONANA
 * @version 1.0
 */
public class MatiereDAO extends ConnectionDAO {

	/**
	 * Constructor
	 * 
	 */
	public MatiereDAO() {
		super();
		
	}
	
	/*
	 * Permet d'ajouter une matière dans la base de données
	 * 
	 */

	public int add(Matiere matiere) {
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
			ps = con.prepareStatement("INSERT INTO MATIERE (NOMMATIERE,MASSEHORAIRE,REPARTITIONHORAIRECM,REPARTITIONHORAIRETD,REPARTITIONHORAIRETP) VALUES (?, ?, ?,?,?)");
			ps.setString(1, matiere.getNomMatiere());
			ps.setFloat(2, matiere.getMasseHoraireMatiere());
			ps.setFloat(3, matiere.getRepartitionHoraireCM());
			ps.setFloat(4, matiere.getRepartitionHoraireTD());
			ps.setFloat(5, matiere.getRepartitionHoraireTP());

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
	
	
	public static void main(String[] args) throws SQLException {
		int returnValue;
		float t1[]= {2, 25, 23};
		Matiere m1= new Matiere("info",80 , t1);
		MatiereDAO matiere = new MatiereDAO();
		returnValue= matiere.add(m1);
		//System.out.println("Ajout éffectué");
		System.out.println(returnValue + " matiére ajoutée");
		
	}

}
