
package com.example.supermercado.servicios.frutas;

import java.util.List;

import com.example.supermercado.modelo.entity.Fruta;

public interface FrutaService {
    List<Fruta> listar();

    Fruta listarId(int id);

    Fruta add(Fruta p);

    Fruta edit(Fruta p);

    Fruta delete(int id);
}
