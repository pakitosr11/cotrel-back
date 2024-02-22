package com.example.supermercado.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.supermercado.modelo.entity.Carne;
import com.example.supermercado.servicios.CarniceriaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping({ "/carniceria" })
public class ControladorCarniceria {

	@Autowired
    CarniceriaService carniceriaService;
    
    @GetMapping
    public List<Carne> listar() {
	return this.carniceriaService.listar();
    }

    @PostMapping
    public Carne agregar(@RequestBody Carne c) {
	return this.carniceriaService.add(c);
    }

    @GetMapping(path = { "/{id}" })
    public Carne listarId(@PathVariable("id") int id) {
	return carniceriaService.listarId(id);
    }

    @PutMapping(path = { "/{id}" })
    public Carne editar(@RequestBody Carne c, @PathVariable("id") int id) {
	c.setId(id);
	return this.carniceriaService.edit(c);
    }

    @DeleteMapping(path = { "/{id}" })
    public Carne delete(@PathVariable("id") int id) {
	return this.carniceriaService.delete(id);
    }
}
