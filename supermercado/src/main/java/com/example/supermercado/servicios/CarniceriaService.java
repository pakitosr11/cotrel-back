package com.example.supermercado.servicios;

import java.util.List;

import com.example.supermercado.modelo.entity.Carne;


public interface CarniceriaService {

	List<Carne> listar();

	Carne listarId(int id);

	Carne add(Carne c);

	Carne edit(Carne c);

	Carne delete(int id);
}
