package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Cat;

public interface CatService {
	public Cat createCat(Cat c);
	
	public Cat getById(int id );
	
	List<Cat> getAll();
	
	public Cat delete(int id );
	
	public Cat update(int id, String name, Boolean hasWhiskers, Boolean evil, Integer length);
}
