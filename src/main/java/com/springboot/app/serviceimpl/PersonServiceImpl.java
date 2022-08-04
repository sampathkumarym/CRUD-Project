package com.springboot.app.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.app.entity.Person;
import com.springboot.app.repository.PersonRepository;
import com.springboot.app.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonRepository personRepository;

	@Override
	public List<Person> getAllPersons() {
		return personRepository.findAll();
	}

	@Override
	public Person savePerson(Person person) {
		if(person.isStatus()==true)
			person.setMessage("Activated");
		else
			person.setMessage("De-Activated");
		return personRepository.save(person);
	}

	@Override
	public Person getPersonById(Long id) {
		return personRepository.findById(id).get();
	}

	@Override
	public Person updatePerson(Person person) {
		if(person.isStatus()==true)
			person.setMessage("Activated");
		else
			person.setMessage("De-Activated");
		return personRepository.save(person);
	}

	@Override
	public void deletePersonById(Long id) {
		personRepository.deleteById(id);
		
	}

	@Override
	public List<Person> findByName(String name) {
		return personRepository.findByName(name);
	}

	
}
