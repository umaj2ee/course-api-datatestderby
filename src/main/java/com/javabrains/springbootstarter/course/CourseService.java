package com.javabrains.springbootstarter.course;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
/*private List<Course> topics=new ArrayList<>(Arrays.asList(
		new Course("Spring","Spring Framework","SpringFrameWork Descriptiion"),
		new Course("Java","Core Java","core java Descriptiion"),
		new Course("javascript","javaScript","javascript Descriptiion")
		));*/
public List<Course> getAllCourses(String topicId){
	//return topics;
	List<Course> courses=new ArrayList<>();
	//method references java8 lambda expressions
	courseRepository.findByTopicId(topicId).forEach(courses::add);
    return courses;
}

public Course getCourse(String id) {
	//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
 return courseRepository.findOne(id);

}

public void addCourse(Course course) {
	courseRepository.save(course);
	}

public void updateCourse(Course course) {
/*for(int i=0;i<topics.size();i++)	{
	Topic t =topics.get(i);
	if(t.getId().equals(id)) {
		topics.set(i,topic);
		return;
	}
}*/

	courseRepository.save(course);
}

public void deleteCourse(String id) {
	/*
	for(int i=0;i<topics.size();i++)	{
		Topic t =topics.get(i);
		if(t.getId().equals(id)) {
			topics.remove(i);
			return;
		}
	}*/
	courseRepository.delete(id);
}



}
