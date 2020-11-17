package com.example.PeliHarjoitustyo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
public class Peli {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long peli_id;
	@NotNull
    @Size(min=1, max=50)
	String name;
	@NotNull
    @Size(min=1, max=50)
	String publisher;
	@NotNull
    @Size(min=1, max=50)
	double price;
	
	@ManyToOne
    @JsonIgnoreProperties ("peli") 
    @JoinColumn(name = "konsoli_id")
    private Konsoli konsoli;
	
	@ManyToOne
    @JsonIgnoreProperties ("peli") 
    @JoinColumn(name = "genre_id")
    private Genre genre;

	public Peli(String name, String publisher, double price, Genre genre) {
		super();
		this.name = name;
		this.publisher = publisher;
		this.price = price;
		this.genre = genre;
	
	}
	
	public Peli(String name, String publisher, double price, Genre genre, Konsoli konsoli) {
		super();
		this.name = name;
		this.publisher = publisher;
		this.price = price;
		this.genre = genre;
		this.konsoli = konsoli;
	}

	
	

	public Peli() {
		
	}

	public Long getPeli_id() {
		return peli_id;
	}

	public void setPeli_id(Long peli_id) {
		this.peli_id = peli_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	public Konsoli getKonsoli() {
		return konsoli;
	}

	public void setKonsoli(Konsoli konsoli) {
		this.konsoli = konsoli;
	}
	
	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

//	@Override
//	public String toString() {
//		return "peli [name=" + name + ", vaadittu=" + vaadittu + ", publisher=" + publisher + ", kysely=" + kysely + "]";
//§	}
	
}
