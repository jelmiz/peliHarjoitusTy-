package com.example.PeliHarjoitustyo.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface KonsoliRepository extends CrudRepository<Konsoli, Long>{
	List<Konsoli> findByName(String name);
}
