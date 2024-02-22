package com.example.supermercado.servicios;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.supermercado.exception.CotrelException;
import com.example.supermercado.mapper.ConductorMapper;
import com.example.supermercado.modelo.dto.ConductorDTO;
import com.example.supermercado.modelo.entity.Camion;
import com.example.supermercado.modelo.entity.Conductor;
import com.example.supermercado.modelo.repositorio.CamionRepositorio;
import com.example.supermercado.modelo.repositorio.ConductorRepositorio;

@Service
public class ConductorServiceImpl implements ConductorService {
	@Autowired
	private ConductorRepositorio conductorRepositorio;

	@Autowired
	private ConductorMapper conductorMapper;

	@Autowired
	private CamionRepositorio camionRepositorio;

	@Override
	public ConductorDTO listarId(Long id) {
		Conductor conductor = conductorRepositorio.findById(id)
				.orElseThrow(() -> new RuntimeException("Conductor no encontrado"));
		return conductorMapper.convertirAConductorDTO(conductor);
	}

	@Override
	public ConductorDTO add(ConductorDTO c) throws Exception {
		if (c.getId() != null && c.getCamion() != null && c.getCamion().getConductor() != null
				&& !c.getCamion().getConductor().getId().equals(c.getId())) {
			throw new CotrelException("Ya existe un conductor asociado a ese camión");
		}
		Conductor conductor = conductorMapper.convertirAConductor(c);
		Camion camion = conductor.getCamion();
		if (c.getId() == null) {
			conductor = conductorRepositorio.save(conductor);
			camion.setConductor(conductor);
			camion = camionRepositorio.save(camion);
		} else {
			if (camion != null) {
				camion = camionRepositorio.save(camion);
			} else {
				// SI es camión es nulo, se busca si hay un camión asociado a ese conductor y se
				// le pone el conductor a null
				if (conductor.getId() != null) {
					camion = camionRepositorio.findByConductorId(conductor.getId());
					if (camion != null) {
						camion.setConductor(null);
						camion = camionRepositorio.save(camion);
					}

				}

			}
			conductor = conductorRepositorio.save(conductor);
		}

		return conductorMapper.convertirAConductorDTO(conductor);
	}

	@Override
	public ConductorDTO delete(Long id) {
		Optional<Conductor> cond = conductorRepositorio.findById(id);
		if (cond.isPresent()) {
			if (cond.get().getCamion() != null) {
				throw new CotrelException("Existe un camion asociado a ese conductor");
			}
			this.conductorRepositorio.delete(cond.get());
		}
		return conductorMapper.convertirAConductorDTO(cond.get());
	}

	public List<ConductorDTO> findAll() {
		List<Conductor> conductores = conductorRepositorio.findAll();
		return conductores.stream().map(this::convertirAConductorDTO).collect(Collectors.toList());
	}

	private ConductorDTO convertirAConductorDTO(Conductor conductor) {
		return conductorMapper.convertirAConductorDTO(conductor);
	}

}
