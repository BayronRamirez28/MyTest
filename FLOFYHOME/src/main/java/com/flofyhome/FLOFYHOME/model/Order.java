package com.flofyhome.FLOFYHOME.model;


import java.io.Serializable;
import java.sql.Date;
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

@Entity
@Table(name = "pedidos")
public class Order implements Serializable{
	
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="fecha")
	private Date date;
	
	@ManyToOne()
	@JoinColumn(name = "cliente", referencedColumnName = "id")
	private User client;

	@OneToMany(mappedBy = "order")
	private List<OrderDetail> detail_order;

	@OneToOne(mappedBy = "order")
	private Sale sale;
	
}
