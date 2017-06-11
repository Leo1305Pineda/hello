package com.pedrocamejo.services;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pedrocamejo.exeptions.IdNotFountExecption;
import com.pedrocamejo.models.Person;
import com.pedrocamejo.repositories.IPersonDao;

@Service
public class PersonService {
	
	@Autowired
	private IPersonDao personDao;

	public List<Person> findAll() {
		return personDao.findAll();
	}

	public Page<Person> findAll(Pageable pageable) {
		return personDao.findAll(pageable);
	}

	public Page<Person> findAll(Pageable pageable, Map<String, String> parameters) {
		Person person = new Person();
		person.setName(parameters.get("name").toString());
		ExampleMatcher matcher = ExampleMatcher.matching()
				.withMatcher("name", match -> match.caseSensitive().ignoreCase().contains());
		Example<Person> example = Example.of(person,matcher);
		return personDao.findAll(example,pageable);
	}
	
	public Person save(Person person) {
		return (Person) personDao.save(person);
	}

	public Person save(Person person,Person personForm) {
		person.setIdentity(personForm.getIdentity());
		person.setName(personForm.getName());
		person.setSurname(personForm.getIdentity());
		return save(person);
	}
	
	public void delete(Person person){
		personDao.delete(person);
	}
	
	public Person findById(Long id){
		Person person =  (Person) personDao.findOne(id) ; 
		if(person == null){
			throw new IdNotFountExecption(id);
		}
		return person;
	}
 

	

}
