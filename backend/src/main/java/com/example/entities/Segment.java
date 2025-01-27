package com.example.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "segment") // Prefer lowercase for table names to avoid case sensitivity issues
public class Segment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seg_id") // Annotations now aligned with fields
    private int segId;

    @Column(name = "seg_name")
    private String segName;

    public Segment() {
        // Default constructor
    }

    public int getSegId() {
        return segId;
    }

    public void setSegId(int segId) {
        this.segId = segId;
    }

    public String getSegName() {
        return segName;
    }

    public void setSegName(String segName) {
        this.segName = segName;
    }

    @Override
    public String toString() {
        return "Segment [segId=" + segId + ", segName=" + segName + "]";
    }
}
