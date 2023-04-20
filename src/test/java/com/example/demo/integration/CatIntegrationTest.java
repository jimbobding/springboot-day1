package com.example.demo.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.domain.Cat;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:cat-schema.sql", "classpath:cat-data.sql"})
public class CatIntegrationTest{
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void testCreate() throws Exception {
		Cat newCat = new Cat(true, "Chairman Meow", true ,12);
		String newCatAsJson = this.mapper.writeValueAsString(newCat);
		//Method is overloaded
		RequestBuilder req = MockMvcRequestBuilders.post("/create").content(newCatAsJson).contentType(MediaType.APPLICATION_JSON);
		
		ResultMatcher checkStatus = status().isCreated();
		Cat created = new Cat(2, true, "Chairman Meow", true ,12);
		String createdAsJson = this.mapper.writeValueAsString(created);
		ResultMatcher checkBody = content().json(createdAsJson);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test 
	void testGetAll() throws Exception {
		List<Cat> cats = new ArrayList<>();
		Cat created = new Cat(1, true, "Mr Bigglesworth", true ,27);
		cats.add(created);
		String newCatAsJson = this.mapper.writeValueAsString(cats);
		RequestBuilder req = MockMvcRequestBuilders.get("/getAll");
		
		
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(newCatAsJson);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
		
	}
	
	@Test 
	void testGetById() throws Exception {
		List<Cat> cats = new ArrayList<>();
		Cat created = new Cat(1, true, "Mr Bigglesworth", true ,27);
		cats.add(created);
		String newCatAsJson = this.mapper.writeValueAsString(created);
		RequestBuilder req = MockMvcRequestBuilders.get("/get/1");
		
		
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(newCatAsJson);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
		
		
	}
	
	@Test 
	void testDelete() throws Exception {
		List<Cat> cats = new ArrayList<>();
		Cat created = new Cat(1, true, "Mr Bigglesworth", true ,27);
		cats.add(created);
		String newCatAsJson = this.mapper.writeValueAsString(created);
		RequestBuilder req = MockMvcRequestBuilders.delete("/remove/1");
	
		
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(newCatAsJson);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
		
		
	}
	
	@Test 
	void testUpdate() throws Exception {
		
//		Long id = 1l;
		Cat created = new Cat(1, true, "Mr Bigglesworth", true ,27);
		String newCatAsJson = this.mapper.writeValueAsString(created);
		
		RequestBuilder req = patch("/update/" + 1).queryParam("hasWhiskers","true").queryParam("name","Mr Bigglesworth").queryParam("evil","true").queryParam("length", "27");
	
		
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(newCatAsJson);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
		
		
	}
	

}
