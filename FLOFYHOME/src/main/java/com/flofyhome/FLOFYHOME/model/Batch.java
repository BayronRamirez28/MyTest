package com.flofyhome.FLOFYHOME.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "lotes")
@Getter
@Setter
public class Batch implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;
	
	@Column(name="cantidad")
	private int quantity;
	
	@Column(name="precio_compra")
	private float price_shopping;
	
	@Column(name="fecha_registro")
	private Date registration_date;
	
	@Column(name="fecha_vencimiento")
	private Date expiration_date;

	@ManyToOne()
	@JoinColumn(name = "producto", referencedColumnName = "id")
	private Product product;

	public Batch() {
		super();
	}

	public Batch(int id, int quantity, float price_shopping, Date registration_date, Date expiration_date,
			Product product) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.price_shopping = price_shopping;
		this.registration_date = registration_date;
		this.expiration_date = expiration_date;
		this.product = product;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice_shopping() {
		return price_shopping;
	}

	public void setPrice_shopping(float price_shopping) {
		this.price_shopping = price_shopping;
	}

	public Date getRegistration_date() {
		return registration_date;
	}

	public void setRegistration_date(Date registration_date) {
		this.registration_date = registration_date;
	}

	public Date getExpiration_date() {
		return expiration_date;
	}

	public void setExpiration_date(Date expiration_date) {
		this.expiration_date = expiration_date;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
