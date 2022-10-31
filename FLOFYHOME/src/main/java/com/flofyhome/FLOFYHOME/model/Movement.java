package com.flofyhome.FLOFYHOME.model;


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

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "movimientos")
@Getter
@Setter
public class Movement implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="fecha")
	private Date date;
	
	@Column(name="tipo_movimiento", length = 50)
	private String movement_type;
	
	@ManyToOne()
	@JoinColumn(name = "id_inventario", referencedColumnName="id")
	private Inventory inventory;
	
	@ManyToOne()
	@JoinColumn(name = "producto", referencedColumnName="id")
	private Product product;

}
