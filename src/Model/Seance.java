package Model;

import java.util.Date;

public class Seance {
	
	private int idSeance;
	private String nomSeance;
	private String typeSeance;
	private int numerogroupe;
	private String date ;
	private Float Durree;


	public Seance(int idSeance,String nomSeance, String typeSeance,int numerogroupe,
			String date,Float Durree) {
		// TODO Auto-generated constructor stub
		super();
		
		this.idSeance=idSeance;
		this.nomSeance=nomSeance;
		this.typeSeance = typeSeance;
		this.numerogroupe=numerogroupe;
		this.date = date;
		this.Durree=Durree;
		
	}

	public int getIdSeance() {
		return idSeance;
	}

	public void setIdSeance(int idSeance) {
		this.idSeance = idSeance;
	}

	public String getNomSeance() {
		return nomSeance;
	}

	public void setNomSeance(String nomSeance) {
		this.nomSeance = nomSeance;
	}
	public String getTypeSeance() {
		return typeSeance;
	}

	public void setTypeSeance(String typeSeance) {
		this.typeSeance = typeSeance;
	}
	
	public int getNumerogroupe() {
		return numerogroupe;
	}

	public void setNumerogroupe(int numerogroupe) {
		this.numerogroupe = numerogroupe;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	

	public Float getDurree() {
		return Durree;
	}

	public void setDurree(Float durree) {
		Durree = durree;
	}

}
