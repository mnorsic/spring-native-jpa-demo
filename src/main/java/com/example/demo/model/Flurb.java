package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Flurb {

	@Id
	@GeneratedValue
	Long id;

	@Column(name="\"value\"")
	String value;

	public void setValue(String value) {
		this.value = value;
	}
}
