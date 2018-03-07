package com.javabrains.springbootstarter.topic;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class TopicController {
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topic> getTopics() {
		return  topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id) {
	return topicService.getTopic(id);
	}
    
//	@RequestMapping(method=RequestMethod.POST,value="/topics")
//	public void addTopic(@RequestBody Topic topic) {
//	   topicService.addTopic(topic);
//   }
	@RequestMapping(method=RequestMethod.POST,value="/topics")
	public ResponseEntity<Void> addTopic(@RequestBody Topic topic) {
	   Topic topic1=topicService.addTopic(topic);
	   if (topic1 == null)
			return ResponseEntity.noContent().build();

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(topic.getId()).toUri();

		return ResponseEntity.created(location).build();
	   
   }
	
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic,@PathVariable String id) {
	   topicService.updateTopic(id,topic);
   }
	
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{id}")
	public void updateTopic(@PathVariable String id) {
	   topicService.deleteTopic(id);
   }
	
}