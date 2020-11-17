package com.example.PeliHarjoitustyo.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PeliRepository extends CrudRepository<Peli, Long> {
	List<Peli> findByKonsoli(Konsoli konsoli);
}
