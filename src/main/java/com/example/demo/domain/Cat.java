package com.example.demo.domain;

import java.util.Objects;
import java.util.Optional;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Cat {
	
	public Cat(boolean hasWhiskers, String name, boolean evil, int length) {
		super();
		this.hasWhiskers = hasWhiskers;
		this.name = name;
		this.evil = evil;
		this.length = length;
	}
	
	
	
	public Cat(long id, boolean hasWhiskers, String name, boolean evil, int length) {
		super();
		this.id = id;
		this.hasWhiskers = hasWhiskers;
		this.name = name;
		this.evil = evil;
		this.length = length;
	}
	



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

	public boolean hasWhiskers;
	
	public String name;
	
	public boolean evil;
	
	public int length;
	
	

	
	public Cat () {
		super();
	}
		

	public boolean isHasWhiskers() {
		return hasWhiskers;
	}

	public void setHasWhiskers(boolean hasWhiskers) {
		this.hasWhiskers = hasWhiskers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isEvil() {
		return evil;
	}

	public void setEvil(boolean evil) {
		this.evil = evil;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}



	@Override
	public int hashCode() {
		return Objects.hash(evil, hasWhiskers, id, length, name);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cat other = (Cat) obj;
		return evil == other.evil && hasWhiskers == other.hasWhiskers && id == other.id && length == other.length
				&& Objects.equals(name, other.name);
	}




	

}
