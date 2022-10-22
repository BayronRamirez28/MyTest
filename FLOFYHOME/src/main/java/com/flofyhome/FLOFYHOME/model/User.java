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

@Entity
@Table(name = "usuarios")
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
	@JoinColumn(name = "rol", referencedColumnName = "id")
	private Role roles;
	
	@ManyToOne()
	@JoinColumn(name = "permisos", referencedColumnName = "id")
	private Permission permisos;
	
	@OneToMany(mappedBy = "jefe_inventario")
	private List<Purchase> jefe_inventario;
	
	@OneToMany(mappedBy = "usuario")
	private List<Address> usuario;
	
	@OneToMany(mappedBy = "cliente")
	private List<Order> cliente;
	
	@OneToMany(mappedBy = "vendedor")
	private List<Sale> vendedor;
	
	@ManyToMany
	
	@JoinTable(name = "rel_personas_usuarios", 
			joinColumns = @JoinColumn(name = "id_Usuario"),
			inverseJoinColumns = @JoinColumn(name = "id_Persona"))
	
	
	private List<Person> persons = new ArrayList<>();
	
	
}
