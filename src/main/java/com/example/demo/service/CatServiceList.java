package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;

import com.example.demo.domain.Cat;

@Service 
public class CatServiceList implements CatService {
	
	List<Cat>cats = new ArrayList<>();
	@Override
	public Cat createCat(Cat c) {
		this.cats.add(c); 
		Cat created = this.cats.get(cats.size() -1);
		return  created;
	}

	@Override
	public Cat getById(int id) {
		return this.cats.get(id);
	}

	@Override
	public List<Cat> getAll() {
		return this.cats;
		
	}

	@Override
	public Cat delete(int id) {
		return this.cats.get(id);
		
	}

	@Override
	public Cat update(int id, String name, Boolean hasWhiskers, Boolean evil, Integer length) {
		Cat toUpdate = this.cats.get(id);
		if(name != null)toUpdate.setName(name);
		if(hasWhiskers != null)toUpdate.setHasWhiskers(hasWhiskers);
		if(evil != null)toUpdate.setEvil(evil);
		if(length != null)toUpdate.setLength(length);
		return this.cats.get(id);
	}

}
