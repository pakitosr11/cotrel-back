
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

import com.example.supermercado.modelo.entity.Fruta;
import com.example.supermercado.servicios.frutas.FrutaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping({ "/frutas" })
public class ControladorFrutas {

    @Autowired
    FrutaService frutaService;
    
    @GetMapping
    public List<Fruta> listar() {
	return this.frutaService.listar();
    }

    @PostMapping
    public Fruta agregar(@RequestBody Fruta f) {
	return this.frutaService.add(f);
    }

    @GetMapping(path = { "/{id}" })
    public Fruta listarId(@PathVariable("id") int id) {
	return frutaService.listarId(id);
    }

    @PutMapping(path = { "/{id}" })
    public Fruta editar(@RequestBody Fruta f, @PathVariable("id") int id) {
	f.setId(id);
	return this.frutaService.edit(f);
    }

    @DeleteMapping(path = { "/{id}" })
    public Fruta delete(@PathVariable("id") int id) {
	return this.frutaService.delete(id);
    }

}
