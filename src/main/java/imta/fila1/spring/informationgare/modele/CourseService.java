package imta.fila1.spring.informationgare.modele;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe Service des courses
 * 
 * @author Cédric GARCIA
 *
 */
@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;

	public List<Course> getCourses() {
		
		ArrayList<Course> courses = new ArrayList<>();
		for (Course c: courseRepository.findAll()) {
			courses.add(c);
		}
		return courses;
	}
	
	public List<Course> getDeparts(String aGare) {
		
		ArrayList<Course> vDeparts = new ArrayList<>();
		for (Course vCourse: courseRepository.findAll()) {
			if (vCourse.isGareDepart(aGare)) {
				vDeparts.add(vCourse);				
			}
		}
		return vDeparts;
	}
	
	public List<Course> getArrivees(String aGare) {
		
		ArrayList<Course> vDeparts = new ArrayList<>();
		for (Course vCourse: courseRepository.findAll()) {
			if (vCourse.isGareArrivee(aGare)) {
				vDeparts.add(vCourse);				
			}
		}
		return vDeparts;
	}

	public Course getCourse(String id) {	
		
		return courseRepository.findOne(id);
	}

	public void addCourse(Course course) {
		
		courseRepository.save(course);		
	}

	public void updateCourse(Course course) {
		
		courseRepository.save(course);
	}

	public void deleteCourse(String id) {
		
		courseRepository.delete(id);		
	}
}
