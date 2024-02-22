package com.example.supermercado.servicios;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.supermercado.exception.CotrelException;
import com.example.supermercado.mapper.CamionMapper;
import com.example.supermercado.modelo.dto.CamionDTO;
import com.example.supermercado.modelo.entity.Camion;
import com.example.supermercado.modelo.repositorio.CamionRepositorio;

@Service
public class CamionServiceImpl implements CamionService {
	@Autowired
	private CamionRepositorio camionRepositorio;

	@Autowired
	private CamionMapper camionMapper;

	@Override
	public List<CamionDTO> obtenerConductores() {
		List<Camion> camiones = this.camionRepositorio.findAll();
		return camionMapper.listEntityToDto(camiones);
	}

	@Override
	public CamionDTO listarId(Long id) {
		Camion camion = camionRepositorio.findById(id)
				.orElseThrow(() -> new RuntimeException("Camión no encontrado"));
		return camionMapper.convertirACamionDTO(camion); 
	}

	@Override
	public CamionDTO add(CamionDTO c) {
		if (c.getConductor() != null && c.getConductor().getCamion() != null) {
			Camion camionEntity = camionRepositorio.findByConductorId(c.getConductor().getId());
			if (camionEntity != null && !camionEntity.getId().equals(c.getId())) {
				throw new CotrelException("Ya existe un camión asociado a ese conductor");	
			}
			
		}
		Camion camion = camionMapper.convertirACamion(c); 
		camion = camionRepositorio.save(camion);

		return camionMapper.convertirACamionDTO(camion);
	}


	@Override
	public CamionDTO delete(Long id) {
		Optional<Camion> cam = camionRepositorio.findById(id);
		if (cam.isPresent()) {
			this.camionRepositorio.delete(cam.get());
		}
		return camionMapper.convertirACamionDTO(cam.get());
	}

	public List<CamionDTO> getCamionesByFechaCompraRange(Date fromDate, Date toDate) {
		List<Camion> listaCamiones = camionRepositorio.findByFechaCompraBetween(fromDate, toDate);
		return camionMapper.listEntityToDto(listaCamiones);
	}

	@Override
	public List<CamionDTO> findByFechaCompraAfter(Date desde) {
		List<Camion> listaCamiones = camionRepositorio.findByFechaCompraAfter(desde);
		return camionMapper.listEntityToDto(listaCamiones);
	}

	@Override
	public List<CamionDTO> findByFechaCompraBefore(Date hasta) {
		List<Camion> listaCamiones = camionRepositorio.findByFechaCompraBefore(hasta);
		return camionMapper.listEntityToDto(listaCamiones);
	}

}
