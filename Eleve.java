package Model;

public class Eleve {
	
	 /**
	  	 * @param idEleve
		 * @param motDePasseEleve
		 * @param nomEleve
		 * @param prenomEleve
		 * @param adresseMailEleve
		 * @param filiereEleve
		 */
		 private int idEleve;
		 private String motDePasseEleve;	 
		 private String nomEleve;
		 private String prenomEleve;
		 private String adresseMailEleve;
		 private String filiereEleve;
		 
		 
		 
		
		public Eleve(int idEleve,String motDePasseEleve,String nomEleve, String prenomEleve,
				 String adresseMailEleve, String filiereEleve) {
			super();
			this.idEleve = idEleve;
			this.motDePasseEleve=motDePasseEleve;
			this.nomEleve = nomEleve;
			this.prenomEleve = prenomEleve;
			this.adresseMailEleve = adresseMailEleve;
			this.filiereEleve = filiereEleve;
			
		}
		
		
		public  int getIdEleve() {
			return idEleve;
		}

		public void setIdEleve(int idEleve) {
			this.idEleve = idEleve;
		}
		public  String getmotDePasseEleve() {
			return motDePasseEleve;
		}

		public void setmotDePasseEleve(String motDePasseEleve) {
			this.motDePasseEleve = motDePasseEleve;
		}

		public String getNomEleve() {
			return nomEleve;
		}

		public void setNomEleve(String nomEleve) {
			this.nomEleve = nomEleve;
		}

		public String getPrenomEleve() {
			return prenomEleve;
		}

		public void setPrenomEleve(String prenomEleve) {
			this.prenomEleve = prenomEleve;
		}

		public String getAdresseMailEleve() {
			return adresseMailEleve;
		}

		public void setAdresseMailEleve(String adresseMailEleve) {
			this.adresseMailEleve = adresseMailEleve;
		}

		public String getFiliereEleve() {
			return filiereEleve;
		}

		public void setFiliereEleve(String filiereEleve) {
			this.filiereEleve = filiereEleve;
		}

		

	
}
