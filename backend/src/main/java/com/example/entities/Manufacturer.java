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
@Table(name = "Manufacturer")
public class Manufacturer {
	@Id
	@Column(name = "mfg_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int mfg_id;
	
	@Column(name = "mfg_name", nullable = false)
	String mfg_name;
	
//	@ManyToOne
//	@JoinColumn(name = "seg_id")
//	Segment segment ;
	
	public String getMfg_name() {
		return mfg_name;
	}

	public void setMfg_name(String mfg_name) {
		this.mfg_name = mfg_name;
	}

//	public int getSeg_id() {
//		return seg_id;
//	}

//	public void setSeg_id(int seg_id) {
//		this.seg_id = seg_id;
//	}
	
	public int getMfg_id() {
		return mfg_id;
	}

	public void setMfg_id(int mfg_id) {
		this.mfg_id = mfg_id;
	}
	
}