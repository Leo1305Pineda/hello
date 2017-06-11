package com.pedrocamejo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.pedrocamejo.exceptions.InvalidRequestException;
import com.pedrocamejo.exeptions.IdNotFountExecption;
import com.pedrocamejo.models.Person;
import com.pedrocamejo.services.PersonService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/people")
public class PersonController {

	@Autowired 
	private PersonService personService;

	@RequestMapping(method=RequestMethod.GET)
	public List<Person> index() {
		return personService.findAll();
	}
	
	@RequestMapping(value="index2",method=RequestMethod.GET)
	public ResponseEntity<Page<Person>> index2(Pageable pageable, PagedResourcesAssembler<?> assembler,@RequestParam MultiValueMap<String, String> parameters) {
		Page<Person> persons = personService.findAll(pageable,parameters.toSingleValueMap());
		return new ResponseEntity<Page<Person>>(persons,HttpStatus.OK);
	}

	
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	public ResponseEntity<?> showPerson(@PathVariable(name="id",required=true) Person person,@PathVariable("id") Long id) {
		if(person == null) throw new IdNotFountExecption(id);
		return new ResponseEntity<Person>(person,HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody @Valid Person person, BindingResult result) {
		if(result.hasErrors()) throw new InvalidRequestException(result);
		person = personService.save(person);
		return new ResponseEntity<Person>(person,HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@PathVariable(name="id",required=true) Person person, @RequestBody Person personForm, @PathVariable("id") Long id,BindingResult result) {
		if(result.hasErrors()) throw new InvalidRequestException(result);
		personService.save(person,personForm);
		return new ResponseEntity<Person>(person,HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable("id") Person person, @PathVariable("id") Long id) {
		if(person == null) throw new IdNotFountExecption(id);
		personService.delete(person);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
