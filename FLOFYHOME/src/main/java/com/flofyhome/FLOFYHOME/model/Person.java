package com.flofyhome.FLOFYHOME.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "personas")

public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Id
	private long dni;
	
	@Column(name = "nombres", length = 100)
	private String name;

	@Column(name = "apellidos", length = 50)
	private String lastname;

	@Column(name = "tipo_documento", length = 50)
	private String document_type;

	@Column(name = "celular")
	private long cellphone;

	@Column(name = "telefono")
	private long telephone;

	@ManyToMany(mappedBy = "persons")
	private List<User> users = new ArrayList<>();

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDocument_type() {
		return document_type;
	}

	public void setDocument_type(String document_type) {
		this.document_type = document_type;
	}

	public long getCellphone() {
		return cellphone;
	}

	public void setCellphone(long cellphone) {
		this.cellphone = cellphone;
	}

	public long getTelephone() {
		return telephone;
	}

	public void setTelephone(long telephone) {
		this.telephone = telephone;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	

	

	



	
	
}
