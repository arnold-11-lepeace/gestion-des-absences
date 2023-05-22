package Model;

public class Matiere {
	/**
	 * @param nomMatiere
	 * @param masseHoraireMatiere
	 * @param tabRepartHoraire
	 * @param nombreSemainesDispensees
	 */

	private String nomMatiere;
	private float masseHoraireMatiere;
	private float tabRepartHoraire[] = new float[3];
	// private int nombreSemainesDispensees;

	public Matiere(String nomMatiere, float masseHoraireMatiere, float[] tabRepartHoraire) {
		// TODO Auto-generated constructor stub
		super();
		this.nomMatiere = nomMatiere;
		this.masseHoraireMatiere = masseHoraireMatiere;
		this.tabRepartHoraire = tabRepartHoraire;
	}

	public String getNomMatiere() {
		return nomMatiere;
	}

	public void setNomMatiere(String nomMatiere) {
		this.nomMatiere = nomMatiere;
	}

	public float getMasseHoraireMatiere() {
		return masseHoraireMatiere;
	}

	public void setMasseHoraireMatiere(float masseHoraireMatiere) {
		this.masseHoraireMatiere = masseHoraireMatiere;
	}

	public float[] getTabRepartHoraire() {
		return tabRepartHoraire;
	}

	public void setTabRepartHoraire(float[] tabRepartHoraire) {
		this.tabRepartHoraire = tabRepartHoraire;
	}

	public float getRepartitionHoraireCM() {
		return tabRepartHoraire[0];
	}

	public float getRepartitionHoraireTD() {
		return tabRepartHoraire[1];
	}

	public float getRepartitionHoraireTP() {
		return tabRepartHoraire[2];
	}

}
