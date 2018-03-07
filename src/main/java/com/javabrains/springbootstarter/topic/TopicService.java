package com.javabrains.springbootstarter.topic;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
private List<Topic> topics=new ArrayList<>(Arrays.asList(
		new Topic("Spring","Spring Framework","SpringFrameWork Descriptiion"),
		new Topic("Java","Core Java","core java Descriptiion"),
		new Topic("javascript","javaScript","javascript Descriptiion")
		));
public List<Topic> getAllTopics(){
	//return topics;
	List<Topic> topics=new ArrayList<>();
	//method references java8 lambda expressions
    topicRepository.findAll().forEach(topics::add);
    return topics;
}

public Topic getTopic(String id) {
	//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
 return topicRepository.findOne(id);

}

public Topic addTopic(Topic topic) {
	topicRepository.save(topic);
	return topic;
	}

public void updateTopic(String id,Topic topic) {
/*for(int i=0;i<topics.size();i++)	{
	Topic t =topics.get(i);
	if(t.getId().equals(id)) {
		topics.set(i,topic);
		return;
	}
}*/

	topicRepository.save(topic);
}

public void deleteTopic(String id) {
	/*
	for(int i=0;i<topics.size();i++)	{
		Topic t =topics.get(i);
		if(t.getId().equals(id)) {
			topics.remove(i);
			return;
		}
	}*/
	topicRepository.delete(id);
}



}
