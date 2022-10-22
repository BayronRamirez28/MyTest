package com.flofyhome.FLOFYHOME.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "proveedores")
public class Supplier implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombre", length = 50)
	private String name;
	
	@Column(name="email", length = 50)
	private String email;
	
	@Column(name="telefono")
	private long telephone;
	
	@OneToMany(mappedBy = "proveedor")
	private List<Purchase> proveedor_compra;
	
	@OneToMany(mappedBy = "proveedor")
	private List<Product> proveedor_producto;

}
