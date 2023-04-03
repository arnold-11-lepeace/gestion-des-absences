package Model;

public class Gestionnaire {
	
	 /**
  	 * @param idGestionnaire
	 * @param motDePasseGestionnaire
	 */
	
	 private int idGestionnaire;
	 private String motDePasseGestionnaire;
	 
	 public Gestionnaire(int idGestionnaire,String motDePasseGestionnaire) {
		super();
		this.idGestionnaire = idGestionnaire;
		this.motDePasseGestionnaire=motDePasseGestionnaire;
		
	}
	
	
	public  int getIdGestionnaire() {
		return idGestionnaire;
	}

	public void setIdGestionnaire(int idGestionnaire) {
		this.idGestionnaire = idGestionnaire;
	}
	public  String getMotDePasseEleve() {
		return motDePasseGestionnaire;
	}

	public void setMotDePasseEleve(String motDePasseEleve) {
		this.motDePasseGestionnaire = motDePasseGestionnaire;
	}

}
