package com.example.supermercado.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.supermercado.modelo.entity.Carne;
import com.example.supermercado.modelo.repositorio.CarneRepositorio;

@Service
public class CarniceriaServiceImpl implements CarniceriaService{
	@Autowired
    private CarneRepositorio carniceriaRepositorio;

    @Override
    public List<Carne> listar() {
	return this.carniceriaRepositorio.findAll();
    }

    @Override
    public Carne listarId(int id) {
	return carniceriaRepositorio.getOne(id);
    }

    @Override
    public Carne add(Carne c) {
	return this.carniceriaRepositorio.save(c);
    }

    @Override
    public Carne edit(Carne p) {
	return this.carniceriaRepositorio.save(p);
    }

    @Override
    public Carne delete(int id) {
    	Carne carne = this.carniceriaRepositorio.getOne(id);
	if (carne != null) {
	    this.carniceriaRepositorio.delete(carne);
	}
	return carne;
    }


}
