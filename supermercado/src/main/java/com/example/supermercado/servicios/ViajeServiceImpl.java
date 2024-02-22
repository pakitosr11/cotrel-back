package com.example.supermercado.servicios;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.supermercado.mapper.ViajeMapper;
import com.example.supermercado.modelo.dto.ViajeDTO;
import com.example.supermercado.modelo.entity.Viaje;
import com.example.supermercado.modelo.repositorio.ViajeRepositorio;

@Service
public class ViajeServiceImpl implements ViajeService{
	@Autowired
    private ViajeRepositorio viajeRepositorio;
	
	@Autowired
	private ViajeMapper viajeMapper;

    @Override
    public ViajeDTO listarId(Long id) {
    	Viaje viaje = viajeRepositorio.findById(id)
				.orElseThrow(() -> new RuntimeException("Conductor no encontrado"));
		return viajeMapper.convertirAViajeDTO(viaje);
    }

    @Override
    public ViajeDTO add(ViajeDTO v) {
		Viaje viaje = viajeMapper.convertirAViaje(v);
		viaje = viajeRepositorio.save(viaje);

		return viajeMapper.convertirAViajeDTO(viaje);
    }


    @Override
    public ViajeDTO delete(Long id) {
    	Optional<Viaje> via = viajeRepositorio.findById(id);
		if (via.isPresent()) {
			this.viajeRepositorio.delete(via.get());
		}
		return viajeMapper.convertirAViajeDTO(via.get());
    }
    
    public List<ViajeDTO> obtenerViajesPorConductor(Long idConductor) {
        // Implementa la lógica para obtener los viajes para un conductor específico
        // Utiliza el idConductor para filtrar los resultados desde tu repositorio
        // ...
    	
    	List<Viaje> viajes = viajeRepositorio.findByConductorId(idConductor);

        return viajes.stream().map(this::convertirAViajeDTO).collect(Collectors.toList());
    }

    public List<ViajeDTO> obtenerTodosLosViajes() {
    	List<Viaje> viajes = viajeRepositorio.findAll();
		return viajes.stream().map(this::convertirAViajeDTO).collect(Collectors.toList());
	}

	private ViajeDTO convertirAViajeDTO(Viaje viaje) {
		return viajeMapper.convertirAViajeDTO(viaje);
	}
    


}
