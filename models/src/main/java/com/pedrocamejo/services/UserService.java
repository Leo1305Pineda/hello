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
import com.pedrocamejo.models.User;
import com.pedrocamejo.repositories.IuserRepository;


@Service
public class UserService {
	
	@Autowired
	private IuserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public Page<User> findAll(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	public Page<User> findAll(Pageable pageable, Map<String, String> parameters) {
		User user = new User();
		user.setName(parameters.get("name").toString());
		ExampleMatcher matcher = ExampleMatcher.matching()
				.withMatcher("name", match -> match.caseSensitive().ignoreCase().contains());
		Example<User> example = Example.of(user,matcher);
		return userRepository.findAll(example,pageable);
	}
	
	public User save(User User) {
		return (User) userRepository.save(User);
	}

	public User save(User user,User userForm) {
		user.setIdentity(userForm.getIdentity());
		user.setName(userForm.getName());
		user.setSurname(userForm.getIdentity());
		return save(user);
	}
	
	public void delete(User user){
		userRepository.delete(user);
	}
	
	public User findById(Long id){
		User user =  (User) userRepository.findOne(id) ; 
		if(user == null){
			throw new IdNotFountExecption(id);
		}
		return user;
	}

}
