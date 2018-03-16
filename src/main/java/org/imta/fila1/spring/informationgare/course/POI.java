package org.imta.fila1.spring.informationgare.course;

/**
 * Classe des points d'intérêts présents sur un sillon
 * 
 * @author Cédric GARCIA
 *
 */
public class POI {

	private int idPOI;
	private boolean isGare;
	private String nomPOI;
	
	public POI(int id, boolean isGare, String nomPOI) {
		
		this.idPOI = id;
		this.isGare = isGare;
		this.nomPOI = nomPOI;
	}

	// Getters - Setters
	public int getId() {
		
		return idPOI;
	}

	public void setId(int id) {
		
		this.idPOI = id;
	}

	public boolean isGare() {
		
		return isGare;
	}

	public void setGare(boolean isGare) {
		
		this.isGare = isGare;
	}

	public String getNomPOI() {
		
		return nomPOI;
	}

	public void setNomPOI(String nomPOI) {
		
		this.nomPOI = nomPOI;
	}
}
