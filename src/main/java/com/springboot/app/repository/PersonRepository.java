package com.springboot.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

import com.springboot.app.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{
	
	@Query("SELECT n FROM Person n WHERE n.name=:name")
	public List<Person> findByName(@RequestParam("name") String name);
	
}