package com.flofyhome.FLOFYHOME.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lotes")
public class Batch implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;
	
	@Column(name="cantidad")
	private int quantity;
	
	@Column(name="fecha_registro")
	private Date registration_date;
	
	@Column(name="fecha_vencimiento")
	private Date expiration_date;

	@ManyToOne()
	@JoinColumn(name = "producto", referencedColumnName = "id")
	private Product producto;
}