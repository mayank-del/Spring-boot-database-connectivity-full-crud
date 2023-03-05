package com.springrest.springrest.services;
import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Courses;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;
//    List<Courses> list;

    public CourseServiceImpl(){
        /* list=new ArrayList<>();
        list.add(new Courses(145,"Spring Boot Course","13 hours Course"));
        list.add(new Courses(150,"Django Course","15 hours Course")); */
    }
    public List<Courses> getCourses(){
        /* return list; */
        return courseDao.findAll();
    }
    public Courses getCourses(long courseId){
        /* Courses c=null;
        for(Courses course:list){
            if(course.getId()==courseId){
                c=course;
                break;
            }
        }
        return c; */
        return courseDao.findById(courseId).orElse(null);

    }
    public Courses addCourse(Courses course){
        /* list.add(course); */
        courseDao.save(course);
        return course;
    }

    //My Method

    /* public Courses updateCourse(long courseId,Courses course){
        
        int i=0;
        for(Courses specificCourse:list){
            if(specificCourse.getId()==courseId){
                list.set(i,course);
                break;
            }
            i++;
        }
        return course; 
    } */

    public Courses updateByCourse(Courses course){
        /* list.forEach(e->{
            if(e.getId()==course.getId()){
                e.setTitle(course.getTitle());
                e.setDescription(course.getDescription());
            }
        }); */
        courseDao.save(course);
        return course;
    } 
    public Courses deleteCourse(long courseId){
        /* int i=0;
        Courses c=null;

        for(Courses specificCourse:list){
            if(specificCourse.getId()==courseId){
                list.remove(i);
                c=specificCourse;
                break;
            }
            i++;
        }
        return c;  */
        /* Courses entity=courseDao.findById(courseId).orElse(null);
        courseDao.delete(entity);
        return entity; */
        Courses entity=courseDao.findById(courseId).orElse(null);
        courseDao.deleteById(courseId);
        return entity;

    }
    /* public void deleteCourse(long parseLong){
        list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
    } */
   /*  @Override
    public Courses updateCourse(long courseId, Courses course) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateCourse'");
    } */
}
