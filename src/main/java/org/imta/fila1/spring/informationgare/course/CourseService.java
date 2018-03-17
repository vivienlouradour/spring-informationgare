package org.imta.fila1.spring.informationgare.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Classe Service des courses
 * 
 * @author Cédric GARCIA
 *
 */
@Service
public class CourseService {

	public static CourseRepository courseRepository = new SimpleCourseRepository();
	// @Autowired
	// CourseRepository courseRepository;

	private String actualType;
	private String actualCity;

	public String getActualType() {
		return actualType;
	}

	public void setActualType(String actualType) {
		this.actualType = actualType;
	}

	public String getActualCity() {
		return actualCity;
	}

	public void setActualCity(String actualCity) {
		this.actualCity = actualCity;
	}

	public List<Course> getDeparts(String aGare) {

		ArrayList<Course> vDeparts = new ArrayList<>();
		for (Course vCourse : courseRepository.findAll()) {
			if (vCourse.isGareDepart(aGare)) {
				vDeparts.add(vCourse);
			}
		}
		return vDeparts;
	}

	public List<Course> getArrivees(String aGare) {

		ArrayList<Course> vDeparts = new ArrayList<>();
		for (Course vCourse : courseRepository.findAll()) {
			if (vCourse.isGareArrivee(aGare)) {
				vDeparts.add(vCourse);
			}
		}
		return vDeparts;
	}

	// public Course getCourse(String id) {
	//
	// return courseRepository.findOne(id);
	// }

	public void addCourse(Course course) {
		courseRepository.add(course);
	}

	// public void updateCourse(Course course) {
	//
	// courseRepository.save(course);
	// }
	//
	// public void deleteCourse(String id) {
	//
	// courseRepository.delete(id);
	// }

	public void duplicate() {
		Course course = courseRepository.findAll().get(0);
		courseRepository.findAll().add(course);
	}

	public int countEntries() {
		return courseRepository.countEntries();
	}
}