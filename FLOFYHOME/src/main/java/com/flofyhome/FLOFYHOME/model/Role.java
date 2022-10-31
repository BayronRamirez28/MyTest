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
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class Role  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="nombre", length = 50)
	private String name;
	
	@ManyToMany
	
	@JoinTable(name = "rel_usuarios_roles",
		joinColumns = @JoinColumn(name ="id_Rol"),
		inverseJoinColumns = @JoinColumn(name ="id_Usuario"))
	
private List<User> users = new ArrayList<>();

}
