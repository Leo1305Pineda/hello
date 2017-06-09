package com.perdrocamejo.services;

import static org.junit.Assert.*;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import com.pedrocamejo.ApplicationModelsConfiguration;
import com.pedrocamejo.exeptions.IdNotFountExecption;
import com.pedrocamejo.models.Person;
import com.pedrocamejo.services.PersonService;

/**
 * Unit test for simple App.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes={ApplicationModelsConfiguration.class})
@Transactional
public class PersonServiceTest  {
	
	@Autowired
	private PersonService personService;

	@Test
	@Rollback(true)
	public void testEmptyPeopleTable() {
		assertEquals(0,personService.all().size());
	}

	@Test
	@Rollback(true)
	public void testSavePerson() {
		Person person = new Person("Rhonal "," Chirinos","V-19827297");
		personService.save(person);
		assertNotNull(person.getId());
	}

	@Test(expected=IdNotFountExecption.class)
	@Rollback(true)
	public void testDeletePerson()
	{
		Person person = new Person("Rhonal "," Chirinos","V-19827297");
		personService.save(person);
		assertNotNull(person.getId());
		personService.delete(person);
		personService.findById(person.getId());
	}

	@Test
	@Rollback(true)
	@Sql(scripts="/db/test/data_people.sql")
	public void testFindByIdPeople() {
		personService.findById(1L);
	}

}



