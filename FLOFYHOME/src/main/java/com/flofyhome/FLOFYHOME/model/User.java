package com.flofyhome.FLOFYHOME.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
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

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
public class User  implements Serializable, UserDetails{
	
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
	
	@ManyToOne()
	@JoinColumn(name = "rol", referencedColumnName = "id")
	private Role role;

	
	
	public User() {
		super();
	}
	
	



	public User(int id, String state, String password, String email) {
		super();
		this.id = id;
		this.state = state;
		this.password = password;
		this.email = email;
	}

	
	


	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public String getState() {
		return state;
	}





	public void setState(String state) {
		this.state = state;
	}





	public String getEmail() {
		return email;
	}





	public void setEmail(String email) {
		this.email = email;
	}





	public void setPassword(String password) {
		this.password = password;
	}

	

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<Authority> autoridades = new ArrayList<>();
		autoridades.add(new Authority(role.getName()));
		return autoridades;
	}
	
	

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	
	
	
}
