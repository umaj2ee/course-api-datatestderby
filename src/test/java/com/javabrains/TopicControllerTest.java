package com.javabrains;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.junit.Assert.*;
import com.javabrains.springbootstarter.topic.Topic;
import com.javabrains.springbootstarter.topic.TopicController;
import com.javabrains.springbootstarter.topic.TopicService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = TopicController.class, secure = false)
public class TopicControllerTest {

	@Autowired
	private MockMvc mockMvc;
	

	@MockBean
	private TopicService topicService;
	private Topic mockTopic=new Topic("Spring","Spring","SpringFrameWork Descriptiion");
	private Topic mockTopicpost=new Topic("Springpost","Springpost","SpringFrameWorkpost Descriptiion");
	
	String exampleCourseJson = "{\"id\":\"Springpost\", \"name\":\"Springpost\"  ,\"description\":\"SpringFrameWorkpost Descriptiion\"}";

	@Test
	public void createTopic() throws Exception {
		//
		Mockito.when(topicService.addTopic(Mockito.any(Topic.class))).thenReturn(mockTopicpost);;

		// Send course as body to /students/Student1/courses
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("http://localhost:8080/topics/")
				.accept(MediaType.APPLICATION_JSON).content(exampleCourseJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.CREATED.value(), response.getStatus());

		

	}
	
	
//	@Test
//	public void retrieveDetailsOfTopic() throws Exception {
//
//		Mockito.when(
//				topicService.getTopic(Mockito.anyString())).thenReturn(mockTopic);
//
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
//				"http://localhost:8080/topics/Spring").accept(
//				MediaType.APPLICATION_JSON);
//
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//
//		System.out.println("==="+result.getResponse());
//		String expected = "{\"id\":\"Springboot\", \"name\":\"Springboot\"  ,\"description\":\"SpringbootFrameWork Descriptiion\"}";
//
//		JSONAssert.assertEquals(expected, result.getResponse()
//				.getContentAsString(), false);
//	}
//	
//	
//	
	
	
}
