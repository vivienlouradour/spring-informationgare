package org.imta.fila1.spring.informationgare.course;

import java.util.ArrayList;

public class SimpleCourseRepository implements CourseRepository {

    private ArrayList<Course> courses = new ArrayList<>();

    @Override
    public ArrayList<Course> getCourses() {
        return courses;
    }

    @Override
    public void addCourse(Course course) {
        courses.add(course);
    }
}
