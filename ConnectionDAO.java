package DAO;

/**
 * Classe de connexion à la base de données
 * 
 * @author Arnold  ONANA
 * @version 1.0
 * */

public class ConnectionDAO {
		final static String URL   = "jdbc:oracle:thin:@oracle.esigelec.fr:1521:orcl";

		final static String LOGIN = "LOGIN";   
		final static String PASS  = "MOT DE PASSE";   
		
		/**
		 * Constructor
		 * 
		 */
		public ConnectionDAO() {
			// chargement du pilote de bases de donnees
			try {
				Class.forName("oracle.jdbc.OracleDriver");
			} catch (ClassNotFoundException e) {
				System.err.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
			}
		}
	

}
