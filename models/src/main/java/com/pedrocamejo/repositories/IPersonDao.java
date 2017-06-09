package com.pedrocamejo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedrocamejo.models.Person;

public interface IPersonDao extends JpaRepository<Person, Long>{


}
