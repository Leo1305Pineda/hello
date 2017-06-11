package com.pedrocamejo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	private Long id;
	private String identity;
	private String name;
	private String surname;
	private String email;
	private String login;	
	private String password;
	private String enable;
	private String accountNonExpired;
	private String credentialNonExpired;
	private String accountNonLocked;
	private Integer idIng;
	
	public User() {
		super();
	}
	
	public User(String identity, String name, String surname, String email) {
		super();
		this.identity = identity;
		this.name = name;
		this.surname = surname;
		this.email = email;
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
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}

	@Column
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Column
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Column
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	@Column
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}

	@Column
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Column
	public String getEnable() {
		return enable;
	}
	public void setEnable(String enable) {
		this.enable = enable;
	}

	@Column(name="account_non_expired")
	public String getAccountNonExpired() {
		return accountNonExpired;
	}
	public void setAccountNonExpired(String accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	@Column(name="credential_non_expired")
	public String getCredentialNonExpired() {
		return credentialNonExpired;
	}
	public void setCredentialNonExpired(String credentialNonExpired) {
		this.credentialNonExpired = credentialNonExpired;
	}

	@Column(name="account_non_locked")
	public String getAccountNonLocked() {
		return accountNonLocked;
	}
	public void setAccountNonLocked(String accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}
	
	@Column(name="id_ing")
	public Integer getIdIng() {
		return idIng;
	}
	public void setIdIng(Integer idIng) {
		this.idIng = idIng;
	}

}
