package com.tismart.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Gerente")
public class Gerente {

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idGerente;
	private String descGerente;
	private Date fechaRegistro;
	
	public Integer getIdGerente() {
		return idGerente;
	}
	public void setIdGerente(Integer idGerente) {
		this.idGerente = idGerente;
	}
	public String getDescGerente() {
		return descGerente;
	}
	public void setDescGerente(String descGerente) {
		this.descGerente = descGerente;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	@Override
	public String toString() {
		return "Gerente [idGerente=" + idGerente + ", descGerente=" + descGerente + ", fechaRegistro=" + fechaRegistro
				+ "]";
	}
	
}
