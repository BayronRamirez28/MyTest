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
	private Supplier supplier;
	
	@ManyToOne()
	@JoinColumn(name = "categoria", referencedColumnName="id")
	private Category category;
	
	@OneToMany(mappedBy = "product")
	private List<Batch> product_batch;
	
	@OneToMany(mappedBy = "product")
	private List<PurchaseDetail> product_purchasedetail;
	
	@OneToMany(mappedBy = "product")
	private List<Movement> product_movement;
	
	@OneToMany(mappedBy = "product")
	private List<OrderDetail> product_orderdetail;
	
	@OneToMany(mappedBy = "product")
	private List<SaleDetail> product_saledetail;

	public Product() {
		super();
	}

	public Product(int id, String name, int quantity, float sale_price, String estate, String detail,
			int minimun_quantity, String image, Supplier supplier, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.sale_price = sale_price;
		this.estate = estate;
		this.detail = detail;
		this.minimun_quantity = minimun_quantity;
		this.image = image;
		this.supplier = supplier;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getSale_price() {
		return sale_price;
	}

	public void setSale_price(float sale_price) {
		this.sale_price = sale_price;
	}

	public String getEstate() {
		return estate;
	}

	public void setEstate(String estate) {
		this.estate = estate;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getMinimun_quantity() {
		return minimun_quantity;
	}

	public void setMinimun_quantity(int minimun_quantity) {
		this.minimun_quantity = minimun_quantity;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", quantity=" + quantity + ", sale_price=" + sale_price
				+ ", estate=" + estate + ", detail=" + detail + ", minimun_quantity=" + minimun_quantity + ", image="
				+ image + ", supplier=" + supplier + ", category=" + category + "]";
	}

	
	
	

	
	
	}
