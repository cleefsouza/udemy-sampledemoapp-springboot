package com.udemy.demo.app.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.demo.app.model.Course;

@RestController
public class RestEmpoints {

	@Value("${default.course.name}")
	private String cName;

	@Value("${default.course.chapterCount}")
	private int cChapterCount;
	
	@RequestMapping("/defaultCourse")
	public Course getDefaultCourse(
			@RequestParam(value = "name", defaultValue = "Spring Boot", required = false) String name,
			@RequestParam(value = "chapterCount", defaultValue = "2", required = false) int chapterCount) {
		return new Course(cName, cChapterCount);
	}

	@RequestMapping("/course")
	public Course getEmpoint(@RequestParam(value = "name", defaultValue = "Spring Boot", required = false) String name,
			@RequestParam(value = "chapterCount", defaultValue = "2", required = false) int chapterCount) {
		return new Course(name, chapterCount);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/register/course")
	public String saveCourse(@RequestBody Course course) {
		return "Your course name is " + course.getName() + " with " + course.getChapterCount()
				+ " chapters saved successfuly";
	};
}
