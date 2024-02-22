
package com.example.supermercado.modelo.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "frutas")
public class Fruta {

    @Id
    @Column
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nombre;
    @Column
    private int codigo;
    @Column(precision=11, scale=2)
    private BigDecimal precio;

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getNombre() {
	return nombre;
    }

    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

    public int getCodigo() {
	return codigo;
    }

    public void setCodigo(int codigo) {
	this.codigo = codigo;
    }
    
    public BigDecimal getPrecio() {
    	return precio;
        }

    public void setPrecio(BigDecimal precio) {
    	this.precio = precio;
     }

}
