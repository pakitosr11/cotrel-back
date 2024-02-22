
package com.example.supermercado.modelo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.supermercado.modelo.entity.Fruta;

public interface FrutaRepositorio extends JpaRepository<Fruta, Integer> {
    List<Fruta> findAll();

    @SuppressWarnings("unchecked")
    Fruta save(Fruta f);
    // Cliente findOne(int id);

    void delete(Fruta f);
}
