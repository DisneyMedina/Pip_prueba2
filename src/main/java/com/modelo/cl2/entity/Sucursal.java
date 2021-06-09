package com.modelo.cl2.entity;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_sucursal")
public class Sucursal implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_sucursal")
	private int codigo;
	@Column(name = "nom_sucursal")
	private String nombre;
	
	
	@OneToMany(mappedBy = "sucursal")
	@JsonIgnore
	private List<Supervisor> listaSupervisor;


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public List<Supervisor> getListaSupervisor() {
		return listaSupervisor;
	}


	public void setListaSupervisor(List<Supervisor> listaSupervisor) {
		this.listaSupervisor = listaSupervisor;
	}


	

	
	
	
	
	
}
