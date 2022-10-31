package com.flofyhome.FLOFYHOME.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
public class User  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="estado", length = 50)
	private String state;
	
	@Column(name="contraseña", length = 50)
	private String password;
	
	@Column(name="email", length = 50)
	private String email;
	
	@ManyToOne()
	@JoinColumn(name = "permisos", referencedColumnName = "id")
	private Permission permission;
	
	@OneToMany(mappedBy = "chief_inventory")
	private List<Purchase> chief_inventory;
	
	@OneToMany(mappedBy = "user")
	private List<Address> user;
	
	@OneToMany(mappedBy = "client")
	private List<Order> client;
	
	@OneToMany(mappedBy = "salesperson")
	private List<Sale> salesperson;
	
	@ManyToMany
	
	@JoinTable(name = "rel_personas_usuarios", 
			joinColumns = @JoinColumn(name = "id_Usuario"),
			inverseJoinColumns = @JoinColumn(name = "id_Persona"))
	
	
	private List<Person> persons = new ArrayList<>();
	
	@ManyToMany(mappedBy = "users")
	private List<Role> rols = new ArrayList<>();
}
