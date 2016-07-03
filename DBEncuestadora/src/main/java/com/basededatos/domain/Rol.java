package com.basededatos.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

/**
 * Esta clase representa los roles del sistema.
 * Esta clase implementa la interfaz Versionable a fin de poder controlar la
 * edicion concurrente por parte de dos roles.
 * 
 * @author Silvana Bonafina
 * 
 */
@Entity
public class Rol {

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
	 * Es el nombre de este rol abstracto.
	 */
	private String nombre;
	
	
	/**
	 * Es la fecha en la que se creacion el rol abstracto.
	 */
	private Date fechaCreacion;

	/**
	 * Indica si el rol puede ser eliminado del sistema. 
	 * El rol de los administradores es el unico que no puede ser eliminado.
	 */
	private boolean eliminable;

	
	/**
	 * Getter.
	 * 
	 * @return el id de esta instancia.
	 */
	public long getId() {
		return this.id;
	}
	
	/**
	 * Setter.
	 * @param id es el id de esta instancia
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Getter.
	 * @return el nombre del rol
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Setter.
	 * @param nombre va a ser el nombre del rol
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the fechaCreacion del rol 
	 */
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * @param fechaCreacion va a ser la fechaCreacion del rol
	 */
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	

	/**
	 * Getter.
	 * @return true en el caso de que el rol pueda ser eliminado; false en caso contrario.
	 */
	public boolean isEliminable() {
		return eliminable;
	}

	/**
	 * Setter.
	 * @param eliminable indica si el rol puede ser eliminado.
	 */
	public void setEliminable(boolean eliminable) {
		this.eliminable = eliminable;
	}

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

	
}
