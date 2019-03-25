package com.udemy.demo.app.repositories;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy.demo.app.model.Course;

@Repository
@Qualifier(value = "CourseRepository")
public interface CourseRepository extends JpaRepository<Course, Long>{

}
