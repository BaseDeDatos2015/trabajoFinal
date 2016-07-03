package com.basededatos.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

/**
 * Esta clase representa los estados de las encuestas.
 * Pueden ser Diseño, Activa, Dada de Baja
 * Esta clase implementa la interfaz Versionable a fin de poder controlar la
 * edicion concurrente por parte de dos roles.
 * 
 * @author Silvana Bonafina
 * 
 */
@Entity
public class EstadoEncuesta {

	/**
	 * Mantiene la version de este objeto.
	 */
	@Version
	private long version;

	/**
	 * Es el id que permite identificar a una instancia de esta clase.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

		
	/**
	 * Es la instruccion de la encuesta.
	 */
	private String descripcion;


	

	/**
	 * @return the version
	 */
	public long getVersion() {
		return version;
	}


	/**
	 * @param version the version to set
	 */
	public void setVersion(long version) {
		this.version = version;
	}


	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}


	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}


	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	

}
