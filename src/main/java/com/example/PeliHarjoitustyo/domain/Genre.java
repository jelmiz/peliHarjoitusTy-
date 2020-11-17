package com.example.PeliHarjoitustyo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

@Entity
public class Genre {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long genre_id;
	String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "genre")
	private List<Peli> pelit;

	public Genre() {
		super();
	}

	public Genre(String name) {
		super();
		this.name = name;
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

	public long getGenre_id() {
		return genre_id;
	}

	public void setGenre_id(long genre_id) {
		this.genre_id = genre_id;
	}

	//@Override
	//public String toString() {
		//return "Genre [genre_id=" + genre_id + ", name=" + name + "]";
	//}

}
