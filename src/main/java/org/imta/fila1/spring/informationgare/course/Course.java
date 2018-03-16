package org.imta.fila1.spring.informationgare.course;

import java.util.ArrayList;

/**
 * Classe de définition des courses
 * 
 * @author Cédric GARCIA
 *
 */
public class Course {

	private int idCourse;
	private int numTrain;
	private ArrayList<Sillon> listSillons;
	private ArrayList<Passage> listPassages;
	
	public Course(int idCourse, int numTrain, ArrayList<Sillon> listSillons, ArrayList<Passage> listPassages) {
		
		this.idCourse = idCourse;
		this.numTrain = numTrain;
		this.listSillons = listSillons;
		this.listPassages = listPassages;
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
	
	public boolean isGareDepart(String aGare) {
		POI vPoi = getListPassages().get(0).getPoiPassage();
		return vPoi.getNomPOI().equals(aGare);
	}
	
	public boolean isGareArrivee(String aGare) {
		POI vPoi = getListPassages().get(getListPassages().size()).getPoiPassage();
		return vPoi.getNomPOI().equals(aGare);
	
	}
	
}

