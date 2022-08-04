package com.springboot.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.app.entity.Person;
import com.springboot.app.service.PersonService;

@Controller
public class PersonController {

	@Autowired
	private PersonService personService;

	@GetMapping("/persons")
	public String listPersons(Model model) {
		model.addAttribute("persons",personService.getAllPersons());
		return "persons";
	}

	@GetMapping("persons/add")
	public String createPerson(Model model) {
		Person p = new Person();
		model.addAttribute("person",p);
		return "create_person";
	}

	@PostMapping("/persons")
	public String savePerson(@ModelAttribute("person") Person person) {
		personService.savePerson(person);
		return "redirect:/persons";
	}

	@GetMapping("/persons/edit/{id}")
	public String editPersonDetails(@PathVariable long id,Model model) {
		model.addAttribute("person", personService.getPersonById(id));
		return "edit_person";
	}

	@PostMapping("/persons/{id}")
	public String updatePerson(@PathVariable Long id,
			@ModelAttribute("person") Person person,
			Model model) {

		Person existingperson = personService.getPersonById(id);
		existingperson.setId(id);
		existingperson.setName(person.getName());
		existingperson.setCardNumber(person.getCardNumber());
		existingperson.setDate(person.getDate());
		existingperson.setStatus(person.isStatus());

		personService.updatePerson(existingperson);
		return "redirect:/persons";
	}

	@GetMapping("/persons/{id}")
	public String deletePerson(@PathVariable Long id) {
		personService.deletePersonById(id);
		return "redirect:/persons";
	}

	@GetMapping("/persons/search")
	public String findByName(@RequestParam String name, Model model) {
		model.addAttribute("persons",personService.findByName(name));
		return "detailsByName";
	}
	
	
	
	
}