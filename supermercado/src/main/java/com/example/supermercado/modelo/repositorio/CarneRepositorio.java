package com.example.supermercado.modelo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.supermercado.modelo.entity.Carne;

public interface CarneRepositorio extends JpaRepository<Carne, Integer>{
	 	List<Carne> findAll();

	    @SuppressWarnings("unchecked")
	    Carne save(Carne c);
	    // Cliente findOne(int id);

	    void delete(Carne c);

}
