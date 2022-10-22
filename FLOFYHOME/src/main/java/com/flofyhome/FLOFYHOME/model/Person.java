package com.flofyhome.FLOFYHOME.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "personas")
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nombres", length = 50)
	private String name;

	@Column(name = "apellidos", length = 50)
	private String lastname;

	@Column(name = "tipo_documento", length = 50)
	private String document_type;

	@Column(name = "dni", length = 50)
	private String dni;

	@Column(name = "celular")
	private long cellphone;

	@Column(name = "telefono")
	private long telephone;

	@Column(name = "email", length = 50)
	private String email;
	
	@ManyToMany(mappedBy = "persons")
	private List<User> users = new ArrayList<>();

	
	
}
