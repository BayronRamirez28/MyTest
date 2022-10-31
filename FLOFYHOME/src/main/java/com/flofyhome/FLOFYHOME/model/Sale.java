package com.flofyhome.FLOFYHOME.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ventas")
@Getter
@Setter
public class Sale implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="fecha")
	private Date date;
	
	@Column(name="subtotal")
	private float subtotal;

	@Column(name="total")
	private float total;
	
	@ManyToOne()
	@JoinColumn(name = "vendedor", referencedColumnName = "id")
	private User salesperson;
	
	@OneToOne()
	@JoinColumn(name = "pedido", referencedColumnName ="id")
	private Order order;
	
	@OneToMany(mappedBy = "sale")
	private List<SaleDetail> sale;
}
