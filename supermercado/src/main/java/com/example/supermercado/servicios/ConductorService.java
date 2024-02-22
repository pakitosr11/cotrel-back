package com.example.supermercado.servicios;

import java.util.List;

import com.example.supermercado.modelo.dto.ConductorDTO;


public interface ConductorService {

	ConductorDTO listarId(Long id);

	ConductorDTO add(ConductorDTO c) throws Exception;

	ConductorDTO delete(Long id);

	List<ConductorDTO> findAll();
}
