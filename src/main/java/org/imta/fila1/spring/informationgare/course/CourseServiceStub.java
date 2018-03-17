package org.imta.fila1.spring.informationgare.course;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

//@Service
public class CourseServiceStub extends CourseService {

	private ArrayList<Course> courses;

	private String actualType;
	private String actualCity;

	public CourseServiceStub(){
		
		courses = new ArrayList<>();

		ArrayList<Sillon> vSillons = new ArrayList<>();
		ArrayList<Passage> vPassages = new ArrayList<>();
		ArrayList<POI> vPois = new ArrayList<>();
		Calendar vCalendar = Calendar.getInstance();

		POI vDepart = new POI(1, true, "cholet");
		POI vArret = new POI(2, true, "nantes");
		POI vArrivee = new POI(3, true, "paris");

		vPois.add(vDepart);
		vPois.add(vArret);
		vPois.add(vArrivee);

		vSillons.add(new Sillon(1, vPois));

		vPassages.add(new Passage(new Timestamp(vCalendar.getTimeInMillis()), 1, vDepart));
		vCalendar.add(Calendar.HOUR_OF_DAY, 1);
		vPassages.add(new Passage(new Timestamp(vCalendar.getTimeInMillis()), 2, vArret));
		vCalendar.add(Calendar.HOUR_OF_DAY, 1);
		vPassages.add(new Passage(new Timestamp(vCalendar.getTimeInMillis()), 3, vArrivee));

		

		courses.add(new Course(1, 1, vSillons, vPassages));

	}

	public void duplicate() {
		Course course = courses.get(0);
		courses.add(course);
	}

	@Override
	public List<Course> getDeparts(String aGare) {

		ArrayList<Course> vDeparts = new ArrayList<>();
		for (Course vCourse : courses) {
			if (vCourse.isGareDepart(aGare)) {
				vDeparts.add(vCourse);
			}
		}
		return vDeparts;
	}

	@Override
	public List<Course> getArrivees(String aGare) {

		ArrayList<Course> vDeparts = new ArrayList<>();
		for (Course vCourse : courses) {
			if (vCourse.isGareArrivee(aGare)) {
				vDeparts.add(vCourse);
			}
		}
		return vDeparts;
	}
}
