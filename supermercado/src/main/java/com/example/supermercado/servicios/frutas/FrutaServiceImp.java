
package com.example.supermercado.servicios.frutas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.supermercado.modelo.entity.Fruta;
import com.example.supermercado.modelo.repositorio.FrutaRepositorio;

@Service
public class FrutaServiceImp implements FrutaService {
    @Autowired
    private FrutaRepositorio frutaRepositorio;

    @Override
    public List<Fruta> listar() {
	return this.frutaRepositorio.findAll();
    }

    @Override
    public Fruta listarId(int id) {
	return frutaRepositorio.getOne(id);
    }

    @Override
    public Fruta add(Fruta p) {
	return this.frutaRepositorio.save(p);
    }

    @Override
    public Fruta edit(Fruta p) {
	return this.frutaRepositorio.save(p);
    }

    @Override
    public Fruta delete(int id) {
    Fruta fruta = this.frutaRepositorio.getOne(id);
	if (fruta != null) {
	    this.frutaRepositorio.delete(fruta);
	}
	return fruta;
    }

}
