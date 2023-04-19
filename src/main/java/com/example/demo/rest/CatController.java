package com.example.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import domain.Cat;

@RestController
public class CatController {
	@GetMapping("/")
	public String greeting() {
		return "Hello World";
		
		
	}
	List<Cat>cats = new ArrayList<>();
	@PostMapping("/create")
	public ResponseEntity<Cat> createCat(@RequestBody Cat c) {
		this.cats.add(c); 
		Cat created = this.cats.get(cats.size() -1);
		return  new ResponseEntity<>(created, HttpStatus.CREATED );
	}
	@GetMapping("/getAll")
	public List<Cat>getAll(){
		return this.cats;
	}
	
	@GetMapping("/get/{id}")
	public Cat get(@PathVariable int id){
		return this.cats.get(id);
	}
	
	@DeleteMapping("/remove/{id}") 
	public Cat remove(@PathVariable int id) {
		return this.cats.remove(id);
	}
	
	@PatchMapping("/update/{id}")
	public Cat update(@PathVariable int id,
			 		 @RequestParam(name="name", required = false) String name,
					 @RequestParam(name="hasWhiskers", required = false) Boolean hasWhiskers, 
					 @RequestParam(name="evil", required = false) Boolean evil, @RequestParam(name="length", required = false) Integer length) {
		
					Cat toUpdate = this.cats.get(id);
							if(name != null)toUpdate.setName(name);
							if(hasWhiskers != null)toUpdate.setHasWhiskers(hasWhiskers);
							if(evil != null)toUpdate.setEvil(evil);
							if(length != null)toUpdate.setLength(length);
							
						return this.cats.get(id);
		
	}
	
	
}
