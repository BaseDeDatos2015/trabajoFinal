package com.basededatos.domain;



import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

/**
 * Esta clase es la raiz de todo el modelo. Es responsable de mantener las
 * colecciones de usuarios y de las encuestas del sistema.
 * Esta clase implementa el patron de diseño RootObject.
 * Para acceder en forma eficiente a sus colecciones, esta clase utiliza
 * diferentes implementaciones del patron Repository.
 * 
 * @author Bonafina Silvana
 * 
 */
@Entity
public class Encuestadora {
	
	@Version
	private long version;
	
	/**
	 * Es el id que permite identificar a una instancia de esta clase.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	/**
	 * Coleccion que mantiene todos los usuarios del sistema.
	 */
	@OneToMany
	private Collection<Usuario> usuarios;
	
	@OneToMany
	private Collection<Encuesta> encuestas;

	/**
	 * @return the usuarios
	 */
	public Collection<Usuario> getUsuarios() {
		return usuarios;
	}

	/**
	 * @param usuarios the usuarios to set
	 */
	public void setUsuarios(Collection<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	/**
	 * @return the encuestas
	 */
	public Collection<Encuesta> getEncuestas() {
		return encuestas;
	}

	/**
	 * @param encuestas the encuestas to set
	 */
	public void setEncuestas(Collection<Encuesta> encuestas) {
		this.encuestas = encuestas;
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
	
	


}
