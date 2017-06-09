package com.pedrocamejo.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedrocamejo.exeptions.IdNotFountExecption;
import com.pedrocamejo.models.Person;
import com.pedrocamejo.repositories.IPersonDao;

@Service("personService")
public class PersonService {
	
	@Autowired
	private IPersonDao personDao;

	public List<Person> all() {
		return personDao.findAll();
	}

	public Person save(Person person) {
		return (Person) personDao.save(person);
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
