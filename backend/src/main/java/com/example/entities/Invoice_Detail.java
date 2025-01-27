package com.example.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Invoice_Detail")
public class Invoice_Detail {
	
	@Id 
	@Column(name="invdtl_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int invDtl_id ;
	
//	@ManyToOne
//	@JoinColumn(name = "inv_id",nullable = false)
//	Invoice invoice;
	
	@ManyToOne
	@JoinColumn(name = "comp_id",nullable = false)
	Component component;
	

}