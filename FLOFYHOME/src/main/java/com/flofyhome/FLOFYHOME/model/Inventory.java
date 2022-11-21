package com.flofyhome.FLOFYHOME.model;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


import java.util.List;


@Entity
@Table(name = "inventarios")
@Getter
@Setter
public class Inventory  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="cantidad")
	private int quantity;
	
	@Column(name="saldo")
	private float balance;
	
	@Column(name="fecha_creacion")
	private Date creation;

	@Column(name="fecha_cierre")
	private Date closing;

	@OneToMany(mappedBy = "inventory")
	private List<Movement> movement;
	
}
