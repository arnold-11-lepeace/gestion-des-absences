package Model;

public class ElevePeriodeAbsenceDeclare {

	/**
	 * @param idEleve
	 * @param nomEleve
	 * @param dateDebutPeriode
	 * @param dateFinPeriode
	 * @param nomFichier
	 */
	private int idEleve;
	private String nomEleve;
	private String dateDebutPeriode;
	private String dateFinPeriode;
	private String nomFichier;

	public ElevePeriodeAbsenceDeclare(int idEleve, String nomEleve, String dateDebutPeriode, String dateFinPeriode,
			String nomFichier) {
		// TODO Auto-generated constructor stub
	}

	public int getIdEleve() {
		return idEleve;
	}

	public void setIdEleve(int idEleve) {
		this.idEleve = idEleve;
	}

	public String getNomEleve() {
		return nomEleve;
	}

	public void setNomEleve(String nomEleve) {
		this.nomEleve = nomEleve;
	}

	public String getDateDebutPeriode() {
		return dateDebutPeriode;
	}

	public void setDateDebutPeriode(String dateDebutPeriode) {
		this.dateDebutPeriode = dateDebutPeriode;
	}

	public String getDateFinPeriode() {
		return dateFinPeriode;
	}

	public void setDateFinPeriode(String dateFinPeriode) {
		this.dateFinPeriode = dateFinPeriode;
	}

	public String getNomFichier() {
		return nomFichier;
	}

	public void setNomFichier(String nomFichier) {
		this.nomFichier = nomFichier;
	}

}
