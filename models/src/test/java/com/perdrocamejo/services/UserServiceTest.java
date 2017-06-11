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
import com.pedrocamejo.models.User;
import com.pedrocamejo.services.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={ApplicationModelsConfiguration.class})
@Transactional
public class UserServiceTest  {
	
	@Autowired
	private UserService UserService;

	@Test
	@Rollback
	public void testEmptyPeopleTable() {
		assertEquals(0,UserService.findAll().size());
		Map<String,String> parameters = new HashMap<>();
		parameters.put("name","Rhonal");
		parameters.put("surname","Rodriguez");
		UserService.findAll(new PageRequest(1,20), parameters);
	}

	@Test
	@Rollback
	public void testSaveUser() {
		User user = new User("Rhonal "," Chirinos","V-19827297","RhonalChirins@gmail.com");
		user.setLogin("rchirinos");
		user.setPassword("12345678");
		UserService.save(user);
		assertNotNull(user.getId());
	}

	@Test(expected=IdNotFountExecption.class)
	@Rollback
	public void testDeleteUser()
	{
		User user = new User("Rhonal "," Chirinos","V-19827297","RhonalChirins@gmail.com");
		user.setLogin("rchirinos");
		user.setPassword("12345678");
		UserService.save(user);
		assertNotNull(user.getId());
		UserService.delete(user);
		UserService.findById(user.getId());
	}

	@Test
	@Rollback
	@Sql(scripts="/db/test/data_users.sql")
	public void testFindByIdPeople() {
		UserService.findById(1L);
	}

}



