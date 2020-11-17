package com.example.PeliHarjoitustyo.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;

@Entity
public class Konsoli {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long konsoli_id;
	private String name;
	private String publisher;
	private double price;




	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "konsoli")
	private List<Peli> pelit;

	public Konsoli() {

	}
	
	public Konsoli(String name, String publisher, double price, List<Peli> pelit) {
		this.name = name;
		this.publisher = publisher;
		this.price = price;
		this.pelit = pelit;
	}



	public Konsoli(String name, String publisher, double price) {

		this.name = name;
		this.publisher = publisher;
		this.price = price;

	}

	public Long getKonsoli_id() {
		return konsoli_id;
	}

	public void setKonsoli_id(Long konsoli_id) {
		this.konsoli_id = konsoli_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Peli> getPelit() {
		return pelit;
	}

	public void setPelit(List<Peli> pelit) {
		this.pelit = pelit;
	}
	
	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


}
