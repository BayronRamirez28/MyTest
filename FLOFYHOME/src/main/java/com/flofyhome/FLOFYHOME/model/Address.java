package com.flofyhome.FLOFYHOME.model;

import java.io.Serializable;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "direcciones")
public class Address implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="direccion", length = 50)
	private String address;
	
	@ManyToOne()
	@JoinColumn(name = "usuario", referencedColumnName = "id")
	private User usuario;
	
	@OneToMany(mappedBy = "direccion")
	private List<Order> direccion_pedido;
	
	@OneToMany(mappedBy = "direccion")
	private List<Sale> direccion_venta;
}
