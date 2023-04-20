package com.example.demo.unit;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;


import com.example.demo.domain.Cat;
import com.example.demo.repo.CatRepo;
import com.example.demo.service.CatService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CatServiceDBTest {

	@Autowired
	private CatService service;
	
	@MockBean
	private CatRepo repo;
	
	@Test 
	void testUpdate() {
		long id =1;
		Cat existing = new Cat(id, true, "Tiddles", false, 12);
		Cat updated = new Cat(id, false, "Fluffy", true, 99);
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(existing));
		Mockito.when(this.repo.save(updated)).thenReturn(updated);
		
		Assertions.assertEquals(updated, this.service.update((int) id, updated.getName(), updated.isHasWhiskers(), updated.isEvil(), updated.getLength()));
	}
}
