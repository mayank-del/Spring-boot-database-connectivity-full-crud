package com.springrest.springrest.services;
import java.util.List;
import com.springrest.springrest.entities.Courses;
public interface CourseService {
    public List<Courses> getCourses();
    public Courses getCourses(long courseId);
    public Courses addCourse(Courses course );
    public Courses updateCourse(long courseId,Courses course);
    public Courses updateByCourse(Courses course);
    public Courses deleteCourse(long courseId);
}
