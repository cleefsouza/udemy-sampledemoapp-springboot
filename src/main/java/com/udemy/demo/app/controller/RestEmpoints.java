package com.udemy.demo.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.demo.app.model.Course;
import com.udemy.demo.app.repositories.CourseRepository;

import javassist.NotFoundException;

@RestController
@RequestMapping(value = "/demo/app/")
public class RestEmpoints {

	@Autowired
	CourseRepository courseRp;

	@GetMapping("/courses")
	public List<Course> getAllCourses() {
		return courseRp.findAll();
	}

	@GetMapping("/course/{id}")
	public Course getCourseId(@PathVariable(value = "id") Long id) throws NotFoundException {
		return courseRp.findById(id).orElseThrow(() -> new NotFoundException("Course"));
	}

	@PostMapping("/addCourse")
	public Course addCourse(@Valid @RequestBody Course course) {
		return courseRp.save(course);
	}

	@DeleteMapping("/deleteCourse/{id}")
	public ResponseEntity<Course> deleteCourse(@PathVariable(value = "id") Long id) throws NotFoundException {
		Course course = courseRp.findById(id).orElseThrow(() -> new NotFoundException("Course"));
		courseRp.delete(course);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/updateCourse/{id}")
	public Course updateCourse(@PathVariable(value = "id") Long id, @Valid @RequestBody Course courseDetails)
			throws NotFoundException {
		Course course = courseRp.findById(id).orElseThrow(() -> new NotFoundException("Course"));
		course.setName(courseDetails.getName());
		course.setChapterCount(courseDetails.getChapterCount());

		Course updateCourse = courseRp.save(course);
		return updateCourse;
	}
}
