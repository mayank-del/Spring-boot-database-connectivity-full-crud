package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Courses;
import com.springrest.springrest.services.CourseService;

@RestController//Rest-> Representational state transfer
public class MyController {
    
    @Autowired
    private CourseService courseService;

    @GetMapping("/home")
    public String home(){
        return "Welcome to Courses Page.";
    }

    //get courses

    @GetMapping("/courses")
    public List<Courses> getCourse(){
        return this.courseService.getCourses();
    }
    @GetMapping("/courses/{courseId}")
    public Courses getCourse(@PathVariable String courseId){
        return this.courseService.getCourses(Long.parseLong(courseId));
    }
    @PostMapping("/courses")
    public Courses addCourse(@RequestBody Courses course){
        return this.courseService.addCourse(course);
    }
    /* @PutMapping("/courses/{courseId}")
    public Courses updateCourse(@PathVariable String courseId,@RequestBody Courses course){
        return this.courseService.updateCourse(Long.parseLong(courseId),course);
    } */
    @PutMapping("/courses")
    public Courses updateByCourse(@RequestBody Courses course){
        return this.courseService.updateByCourse(course);
    }
    @DeleteMapping("/courses/{courseId}")
    public Courses deleteCourse(@PathVariable String courseId){
        return this.courseService.deleteCourse(Long.parseLong(courseId));
    }
    
}
