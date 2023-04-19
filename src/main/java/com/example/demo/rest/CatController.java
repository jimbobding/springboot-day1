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

import com.example.demo.domain.Cat;
import com.example.demo.service.CatService;

@RestController
public class CatController {
	@GetMapping("/")
	public String greeting() {
		return "Hello World";
	}

	List<Cat> cats = new ArrayList<>();

	private CatService service;

	public CatController(CatService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Cat> createCat(@RequestBody Cat c) {

		Cat created = this.service.createCat(c);
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	public List<Cat> getAll() {
		return this.service.getAll();
	}

	@GetMapping("/get/{id}")
	public Cat get(@PathVariable int id) {
		return this.service.getById(id);
	}

	@DeleteMapping("/remove/{id}")
	public Cat remove(@PathVariable int id) {
		return this.service.delete(id);
	}

	@PatchMapping("/update/{id}")
	public Cat update(@PathVariable int id, @RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "hasWhiskers", required = false) Boolean hasWhiskers,
			@RequestParam(name = "evil", required = false) Boolean evil,
			@RequestParam(name = "length", required = false) Integer length) {

		return this.service.getById(id);

	}

}
