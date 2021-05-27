package com.learnjava.rest.webservice.restfulwebservices.dao.jpa;

import com.learnjava.rest.webservice.restfulwebservices.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSpringJpaRepository extends JpaRepository<Course, Long> {
}
