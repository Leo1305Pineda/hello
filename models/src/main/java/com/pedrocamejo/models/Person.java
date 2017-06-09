package com.pedrocamejo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="people")
public class Person {

	private Long id;
	private String name;
	private String surname;
	private String identity;
	
	public Person() {
		super();
	}
	
	public Person(String name, String surname, String identity) {
		super();
		this.name = name;
		this.surname = surname;
		this.identity = identity;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column
	@Size(min=3,max=35)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column
	@Size(min=3,max=35)
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Column
	@NotEmpty
	public String getIdentity() {
		return identity;
	}
	
	public void setIdentity(String identity) {
		this.identity = identity;
	}
}