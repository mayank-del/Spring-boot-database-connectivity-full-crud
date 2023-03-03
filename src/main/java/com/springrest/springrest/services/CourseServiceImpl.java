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
    public Courses updateCourse(long courseId,Courses course){
        
        int i=0;
        for(Courses specificCourse:list){
            if(specificCourse.getId()==courseId){
                list.set(i,course);
                break;
            }
            i++;
        }
        return course; 
    }

    public Courses updateByCourse(Courses course){
        list.forEach(e->{
            if(e.getId()==course.getId()){
                e.setTitle(course.getTitle());
                e.setDescription(course.getDescription());
            }
        });
        return course;
    } 
    public Courses deleteCourse(long courseId){
        int i=0;
        Courses c=null;

        for(Courses specificCourse:list){
            if(specificCourse.getId()==courseId){
                list.remove(i);
                c=specificCourse;
                break;
            }
            i++;
        }
        return c; 
    }
    /*public void deleteCourse(long parseLong){
        list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
    } */
}
