package com.example.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "model")
public class Model {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int model_id ;
	
	@Column(nullable = false)
	String mdl_name;
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "seg_id" , referencedColumnName = "sed_id")
//	private  Segment segment;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "mfg_id" , referencedColumnName = "mfg_id")
	private Manufacturer manufacturer;
	
	@Column(nullable = false)
	int min_qty;
	
	@Column(nullable = false)
	double price ;
	
	@Column(nullable = false)
	String image_path;

	public int getModel_id() {
		return model_id;
	}

	public void setModel_id(int model_id) {
		this.model_id = model_id;
	}

	public String getMdl_name() {
		return mdl_name;
	}

	public void setMdl_name(String mdl_name) {
		this.mdl_name = mdl_name;
	}

	public int getMin_qty() {
		return min_qty;
	}

	public void setMin_qty(int min_qty) {
		this.min_qty = min_qty;
	}

	public double getPrice() {
		return price;
	}

//	public Segment getSegment() {
//		return segment;
//	}
//
//	public void setSegment(Segment segment) {
//		this.segment = segment;
//	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	@Override
	public String toString() {
		return "Model [model_id=" + model_id + ", mdl_name=" + mdl_name + ", manufacturer=" + manufacturer
				+ ", min_qty=" + min_qty + ", price=" + price + ", image_path=" + image_path + "]";
	}

	
	
 	
}