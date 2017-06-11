package com.pedrocamejo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedrocamejo.models.User;

public interface IuserRepository extends JpaRepository<User, Long> {

	
}
