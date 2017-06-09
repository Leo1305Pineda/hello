package com.pedrocamejo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.pedrocamejo.exceptions.InvalidRequestException;
import com.pedrocamejo.models.Person;
import com.pedrocamejo.services.PersonService;

@RestController
@CrossOrigin(origins="*")
public class PersonController {

	@Autowired 
	private PersonService personService;

	@RequestMapping(value="/people",method=RequestMethod.GET)
	public List<Person> index() {
		return personService.all();
	}
	
	@RequestMapping(value="people/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> show(@PathVariable("id") long id) {
		Person person = personService.findById(id);
		return new ResponseEntity<Person>(person,HttpStatus.OK);
	}

	@RequestMapping(value="/people",method=RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody @Valid Person person, BindingResult result) {
		if(result.hasErrors()){
			throw new InvalidRequestException("Error Model",result);
		}
		person = personService.save(person);
		return new ResponseEntity<Person>(person,HttpStatus.OK);
	}
	

	@RequestMapping(value = "/people/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody @Valid Person person,BindingResult result) {
		Person currentPerson = personService.findById(id);
		if(result.hasErrors()){
			throw new InvalidRequestException("Error Model",result);
		}
		currentPerson.setName(person.getName());
		currentPerson.setSurname(person.getSurname());
		personService.save(currentPerson);
		return new ResponseEntity<Person>(currentPerson,HttpStatus.OK);
	}

	@RequestMapping(value = "/people/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		Person person = personService.findById(id);
		personService.delete(person);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
