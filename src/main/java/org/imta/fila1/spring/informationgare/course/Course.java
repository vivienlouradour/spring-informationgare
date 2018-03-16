package org.imta.fila1.spring.informationgare.course;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Classe de définition des courses
 * 
 * @author Cédric GARCIA
 *
 */
public class Course {

	private int idCourse;
	private int numTrain;
	private String heureDepart;
	private String heureArrivee;
	private String gareArrivee;
	private String gareDepart;
	
	private ArrayList<Sillon> listSillons;
	private ArrayList<Passage> listPassages;
	
	public Course(int idCourse, int numTrain, ArrayList<Sillon> listSillons, ArrayList<Passage> listPassages) {
		
		this.idCourse = idCourse;
		this.numTrain = numTrain;
		this.listSillons = listSillons;
		this.listPassages = listPassages;

		SimpleDateFormat vFormat = new SimpleDateFormat("HH'h'mm");
		Date vDepart = new Date(getPassageDepart().getTimestamp().getTime());
		Date vArrivee = new Date(getPassageArrivee().getTimestamp().getTime());
		
		this.heureDepart = vFormat.format(vDepart);
		this.heureArrivee = vFormat.format(vArrivee);
		
		this.gareDepart = formatNomGare(getPassageDepart().getPoiPassage().getNomPOI());
		this.gareArrivee = formatNomGare(getPassageArrivee().getPoiPassage().getNomPOI());
		
	}
	
	public String formatNomGare(String aGare) {
		return aGare.substring(0,1).toUpperCase() + aGare.substring(1).toLowerCase();
	}

	// Getters - Setters
	public int getIdCourse() {
		
		return idCourse;
	}

	public void setIdCourse(int idCourse) {
		
		this.idCourse = idCourse;
	}

	public int getNumTrain() {
		
		return numTrain;
	}

	public void setNumTrain(int numTrain) {
		
		this.numTrain = numTrain;
	}

	public ArrayList<Sillon> getListSillons() {
		
		return listSillons;
	}

	public void setListSillons(ArrayList<Sillon> listSillons) {
		
		this.listSillons = listSillons;
	}

	public ArrayList<Passage> getListPassages() {
		
		return listPassages;
	}

	public void setListPassages(ArrayList<Passage> listPassages) {
		
		this.listPassages = listPassages;
	}
	
	public Passage getPassageDepart() {
		return getListPassages().get(0);
	}
	
	public Passage getPassageArrivee() {
		return getListPassages().get(getListPassages().size()-1);
	}
	
	public boolean isGareDepart(String aGare) {
		return getPassageDepart().getPoiPassage().getNomPOI().equals(aGare);
	}
	
	public boolean isGareArrivee(String aGare) {
		return getPassageArrivee().getPoiPassage().getNomPOI().equals(aGare);
	}
	
	public String getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(String heureDepart) {
		this.heureDepart = heureDepart;
	}

	public String getHeureArrivee() {
		return heureArrivee;
	}

	public void setHeureArrivee(String heureArrivee) {
		this.heureArrivee = heureArrivee;
	}
	
	public String getGareArrivee() {
		return gareArrivee;
	}

	public void setGareArrivee(String gareArrivee) {
		this.gareArrivee = gareArrivee;
	}
	

	public String getGareDepart() {
		return gareDepart;
	}

	public void setGareDepart(String gareDepart) {
		this.gareDepart = gareDepart;
	}

	
}

