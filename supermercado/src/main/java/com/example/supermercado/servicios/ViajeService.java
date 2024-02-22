package com.example.supermercado.servicios;

import java.util.List;

import com.example.supermercado.modelo.dto.ViajeDTO;


public interface ViajeService {

	ViajeDTO listarId(Long id);

	ViajeDTO add(ViajeDTO v);

	ViajeDTO delete(Long id);

	List<ViajeDTO> obtenerViajesPorConductor(Long idConductor);

	List<ViajeDTO> obtenerTodosLosViajes();
}
