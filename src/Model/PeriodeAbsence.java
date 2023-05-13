/**
 * 
 */
package Model;

import java.io.File;
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
	 * @param fichierJustificatif
	 * @param etat
	 */
	private Date dateDebutPeriodeAbsence;
	private Date dateFinPeriodeAbsence;
	private String typeAbsence;
	private File fichierJustificatif;
	private int etat;
	
	
		public PeriodeAbsence(Date dateDebutPeriodeAbsence, Date dateFinPeriodeAbsence, String typeAbsence,
				File fichierJustificatif, int etat) {
			super();
			this.dateDebutPeriodeAbsence = dateDebutPeriodeAbsence;
			this.dateFinPeriodeAbsence = dateFinPeriodeAbsence;
			this.typeAbsence = typeAbsence;
			this.fichierJustificatif = fichierJustificatif;
			this.etat = etat;
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
		
		
		public File getFichierJustificatif() {
			return fichierJustificatif;
		}
		
		
		public void setFichierJustificatif(File fichierJustificatif) {
			this.fichierJustificatif = fichierJustificatif;
		}
		
		
		public int getEtat() {
			return etat;
		}
		
		public void setEtat(int etat) {
			this.etat = etat;
		}
	
	
	

}
