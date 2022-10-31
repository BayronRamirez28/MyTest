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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Entity
@Table(name = "compras")
@Getter
@Setter
public class Purchase  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="fecha")
	private Date date;
	
	@ManyToOne()
	@JoinColumn(name = "proveedor", referencedColumnName = "id")
	private Supplier supplier;
	
	@ManyToOne()
	@JoinColumn(name = "jefe_inventario", referencedColumnName = "id")
	private User chief_inventory;
	
	@OneToMany(mappedBy = "purchase")
	private List<PurchaseDetail> purchase;
	

}
