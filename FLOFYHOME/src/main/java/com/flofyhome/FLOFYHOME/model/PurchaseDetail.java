package com.flofyhome.FLOFYHOME.model;

import java.io.Serializable;

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
@Table(name = "detalle_compra")
@Getter
@Setter
public class PurchaseDetail implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="cantidad")
	private int quantity;
	
	@Column(name="total")
	private float total;
	
	@ManyToOne()
	@JoinColumn(name = "id_compra", referencedColumnName = "id")
	private Purchase purchase;
	
	@ManyToOne()
	@JoinColumn(name = "producto", referencedColumnName = "id")
	private Product product;
}
