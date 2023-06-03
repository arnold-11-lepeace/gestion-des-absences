/**
 * 
 */
package Model;

import java.util.Date;

/**
 * @author ONANA Arnold
 *
 */
public class PeriodeAbsence {

	/**
	 * @param dateDebutPeriodeAbsence
	 * @param dateFinPeriodeAbsence
	 * @param typeAbsence
	 * @param nomFichierJustificatif
	 * @param etat
	 */
	private int id;
	private Date dateDebutPeriodeAbsence;
	private Date dateFinPeriodeAbsence;
	private String typeAbsence;
	private String nomFichierJustificatif;
	private int etat;

	public PeriodeAbsence(int id, Date dateDeDebut, Date datedeFin, String typeAbsence,
			String nomFichierJustificatif, int etat) {
		super();
		this.id = id;
		this.dateDebutPeriodeAbsence = dateDeDebut;
		this.dateFinPeriodeAbsence = datedeFin;
		this.typeAbsence = typeAbsence;
		this.nomFichierJustificatif = nomFichierJustificatif;
		this.etat = etat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateDebutPeriodeAbsence() {
		return dateDebutPeriodeAbsence;
	}

	public void setDateDebutPeriodeAbsence(Date dateDebutPeriodeAbsence) {
		this.dateDebutPeriodeAbsence = dateDebutPeriodeAbsence;
	}

	public Date getDateFinPeriodeAbsence() {
		return dateFinPeriodeAbsence;
	}

	public void setDateFinPeriodeAbsence(Date dateFinPeriodeAbsence) {
		this.dateFinPeriodeAbsence = dateFinPeriodeAbsence;
	}

	public String getTypeAbsence() {
		return typeAbsence;
	}

	public void setTypeAbsence(String typeAbsence) {
		this.typeAbsence = typeAbsence;
	}

	public String getNomFichierJustificatif() {
		return nomFichierJustificatif;
	}

	public void setNomFichierJustificatif(String nomFichierJustificatif) {
		this.nomFichierJustificatif = nomFichierJustificatif;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

}
