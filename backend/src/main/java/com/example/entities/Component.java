package com.example.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

@Table(name= "Component")
public class Component {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "comp_id" , nullable = false)
	int comp_id;
	
	public int getComp_id() {
		return comp_id;
	}

	public void setComp_id(int comp_id) {
		this.comp_id = comp_id;
	}

	public int getComp_name() {
		return comp_name;
	}

	public void setComp_name(int comp_name) {
		this.comp_name = comp_name;
	}

	@Column(name = "comp_id",nullable = false)
	int comp_name;
}
