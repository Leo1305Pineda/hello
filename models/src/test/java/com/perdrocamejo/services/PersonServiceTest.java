package com.perdrocamejo.services;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import com.pedrocamejo.ApplicationModelsConfiguration;
import com.pedrocamejo.exeptions.IdNotFountExecption;
import com.pedrocamejo.models.Person;
import com.pedrocamejo.services.PersonService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={ApplicationModelsConfiguration.class})
@Transactional
public class PersonServiceTest  {
	
	@Autowired
	private PersonService personService;

	@Test
	@Rollback
	public void testEmptyPeopleTable() {
		assertEquals(0,personService.findAll().size());
		Map<String,String> parameters = new HashMap<>();
		parameters.put("name","Rhonal");
		parameters.put("surname","Rodriguez");
		personService.findAll(new PageRequest(1,20), parameters);
	}

	@Test
	@Rollback
	public void testSavePerson() {
		Person person = new Person("Rhonal "," Chirinos","V-19827297");
		personService.save(person);
		assertNotNull(person.getId());
		
		
	}

	@Test(expected=IdNotFountExecption.class)
	@Rollback
	public void testDeletePerson()
	{
		Person person = new Person("Rhonal "," Chirinos","V-19827297");
		personService.save(person);
		assertNotNull(person.getId());
		personService.delete(person);
		personService.findById(person.getId());
	}

	@Test
	@Rollback
	@Sql(scripts="/db/test/data_people.sql")
	public void testFindByIdPeople() {
		personService.findById(1L);
	}

}



