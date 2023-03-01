package com.springrest.springrest.services;
import com.springrest.springrest.entities.Courses;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {
    List<Courses> list;
    public CourseServiceImpl(){
        list=new ArrayList<>();
        list.add(new Courses(145,"Spring Boot Course","13 hours Course"));
        list.add(new Courses(150,"Django Course","15 hours Course"));
    }
    public List<Courses> getCourses(){
        return list;
    }
    public Courses getCourses(long courseId){
        Courses c=null;
        for(Courses course:list){
            if(course.getId()==courseId){
                c=course;
                break;
            }
        }
        return c;
    }
    public Courses addCourse(Courses course){
        list.add(course);
        return course;
    }
}
