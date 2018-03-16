package org.imta.fila1.spring.informationgare.course;

import java.util.ArrayList;

/**
 * Interface Repository des courses
 * 
 * @author Cédric GARCIA
 *
 */
public interface CourseRepository {

    ArrayList<Course> getCourses();
    void addCourse(Course course);
	
}
