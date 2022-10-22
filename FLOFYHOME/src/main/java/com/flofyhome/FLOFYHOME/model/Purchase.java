package com.flofyhome.FLOFYHOME.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "compras")
public class Purchase  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="fecha")
	private Date date;
	
	@ManyToOne()
	@JoinColumn(name = "proveedor", referencedColumnName = "id")
	private Supplier proveedor;
	
	@ManyToOne()
	@JoinColumn(name = "jefe_inventario", referencedColumnName = "id")
	private User jefe_inventario;
	
	@OneToMany(mappedBy = "id_compra")
	private List<PurchaseDetail> id_compra;
	

}
