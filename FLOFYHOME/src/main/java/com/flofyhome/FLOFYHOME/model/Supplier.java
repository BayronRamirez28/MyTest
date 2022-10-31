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
	
	@OneToMany(mappedBy = "supplier")
	private List<Purchase> supplier_purchase;
	
	@OneToMany(mappedBy = "supplier")
	private List<Product> supplier_product;

	
	
	public Supplier() {
		super();
	}



	public Supplier(int id, String name, String email, long telephone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.telephone = telephone;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public long getTelephone() {
		return telephone;
	}



	public void setTelephone(long telephone) {
		this.telephone = telephone;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public String toString() {
		return "Supplier [id=" + id + ", name=" + name + ", email=" + email + ", telephone=" + telephone + "]";
	}

	
	
	

}
