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

@Entity
@Table(name = "detalle_pedidos")
public class OrderDetail implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="cantidad")
	private int quantity;
	
	@ManyToOne()
	@JoinColumn(name = "id_pedido", referencedColumnName= "id")
	private Order id_pedido;

	@ManyToOne()
	@JoinColumn(name = "producto", referencedColumnName= "id")
	private Product producto;
}
