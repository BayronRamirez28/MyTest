package com.flofyhome.FLOFYHOME.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Product implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombre", length = 50)
	private String name;

	@Column(name="cantidad")
	private int quantity;
	
	@Column(name="precio_compra")
	private float price_shopping;
	
	@Column(name="precio_venta")
	private float sale_price;
	
	@Column(name="estado", length = 50)
	private String estate;
	
	@Column(name="detalle", length = 100)
	private String detail;
	
	@Column(name="cantidad_minima")
	private int minimun_quantity;
	
	@Column(name="imagen", length = 50)
	private String image;
	
	@ManyToOne()
	@JoinColumn(name = "proveedor", referencedColumnName = "id")
	private Supplier proveedor;
	
	@ManyToOne()
	@JoinColumn(name = "categoria", referencedColumnName="id")
	private Category categoria;
	
	@OneToMany(mappedBy = "producto")
	private List<Batch> producto;
	
	@OneToMany(mappedBy = "producto")
	private List<PurchaseDetail> producto_detalle_compra;
	
	@OneToMany(mappedBy = "producto")
	private List<Movement> producto_movimiento;
	
	@OneToMany(mappedBy = "producto")
	private List<OrderDetail> producto_detalle_pedido;
	
	@OneToMany(mappedBy = "producto")
	private List<SaleDetail> producto_detalle_venta;
	}
