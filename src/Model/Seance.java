package Model;

import java.util.Date;

public class Seance {
	
	private String typeSeance;
	private float dureeSeance;
	private Date date ;

	public Seance(String typeSeance,float dureeSeance,
			Date date) {
		// TODO Auto-generated constructor stub
		super();
		this.typeSeance = typeSeance;
		this.dureeSeance = dureeSeance;
		this.date = date;
		
	}

	public String getTypeSeance() {
		return typeSeance;
	}

	public void setTypeSeance(String typeSeance) {
		this.typeSeance = typeSeance;
	}

	public float getDureeSeance() {
		return dureeSeance;
	}

	public void setDureeSeance(float dureeSeance) {
		this.dureeSeance = dureeSeance;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
