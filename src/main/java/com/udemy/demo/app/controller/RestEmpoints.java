package com.udemy.demo.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestEmpoints {

	@RequestMapping("/course")
	public Course getEmpoint(@RequestParam(value="name", defaultValue="Spring Boot", required=false) String name,
			@RequestParam(value="chapterCount", defaultValue="2", required=false) int chapterCount) {
		return new Course(name, chapterCount);
	}
}
