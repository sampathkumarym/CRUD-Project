package com.springboot.app.service;

import java.util.List;

import com.springboot.app.entity.Person;


public interface PersonService {
	
	List<Person> getAllPersons();
	Person savePerson(Person person);
	Person getPersonById(Long id);
	Person updatePerson(Person person);
	void deletePersonById(Long id);
	List<Person> findByName(String name);

}
