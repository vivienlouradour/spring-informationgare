package org.imta.fila1.spring.informationgare.course;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CourseServiceStub extends CourseService{
	
	private ArrayList<Course> courses;
	
	public CourseServiceStub(){
		
		courses = new ArrayList<>();
		
		ArrayList<Sillon> vSillons = new ArrayList<>();
		ArrayList<Passage> vPassages = new ArrayList<>();
		ArrayList<POI> vPois = new ArrayList<>();
		
		POI vPoi = new POI(1, true, "cholet");
		vPois.add(vPoi);
		vPois.add(new POI(2, true, "nantes"));
		vPois.add(new POI(3, true, "paris"));
		
		vSillons.add(new Sillon(1, vPois));
		vPassages.add(new Passage(new Timestamp(new Date().getTime()), 1, vPoi));
		
		courses.add(new Course(1, 1, vSillons, vPassages));
		
	}
	
	
	@Override
	public List<Course> getDeparts(String aGare) {
		
		ArrayList<Course> vDeparts = new ArrayList<>();
		for (Course vCourse: courses) {
			if (vCourse.isGareDepart(aGare)) {
				vDeparts.add(vCourse);				
			}
		}
		return vDeparts;
	}
	
	@Override
	public List<Course> getArrivees(String aGare) {
		
		ArrayList<Course> vDeparts = new ArrayList<>();
		for (Course vCourse: courses) {
			if (vCourse.isGareArrivee(aGare)) {
				vDeparts.add(vCourse);				
			}
		}
		return vDeparts;
	}
}

