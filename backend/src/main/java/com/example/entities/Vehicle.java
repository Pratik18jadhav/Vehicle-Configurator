package com.example.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

enum Comp_Type{
	C,S,I,E
}

enum Is_ConFigurable{
	N,Y
}
@Entity
@Table(name = "Vehicle")
public class Vehicle {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "confi_id")
	int confi_id;
	
	public int getConfi_id() {
		return confi_id;
	}

	public void setConfi_id(int confi_id) {
		this.confi_id = confi_id;
	}

	public char getComp_id() {
		return comp_id;
	}

	public void setComp_id(char comp_id) {
		this.comp_id = comp_id;
	}

	public Comp_Type getComp_type() {
		return comp_type;
	}

	public void setComp_type(Comp_Type comp_type) {
		this.comp_type = comp_type;
	}

	public Is_ConFigurable getIs_configrable() {
		return is_configrable;
	}

	public void setIs_configrable(Is_ConFigurable is_configrable) {
		this.is_configrable = is_configrable;
	}

	@ManyToOne
  	@JoinColumn(name = "comp_id",nullable = false)
	Component model ;
	
	@Column(name="comp_id" , nullable = false)
	char comp_id;
	
	@Enumerated(EnumType.STRING)
	@Column(name="comp_type", nullable = false)
	Comp_Type comp_type;
	
	@Enumerated(EnumType.STRING)
	@Column(name="is_configrable" , nullable = false)
	Is_ConFigurable is_configrable;
	
	
	
	
//	@ManyToOne
//	@JoinColumn(name = "model_id")
//	Model model ;
//
//	public Model getModel() {
//		return model;
//	}
//
//	public void setModel(Model model) {
//		this.model = model;
//	}
	
	

}